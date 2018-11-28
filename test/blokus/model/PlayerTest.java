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
     * Checks if the piece getter gets the expected piece.
     */
    @Test
    public void getPiece() {
        Player p = new Player(BlokusColor.BLUE);
        Piece p1 = p.getPiece(0);
        assertTrue(p1.equals(new Piece(Shape.SHAPE_01, BlokusColor.BLUE)));
    }

    /**
     * Checks if removing a piece removes the expected piece.
     */
    @Test
    public void remove() {
        Player p = new Player(BlokusColor.BLUE);
        Piece piece = new Piece(Shape.SHAPE_03, BlokusColor.BLUE);
        p.remove(piece);
        assertFalse(p.owns(piece));
    }

}
