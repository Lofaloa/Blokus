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
        Piece pieceOf5 = new Piece(new Position(0, 0),
                new Position(0, 1),
                new Position(0, 2),
                new Position(1, 2),
                new Position(2, 3));
        assertEquals(5, pieceOf5.getSize());
    }

    @Test(expected = IllegalArgumentException.class)
    public void initAPieceWithoutPositions() {
        Piece piece = new Piece();
    }

    @Test(expected = IllegalArgumentException.class)
    public void initAPieceWith8Positions() {
        Piece piece = new Piece(new Position(0, 0),
                new Position(0, 1),
                new Position(0, 2),
                new Position(1, 2),
                new Position(2, 3),
                new Position(3, 3),
                new Position(4, 3),
                new Position(5, 3));
    }

}
