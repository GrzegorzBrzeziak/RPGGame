package pl.sda.controller;

import pl.sda.view.core.ConsoleRunner;
import pl.sda.view.core.ConsoleView;
import pl.sda.view.core.Menu;
import pl.sda.view.core.MenuItem;

import java.util.Scanner;

public class Controller {
    private ConsoleRunner runner;
    private ConsoleView view;
    private final Scanner input = new Scanner(System.in);

    public void MenuController() {
        Menu menu = new Menu();
        view = new ConsoleView(menu, System.in);
        runner = new ConsoleRunner(view);

        menu.addMenuItem(new MenuItem(
                "Dodaj nowy quiz",
                Menu.DEFAULT_QUIT
        ));

        menu.addMenuItem(new MenuItem(
                "Koniec",
                Menu.DEFAULT_QUIT
        ));


    }
    public void start() {
        runner.run();
    }
}
