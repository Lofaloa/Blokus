package blokus.model;

import java.util.List;

/**
 * Represents the game.
 *
 * @author g47923
 */
public interface Blokus {

    /**
     * Starts a game of <i>Blokus</i>.
     */
    public void start();

    /**
     * Indicates the end of the game.
     *
     * @return true if the game is over.
     */
    public boolean isOver();

    /**
     * Gets the winner of the game. The winner has the highest score. If two
     * players happen to have the same highest score, they both win the game.
     *
     * @return the winner(s).
     */
    public List<Player> getWinner();

    /**
     * Gets the current player of the game.
     *
     * @return the current player of the game.
     */
    public Player getCurrentPlayer();

    /**
     * Places the current player piece on the board at the given position.
     *
     * @param row is a row of the board.
     * @param column is a column of the board.
     */
    public void placePiece(int row, int column);

    /**
     * Clears the board game.
     */
    public void clear();

    /**
     * Gets the board game.
     *
     * @return the board game.
     */
    Piece[][] getBoard();

}
