package pl.sda.service;

import pl.sda.model.Encounter;
import pl.sda.model.Location;
import pl.sda.model.Monster;
import pl.sda.model.Treasure;
import pl.sda.repository.*;

import java.util.List;
import java.util.Random;

public class EventServiceImpl implements EventServiceRepo{


    LocationRepoImpl impl = new LocationRepoImpl();
    private final Location location1 = impl.getRandomLocation();
    private final Location location2 = impl.getRandomLocation();
    private final Location location3 = impl.getRandomLocation();
    MonsterRepoImpl monsterRepo = new MonsterRepoImpl();
    TreasureRepoImpl treasureRepo = new TreasureRepoImpl();
    EncounterRepoImpl encounterRepo = new EncounterRepoImpl();


    @Override
    public void eventRandomizer(Location location) {

        Random rand = new Random();

        int random_integer = rand.nextInt(100);

        if (random_integer <= location.getMonsterChanceEvent()){

            System.out.println("MonsterEvent");
            List<Monster> monsterList = monsterRepo.ReadMonstersFromCSV();
            Monster monster = monsterRepo.getRandomMonster(monsterList);
            System.out.println("Atakuje Ciebie Potwór: " + monster.getName());


        } else if (random_integer > location.getMonsterChanceEvent() && random_integer <= (location.getMonsterChanceEvent() + location.getTreasureChanceEvent())){

            System.out.println("TreasureEvent");
            List<Treasure> treasureList = treasureRepo.ReadTreasuresFromCSV();
            Treasure treasure = treasureRepo.getRandomTreasure(treasureList);
            System.out.println("Znajdujesz skarb: " + treasure.getName());


        } else {

            System.out.println("EncounterEvent");
            List<Encounter> encounterList = encounterRepo.ReadEncountersFromCSV();
            Encounter encounter = encounterRepo.getRandomEncounter(encounterList);
            System.out.println("Spotykasz się z: " + encounter.getName() + "em");


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
    public void monsterAttacksPlayer() {

    }

    @Override
    public void PlayerAttacksMonster() {

    }


}
