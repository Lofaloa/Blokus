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

    public ControllerConsole(Game game, View view) {
        this.game = game;
        this.view = view;
    }

    public void start() {
        view.printStart();
        while (true) {
            view.executeCommand();
        }
    }

}
