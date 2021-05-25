package pl.sda.view.core;

public class ConsoleRunner {


    private final ConsoleView view;

    public ConsoleRunner(ConsoleView view) {
        this.view = view;
    }

    public void runMenu() {

            view.printAndSelectMenuOption();
    }


}