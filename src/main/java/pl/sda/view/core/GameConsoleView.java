package pl.sda.view.core;

import java.io.InputStream;
import java.util.Scanner;

public class GameConsoleView{
    private final Game game;
    private final Scanner scanner;


    public GameConsoleView(Game game, InputStream inputStream) {
        this.game = game;
        this.scanner = new Scanner(inputStream);
    }

    public boolean printAndSelectGameOption() {
        game.print();
        if (scanner.hasNextInt()) {
            int option = scanner.nextInt();
            scanner.nextLine();
            return game.process(option);
        }
        scanner.nextLine();
        return false;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }




}
