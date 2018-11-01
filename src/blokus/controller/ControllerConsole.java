package blokus.controller;

import blokus.model.Blokus;
import blokus.view.console.View;

/**
 * Manages the logic of the console version of the game.
 *
 * @author g47923
 */
public class ControllerConsole {

    private final Blokus game;
    private final View view;

    /**
     * Initializes this controller with the given view and game.
     *
     * @param game is the game to control.
     * @param view is the view of the game to control.
     */
    public ControllerConsole(Blokus game, View view) {
        this.game = game;
        this.view = view;
    }

    /**
     * Launches <i>Blokus</i>.
     */
    public void launch() {
        view.printStart();
        while (!game.isOver()) {
            try {
                view.printCurrentPlayer();
                view.executeCommand();
            } catch (Exception e) {
                System.out.println("usage: " + e.getMessage());
            }
        }
    }

}
