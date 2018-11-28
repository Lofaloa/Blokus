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
     * Throws an exception if the stock is empty.
     */
    void requireNonEmptyStock() {
        stock.requireNonEmpty();
    }

    /**
     * Tells if this player owns a piece of the given shape.
     *
     * @param piece is the piece to look for.
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
        requireNonEmptyStock();
        stock.remove(piece);
    }

    /**
     * Gets one of the piece of this player stock.
     *
     * @param pieceId is the id of the piece to select.
     * @return the selected piece.
     */
    Piece getPiece(int pieceId) {
        requireNonEmptyStock();
        return stock.getPiece(Shape.values()[pieceId]);
    }

    /**
     * Clears this player stock.
     */
    void clearStock() {
        requireNonEmptyStock();
        stock.clear();
    }

    /**
     * Clears this player stock.
     */
    void clearStockSmallestPieceAtEnd() {
        requireNonEmptyStock();
        for (int i = 1; i < Stock.CAPACITY; i++) {
            remove(stock.getPieces().get(1));
        }
        remove(getStock().get(0));
    }

}
