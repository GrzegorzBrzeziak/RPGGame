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

    @CsvBindByName(column = "locationDifficulty", required = true)
    private int locationDifficulty;

    @CsvBindByName(column = "monsterId1", required = true)
    private int monsterId1;

    @CsvBindByName(column = "monsterId1Chance", required = true)
    private int monsterId1Chance;

    @CsvBindByName(column = "monsterId2", required = true)
    private int monsterId2;

    @CsvBindByName(column = "monsterId2Chance", required = true)
    private int monsterId2Chance;

    @CsvBindByName(column = "monsterId3", required = true)
    private int monsterId3;

    @CsvBindByName(column = "monsterId3Chance", required = true)
    private int monsterId3Chance;

    @CsvBindByName(column = "monsterId4", required = true)
    private int monsterId4;

    @CsvBindByName(column = "monsterId4Chance", required = true)
    private int monsterId4Chance;





    public Location() {
    }

    public Location(int id, String locationName, int monsterChance, int treasureChance, int encounterChance, int locationDifficulty, int monsterId1, int monsterId1Chance, int monsterId2, int monsterId2Chance, int monsterId3, int monsterId3Chance, int monsterId4, int monsterId4Chance) {
        this.id = id;
        this.locationName = locationName;
        this.monsterChance = monsterChance;
        this.treasureChance = treasureChance;
        this.encounterChance = encounterChance;
        this.locationDifficulty = locationDifficulty;
        this.monsterId1 = monsterId1;
        this.monsterId1Chance = monsterId1Chance;
        this.monsterId2 = monsterId2;
        this.monsterId2Chance = monsterId2Chance;
        this.monsterId3 = monsterId3;
        this.monsterId3Chance = monsterId3Chance;
        this.monsterId4 = monsterId4;
        this.monsterId4Chance = monsterId4Chance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;    }

    public int getMonsterChance() {
        return monsterChance;
    }

    public int getTreasureChance() {
        return treasureChance;
    }

    public int getEncounterChance() {
        return encounterChance;
    }

    public int getLocationDifficulty() {
        return locationDifficulty;
    }

    public int getMonsterId1() {
        return monsterId1;
    }

    public int getMonsterId1Chance() {
        return monsterId1Chance;
    }

    public int getMonsterId2() {
        return monsterId2;
    }

    public int getMonsterId2Chance() {
        return monsterId2Chance;
    }

    public int getMonsterId3() {
        return monsterId3;
    }

    public int getMonsterId3Chance() {
        return monsterId3Chance;
    }

    public int getMonsterId4() {
        return monsterId4;
    }

    public int getMonsterId4Chance() {
        return monsterId4Chance;
    }

    public void set(Location randomLocationBoundedByPlayerLevel) {
    }
}
