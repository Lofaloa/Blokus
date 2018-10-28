package blokus.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a stock of 21 pieces.
 *
 * @author g47923
 */
class Stock {

    private final List<Piece> pieces;

    /**
     * Initializes this stock with 21 distinct pieces of the given color.
     *
     * @param color is the color of this stock.
     */
    public Stock(Color color) {
        this.pieces = buildPiecesOf(color);
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
     * Gets a piece of this stock by its shape.
     *
     * @param shape is the shape of the wanted piece.
     * @return the wanted piece if it is in this stock, if not null is returned.
     */
    Piece getPieceBy(Shape shape) {
        Piece wantedPiece = null;
        for (Piece piece : pieces) {
            if (shape == piece.getShape()) {
                wantedPiece = piece;
            }
        }
        pieces.remove(wantedPiece);
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
