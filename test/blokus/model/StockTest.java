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
    public void stockAfterInitializationShouldNotBeEmpty() {
        Stock s = new Stock(Color.RED);
        assertFalse(s.isEmpty());
    }

    @Test
    public void emptyStockShouldBeEmpty() {
        Stock s = new Stock(Color.RED);
        for (Shape shape : Shape.values()) {
            s.getPieceBy(shape);
        }
        assertTrue(s.isEmpty());
    }

    @Test
    public void numberOfSquaresUnitInFullStockShouldBe89() {
        Stock s = new Stock(Color.BLUE);
        assertEquals(89, s.getNumberOfSquares());
    }

    @Test
    public void numberOfSquaresUnitInEmptyStockShouldBe0() {
        Stock s = new Stock(Color.BLUE);
        for (Shape shape : Shape.values()) {
            s.getPieceBy(shape);
        }
        assertEquals(0, s.getNumberOfSquares());
    }

    @Test
    public void pieceGotByShapeShouldBeWantedPiece() {
        Stock s = new Stock(Color.BLUE);
        Piece piece = s.getPieceBy(Shape.SHAPE_15);
        assertTrue(piece.equals(new Piece(Shape.SHAPE_15, Color.BLUE)));
        assertEquals(20, s.getPieces().size());
        assertTrue(piece.equals(s.getLastTakenPiece()));
    }

    @Test
    public void nullShouldBeReturnedIfAskedShapeIsNotInStock() {
        Stock s = new Stock(Color.BLUE);
        s.getPieceBy(Shape.SHAPE_15);
        Piece notFoundPiece = s.getPieceBy(Shape.SHAPE_15);
        assertEquals(null, notFoundPiece);
    }

    @Test
    public void scoreShouldBe20WhenStockIsEmptyAndSmallestPieceIsLastTaken() {
        Stock s = new Stock(Color.BLUE);
        Shape[] shapes = Shape.values();
        for (int i = 1; i < shapes.length; i++) {
            s.getPieceBy(shapes[i]);
        }
        s.getPieceBy(shapes[0]);
        assertEquals(20, s.getScore());
    }

    @Test
    public void scoreShouldBe15WhenStockIsEmptyButSmallestPieceIsFirstTaken() {
        Stock s = new Stock(Color.BLUE);
        Shape[] shapes = Shape.values();
        s.getPieceBy(shapes[0]);
        for (int i = 1; i < shapes.length; i++) {
            s.getPieceBy(shapes[i]);
        }
        assertEquals(15, s.getScore());
    }

    @Test
    public void scoreShouldBeNegativeWhenStockIsNotEmpty() {
        Stock s = new Stock(Color.BLUE);
        Shape[] shapes = Shape.values();
        for (int i = 15; i < shapes.length; i++) {
            s.getPieceBy(shapes[i]);
        }
        assertTrue(s.getScore() < 0);
    }

}
