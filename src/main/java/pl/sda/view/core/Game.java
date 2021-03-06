package pl.sda.view.core;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<GameItem> gameItems = new ArrayList<>();
    public static Runnable DEFAULT_QUIT = () -> System.exit(0);

    public void addGameItem(GameItem item) {
        gameItems.add(item);
    }

    public void print() {
        for (int i = 0; i < gameItems.size(); i++) {
            System.out.println((i + 1) + ". " + gameItems.get(i).getLabel());
        }
    }

    private void runGameItemAction(int option) {
        gameItems.get(option - 1).getAction().run();
    }

    private boolean isItemAt(int position) {
        int index = position - 1;
        return index >= 0 && index < gameItems.size();
    }

    public GameItem getItemByID(int itemID) {
        for (int i = 0; i < this.gameItems.size(); i++) {
            GameItem gameItemTmp = this.gameItems.get(i);
            if (gameItemTmp.getId() == itemID) {
                return gameItemTmp;
            }
        }

        return null;
    }


    public boolean process(int option) {
        if (isItemAt(option)) {
            runGameItemAction(option);
            return true;
        } else {
            return false;
        }
    }
}

