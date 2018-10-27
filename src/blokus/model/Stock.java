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

/*
    A SUPPRIMER AVANT REMISE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
*/
class Test {
    public static void main(String[] args) {
        Stock s = new Stock(Color.BLUE);

        for (int i = 0; i < 21; i++) {
            System.out.println("SHAPE NUMERO " + i);
            printPiece(s.getPieceBy(i));
        }

    }

    public static boolean isInPiece(Position pos, Piece piece) {
        for (Position p : piece.getPositions()) {
            if (p.equals(pos)) return true;
        }
        return false;
    }

    public static void printPiece(Piece p) {
        List<Position> pos = p.getPositions();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (isInPiece(new Position(i, j), p)) {
                    System.out.print(" x ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println(" ");
        }
    }
}
