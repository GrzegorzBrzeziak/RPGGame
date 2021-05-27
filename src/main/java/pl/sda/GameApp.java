package pl.sda;

import pl.sda.controller.Controller;

public class GameApp {
    public static final Controller controller = new Controller();

    public static void main(String[] args) {

        controller.start();
    }


}
