package pl.sda.controller;

import pl.sda.GameApp;
import pl.sda.model.Location;
import pl.sda.repository.LocationRepoImpl;
import pl.sda.service.EventServiceImpl;
import pl.sda.view.core.*;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class GameController {
    private GameConsoleView gameView;
    private ConsoleGameRunner gameRunner;
    private final Scanner input = new Scanner(System.in);


    public void initialize() {
        EventServiceImpl eventService = new EventServiceImpl();
        Game game = new Game();
        gameView = new GameConsoleView(game, System.in);
        gameRunner = new ConsoleGameRunner(gameView);
        LocationRepoImpl impl = new LocationRepoImpl();

        game.addGameItem(new GameItem(1,
                "Idź do: " + eventService.getLocation1().getLocationName() + " " +  eventService.getLocation1().getLocationDifficulty(),
                () -> {
                    eventService.eventRandomizer(eventService.getLocation1(), GameApp.controller.getPlayer());
                    eventService.setLocation1(impl.getRandomLocationBoundedByPlayerLevel(eventService.getLocationList(), GameApp.controller.getPlayer()));
                    game.getItemByID(1).setLabel("Idź do: " + eventService.getLocation1().getLocationName() + " " +  eventService.getLocation1().getLocationDifficulty());
                }
        ));
        game.addGameItem(new GameItem(2,
                "Idź do: " + eventService.getLocation2().getLocationName() + " " +  eventService.getLocation2().getLocationDifficulty(),
                () -> {
                    eventService.eventRandomizer(eventService.getLocation2(), GameApp.controller.getPlayer());
                    eventService.setLocation2(impl.getRandomLocationBoundedByPlayerLevel(eventService.getLocationList(), GameApp.controller.getPlayer()));
                    game.getItemByID(2).setLabel("Idź do: " + eventService.getLocation2().getLocationName()+ " " +  eventService.getLocation2().getLocationDifficulty());
                }
        ));


        game.addGameItem(new GameItem(3,
                "Idź do: " + eventService.getLocation3().getLocationName() + " " +  eventService.getLocation3().getLocationDifficulty(),
                () -> {
                    eventService.eventRandomizer(eventService.getLocation3(), GameApp.controller.getPlayer());
                    eventService.setLocation3(impl.getRandomLocationBoundedByPlayerLevel(eventService.getLocationList(), GameApp.controller.getPlayer()));
                    game.getItemByID(3).setLabel("Idź do: " + eventService.getLocation3().getLocationName()+ " " +  eventService.getLocation3().getLocationDifficulty());
                }

        ));


        game.addGameItem(new GameItem(4,
                "Idź do: " + eventService.getLocation4().getLocationName()+ " " +  eventService.getLocation4().getLocationDifficulty(),
                () -> {
                    eventService.eventRandomizer(eventService.getLocation4(), GameApp.controller.getPlayer());
                    eventService.setLocation4(impl.getRandomLocationBoundedByPlayerLevel(eventService.getLocationList(), GameApp.controller.getPlayer()));
                    game.getItemByID(4).setLabel("Idź do: " + eventService.getLocation4().getLocationName()+ " " +  eventService.getLocation4().getLocationDifficulty());
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

