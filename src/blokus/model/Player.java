package blokus.model;

import java.util.List;

/**
 * Represents a player.
 *
 * @author Logan Farci (47923)
 */
class Player {

    private final Color color;
    private final Stock stock;

    /**
     * Initializes this player of the given color and a stock of 21 distinct
     * piece.
     *
     * @param color is the color of this player.
     */
    Player(Color color) {
        this.color = color;
        this.stock = new Stock(color);
    }

    /**
     * Gets the score of this player.
     *
     * @return the score of this player.
     */
    public int getScore() {
        return stock.getScore();
    }

    /**
     * Gets this player stock.
     *
     * @return this player stock.
     */
    public List<Piece> getStock() {
        return stock.getPieces();
    }

    /**
     * Gets this player color.
     *
     * @return this player color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Makes this player lose the given piece.
     *
     * @param piece is the piece to lose.
     */
    void loses(Piece piece) {
        stock.remove(piece);
    }

    /**
     * Tells if this player owns a piece of the given shape.
     *
     * @param shapeId is the id of the shape to look for.
     * @return true if the given shape is this player stock.
     */
    boolean ownsPieceOf(int shapeId) {
        return stock.contains(shapeId);
    }

    /**
     * Gets one of the piece of this player stock.
     *
     * @param pieceId is the id of the piece to select.
     * @return the selected piece.
     */
    Piece getPiece(int pieceId) {
        return stock.getPiece(Shape.values()[pieceId]);
    }

    /**
     * Clears this player stock.
     */
    void clearStock() {
        stock.getPieces().clear();
    }

}
