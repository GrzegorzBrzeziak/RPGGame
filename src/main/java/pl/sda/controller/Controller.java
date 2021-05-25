package pl.sda.controller;

import pl.sda.view.core.*;

import java.util.Scanner;

public class Controller {
    private ConsoleRunner runner;
    private ConsoleView view;
    private GameConsoleView gameView;
    private ConsoleGameRunner gameRunner;
    private final Scanner input = new Scanner(System.in);

    public Controller() {
        Menu menu = new Menu();
        Game game = new Game();
        view = new ConsoleView(menu, System.in);
        runner = new ConsoleRunner(view);
        gameView = new GameConsoleView(game, System.in);
        gameRunner = new ConsoleGameRunner(gameView);

        menu.addMenuItem(new MenuItem(
                "Zacznij grę",
                gameRunner.runGameLoop()));


//        TODO
//        menu.addMenuItem(new MenuItem(
//                "Załaduj grę",
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
