package pl.sda.service;

import pl.sda.model.*;
import pl.sda.repository.*;
import java.util.List;
import java.util.Random;

public class EventServiceImpl implements EventServiceRepo{



    MonsterRepoImpl monsterRepo = new MonsterRepoImpl();
    TreasureRepoImpl treasureRepo = new TreasureRepoImpl();
    EncounterRepoImpl encounterRepo = new EncounterRepoImpl();



    @Override
    public void eventRandomizer(Location location, Player player) {

        Random rand = new Random();

        int random_integer = rand.nextInt(100);

        if (random_integer <= location.getMonsterChance()){

            System.out.println("MonsterEvent");
            List<Monster> monsterList = monsterRepo.ReadMonstersFromCSV();
            Monster monster = monsterRepo.getRandomMonster(monsterList);
            System.out.println("Atakuje Ciebie Potwór: " + monster.getName());

            while (player.getHp() > 0 && monster.getHp()> 0){
                monster.setHp(monster.getHp() - (player.getAttack() - monster.getArmor()));
                System.out.println("Potwór: " + monster.getName() + " ma " + monster.getHp() + "HP");
                player.setHp(player.getHp() -(monster.getAttack() - player.getArmor()));
                System.out.println("Gracz ma: " + player.getHp() + " HP");
            }
            if (monster.getHp() > player.getHp() || player.getHp() <= 0){
                System.out.println("przegrałeś");
                System.exit(1);
            }
            System.out.println("Masz teraz: " + player.getHp() + " HP, " + player.getAttack() + " ataku, " + player.getArmor() + " pancerza.");



        } else if (random_integer > location.getMonsterChance() && random_integer <= (location.getMonsterChance() + location.getTreasureChance())){

            System.out.println("TreasureEvent");
            List<Treasure> treasureList = treasureRepo.ReadTreasuresFromCSV();
            Treasure treasure = treasureRepo.getRandomTreasure(treasureList);
            System.out.println("Znajdujesz skarb: " + treasure.getName());
            if(treasure.getHp() != 0) {
                System.out.println("Zdobywasz: " + treasure.getHp() + " HP");
                player.setHp(player.getHp() + treasure.getHp());
            }
            if(treasure.getAttack() != 0) {
                System.out.println("Zdobywasz: " + treasure.getArmor() + " pancerza");
                player.setArmor(player.getArmor() + treasure.getArmor());
            }
            if (treasure.getAttack() != 0) {
                System.out.println("Zdobywasz: " + treasure.getAttack() + " ataku");
                player.setAttack(player.getAttack() + treasure.getAttack());
            }
            System.out.println("Masz teraz: " + player.getHp() + " HP, " + player.getAttack() + " ataku, " + player.getArmor() + " pancerza.");

        } else {

            System.out.println("EncounterEvent");
            List<Encounter> encounterList = encounterRepo.ReadEncountersFromCSV();
            Encounter encounter = encounterRepo.getRandomEncounter(encounterList);
            System.out.println("Spotykasz się z: " + encounter.getName() + "em");
            if(encounter.getHp() != 0) {
                System.out.println("Masz: " + encounter.getHp() + " do HP");
                player.setHp(player.getHp() + encounter.getHp());
            }
            if(encounter.getAttack() != 0) {
                System.out.println("Masz: " + encounter.getArmor() + " do pancerza");
                player.setArmor(player.getArmor() + encounter.getArmor());
            }
            if (encounter.getAttack() != 0) {
                System.out.println("Masz: " + encounter.getAttack() + " do ataku");
                player.setAttack(player.getAttack() + encounter.getAttack());
            }
            System.out.println("Masz teraz: " + player.getHp() + " HP, " + player.getAttack() + " ataku, " + player.getArmor() + " pancerza.");

        }

    }

    @Override
    public void monsterEvent(Monster monster) {


    }

    @Override
    public void treasureEvent(Treasure treasure) {


    }

    @Override
    public void encounterEvent(Encounter encounter) {


    }

    @Override
    public Player monsterAttacksPlayer(Player player, Monster monster) {
        int playerHp = player.getHp();
        int playerArmor = player.getArmor();
        int monsterAttack = monster.getAttack();
        int newPlayerHp = playerHp - (monsterAttack - playerArmor);
        player.setHp(newPlayerHp);
        return player;
    }

    @Override
    public Monster playerAttacksMonster(Player player, Monster monster) {

        int monsterHp = monster.getHp();
        int monsterArmor = monster.getArmor();
        int playerAttack = player.getAttack();
        int newMonsterHp = monsterHp - (playerAttack - monsterArmor);
        monster.setHp(newMonsterHp);
        return monster;


    }


}
