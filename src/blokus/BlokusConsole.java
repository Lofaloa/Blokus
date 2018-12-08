package blokus;

import blokus.controller.ControllerConsole;
import blokus.model.Blokus;
import blokus.view.console.View;

/**
 * Main class of <i>Blokus</i> console version.
 *
 * @author g47923
 */
public class BlokusConsole {

    /**
     * Entry point of <i>Blokus</i> console version.
     *
     * @param args nothing.
     */
    public static void main(String[] args) {
        Blokus game = new Blokus();
        View view = new View(game);
        ControllerConsole controller = new ControllerConsole(game, view);
        controller.start();
    }

}
