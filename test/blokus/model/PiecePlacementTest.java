package blokus.model;

import blokus.exception.ModelException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test the placement of pieces on the game board by players.
 *
 * @author Logan Farci (47923)
 */
public class PiecePlacementTest {

    /**
     * At first round, placing piece without selecting a piece causes an
     * exception.
     */
    @Test(expected = NullPointerException.class)
    public void placePiece_case_1() {
        Blokus g = new Blokus();
        g.placePiece(0, 0);
    }

    /**
     * During a game, placing piece without selecting a piece causes an
     * exception.
     */
    @Test(expected = NullPointerException.class)
    public void placePiece_case_2() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(Shape.SHAPE_01);
        g.placePiece(0, 0);
        g.nextPlayer();
        g.placePiece(0, 0);
    }

    /**
     * Placing a piece at an out of bounds location causes an exception.
     */
    @Test(expected = ModelException.class)
    public void placePiece_case_3() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(Shape.SHAPE_01);
        g.placePiece(-1, 0);
    }

    /**
     * Placing a piece on another one causes an exception.
     */
    @Test(expected = ModelException.class)
    public void placePiece_case_4() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(Shape.SHAPE_01);
        g.placePiece(0, 0);
        g.nextPlayer();
        g.selectCurrentPlayerPiece(Shape.SHAPE_01);
        g.placePiece(0, 0);
    }

    /**
     * Placing a piece on the board where there is not enough space causes an
     * exception.
     */
    @Test(expected = ModelException.class)
    public void placePiece_case_5() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(Shape.SHAPE_21);
        g.placePiece(18, 0);
    }

    /**
     * Placed piece should be located where it is expected to.
     */
    @Test
    public void placePiece_case_6() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(Shape.SHAPE_04);
        g.placePiece(0, 0);
        assertEquals(BlokusColor.BLUE, g.getBoard().getColorAt(0, 0));
    }

}
