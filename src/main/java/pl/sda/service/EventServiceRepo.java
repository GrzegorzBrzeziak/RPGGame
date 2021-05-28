package pl.sda.service;

import pl.sda.model.*;

public interface EventServiceRepo {

    void eventRandomizer(Location location, Player player);
    int getRandomIntFrom0To100();
    int getRandomDamageValue(int dmgMin, int dmgMax );
    void playerLosesGame(Player player);
    void fight(Player player, Monster monster);



}
