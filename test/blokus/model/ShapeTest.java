package blokus.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the integrity of a shape.
 *
 * @author Logan Farci (47923)
 */
public class ShapeTest {

    /**
     * Shape should have expected state after initialization.
     */
    @Test
    public void initialization() {
        Shape s = Shape.SHAPE_01;
        assertEquals(1, s.getNbOfSquares());
    }

    /**
     * Asking if a shape contains negative row causes an exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void contains_case_1() {
        Shape.SHAPE_02.contains(-3, 0);
    }

    /**
     * Asking if a shape contains negative column causes an exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void contains_case_2() {
        Shape.SHAPE_02.contains(0, -3);
    }

    /**
     * Asking if a shape contains negative row and column causes an exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void contains_case_3() {
        Shape.SHAPE_02.contains(-3, -3);
    }

    /**
     * Asking if a shape contains out of bounds row causes an exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void contains_case_4() {
        Shape.SHAPE_02.contains(6, 0);
    }

    /**
     * Asking if a shape contains out of bounds column causes an exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void contains_case_5() {
        Shape.SHAPE_02.contains(0, 6);
    }

    /**
     * Asking if a shape contains out of bounds row and column causes an
     * exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void contains_case_6() {
        Shape.SHAPE_02.contains(0, 6);
    }

    /**
     * Shape should contain expected square.
     */
    @Test
    public void contains_case_7() {
        assertTrue(Shape.SHAPE_01.contains(0, 0));
    }

    /**
     * Rotating a shape should rotate it by 90 degrees clockwise each time.
     */
    @Test
    public void rotate_case_1() {
        Shape s = Shape.SHAPE_07;
        s.rotate();
        assertTrue(s.getSquares().contains(new Square(0, 2)));
        assertTrue(s.getSquares().contains(new Square(0, 1)));
        assertTrue(s.getSquares().contains(new Square(0, 0)));
        assertTrue(s.getSquares().contains(new Square(1, 1)));
        s.rotate();
        assertTrue(s.getSquares().contains(new Square(0, 2)));
        assertTrue(s.getSquares().contains(new Square(1, 2)));
        assertTrue(s.getSquares().contains(new Square(2, 2)));
        assertTrue(s.getSquares().contains(new Square(1, 1)));
        s.rotate();
        assertTrue(s.getSquares().contains(new Square(2, 0)));
        assertTrue(s.getSquares().contains(new Square(1, 1)));
        assertTrue(s.getSquares().contains(new Square(2, 2)));
        assertTrue(s.getSquares().contains(new Square(1, 1)));
        s.rotate();
        assertTrue(s.getSquares().contains(new Square(0, 0)));
        assertTrue(s.getSquares().contains(new Square(1, 0)));
        assertTrue(s.getSquares().contains(new Square(2, 0)));
        assertTrue(s.getSquares().contains(new Square(1, 1)));
    }

}
