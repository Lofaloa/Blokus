package blokus.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a stock of 21 pieces.
 *
 * @author g47923
 */
public class Stock {

    private final List<Piece> pieces;

    public Stock(Color color) {
        this.pieces = buildPieces();
    }

    final List<Piece> buildPieces() {
        List<Piece> pieces = new ArrayList<>(Arrays.asList(
                /*SIZE OF 1*/
                new Piece(new Position(0, 0)),
                /*SIZE OF 2*/
                new Piece(new Position(0, 0), new Position(1, 0)),
                /*SIZE OF 3*/
                new Piece(new Position(0, 0), new Position(1, 0),
                        new Position(2, 0)),
                new Piece(new Position(0, 0), new Position(1, 0),
                        new Position(1, 1)),
                /*SIZE OF 4*/
                new Piece(new Position(0, 0), new Position(1, 0),
                        new Position(2, 0), new Position(3, 0)),
                new Piece(new Position(2, 0), new Position(2, 1),
                        new Position(1, 1), new Position(0, 1)),
                new Piece(new Position(0, 0), new Position(1, 0),
                        new Position(2, 0), new Position(1, 1)),
                new Piece(new Position(0, 0), new Position(1, 0),
                        new Position(1, 1), new Position(0, 1)),
                new Piece(new Position(0, 0), new Position(0, 1),
                        new Position(1, 1), new Position(1, 2)),
                /*SIZE OF 5*/
                new Piece(new Position(0, 0), new Position(1, 0), new Position(2, 0),
                        new Position(3, 0), new Position(4, 0)),
                new Piece(new Position(3, 0), new Position(3, 1), new Position(2, 1),
                        new Position(1, 1), new Position(0, 1)),
                new Piece(new Position(0, 1), new Position(1, 1), new Position(2, 0),
                        new Position(2, 1), new Position(3, 0)),
                new Piece(new Position(0, 1), new Position(1, 0), new Position(1, 1),
                        new Position(2, 0), new Position(2, 1)),
                new Piece(new Position(0, 0), new Position(0, 1),
                        new Position(1, 1), new Position(2, 0), new Position(2, 1)),
                new Piece(new Position(0, 0), new Position(1, 0),
                        new Position(1, 1), new Position(2, 0), new Position(3, 0)),
                new Piece(new Position(0, 1), new Position(1, 1), new Position(2, 0),
                        new Position(2, 1), new Position(2, 2)),
                new Piece(new Position(0, 0), new Position(1, 0), new Position(2, 0),
                        new Position(2, 1), new Position(2, 2)),
                new Piece(new Position(0, 0), new Position(0, 1), new Position(1, 1),
                        new Position(1, 2), new Position(2, 2)),
                new Piece(new Position(0, 0), new Position(1, 0), new Position(1, 1),
                        new Position(1, 2), new Position(2, 2)),
                new Piece(new Position(0, 0), new Position(1, 0), new Position(1, 1),
                        new Position(1, 2), new Position(2, 1)),
                new Piece(new Position(0, 1), new Position(1, 1), new Position(1, 0),
                        new Position(1, 2), new Position(2, 1))
        ));
        return pieces;
    }

}
