package blokus.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a player.
 *
 * @author Logan Farci (47923)
 */
public class PlayerTest {

    /**
     * Tests the state of a player after initialization.
     */
    @Test
    public void initialization() {
        Player p = new Player(BlokusColor.BLUE);
        assertTrue(p.getColor() == BlokusColor.BLUE
                && !p.getStock().isEmpty()
                && p.getScore() == -89);
    }

    /**
     * Checks if the score of a player is -84 after removing a piece of 5
     * squares.
     */
    @Test
    public void getScore_case_1() {
        Player p = new Player(BlokusColor.BLUE);
        Piece piece = new Piece(Shape.SHAPE_21, BlokusColor.BLUE);
        p.remove(piece);
        assertEquals(-84, p.getScore());
    }

    /**
     * Checks if the score of a player is 15 after clearing stock.
     */
    @Test
    public void getScore_case_2() {
        Player p = new Player(BlokusColor.BLUE);
        p.clearStock();
        assertEquals(15, p.getScore());
    }

    /**
     * Checks if the score of a player is 20 after clearing stock knowing the
     * last piece is the smallest one.
     */
    @Test
    public void getScore_case_3() {
        Player p = new Player(BlokusColor.BLUE);
        p.clearStockSmallestPieceAtEnd();
        assertEquals(20, p.getScore());
    }

    /**
     * Asking a player he/ she owns <code>null</code> value causes an exception.
     */
    @Test(expected = NullPointerException.class)
    public void owns_case_1() {
        Player p = new Player(BlokusColor.BLUE);
        p.owns(null);
    }

    /**
     * A player should own a piece in his/ her stock.
     */
    @Test
    public void owns_case_2() {
        Player p = new Player(BlokusColor.BLUE);
        assertTrue(p.owns(new Piece(Shape.SHAPE_10, BlokusColor.BLUE)));
    }

    /**
     * A player should not own a removed piece.
     */
    @Test
    public void owns_case_3() {
        Player p = new Player(BlokusColor.BLUE);
        Piece piece = new Piece(Shape.SHAPE_10, BlokusColor.BLUE);
        p.remove(piece);
        assertFalse(p.owns(piece));
    }

    /**
     * Trying to remove a <code>null</code> value causes an exception.
     */
    @Test(expected = NullPointerException.class)
    public void remove_case_1() {
        Player p = new Player(BlokusColor.BLUE);
        p.remove(null);
    }

    /**
     * Trying to remove a piece from an empty stock causes an exception.
     */
    @Test(expected = IllegalStateException.class)
    public void remove_case_2() {
        Player p = new Player(BlokusColor.BLUE);
        p.clearStock();
        p.remove(new Piece(Shape.SHAPE_01,BlokusColor.BLUE));
    }

    /**
     * Checks if removing a piece removes the expected piece.
     */
    @Test
    public void remove_case_3() {
        Player p = new Player(BlokusColor.BLUE);
        Piece piece = new Piece(Shape.SHAPE_03, BlokusColor.BLUE);
        p.remove(piece);
        assertFalse(p.owns(piece));
    }

    /**
     * Checks if the piece getter gets the expected piece.
     */
    @Test
    public void getPiece() {
        Player p = new Player(BlokusColor.BLUE);
        p.selectPiece(Shape.SHAPE_01);
        assertTrue(p.getCurrentPiece().equals(new Piece(Shape.SHAPE_01, BlokusColor.BLUE)));
    }

}
