package blokus.view.console;

/**
 * Manages the input and the output of <i>Blokus</i>.
 *
 * @author Logan Farci (47923)
 */
public interface BlokusView {

    /**
     * Prints the title of the game and a help for the players.
     */
    public void printStart();

    /**
     * Prints the current player of the game.
     */
    public void printCurrentPlayer();

    /**
     * Reads and execute a command entered by an user.
     */
    public void executeCommand();

    /**
     * Prints the results of the finished game. Each player and their score.
     */
    public void printEnd();

}
