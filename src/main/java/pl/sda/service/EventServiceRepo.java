package pl.sda.service;

import pl.sda.model.*;

public interface EventServiceRepo {

    void eventRandomizer(Location location, Player player);

    void monsterEvent(Monster monster);

    void treasureEvent(Treasure treasure);

    void encounterEvent(Encounter encounter);

    Player monsterAttacksPlayer(Player player, Monster monster);

    Monster playerAttacksMonster(Player player, Monster monster);

}
