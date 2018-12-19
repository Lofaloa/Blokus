package blokus.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a stock of 21 pieces.
 *
 * @author Logan Farci (47923)
 */
public class Stock {

    /**
     * Is the number of pieces that can fit in a stock.
     */
    public static final int CAPACITY = 22;

    private final List<Piece> pieces;
    private final BlokusColor color;
    private Piece lastTakenPiece;

    /**
     * Initializes this stock with 21 distinct pieces of the given color.
     *
     * @param color is the color of this stock.
     */
    Stock(BlokusColor color) {
        this.pieces = new ArrayList<>();
        this.color = color;
        initialize();
    }

    Stock(List<Piece> pieces, BlokusColor color) {
        this.pieces = pieces;
        this.color = color;
    }

    /**
     * Indicates that this stock is empty.
     *
     * @return true if this stock is empty.
     */
    boolean isEmpty() {
        return pieces.isEmpty();
    }

    /**
     * Gets this stock pieces.
     *
     * @return this stock pieces.
     */
    List<Piece> getPieces() {
        return pieces;
    }

    BlokusColor getColor() {
        return color;
    }

    /**
     * Gets the number of unit squares contained in this stock.
     *
     * @return the number of unit squares contained in this stock.
     */
    int getNbOfSquares() {
        if (isEmpty()) {
            return 0;
        } else {
            int nbOfSquare = 0;
            nbOfSquare = pieces.stream()
                    .map(piece -> piece.getShape().getNbOfSquares())
                    .reduce(nbOfSquare, Integer::sum);
            return nbOfSquare;
        }
    }

    /**
     * Gets the score of this stock.
     *
     * @return the score of this stock.
     */
    int getScore() {
        int score = 0;
        if (isEmpty()) {
            score += 15;
            if (lastTakenPiece.isSmallestPiece()) {
                score += 5;
            }
        } else {
            score -= getNbOfSquares();
        }
        return score;
    }

    /**
     * Gets the piece of the given shape in this stock.
     *
     * @param shape is the shape of the piece to get.
     * @return the piece of the given shape. If no piece is found
     * <code>null</code> is returned.
     */
    Piece getPiece(Shape shape) {
        Objects.requireNonNull(shape, "No given shape.");
        for (Piece piece : pieces) {
            if (shape == piece.getShape()) {
                return piece;
            }
        }
        return null;
    }

    /**
     * Throws an exception if this stock is empty.
     */
    void requireNonEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException("This stock is empty, no pieces to remove.");
        }
    }

    /**
     * Throws an exception if the given color does not match this stock color.
     *
     * @param color is the color to test.
     */
    void requireMatchingColor(BlokusColor color) {
        if (color != this.color) {
            throw new IllegalArgumentException("The given piece does not match "
                    + "this stock color, " + this.color + " is expected but was "
                    + color + ".");
        }
    }

    /**
     * Removes the given piece.
     *
     * @param piece the piece to remove.
     */
    void remove(Piece piece) {
        Objects.requireNonNull(piece);
        requireMatchingColor(piece.getColor());
        requireNonEmpty();
        lastTakenPiece = piece;
        pieces.remove(piece);
    }

    /**
     * Tells if this stock contains a piece of the given shape.
     *
     * @param shapeId is the id of the shape to look for.
     * @return true if a piece of given shape is in this stock.
     */
    boolean contains(Piece piece) {
        Objects.requireNonNull(piece);
        requireMatchingColor(piece.getColor());
        return pieces.contains(piece);
    }

    /**
     * Clears this stock.
     */
    void clear() {
        requireNonEmpty();
        lastTakenPiece = pieces.get(CAPACITY - 1);
        pieces.clear();
    }

    /**
     * Initializes this stock pieces.
     */
    final void initialize() {
        pieces.clear();
        for (Shape shape : Shape.values()) {
            pieces.add(new Piece(shape, color));
        }
    }

}
