package blokus.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a stock of 21 pieces.
 *
 * @author Logan Farci (47923)
 */
class Stock {

    private final List<Piece> pieces;
    private Piece lastTakenPiece;

    /**
     * Initializes this stock with 21 distinct pieces of the given color.
     *
     * @param color is the color of this stock.
     */
    Stock(BlokusColor color) {
        this.pieces = buildPiecesOf(color);
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

    /**
     * Gets the number of unit squares contained in this stock.
     *
     * @return the number of unit squares contained in this stock.
     */
    int getNumberOfSquares() {
        if (isEmpty()) {
            return 0;
        } else {
            int nbOfSquare = 0;
            nbOfSquare = pieces.stream()
                               .map(piece -> piece.getShape().getSize())
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
            score -= getNumberOfSquares();
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
        for (Piece piece : pieces) {
            if (shape == piece.getShape()) {
                return piece;
            }
        }
        return null;
    }

    /**
     * Removes the given piece.
     *
     * @param piece the piece to remove.
     */
    void remove(Piece piece) {
        lastTakenPiece = piece;
        pieces.remove(piece);
    }

    /**
     * Tells if this stock contains a piece of the given shape.
     *
     * @param shapeId is the id of the shape to look for.
     * @return true if a piece of given shape is in this stock.
     */
    boolean contains(int shapeId) {
        Shape shape = Shape.values()[shapeId];
        return pieces.stream().anyMatch(piece -> shape == piece.getShape());
    }

    /**
     * Builds this stock pieces.
     *
     * @param color is the color of this stock.
     * @return the newly built pieces.
     */
    final List<Piece> buildPiecesOf(BlokusColor color) {
        List<Piece> builtPieces = new ArrayList<>();
        for (Shape shape : Shape.values()) {
            builtPieces.add(new Piece(shape, color));
        }
        return builtPieces;
    }

    /**
     * Clears this stock.
     */
    void clear() {
        pieces.clear();
    }

}
