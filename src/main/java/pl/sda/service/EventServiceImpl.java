package pl.sda.service;

import pl.sda.model.*;
import pl.sda.repository.*;
import pl.sda.view.core.GameViewService;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class EventServiceImpl implements EventServiceRepo {


    MonsterRepoImpl monsterRepo = new MonsterRepoImpl();
    TreasureRepoImpl treasureRepo = new TreasureRepoImpl();
    EncounterRepoImpl encounterRepo = new EncounterRepoImpl();
    PlayerLevelRepoImpl playerLevelRepo = new PlayerLevelRepoImpl();
    private final GameViewService gameViewService = new GameViewService();


    @Override
    public void eventRandomizer(Location location, Player player) {

        int randomInteger = getRandomIntFrom0To100();

        if (randomInteger <= location.getMonsterChance()) {
            monsterEvent(player);
        } else if (randomInteger > location.getMonsterChance() && randomInteger <= (location.getMonsterChance() + location.getTreasureChance())) {
            treasureEvent(player);
        } else {
            encounterEvent(player);
        }

    }


    @Override
    public int getRandomIntFrom0To100() {
        return ThreadLocalRandom.current().nextInt(0, 101);
    }

    @Override
    public int getRandomDamageValue(int dmgMin, int dmgMax) {
        return ThreadLocalRandom.current().nextInt(dmgMin, (dmgMax + 1));
    }

    @Override
    public void playerLosesGame(Player player) {
        gameViewService.youLose();
        player.setHp(100);
        player.setMinAttack(2);
        player.setMaxAttack(3);
        player.setArmor(0);
        player.setMaxHp(100);
        player.setCriticalChance(1);
        player.setCriticalMultiplayer(2);
        player.setAccuracy(80);
        player.setDodge(0);
        player.setXp(0);
        player.setPlayerLevel(0);
        PlayerRepoImpl playerRepo = new PlayerRepoImpl();
        playerRepo.savePlayer(player);
        System.exit(1);

    }

    @Override
    public void fight(Player player, Monster monster) {

        if (isMissedAttack(player.getAccuracy(), monster.getDodge())) {
            gameViewService.printMissedPlayerAttack(player);
        } else {
            int randomizedPlayerDmg = getRandomDamageValue(player.getMinAttack(), player.getMaxAttack());
            int dmgWithCrit = calculateCriticalDamage(randomizedPlayerDmg, player.getCriticalChance(), player.getCriticalMultiplayer());
            gameViewService.printPlayerAttack(dmgWithCrit);
            if (dmgWithCrit - monster.getArmor() <= 0) {
                monster.setHp(monster.getHp() - 1);
            } else {
                monster.setHp(monster.getHp() - (dmgWithCrit - monster.getArmor()));
            }
            gameViewService.printMonsterHp(monster);
        }
        if (isMissedAttack(monster.getAccuracy(), player.getDodge())) {
            gameViewService.printMissedMonsterAttack(monster);
        } else {
            int randomizedMonsterDmg = getRandomDamageValue(monster.getMinAttack(), monster.getMaxAttack());
            int monsterDmgWithCrit = calculateCriticalDamage(randomizedMonsterDmg, monster.getCriticalChance(), monster.getCriticalMultiplayer());
            gameViewService.printMonsterAttack(monster, monsterDmgWithCrit);
            if (monsterDmgWithCrit - player.getArmor() <= 0) {
                player.setHp(player.getHp() - 1);
            } else {
                player.setHp(player.getHp() - (monsterDmgWithCrit - player.getArmor()));
            }
            gameViewService.printPlayerHp(player);
        }
    }

    public int calculateCriticalDamage(int damage, int criticalDamageChance, double criticalDmgMultiplayer) {
        int randomInt = getRandomIntFrom0To100();
        if (randomInt < criticalDamageChance) {

            damage = (int) (damage * criticalDmgMultiplayer);
            gameViewService.printCriticalDamage(damage);
            return damage;
        }
        return damage;
    }

    public boolean isMissedAttack(int accuracy, double dodge) {
        int randomInt = getRandomIntFrom0To100();
        double hitChance = ((accuracy - dodge) / accuracy) * 100;
        return !(randomInt < hitChance);
    }

    public void treasureEvent(Player player) {
        System.out.println("TreasureEvent");
        List<Treasure> treasureList = treasureRepo.ReadTreasuresFromCSV();
        Treasure treasure = treasureRepo.getRandomTreasure(treasureList);
        gameViewService.printFoundTreasure(treasure);
        if (treasure.getHp() != 0) {
            gameViewService.printFoundTreasureGetHp(treasure);
            if (player.getHp() + treasure.getHp() >= player.getMaxHp()) {
                player.setHp(player.getMaxHp());
            } else {
                player.setHp(player.getHp() + treasure.getHp());
            }
        }
        if (treasure.getArmor() != 0) {
            gameViewService.printFoundTreasureGetArmor(treasure);
            player.setArmor(player.getArmor() + treasure.getArmor());
        }
        if (treasure.getAttack() != 0) {
            gameViewService.printFoundTreasureGetAttack(treasure);
            player.setMinAttack(player.getMinAttack() + treasure.getAttack());
            player.setMaxAttack(player.getMaxAttack() + treasure.getAttack());
        }
        if (treasure.getMaxhp() != 0) {
            gameViewService.printFoundTreasureGetMaxHP(treasure);
            player.setMaxHp(player.getMaxHp() + treasure.getMaxhp());
        }
        gameViewService.printPlayerStats(player);
    }

    public void monsterEvent(Player player) {
        System.out.println("MonsterEvent");
        List<Monster> monsterList = monsterRepo.ReadMonstersFromCSV();
        Monster monster = monsterRepo.getRandomMonster(monsterList);
        gameViewService.printAttackingMonsterName(monster);

        while (player.getHp() > 0 && monster.getHp() > 0) {
            fight(player, monster);
        }
        if (player.getHp() <= 0) {
            playerLosesGame(player);
        }
        player.setXp(player.getXp() + monster.getXp());
        gameViewService.printPlayerXp(player);
        Level playerLevelFromList = playerLevelRepo.getLevel(playerLevelRepo.ReadlevelsFromCSV(), player);
        if (player.getXp() >= playerLevelFromList.getXp()) {
            player.setXp(player.getXp() - playerLevelFromList.getXp());
            player.setPlayerLevel(playerLevelFromList.getId());
            levelUp(player);
        }

        gameViewService.printPlayerStats(player);

        int randomLoot = getRandomIntFrom0To100();
        if (randomLoot <= monster.getLootChance()) {
            treasureEvent(player);
        }
    }

    public void encounterEvent(Player player) {
        System.out.println("EncounterEvent");
        List<Encounter> encounterList = encounterRepo.ReadEncountersFromCSV();
        Encounter encounter = encounterRepo.getRandomEncounter(encounterList);
        gameViewService.printEncounterName(encounter);
        if (encounter.getId() == 1) {
            gameViewService.printEncounterId1(encounter);
            player.setHp(player.getMaxHp());
        }
        if (encounter.getHp() != 0) {
            gameViewService.printEncounterGetHp(encounter);
            if (player.getHp() + encounter.getHp() >= player.getMaxHp()) {
                player.setHp(player.getMaxHp());
            } else if (player.getHp() + encounter.getHp() <= 0){
                playerLosesGame(player);
            }
            else {
                player.setHp(player.getHp() + encounter.getHp());
            }
        }
        if (encounter.getAttack() != 0) {
            gameViewService.printEncounterGetArmor(encounter);
            player.setArmor(player.getArmor() + encounter.getArmor());
        }
        if (encounter.getAttack() != 0) {
            gameViewService.printEncounterGetAttack(encounter);
            player.setMinAttack(player.getMinAttack() + encounter.getAttack());
            player.setMaxAttack(player.getMaxAttack() + encounter.getAttack());
        }
        gameViewService.printPlayerStats(player);
    }

    public void levelUp(Player player) {
        gameViewService.youHaveGainedALevel(player);
        Scanner scanner = new Scanner(System.in);
        int playerChoice = scanner.nextInt();
        if (playerChoice == 1) {
            player.setMaxHp(player.getMaxHp() + 10);
            player.setHp(player.getMaxHp());
        } else if (playerChoice == 2) {
            player.setMinAttack(player.getMinAttack() + 3);
            player.setMaxAttack(player.getMaxAttack() + 3);
        } else if (playerChoice == 3) {
            player.setDodge(player.getDodge() + 5);
            player.setAccuracy(player.getAccuracy() + 5);
        } else if (playerChoice == 4) {
            player.setMaxAttack(player.getMaxAttack() + 2);
            player.setCriticalChance(player.getCriticalChance() + 2);
        } else {
            System.out.println("Podaj liczbę.");
        }

    }
}
