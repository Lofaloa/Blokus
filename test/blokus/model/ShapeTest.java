package blokus.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the integrity of a shape.
 *
 * @author Logan Farci (47923)
 */
public class ShapeTest {

    @Test(expected = IllegalArgumentException.class)
    public void askingIfAShapeContainsNegativeRowCausesAnException() {
        Shape.SHAPE_02.contains(-3, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void askingIfAShapeContainsNegativeColumnCausesAnException() {
        Shape.SHAPE_02.contains(0, -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void askingIfAShapeContainsNegativeRowAndColumnCausesAnException() {
        Shape.SHAPE_02.contains(-3, -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void askingIfAShapeContainsTooBigRowCausesAnException() {
        Shape.SHAPE_02.contains(6, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void askingIfAShapeContainsTooBigColumnCausesAnException() {
        Shape.SHAPE_02.contains(0, 6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void askingIfAShapeContainsTooBigRowAndColumnCausesAnException() {
        Shape.SHAPE_02.contains(0, 6);
    }

    @Test
    public void shapeShouldContainExpectedCoordinate() {
        assertTrue(Shape.SHAPE_01.contains(0, 0));
    }

    @Test
    public void shapeShouldContainExpectedCoordinates() {
        assertTrue(Shape.SHAPE_03.contains(0, 0));
        assertTrue(Shape.SHAPE_03.contains(1, 0));
        assertTrue(Shape.SHAPE_03.contains(2, 0));
    }

}
