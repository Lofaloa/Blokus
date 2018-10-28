package blokus.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a stock of 21 pieces.
 *
 * @author g47923
 */
public class Stock {

    private final List<Piece> pieces;

    /**
     * Initializes this stock with 21 distinct pieces of the given color.
     *
     * @param color is the color of this stock.
     */
    public Stock(Color color) {
        this.pieces = buildPiecesOf(color);
    }

    public Piece getPieceBy(int id) {
        return pieces.get(id);
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
