package pl.sda.controller;

import pl.sda.GameApp;
import pl.sda.model.Location;
import pl.sda.repository.LocationRepoImpl;
import pl.sda.service.EventServiceImpl;
import pl.sda.view.core.*;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
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
        AtomicReference<Location> location4 = new AtomicReference<>(impl.getRandomLocation(locationList));
        EventServiceImpl eventService = new EventServiceImpl();
        Game game = new Game();
        gameView = new GameConsoleView(game, System.in);
        gameRunner = new ConsoleGameRunner(gameView);

        game.addGameItem(new GameItem(1,
                "Idź do: " + location1.get().getLocationName(),
                () -> {
                    eventService.eventRandomizer(location1.get(), GameApp.controller.getPlayer());
                    location1.set(impl.getRandomLocation(locationList));
                    game.getItemByID(1).setLabel("Idź do: " + location1.get().getLocationName());
                }
        ));
        game.addGameItem(new GameItem(2,
                "Idź do: " + location2.get().getLocationName(),
                () -> {
                    eventService.eventRandomizer(location2.get(), GameApp.controller.getPlayer());
                    location2.set(impl.getRandomLocation(locationList));
                    game.getItemByID(2).setLabel("Idź do: " + location2.get().getLocationName());
                }
        ));


            game.addGameItem(new GameItem(3,
                    "Idź do: " + location3.get().getLocationName(),
                    () -> {
                        eventService.eventRandomizer(location3.get(), GameApp.controller.getPlayer());
                        location3.set(impl.getRandomLocation(locationList));
                        game.getItemByID(3).setLabel("Idź do: " + location3.get().getLocationName());
                    }

            ));


            game.addGameItem(new GameItem(4,
                    "Idź do: " + location4.get().getLocationName(),
                    () -> {
                        eventService.eventRandomizer(location4.get(), GameApp.controller.getPlayer());
                        location4.set(impl.getRandomLocation(locationList));
                        game.getItemByID(4).setLabel("Idź do: " + location4.get().getLocationName());
                    }
            ));


        game.addGameItem(new GameItem(5,
                "Powrót do menu",
                () -> {
                    gameRunner.closeGameLoop();
                }
        ));
    }

    public void start() {
        gameRunner.openGameLoop();
        gameRunner.runGameLoop();
    }
}

