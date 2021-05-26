package pl.sda.controller;

import pl.sda.view.core.*;

import java.util.Scanner;

public class Controller {
    private ConsoleRunner runner;
    private ConsoleView view;
    private final Scanner input = new Scanner(System.in);

    public Controller() {
        Menu menu = new Menu();
        GameController gameController = new GameController();
        view = new ConsoleView(menu, System.in);
        runner = new ConsoleRunner(view);
        menu.addMenuItem(new MenuItem(
                "Zacznij grę",
                () -> {
                    gameController.start();
                }
        ));

        menu.addMenuItem(new MenuItem(
                "Załaduj grę",
                () -> {

                }
        ));

//        TODO
//        menu.addMenuItem(new MenuItem(
//                "Zapisz grę",
//                Menu.DEFAULT_QUIT
//        ));

        menu.addMenuItem(new MenuItem(
                "Koniec",
                Menu.DEFAULT_QUIT
        ));
    }

    public void start() {
        runner.runMenu();
    }
}
