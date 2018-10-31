package blokus.controller;

import blokus.model.Game;
import blokus.view.console.View;

/**
 * Manages the logic of the console version of the game.
 *
 * @author g47923
 */
public class ControllerConsole {

    private final Game game;
    private final View view;

    /**
     * Initializes this controller with the given view and game.
     *
     * @param game is the game to control.
     * @param view is the view of the game to control.
     */
    public ControllerConsole(Game game, View view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Launches <i>Blokus</i>.
     */
    public void launch() {
        view.printStart();
        while (true) {
            view.executeCommand();
        }
    }

}
