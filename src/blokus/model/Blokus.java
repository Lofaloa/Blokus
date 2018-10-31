package blokus.model;

import java.util.List;

/**
 * Represents the game.
 *
 * @author g47923
 */
public interface Blokus {

    /**
     * Gets the current player of the game.
     *
     * @return the current player of the game.
     */
    public Player getCurrentPlayer();

    /**
     * Gets the current player piece.
     *
     * @return the current player piece.
     */
    public Piece getCurrentPlayerPiece();

    /**
     * Gets the current player stock.
     *
     * @return the current player stock.
     */
    public List<Piece> getCurrentPlayerStock();

    /**
     * Gets the board game.
     *
     * @return the board game.
     */
    public Piece[][] getBoard();

    /**
     * Gets the winner of the game. The winner has the highest score. If two
     * players happen to have the same highest score, they both win the game.
     *
     * @return the winner(s).
     */
    public List<Player> getWinner();

    /**
     * Indicates the end of the game.
     *
     * @return true if the game is over.
     */
    public boolean isOver();

    /**
     * Starts a game of <i>Blokus</i>.
     */
    public void start();

    /**
     * Selects the piece of the current player.
     *
     * @param id is the piece id;
     */
    public void selectCurrentPlayerPiece(int id);

    /**
     * Places the current player piece on the board at the given position.
     *
     * @param row is a row of the board.
     * @param column is a column of the board.
     */
    public void placePiece(int row, int column);

    /**
     * Passes to the next player.
     */
    public void nextPlayer();

    /**
     * Clears the board game.
     */
    public void clear();

}
