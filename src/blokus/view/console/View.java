package blokus.view.console;

import blokus.model.Blokus;

/**
 * Represents the view.
 *
 * @author Logan Farci (47923)
 */
public class View implements BlokusView {

    private final Input in;
    private final Output out;

    /**
     * Initializes this view with the game to represent.
     * 
     * @param game is the game to represent.
     */
    public View(Blokus game) {
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
