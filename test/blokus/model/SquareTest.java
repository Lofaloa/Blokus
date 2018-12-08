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

    /**
     * Square should have expected state after initialization.
     */
    @Test
    public void initialization_case_1() {
        Square pos = new Square(2, 3);
        assertTrue(pos.getRow() == 2 && pos.getColumn() == 3);
    }

    /**
     * Initializing a square with a negative row causes an exception.
     */
    @Test(expected = ModelException.class)
    public void initialization_case_2() {
        new Square(-1, 3);
    }

    /**
     * Initializing a square with a out of bounds row causes an exception.
     */
    @Test(expected = ModelException.class)
    public void initialization_case_3() {
        new Square(20, 3);
    }

    /**
     * Initializing a square with a out of bounds column causes an exception.
     */
    @Test(expected = ModelException.class)
    public void initilization_case_4() {
        new Square(2, 20);
    }

    /**
     * Initializing a square with a negative column causes an exception.
     */
    @Test(expected = ModelException.class)
    public void initilization_case_5() {
        new Square(2, -2);
    }

    /**
     * Moving a square to an out of bounds coordinate causes an exception.
     */
    @Test(expected = ModelException.class)
    public void move_case_1() {
        Square pos = new Square(2, 3);
        pos = pos.move(-10, 23);
    }

    /**
     * Moved square should have the new expected coordinates.
     */
    @Test
    public void move_case_2() {
        Square pos = new Square(2, 3);
        Square movedPos = pos.move(2, 3);
        assertTrue(movedPos.getRow() == 4 && movedPos.getColumn() == 6);
    }

    /**
     * Equals method should be reflexive.
     */
    @Test
    public void equals_is_reflexive() {
        Square s = new Square(0, 0);
        assertTrue(s.equals(s));
        assertEquals(s.hashCode(), s.hashCode());
    }

    /**
     * Equals method should be symmetric.
     */
    @Test
    public void equals_is_symmetric() {
        Square s1 = new Square(0, 0);
        Square s2 = new Square(0, 0);
        assertTrue(s1.equals(s2) && s2.equals(s1));
        assertEquals(s1.hashCode(), s2.hashCode());

    }

    /**
     * Equals method should be transitive.
     */
    @Test
    public void equals_is_transitive() {
        Square s1 = new Square(0, 0);
        Square s2 = new Square(0, 0);
        Square s3 = new Square(0, 0);
        assertTrue(s1.equals(s2) && s2.equals(s3) && s1.equals(s3));
        assertEquals(s1.hashCode(), s2.hashCode());
        assertEquals(s2.hashCode(), s3.hashCode());
    }

    /**
     * Equals method should always return false with a null argument.
     */
    @Test
    public void equals_is_false_with_null() {
        Square s = new Square(0, 0);
        assertFalse(s.equals(null));
    }

    /**
     * A square should never be equal to an other type.
     */
    @Test
    public void equals_case_1() {
        String str = "square";
        Square s = new Square(0, 0);
        assertFalse(s.equals(str));
    }

    /**
     * Two squares with different rows are not equal.
     */
    @Test
    public void equals_case_2() {
        Square s1 = new Square(1, 0);
        Square s2 = new Square(0, 0);
        assertFalse(s1.equals(s2));
    }

    /**
     * Two squares with different columns are not equal.
     */
    @Test
    public void equals_case_3() {
        Square s1 = new Square(0, 1);
        Square s2 = new Square(0, 0);
        assertFalse(s1.equals(s2));
    }

}
