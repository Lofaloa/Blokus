package blokus.model;

import java.util.Collections;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author g47923
 */
public class StockTest {

    @Test
    public void stockAfterInitializationShouldHave21DistinctPieceOfOneColor() {
        Stock s = new Stock(Color.RED);
        assertEquals(21, s.getPieces().size());
        for (Piece piece : s.getPieces()) {
            assertEquals(1, Collections.frequency(s.getPieces(), piece));
        }
    }

    @Test
    public void pieceGotByShapeShouldBeWantedPiece() {
        Stock s = new Stock(Color.BLUE);
        Piece piece = s.getPieceBy(Shape.SHAPE_15);
        assertEquals(Shape.SHAPE_15, piece.getShape());
        assertEquals(20, s.getPieces().size());
    }

    @Test
    public void nullShouldBeReturnedIfAskedShapeIsNotInStock() {
        Stock s = new Stock(Color.BLUE);
        s.getPieceBy(Shape.SHAPE_15);
        Piece notFoundPiece = s.getPieceBy(Shape.SHAPE_15);
        assertEquals(null, notFoundPiece);
    }
    
}
