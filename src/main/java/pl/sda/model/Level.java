package pl.sda.model;

import com.opencsv.bean.CsvBindByName;

public class Level {
    @CsvBindByName
    private int id;
    @CsvBindByName
    private int xp;


    public Level(int id, int xp) {
        this.id = id;
        this.xp = xp;
    }

    public Level() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
