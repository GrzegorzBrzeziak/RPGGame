package pl.sda.model;

import com.opencsv.bean.CsvBindByName;

public class EncounterModel {
    @CsvBindByName
    private int id;

    @CsvBindByName
    private String name;

    @CsvBindByName
    private int hp;

    @CsvBindByName
    private int attack;

    @CsvBindByName
    private int armor;
}
