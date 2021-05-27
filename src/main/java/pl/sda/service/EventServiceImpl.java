package pl.sda.service;

import pl.sda.model.*;
import pl.sda.repository.*;
import pl.sda.view.core.GameConsoleView;
import pl.sda.view.core.GameViewService;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EventServiceImpl implements EventServiceRepo{



    MonsterRepoImpl monsterRepo = new MonsterRepoImpl();
    TreasureRepoImpl treasureRepo = new TreasureRepoImpl();
    EncounterRepoImpl encounterRepo = new EncounterRepoImpl();
    private GameViewService gameViewService = new GameViewService();



    @Override
    public void eventRandomizer(Location location, Player player) {

        Random rand = new Random();

        int random_integer = rand.nextInt(100);

        if (random_integer <= location.getMonsterChance()){

            System.out.println("MonsterEvent");
            List<Monster> monsterList = monsterRepo.ReadMonstersFromCSV();
            Monster monster = monsterRepo.getRandomMonster(monsterList);
            gameViewService.printAttackingMonsterName(monster);

            while (player.getHp() > 0 && monster.getHp()> 0){
                int randomizedPlayerDmg = getRandomDamageValue(player.getMinAttack(), player.getMaxAttack());
                gameViewService.printPlayerAttack(randomizedPlayerDmg);
                monster.setHp(monster.getHp() - (randomizedPlayerDmg - monster.getArmor()));
                gameViewService.printMonsterHp(monster);
                int randomizedMonsterDmg = getRandomDamageValue(monster.getMinAttack(), monster.getMaxAttack());
                gameViewService.printMonsterAttack(monster, randomizedMonsterDmg);
                player.setHp(player.getHp() - (randomizedMonsterDmg - player.getArmor()));
                gameViewService.printPlayerHp(player);
            }
            if (monster.getHp() > player.getHp() || player.getHp() <= 0){
                gameViewService.youLose();
                player.setHp(100);
                player.setMinAttack(2);
                player.setMaxAttack(3);
                player.setArmor(0);
                player.setMaxHp(100);
                PlayerRepoImpl playerRepo = new PlayerRepoImpl();
                playerRepo.savePlayer(player);
                System.exit(1);
            }
            gameViewService.printPlayerStats(player);



        } else if (random_integer > location.getMonsterChance() && random_integer <= (location.getMonsterChance() + location.getTreasureChance())){

            System.out.println("TreasureEvent");
            List<Treasure> treasureList = treasureRepo.ReadTreasuresFromCSV();
            Treasure treasure = treasureRepo.getRandomTreasure(treasureList);
            gameViewService.printFoundTreasure(treasure);
            if(treasure.getHp() != 0) {
                gameViewService.printFoundTreasureGetHp(treasure);
                if (player.getHp() + treasure.getHp() >= player.getMaxHp()){
                    player.setHp(player.getMaxHp());
                }else {
                    player.setHp(player.getHp() + treasure.getHp());
                }
            }
            if(treasure.getArmor() != 0) {
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

        } else {

            System.out.println("EncounterEvent");
            List<Encounter> encounterList = encounterRepo.ReadEncountersFromCSV();
            Encounter encounter = encounterRepo.getRandomEncounter(encounterList);
            gameViewService.printEncounterName(encounter);
            if (encounter.getId() == 1){
            gameViewService.printEncounterId1(encounter);
            player.setHp(player.getMaxHp());
            }
            if(encounter.getHp() != 0) {
                gameViewService.printEncounterGetHp(encounter);
                if (player.getHp() + encounter.getHp() >= player.getMaxHp()){
                    player.setHp(player.getMaxHp());
                }else {
                    player.setHp(player.getHp() + encounter.getHp());
                }
            }
            if(encounter.getAttack() != 0) {
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

    }

    @Override
    public int getRandomIntFrom0To100() {
        int boundedRandomValue = ThreadLocalRandom.current().nextInt(0, 100);
        return boundedRandomValue;
    }

    @Override
    public int getRandomDamageValue(int dmgMin, int dmgMax ) {
        int boundedRandomValue = ThreadLocalRandom.current().nextInt(dmgMin, dmgMax);
        return boundedRandomValue;
    }



}
