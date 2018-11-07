package blokus.model;

import blokus.exception.ModelException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests a position.
 *
 * @author g47923
 */
public class SquareTest {

    @Test
    public void initASquare() {
        Square pos = new Square(2, 3);
        assertTrue(pos.getRow() == 2 && pos.getColumn() == 3);
    }

    @Test(expected = ModelException.class)
    public void initASquareWithTooSmallRowShouldCauseException() {
        Square s = new Square(-1, 3);
    }

    @Test(expected = ModelException.class)
    public void initASquareWithTooBigRowShouldCauseException() {
        Square s = new Square(20, 3);
    }

    @Test(expected = ModelException.class)
    public void initASquareWithTooBigColumnShouldCauseException() {
        Square s = new Square(2, 20);
    }

    @Test(expected = ModelException.class)
    public void initASquareWithTooSmallColumnShouldCauseException() {
        Square s = new Square(2, -1);
    }

    @Test
    public void moveAPosition() {
        Square pos = new Square(2, 3);
        Square movedPos = pos.move(2, 3);
        assertTrue(movedPos.getRow() == 4 && movedPos.getColumn() == 6);
    }

    @Test
    public void equalsShouldBeReflexive() {
        Square s = new Square(0, 0);
        assertTrue(s.equals(s));
        assertEquals(s.hashCode(), s.hashCode());
    }

    @Test
    public void equalsShouldBeSymmetric() {
        Square s1 = new Square(0, 0);
        Square s2 = new Square(0, 0);
        assertTrue(s1.equals(s2) && s2.equals(s1));
        assertEquals(s1.hashCode(), s2.hashCode());

    }

    @Test
    public void equalsShouldBeTransitive() {
        Square s1 = new Square(0, 0);
        Square s2 = new Square(0, 0);
        Square s3 = new Square(0, 0);
        assertTrue(s1.equals(s2) && s2.equals(s3) && s1.equals(s3));
        assertEquals(s1.hashCode(), s2.hashCode());
        assertEquals(s2.hashCode(), s3.hashCode());
    }

    @Test
    public void squareShouldNeverbeEqualToNull() {
        Square s = new Square(0, 0);
        assertFalse(s.equals(null));
    }

    @Test
    public void pieceShouldNotBeEqualToAString() {
        String str = "square";
        Square s = new Square(0, 0);
        assertFalse(s.equals(str));
    }

    @Test
    public void squareWithDifferentRowsShouldNotEqual() {
        Square s1 = new Square(1, 0);
        Square s2 = new Square(0, 0);
        assertFalse(s1.equals(s2));
    }

    @Test
    public void squareWithDifferentColumnsShouldNotEqual() {
        Square s1 = new Square(0, 1);
        Square s2 = new Square(0, 0);
        assertFalse(s1.equals(s2));
    }

}
