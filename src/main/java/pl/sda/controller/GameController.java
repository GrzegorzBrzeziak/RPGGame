package pl.sda.controller;

import pl.sda.model.Location;
import pl.sda.model.Player;
import pl.sda.repository.LocationRepo;
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
    private final Location location1 = impl.getRandomLocation(locationList);
    private final Location location2 = impl.getRandomLocation(locationList);
    private final Location location3 = impl.getRandomLocation(locationList);
    EventServiceImpl eventService = new EventServiceImpl();

    public GameController() {
        Game game = new Game();
        PlayerRepoImpl playerRepo = new PlayerRepoImpl();
        Player player = playerRepo.createNewPlayer();
        gameView = new GameConsoleView(game, System.in);
        gameRunner = new ConsoleGameRunner(gameView);



        game.addGameItem(new GameItem(
                "Idź do: " + location1.getLocationName(),
                () ->{eventService.eventRandomizer(location1);

                }
        ));
        game.addGameItem(new GameItem(
                "Idź do: " + location2.getLocationName(),
                () ->{eventService.eventRandomizer(location2);

                }
        ));

        game.addGameItem(new GameItem(
                "Idź do: " + location3.getLocationName(),
                () ->{eventService.eventRandomizer(location3);

                }
        ));

        game.addGameItem(new GameItem(
                "Powrót do menu",
                Game.DEFAULT_QUIT

        ));

    }

    public void start() {
        gameRunner.runGameLoop();
    }
}

