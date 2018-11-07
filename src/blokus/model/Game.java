package blokus.model;

import blokus.exception.ModelException;
import java.util.List;
import java.util.Observable;

/**
 * Represents the game.
 *
 * @author Logan Farci (47923)
 */
public interface Game {

    /**
     * Gets the board game.
     *
     * @return the board game.
     */
    public Piece[][] getBoard();

    /**
     * Gets the color of the square located at the given position in the board.
     *
     * @param row is the row of the square.
     * @param column is the column of the square.
     * @return the color of the square located at the given position.
     * <code>null</code> is returned when the given square is empty.
     */
    public String getBoardColorAt(int row, int column);

    /**
     * Tells if the given position is inside the given piece.
     *
     * @param row the row of the position.
     * @param column the column of the position.
     * @return true if the given position in the given piece.
     */
    public boolean isInsidePiece(Piece piece, int row, int column);

    /**
     * Gets the color name of the given piece.
     *
     * @param piece is the piece to get the color name for.
     * @return the color name of the given piece.
     */
    public String getPieceColor(Piece piece);

    /**
     * Gets the size of the given piece.
     *
     * @param piece is the piece to get the size for.
     * @return the size of the given piece.
     */
    public int getPieceSize(Piece piece);

    /**
     * Gets the current player id of the game.
     *
     * @return the current player id of the game.
     */
    public int getCurrentPlayerId();

    /**
     * Gets the piece selected by the current player.
     *
     * @return the piece selected by the current player.
     */
    public Piece getCurrentPlayerPiece();

    /**
     * Gets the player matching the given id.
     *
     * @param playerId is the id of the player.
     * @return the player.
     */
    public Player getPlayer(int playerId);

    /**
     * Gets the player score matching the given id.
     *
     * @param playerId is the id of the player.
     * @return the score of the given player.
     */
    public int getPlayerScore(int playerId);

    /**
     * Gets the player color name matching the given id.
     *
     * @param playerId is the id of the player.
     * @return the color name of the given player.
     */
    public String getPlayerColor(int playerId);

    /**
     * Gets the player stock matching the given id.
     *
     * @param playerId is the id of the player.
     * @return the stock of the given player.
     */
    public List<Piece> getPlayerStock(int playerId);

    /**
     * Gets the winner of the game. The winner has the highest score. If two
     * players happen to have the same highest score, they both win the game.
     *
     * @return the winner(s).
     */
    public List<Player> getWinner();

    /**
     * Indicates the end of the game. The game is over either when all players have 
     * placed all of their pieces.
     *
     * @return true if the game is over.
     */
    public boolean isOver();

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

}
