package pl.sda.view.core;

public class GameItem {
    private final int id;
    private String label;
    private final Runnable action;

    public GameItem(int id, String label, Runnable action) {
        this.id = id;
        this.label = label;
        this.action = action;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public Runnable getAction() {
        return action;
    }
}
