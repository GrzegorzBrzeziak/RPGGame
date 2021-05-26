package pl.sda.model;

import com.opencsv.bean.CsvBindByName;

public class Location {

    @CsvBindByName(column = "id", required = true)
    private int id;

    @CsvBindByName(column = "name", required = true)
    private String locationName;

    @CsvBindByName(column = "monsterChance", required = true)
    private int monsterChance;

    @CsvBindByName(column = "treasureChance", required = true)
    private int treasureChance;

    @CsvBindByName(column = "encounterChance", required = true)
    private int encounterChance;

    public Location() {
    }

    public Location(int id, String locationName, int monsterChance, int treasureChance, int encounterChance) {
        this.id = id;
        this.locationName = locationName;
        this.monsterChance = monsterChance;
        this.treasureChance = treasureChance;
        this.encounterChance = encounterChance;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getMonsterChance() {
        return monsterChance;
    }

    public void setMonsterChance(int monsterChance) {
        this.monsterChance = monsterChance;
    }

    public int getTreasureChance() {
        return treasureChance;
    }

    public void setTreasureChance(int treasureChance) {
        this.treasureChance = treasureChance;
    }

    public int getEncounterChance() {
        return encounterChance;
    }

    public void setEncounterChance(int encounterChance) {
        this.encounterChance = encounterChance;
    }
}
