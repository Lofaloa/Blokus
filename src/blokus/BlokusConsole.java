package blokus;

import blokus.controller.ControllerConsole;
import blokus.model.Game;
import blokus.view.console.View;

/**
 * Entry point for the console version.
 *
 * @author g47923
 */
public class BlokusConsole {

    public static void main(String[] args) {
        Game game = new Game();
        View view = new View(game);
        ControllerConsole controller = new ControllerConsole(game, view);
        controller.start();
    }

}
