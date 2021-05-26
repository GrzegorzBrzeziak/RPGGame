package pl.sda.view.core;

public class ConsoleGameRunner {


    private final GameConsoleView gameView;
    private boolean game_runner = true;


    public ConsoleGameRunner(GameConsoleView gameView) {
        this.gameView = gameView;
    }

    public void runGameLoop() {

        while(game_runner == true){
            if (!gameView.printAndSelectGameOption()){
                gameView.printMessage("Brak takiej opcji!");
            }
        }
    }

    public void closeGameLoop(){
        game_runner = false;
    }

}
