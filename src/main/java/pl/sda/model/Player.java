package pl.sda.model;

import com.opencsv.bean.CsvBindByName;

public class Player {
    @CsvBindByName
    private int hp;
    @CsvBindByName
    private int attack;
    @CsvBindByName
    private int armor;


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

    public Player() {
    }

    public Player(int hp, int attack, int armor) {
        this.hp = hp;
        this.attack = attack;
        this.armor = armor;

    }
}
