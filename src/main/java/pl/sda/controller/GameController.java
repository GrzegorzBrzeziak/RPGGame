package pl.sda.controller;

import pl.sda.model.Location;
import pl.sda.model.Player;
import pl.sda.repository.LocationRepoImpl;
import pl.sda.repository.PlayerRepoImpl;
import pl.sda.service.EventServiceImpl;
import pl.sda.view.core.*;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class GameController {
    private GameConsoleView gameView;
    private ConsoleGameRunner gameRunner;
    private final Scanner input = new Scanner(System.in);


    public GameController() {
        LocationRepoImpl impl = new LocationRepoImpl();
        List<Location> locationList = impl.ReadLocationsFromCSV();
        AtomicReference<Location> location1 = new AtomicReference<>(impl.getRandomLocation(locationList));
        AtomicReference<Location> location2 = new AtomicReference<>(impl.getRandomLocation(locationList));
        AtomicReference<Location> location3 = new AtomicReference<>(impl.getRandomLocation(locationList));
        EventServiceImpl eventService = new EventServiceImpl();
        Game game = new Game();
        PlayerRepoImpl playerRepo = new PlayerRepoImpl();
        Player player = playerRepo.createNewPlayer();
        gameView = new GameConsoleView(game, System.in);
        gameRunner = new ConsoleGameRunner(gameView);

        game.addGameItem(new GameItem(
                "Idź do: " + location1.get().getLocationName(),
                () -> {
                    eventService.eventRandomizer(location1.get(), player);
                    location1.set(impl.getRandomLocation(locationList));
                }
        ));
        game.addGameItem(new GameItem(
                "Idź do: " + location2.get().getLocationName(),
                () -> {
                    eventService.eventRandomizer(location2.get(), player);
                    location2.set(impl.getRandomLocation(locationList));
                }
        ));

        game.addGameItem(new GameItem(
                "Idź do: " + location3.get().getLocationName(),
                () -> {
                    eventService.eventRandomizer(location3.get(), player);
                    location3.set(impl.getRandomLocation(locationList));
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

