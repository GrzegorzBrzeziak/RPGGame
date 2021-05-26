package pl.sda.repository;

import pl.sda.model.Player;

public interface PlayerRepo {

    public Player createNewPlayer();

    public Player loadPlayer();

    public void savePlayer();
}
