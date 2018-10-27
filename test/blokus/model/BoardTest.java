package blokus.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 *
 * @author g47923
 */
public class BoardTest {

    @Test
    public void testIsFreeFullCell() {
        Board board = new Board();
        Piece p = new Piece(Shape.SHAPE_1, Color.BLUE);
        board.add(p, new Position(0, 0));
        assertFalse(board.isFree(new Position(0, 0)));
    }

    @Test
    public void testIsFreeCell() {
        Board board = new Board();
        assertTrue(board.isFree(new Position(0, 0)));
    }

    @Test
    public void isValidCellOutOfBounds() {
        Board board = new Board();
        assertFalse(board.isValid(new Position(0, 20)));
        assertFalse(board.isValid(new Position(-1, 0)));
        assertFalse(board.isValid(new Position(20, 0)));
        assertFalse(board.isValid(new Position(0, -1)));
    }

    @Test
    public void isValidCellInBounds() {
        Board board = new Board();
        assertTrue(board.isValid(new Position(0, 0)));
        assertTrue(board.isValid(new Position(0, 19)));
        assertTrue(board.isValid(new Position(19, 19)));
        assertTrue(board.isValid(new Position(19, 0)));
    }

}
