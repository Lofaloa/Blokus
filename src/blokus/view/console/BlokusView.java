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
     * Prints the current state of the board.
     */
    public void printBoard();

    /**
     * Prints the current player of the game.
     */
    public void printCurrentPlayer();
    
    /**
     * Prints the current player stock.
     */
    public void printCurrentPlayerStock();

    /**
     * Prints the current player score.
     */
    public void printCurrentPlayerScore();
    
    /**
     * Prints the message of the given exception.
     * 
     * @param exception is the exception to print a message for.
     */
    public void printExceptionMessage(Exception exception);

    /**
     * Reads a command entered by an user.
     * 
     * @return an array of tokens forming the read command.
     */
    public String[] readCommand();

    /**
     * Prints the results of the finished game. Each player and their score.
     */
    public void printEnd();

}
