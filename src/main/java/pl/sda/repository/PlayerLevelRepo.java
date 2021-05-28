package pl.sda.repository;

import pl.sda.model.Level;
import pl.sda.model.Monster;
import pl.sda.model.Player;

import java.util.List;

public interface PlayerLevelRepo {
    public List<Level> ReadlevelsFromCSV();
    public Level getLevel(List<Level> levelsList, Player player);
}
