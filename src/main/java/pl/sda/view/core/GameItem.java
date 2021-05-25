package pl.sda.view.core;

public class GameItem {
    public final String label;
    public final Runnable action;

    public GameItem(String label, Runnable action) {
        this.label = label;
        this.action = action;
    }
}
