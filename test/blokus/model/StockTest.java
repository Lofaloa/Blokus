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

    /**
     * Stock after initialization should have 21 distinct pieces of the same
     * color.
     */
    @Test
    public void initialization() {
        Stock s = new Stock(BlokusColor.RED);
        assertEquals(21, s.getPieces().size());
        for (Piece piece : s.getPieces()) {
            assertEquals(1, Collections.frequency(s.getPieces(), piece));
            assertEquals(BlokusColor.RED, piece.getColor());
        }
    }

    /**
     * Full stock should have 89 squares.
     */
    @Test
    public void nbOfSquares_case_1() {
        Stock s = new Stock(BlokusColor.BLUE);
        assertEquals(89, s.getNbOfSquares());
    }

    /**
     * Empty stock should have no square.
     */
    @Test
    public void nbOfSquares_case_2() {
        Stock s = new Stock(BlokusColor.BLUE);
        s.clear();
        assertEquals(0, s.getNbOfSquares());
    }

    /**
     * Score should be 20 when stock is empty and last taken piece is the
     * smallest one.
     */
    @Test
    public void getScore_case_1() {
        Stock s = new Stock(BlokusColor.BLUE);
        Shape[] shapes = Shape.values();
        for (int i = 1; i < shapes.length; i++) {
            s.remove(new Piece(shapes[i], BlokusColor.BLUE));
        }
        s.remove(new Piece(shapes[0], BlokusColor.BLUE));
        assertEquals(20, s.getScore());
    }

    /**
     * Score should be 15 when stock is empty.
     */
    @Test
    public void getScore_case_2() {
        Stock s = new Stock(BlokusColor.BLUE);
        Shape[] shapes = Shape.values();
        s.remove(new Piece(shapes[0], BlokusColor.BLUE));
        for (int i = 1; i < shapes.length; i++) {
            s.remove(new Piece(shapes[i], BlokusColor.BLUE));
        }
        assertEquals(15, s.getScore());
    }

    /**
     * Score should be negative when stock is not empty.
     */
    @Test
    public void getScore_case_3() {
        Stock s = new Stock(BlokusColor.BLUE);
        assertTrue(s.getScore() < 0);
    }

    /**
     * Getting a piece not contained in stock should result in <code>null</code>
     * value.
     */
    @Test
    public void getPiece_case_1() {
        Stock s = new Stock(BlokusColor.BLUE);
        s.remove(new Piece(Shape.SHAPE_01, BlokusColor.BLUE));
        assertNull(s.getPiece(Shape.SHAPE_01));
    }

    /**
     * Getting a piece by <code>null</code> causes an exception.
     */
    @Test(expected = NullPointerException.class)
    public void getPiece_case_2() {
        Stock s = new Stock(BlokusColor.BLUE);
        s.getPiece(null);
    }

    /**
     * Getting a piece by shape should get the expected piece.
     */
    @Test
    public void getPiece_case_3() {
        Stock s = new Stock(BlokusColor.BLUE);
        assertEquals(new Piece(Shape.SHAPE_01, BlokusColor.BLUE),
                s.getPiece(Shape.SHAPE_01));
    }

    /**
     * Removing <code>null</code> causes an exception.
     */
    @Test(expected = NullPointerException.class)
    public void remove_case_1() {
        Stock s = new Stock(BlokusColor.BLUE);
        s.remove(null);
    }

    /**
     * Removing from empty stock causes an exception.
     */
    @Test(expected = IllegalStateException.class)
    public void remove_case_2() {
        Stock s = new Stock(BlokusColor.BLUE);
        s.clear();
        s.remove(new Piece(Shape.SHAPE_01, BlokusColor.BLUE));
    }

    /**
     * Removing piece from stock should remove the expected piece.
     */
    @Test
    public void remove_case_3() {
        Stock s = new Stock(BlokusColor.BLUE);
        Piece p = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        s.remove(p);
        assertFalse(s.contains(p));
    }

    /**
     * Removing a piece of a non matching color causes an exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void remove_case_4() {
        Stock s = new Stock(BlokusColor.BLUE);
        s.remove(new Piece(Shape.SHAPE_01, BlokusColor.RED));
    }

    /**
     * Empty stock does not contain a piece.
     */
    @Test
    public void contains_case_1() {
        Stock s = new Stock(BlokusColor.BLUE);
        s.clear();
        assertFalse(s.contains(new Piece(Shape.SHAPE_01, BlokusColor.BLUE)));
    }

    /**
     * Asking a stock if it contains a piece of a non matching color should
     * cause an exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void contains_case_2() {
        Stock s = new Stock(BlokusColor.BLUE);
        s.contains(new Piece(Shape.SHAPE_01, BlokusColor.RED));
    }

    /**
     * Asking a stock if it contains a <code>null</code> value should cause an
     * exception.
     */
    @Test(expected = NullPointerException.class)
    public void contains_case_3() {
        Stock s = new Stock(BlokusColor.BLUE);
        s.contains(null);
    }

    /**
     * Stock does not contain removed piece.
     */
    @Test
    public void contains_case_4() {
        Stock s = new Stock(BlokusColor.BLUE);
        s.remove(new Piece(Shape.SHAPE_01, BlokusColor.BLUE));
        assertFalse(s.contains(new Piece(Shape.SHAPE_01, BlokusColor.BLUE)));
    }

    /**
     * Stock contains piece in it.
     */
    @Test
    public void contains_case_5() {
        Stock s = new Stock(BlokusColor.BLUE);
        assertTrue(s.contains(new Piece(Shape.SHAPE_01, BlokusColor.BLUE)));
    }

    /**
     * Cleared stock should be empty.
     */
    @Test
    public void clear_case_1() {
        Stock s = new Stock(BlokusColor.RED);
        s.clear();
        assertTrue(s.isEmpty());
    }

    /**
     * Clearing a cleared (empty) stock should cause an exception.
     */
    @Test(expected = IllegalStateException.class)
    public void clear_case_2() {
        Stock s = new Stock(BlokusColor.RED);
        s.clear();
        s.clear();
    }

}
