package blokus.model;

/**
 * Represents a move made by a player.
 *
 * @author Logan Farci (47923)
 */
public interface Move {

    Piece getPiece();
    
    Player getPlayer();

    /**
     * Executes this move.
     */
    void execute();

}
