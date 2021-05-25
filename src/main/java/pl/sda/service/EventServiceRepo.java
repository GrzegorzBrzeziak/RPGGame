package pl.sda.service;

import pl.sda.model.Encounter;
import pl.sda.model.Location;
import pl.sda.model.Monster;
import pl.sda.model.Treasure;

public interface EventServiceRepo {

    void eventRandomizer(Location location);

    void monsterEvent(Monster monster);

    void treasureEvent(Treasure treasure);

    void encounterEvent(Encounter encounter);

    void monsterAttacksPlayer();

    void PlayerAttacksMonster();

}
