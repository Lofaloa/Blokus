package blokus.view.console;

import blokus.model.Game;

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
    public View(Game game) {
        this.in = new Input();
        this.out = new Output(game);
    }

    @Override
    public void printStart() {
        out.printTitle();
    }

    public void printHelp() {
        out.printHelp();
    }

    @Override
    public void printBoard() {
        out.printBoard();
    }

    @Override
    public void printCurrentPlayer() {
        out.printCurrentPlayer();
    }

    @Override
    public void printCurrentPlayerStock() {
        out.printCurrentPlayerStock();
    }

    @Override
    public void printCurrentPlayerScore() {
        out.printCurrentPlayerScore();
    }

    @Override
    public void printPlayers() {
        out.printPlayers();
    }

    @Override
    public void printExceptionMessage(Exception exception) {
        out.printExceptionMessage(exception);
    }

    @Override
    public void printRestart() {
        out.printRestart();
    }

    @Override
    public void printRotation(int rotation) {
        out.printRotation(rotation);
    }

    @Override
    public String[] readCommand() {
        return in.readCommand();
    }

    @Override
    public boolean askConfirmation() {
        return in.askConfirmation();
    }

    @Override
    public void printEnd() {
        out.printEnd();
    }

}
