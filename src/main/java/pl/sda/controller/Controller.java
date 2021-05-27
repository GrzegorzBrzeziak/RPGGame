package pl.sda.controller;

import pl.sda.model.Player;
import pl.sda.repository.PlayerRepoImpl;
import pl.sda.view.core.*;

import java.util.Scanner;

public class Controller {
    private ConsoleRunner runner;
    private ConsoleView view;
    private final Scanner input = new Scanner(System.in);
    PlayerRepoImpl playerRepo = new PlayerRepoImpl();
    private Player player;
    GameController gameController = new GameController();

    public Controller() {
        Menu menu = new Menu();
        view = new ConsoleView(menu, System.in);
        runner = new ConsoleRunner(view);
        menu.addMenuItem(new MenuItem(
                "Zacznij grę",
                () -> {
                    player = playerRepo.createNewPlayer();
                    gameController.start();
                }
        ));

        menu.addMenuItem(new MenuItem(
                "Załaduj grę",
                () -> {
                    player = playerRepo.loadPlayer();

                    gameController.start();
                }
        ));

        menu.addMenuItem(new MenuItem(
                "Zapisz grę",
                ()-> {
                    playerRepo.savePlayer(player);
                }
        ));

        menu.addMenuItem(new MenuItem(
                "Koniec",
                Menu.DEFAULT_QUIT
        ));
    }

    public void start() {
        runner.runMenu();
    }


    public Player getPlayer() {
        return player;
    }

}


