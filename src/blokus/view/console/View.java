package blokus.view.console;

import blokus.model.Game;

/**
 * Represents the view.
 *
 * @author g47923
 */
public class View implements BlokusView {

    private final Input in;
    private final Output out;

    public View(Game game) {
        this.in = new Input(game);
        this.out = new Output(game);
    }

    @Override
    public void printStart() {
        out.printTitle();
        out.printHelp();
    }

    @Override
    public void printCurrentPlayer() {
        out.printCurrentPlayer();
    }

    @Override
    public void executeCommand() {
        in.executeCommand(in.readCommand());
    }

    @Override
    public void printEnd() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
