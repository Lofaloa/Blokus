package blokus.model;

import java.util.Collections;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the stock.
 *
 * @author g47923
 */
public class StockTest {

    @Test
    public void stockAfterInitializationShouldHave21DistinctPieceOfOneColor() {
        Stock s = new Stock(BlokusColor.RED);
        assertEquals(21, s.getPieces().size());
        for (Piece piece : s.getPieces()) {
            assertEquals(1, Collections.frequency(s.getPieces(), piece));
        }
    }

    @Test
    public void stockAfterInitializationShouldNotBeEmpty() {
        Stock s = new Stock(BlokusColor.RED);
        assertFalse(s.isEmpty());
    }

    @Test
    public void emptyStockShouldBeEmpty() {
        Stock s = new Stock(BlokusColor.RED);
        s.clear();
        assertTrue(s.isEmpty());
    }

    @Test
    public void numberOfSquaresUnitInFullStockShouldBe89() {
        Stock s = new Stock(BlokusColor.BLUE);
        assertEquals(89, s.getNumberOfSquares());
    }

    @Test
    public void numberOfSquaresUnitInEmptyStockShouldBe0() {
        Stock s = new Stock(BlokusColor.BLUE);
        s.clear();
        assertEquals(0, s.getNumberOfSquares());
    }

    @Test
    public void nullShouldBeReturnedIfAskedShapeIsNotInStock() {
        Stock s = new Stock(BlokusColor.BLUE);
        s.remove(new Piece(Shape.SHAPE_01, BlokusColor.BLUE));
        assertNull(s.getPiece(Shape.SHAPE_01));
    }

    @Test
    public void scoreShouldBe20WhenStockIsEmptyAndSmallestPieceIsLastTaken() {
        Stock s = new Stock(BlokusColor.BLUE);
        Shape[] shapes = Shape.values();
        for (int i = 1; i < shapes.length; i++) {
            s.remove(new Piece(shapes[i], BlokusColor.BLUE));
        }
        s.remove(new Piece(shapes[0], BlokusColor.BLUE));
        assertEquals(20, s.getScore());
    }

    @Test
    public void scoreShouldBe15WhenStockIsEmptyButSmallestPieceIsFirstTaken() {
        Stock s = new Stock(BlokusColor.BLUE);
        Shape[] shapes = Shape.values();
        s.remove(new Piece(shapes[0], BlokusColor.BLUE));
        for (int i = 1; i < shapes.length; i++) {
            s.remove(new Piece(shapes[i], BlokusColor.BLUE));
        }
        assertEquals(15, s.getScore());
    }

    @Test
    public void scoreShouldBeNegativeWhenStockIsNotEmpty() {
        Stock s = new Stock(BlokusColor.BLUE);
        assertTrue(s.getScore() < 0);
    }

}
