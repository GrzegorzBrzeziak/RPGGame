package pl.sda.model;

import com.opencsv.bean.CsvBindByName;

public class Player {
    @CsvBindByName
    private int hp;
    @CsvBindByName
    private int attack;
    @CsvBindByName
    private int armor;
    @CsvBindByName
    private int maxHp;



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

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public Player() {
    }

    public Player(int hp, int attack, int armor, int maxHp) {
        this.hp = hp;
        this.attack = attack;
        this.armor = armor;
        this.maxHp = maxHp;
    }
}
