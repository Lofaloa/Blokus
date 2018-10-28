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

}
