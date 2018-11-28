package blokus.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents a player.
 *
 * @author Logan Farci (47923)
 */
public class Player {

    private final BlokusColor color;
    private final Stock stock;

    /**
     * Initializes this player of the given color and a stock of 21 distinct
     * piece.
     *
     * @param color is the color of this player.
     */
    Player(BlokusColor color) {
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
        return Collections.unmodifiableList(stock.getPieces());
    }

    /**
     * Gets this player color.
     *
     * @return this player color.
     */
    public BlokusColor getColor() {
        return color;
    }

    /**
     * Tells if this player owns a piece of the given shape.
     *
     * @param shapeId is the id of the shape to look for.
     * @return true if the given shape is this player stock.
     */
    public boolean owns(Piece piece) {
        Objects.requireNonNull(piece, "No given piece.");
        return stock.contains(piece);
    }

    /**
     * Makes this player lose the given piece.
     *
     * @param piece is the piece to lose.
     */
    void remove(Piece piece) {
        Objects.requireNonNull(piece, "No given piece.");
        if (stock.isEmpty()) {
            throw new IllegalStateException("This player stock is empty, no pieces to remove.");
        }
        stock.remove(piece);
    }

    /**
     * Gets one of the piece of this player stock.
     *
     * @param pieceId is the id of the piece to select.
     * @return the selected piece.
     */
    Piece getPiece(int pieceId) {
        if (stock.isEmpty()) {
            throw new IllegalStateException("This player stock is empty, no more pieces.");
        }
        return stock.getPiece(Shape.values()[pieceId]);
    }

    /**
     * Clears this player stock.
     */
    void clearStock() {
        if (stock.isEmpty()) {
            throw new IllegalStateException("This player stock is empty, nothing to clear");
        }
        stock.clear();
    }

    /**
     * Clears this player stock.
     */
    void clearStockSmallestPieceAtEnd() {
        if (stock.isEmpty()) {
            throw new IllegalStateException("This player stock is empty, nothing to clear");
        }
        for (int i = 1; i < Stock.CAPACITY; i++) {
            remove(stock.getPieces().get(1));
        }
        remove(getStock().get(0));
    }

}
