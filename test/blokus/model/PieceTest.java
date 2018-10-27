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
    public void initAPieceOf5Positions() {
        Piece pieceOf5 = new Piece(Shape.SHAPE_21, Color.BLUE);
        assertTrue(5 == pieceOf5.getSize() && Color.BLUE == pieceOf5.getColor());
    }

}
