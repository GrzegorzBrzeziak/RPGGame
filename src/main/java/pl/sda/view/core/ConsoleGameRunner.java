package pl.sda.view.core;

public class ConsoleGameRunner {


    private final GameConsoleView gameView;


    public ConsoleGameRunner(GameConsoleView gameView) {
        this.gameView = gameView;
    }

    public void runGameLoop() {

        while(true){
            if (!gameView.printAndSelectGameOption()){
                gameView.printMessage("Brak takiej opcji!");
            }
        }
    }
}
