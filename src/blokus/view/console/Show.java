package blokus.view.console;

import blokus.model.Game;

/**
 * Represents the <i>show</i> command. Once executed the current state of the game
 * board is printed.
 *
 * @author g47923
 */
public class Show implements Command {

    private final Game game;

    public Show(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        new View(game).printBoard();
    }

}
