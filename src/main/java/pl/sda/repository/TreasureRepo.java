package pl.sda.repository;


import pl.sda.model.Treasure;

import java.util.List;

public interface TreasureRepo {
    public List<Treasure> ReadTreasuresFromCSV();

    public void PrintTreasuresList(List<Treasure> treasuresList);

    public Treasure getRandomTreasure(List<Treasure> treasuresList);
}