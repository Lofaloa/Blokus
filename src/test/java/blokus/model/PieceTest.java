package blokus.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests a Piece.
 *
 * @author g47923
 */
public class PieceTest {

    /**
     * Piece should have expected color and shape after initialization.
     */
    @Test
    public void initialization() {
        Piece piece = new Piece(Shape.SHAPE_21, BlokusColor.BLUE);
        assertTrue(piece.getShape() == Shape.SHAPE_21
                && BlokusColor.BLUE == piece.getColor());
    }

    /**
     * Piece should contains its squares.
     */
    @Test
    public void contains_case_1() {
        Piece piece = new Piece(Shape.SHAPE_03, BlokusColor.BLUE);
        assertTrue(piece.contains(0, 0) && piece.contains(1, 0)
                && piece.contains(2, 0));
    }

    /**
     * Asking a piece if it contains out of bounds squares causes exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void contains_case_2() {
        Piece piece = new Piece(Shape.SHAPE_03, BlokusColor.BLUE);
        piece.contains(0, -1);
    }

    @Test
    public void equals_is_reflexive() {
        Piece p = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        assertTrue(p.equals(p));
        assertEquals(p.hashCode(), p.hashCode());
    }

    @Test
    public void equals_is_symmetric() {
        Piece p1 = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        Piece p2 = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        assertTrue(p1.equals(p2) && p2.equals(p1));
        assertEquals(p1.hashCode(), p2.hashCode());

    }

    @Test
    public void equals_is_transitive() {
        Piece p1 = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        Piece p2 = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        Piece p3 = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        assertTrue(p1.equals(p2) && p2.equals(p3) && p1.equals(p3));
        assertEquals(p1.hashCode(), p2.hashCode());
        assertEquals(p2.hashCode(), p3.hashCode());

    }

    @Test
    public void equals_is_never_true_whith_null() {
        Piece p = new Piece(Shape.SHAPE_01, BlokusColor.RED);
        assertFalse(p.equals(null));
    }

    /**
     * A piece is not equal to a string.
     */
    @Test
    public void equals_case_1() {
        String s = "piece";
        Piece p = new Piece(Shape.SHAPE_01, BlokusColor.RED);
        assertFalse(p.equals(s));
    }

    /**
     * Pieces of different colors are not equal.
     */
    @Test
    public void equals_case_2() {
        Piece p1 = new Piece(Shape.SHAPE_01, BlokusColor.RED);
        Piece p2 = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        assertFalse(p1.equals(p2));
    }

    /**
     * Pieces of different shapes are not equal.
     */
    @Test
    public void equals_case_3() {
        Piece p1 = new Piece(Shape.SHAPE_02, BlokusColor.BLUE);
        Piece p2 = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        assertFalse(p1.equals(p2));
    }

}
