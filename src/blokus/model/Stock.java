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
    Stock(Color color) {
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
     * Gets the last taken piece.
     *
     * @return the last taken piece.
     */
    Piece getLastTakenPiece() {
        return new Piece(lastTakenPiece.getShape(), lastTakenPiece.getColor());
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
            for (Piece piece : pieces) {
                nbOfSquare += piece.getShape().getSize();
            }
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
            if (lastTakenPiece.getShape() == Shape.SHAPE_01) {
                System.out.println("test");
                score += 5;
            }
        } else {
            score -= getNumberOfSquares();
        }
        return score;
    }

    /**
     * Gets a piece of this stock by its shape.
     *
     * @param shape is the shape of the wanted piece.
     * @return the wanted piece if it is in this stock, if not null is returned.
     */
    Piece getPiece(Shape shape) {
        Piece wantedPiece = null;
        for (Piece piece : pieces) {
            if (shape == piece.getShape()) {
                wantedPiece = piece;
            }
        }
        return wantedPiece;
    }

    /**
     * Gets a piece of this stock by its shape and remove it.
     *
     * @param shape is the shape of the wanted piece.
     * @return the wanted piece if it is in this stock, if not null is returned.
     */
    Piece takePiece(Shape shape) {
        Piece wantedPiece = getPiece(shape);
        pieces.remove(wantedPiece);
        lastTakenPiece = wantedPiece;
        return wantedPiece;
    }

    /**
     * Builds this stock pieces.
     *
     * @param color is the color of this stock.
     * @return the newly built pieces.
     */
    final List<Piece> buildPiecesOf(Color color) {
        List<Piece> builtPieces = new ArrayList<>();
        for (Shape shape : Shape.values()) {
            builtPieces.add(new Piece(shape, color));
        }
        return builtPieces;
    }

}
