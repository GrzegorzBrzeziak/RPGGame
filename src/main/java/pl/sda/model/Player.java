package pl.sda.model;

import com.opencsv.bean.CsvBindByName;

public class Player {
    @CsvBindByName
    private int hp;
    @CsvBindByName
    private int minAttack;
    @CsvBindByName
    private int maxAttack;
    @CsvBindByName
    private int armor;
    @CsvBindByName
    private int maxHp;
    @CsvBindByName
    private int criticalChance;
    @CsvBindByName
    private double criticalMultiplayer;



    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMinAttack() {
        return minAttack;
    }

    public void setMinAttack(int minAttack) {
        this.minAttack = minAttack;
    }

    public int getMaxAttack() {
        return maxAttack;
    }

    public void setMaxAttack(int maxAttack) {
        this.maxAttack = maxAttack;
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

    public int getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(int criticalChance) {
        this.criticalChance = criticalChance;
    }

    public double getCriticalMultiplayer() {
        return criticalMultiplayer;
    }

    public void setCriticalMultiplayer(double criticalMultiplayer) {
        this.criticalMultiplayer = criticalMultiplayer;
    }

    public Player() {
    }

    public Player(int hp, int minAttack, int maxAttack, int armor, int maxHp, int criticalChance, double criticalMultiplayer) {
        this.hp = hp;
        this.minAttack = minAttack;
        this.maxAttack = maxAttack;
        this.armor = armor;
        this.maxHp = maxHp;
        this.criticalChance = criticalChance;
        this.criticalMultiplayer = criticalMultiplayer;
    }
}
