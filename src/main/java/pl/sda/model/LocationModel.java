package pl.sda.model;

import com.opencsv.bean.CsvBindByName;

public class LocationModel {

    @CsvBindByName
    private int id;

    @CsvBindByName(column = "name", required = true)
    private String locationName;

    @CsvBindByName(column = "monsterChance", required = true)
    private int monsterChanceEvent;

    @CsvBindByName(column = "treasureChance", required = true)
    private int treasureChanceEvent;

    @CsvBindByName(column = "encounterChance", required = true)
    private int encounterChanceEvent;


    public LocationModel(int id, String locationName, int monsterChanceEvent, int treasureChanceEvent, int encounterChanceEvent) {
        this.id = id;
        this.locationName = locationName;
        this.monsterChanceEvent = monsterChanceEvent;
        this.treasureChanceEvent = treasureChanceEvent;
        this.encounterChanceEvent = encounterChanceEvent;
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

    public int getMonsterChanceEvent() {
        return monsterChanceEvent;
    }

    public void setMonsterChanceEvent(int monsterChanceEvent) {
        this.monsterChanceEvent = monsterChanceEvent;
    }

    public int getTreasureChanceEvent() {
        return treasureChanceEvent;
    }

    public void setTreasureChanceEvent(int treasureChanceEvent) {
        this.treasureChanceEvent = treasureChanceEvent;
    }

    public int getEncounterChanceEvent() {
        return encounterChanceEvent;
    }

    public void setEncounterChanceEvent(int encounterChanceEvent) {
        this.encounterChanceEvent = encounterChanceEvent;
    }
}
