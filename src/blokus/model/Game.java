package blokus.model;

import blokus.exception.IllegalActionException;
import blokus.exception.ModelException;
import java.util.List;

/**
 * Represents the game.
 *
 * @author Logan Farci (47923)
 */
public interface Game {

    public List<Player> getPlayers();

    /**
     * Gets the current player of the game.
     *
     * @return the current player of the game.
     */
    public Player getCurrentPlayer();

    /**
     * Gets the piece selected by the current player.
     *
     * @return the piece selected by the current player.
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
     * Indicates the end of the game. The game is over either when one of the
     * player has placed all of her/ his pieces.
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
     * @throws ModelException if the given id is not valid.
     */
    public void selectCurrentPlayerPiece(int id) throws ModelException;

    /**
     * Places the current player piece on the board at the given position.
     *
     * @param row is a row of the board.
     * @param column is a column of the board.
     * @throws ModelException if the given row and column are not valid.
     */
    public void placePiece(int row, int column) throws ModelException;

    /**
     * Passes to the next player.
     */
    public void nextPlayer();

    /**
     * Clears the board game.
     */
    public void clear();

}
