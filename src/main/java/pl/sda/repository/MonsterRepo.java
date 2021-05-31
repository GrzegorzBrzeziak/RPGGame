package pl.sda.repository;

import pl.sda.model.Encounter;
import pl.sda.model.Location;
import pl.sda.model.Monster;

import java.util.List;

public interface MonsterRepo {
    public List<Monster> ReadMonstersFromCSV();

    public void PrintMonstersList(List<Monster> monstersList);

    public Monster getRandomMonsterFromLocation(List<Monster> monsterList, Location location);
}

