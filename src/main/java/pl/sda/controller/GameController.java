package pl.sda.controller;

import pl.sda.repository.LocationRepo;
import pl.sda.view.core.*;

import java.util.Scanner;

public class GameController {
    private GameConsoleView gameView;
    private ConsoleGameRunner gameRunner;
    private final Scanner input = new Scanner(System.in);

    public GameController() {
        Game game = new Game();

        gameView = new GameConsoleView(game, System.in);
        gameRunner = new ConsoleGameRunner(gameView);

        game.addGameItem(new GameItem(
                "Idź do: ",
                () ->{

                }
        ));
        game.addGameItem(new GameItem(
                "Idź do: ",
                Game.DEFAULT_QUIT
        ));

        game.addGameItem(new GameItem(
                "Idź do: ",
                Game.DEFAULT_QUIT
        ));



    }

    public void start() {
        gameRunner.runGameLoop();
    }
}

