package pl.sda.model;

import com.opencsv.bean.CsvBindByName;

public class Encounter {
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

    public Encounter() {
    }

    public Encounter(int id, String name, int hp, int attack, int armor) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.armor = armor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
