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
        Piece piece = new Piece(Shape.SHAPE_21, Color.BLUE);
        assertTrue(piece.getShape() == Shape.SHAPE_21
                && Color.BLUE == piece.getColor());
    }

    @Test
    public void equalsShouldBeReflexive() {
        Piece p = new Piece(Shape.SHAPE_01, Color.BLUE);
        assertTrue(p.equals(p));
        assertEquals(p.hashCode(), p.hashCode());
    }

    @Test
    public void equalsShouldBeSymmetric() {
        Piece p1 = new Piece(Shape.SHAPE_01, Color.BLUE);
        Piece p2 = new Piece(Shape.SHAPE_01, Color.BLUE);
        assertTrue(p1.equals(p2) && p2.equals(p1));
        assertEquals(p1.hashCode(), p2.hashCode());

    }

    @Test
    public void equalsShouldBeTransitive() {
        Piece p1 = new Piece(Shape.SHAPE_01, Color.BLUE);
        Piece p2 = new Piece(Shape.SHAPE_01, Color.BLUE);
        Piece p3 = new Piece(Shape.SHAPE_01, Color.BLUE);
        assertTrue(p1.equals(p2) && p2.equals(p3) && p1.equals(p3));
        assertEquals(p1.hashCode(), p2.hashCode());
        assertEquals(p2.hashCode(), p3.hashCode());

    }

    @Test
    public void pieceShouldNeverbeEqualToNull() {
        Piece p = new Piece(Shape.SHAPE_01, Color.RED);
        assertFalse(p.equals(null));
    }

    @Test
    public void pieceShouldNotBeEqualToAString() {
        String s = "piece";
        Piece p = new Piece(Shape.SHAPE_01, Color.RED);
        assertFalse(p.equals(s));
    }

    @Test
    public void piecesOfDifferentColorsShouldNotBeEqualToEachOther() {
        Piece p1 = new Piece(Shape.SHAPE_01, Color.RED);
        Piece p2 = new Piece(Shape.SHAPE_01, Color.BLUE);
        assertFalse(p1.equals(p2));
    }

    @Test
    public void piecesOfDifferentShapesShouldNotBeEqualToEachOther() {
        Piece p1 = new Piece(Shape.SHAPE_02, Color.BLUE);
        Piece p2 = new Piece(Shape.SHAPE_01, Color.BLUE);
        assertFalse(p1.equals(p2));
    }

}
