package blokus.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests a Piece.
 *
 * @author g47923
 */
public class PieceTest {

    @Test
    public void pieceShouldHaveExpectedColorAndShapeAfterInitialization() {
        Piece piece = new Piece(Shape.SHAPE_21, BlokusColor.BLUE);
        assertTrue(piece.getShape() == Shape.SHAPE_21
                && BlokusColor.BLUE == piece.getColor());
    }

    @Test
    public void pieceShouldContainItsSquares() {
        Piece piece = new Piece(Shape.SHAPE_03, BlokusColor.BLUE);
        assertTrue(piece.contains(0, 0) && piece.contains(1, 0)
                && piece.contains(2, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void containsMethodShouldCauseExceptionWhenArgumentsNotValid() {
        Piece piece = new Piece(Shape.SHAPE_03, BlokusColor.BLUE);
        piece.contains(0, -1);
    }

    @Test
    public void equalsShouldBeReflexive() {
        Piece p = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        assertTrue(p.equals(p));
        assertEquals(p.hashCode(), p.hashCode());
    }

    @Test
    public void equalsShouldBeSymmetric() {
        Piece p1 = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        Piece p2 = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        assertTrue(p1.equals(p2) && p2.equals(p1));
        assertEquals(p1.hashCode(), p2.hashCode());

    }

    @Test
    public void equalsShouldBeTransitive() {
        Piece p1 = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        Piece p2 = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        Piece p3 = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        assertTrue(p1.equals(p2) && p2.equals(p3) && p1.equals(p3));
        assertEquals(p1.hashCode(), p2.hashCode());
        assertEquals(p2.hashCode(), p3.hashCode());

    }

    @Test
    public void pieceShouldNeverbeEqualToNull() {
        Piece p = new Piece(Shape.SHAPE_01, BlokusColor.RED);
        assertFalse(p.equals(null));
    }

    @Test
    public void pieceShouldNotBeEqualToAString() {
        String s = "piece";
        Piece p = new Piece(Shape.SHAPE_01, BlokusColor.RED);
        assertFalse(p.equals(s));
    }

    @Test
    public void piecesOfDifferentColorsShouldNotBeEqualToEachOther() {
        Piece p1 = new Piece(Shape.SHAPE_01, BlokusColor.RED);
        Piece p2 = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        assertFalse(p1.equals(p2));
    }

    @Test
    public void piecesOfDifferentShapesShouldNotBeEqualToEachOther() {
        Piece p1 = new Piece(Shape.SHAPE_02, BlokusColor.BLUE);
        Piece p2 = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        assertFalse(p1.equals(p2));
    }

}
