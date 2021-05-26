package pl.sda.controller;

import pl.sda.model.Location;
import pl.sda.model.Player;
import pl.sda.repository.LocationRepoImpl;
import pl.sda.repository.PlayerRepoImpl;
import pl.sda.service.EventServiceImpl;
import pl.sda.view.core.*;

import java.util.List;
import java.util.Scanner;

public class GameController {
    private GameConsoleView gameView;
    private ConsoleGameRunner gameRunner;
    private final Scanner input = new Scanner(System.in);
    LocationRepoImpl impl = new LocationRepoImpl();
    List<Location> locationList = impl.ReadLocationsFromCSV();
    Location location1 = impl.getRandomLocation(locationList);
    Location location2 = impl.getRandomLocation(locationList);
    Location location3 = impl.getRandomLocation(locationList);
    EventServiceImpl eventService = new EventServiceImpl();

    public GameController() {





        Game game = new Game();
        PlayerRepoImpl playerRepo = new PlayerRepoImpl();
        Player player = playerRepo.createNewPlayer();
        gameView = new GameConsoleView(game, System.in);
        gameRunner = new ConsoleGameRunner(gameView);

        game.addGameItem(new GameItem(
                "Idź do: " + location1.getLocationName(),
                () -> {
                    eventService.eventRandomizer(location1, player);
                    location1 = impl.getRandomLocation(locationList);
                }
        ));
        game.addGameItem(new GameItem(
                "Idź do: " + location2.getLocationName(),
                () -> {
                    eventService.eventRandomizer(location2, player);
                    location2 = impl.getRandomLocation(locationList);
                }
        ));

        game.addGameItem(new GameItem(
                "Idź do: " + location3.getLocationName(),
                () -> {
                    eventService.eventRandomizer(location3, player);
                    location3 = impl.getRandomLocation(locationList);
                }
        ));

        game.addGameItem(new GameItem(
                "Powrót do menu",
                () -> {
                    gameRunner.closeGameLoop();
                }
        ));
    }

    public void start() {
        gameRunner.runGameLoop();
    }
}

