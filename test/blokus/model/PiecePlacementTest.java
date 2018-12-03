package blokus.model;

import blokus.exception.ModelException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
    @Test(expected = IllegalStateException.class)
    public void first_round_placePiece_case_1() {
        Blokus g = new Blokus();
        g.placePiece(0, 0);
    }

    /**
     * At first round, not placing a piece in a corner of the board game should
     * cause an exception.
     */
    @Test(expected = ModelException.class)
    public void first_round_placePiece_case_2() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(Shape.SHAPE_04);
        g.placePiece(1, 1);
    }

    /**
     * At first round, placing a piece outside one of the corners should
     * cause an exception. When caught the piece should not be removed from the
     * current player stock.
     */
    @Test
    public void first_round_placePiece_case_3() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(Shape.SHAPE_01);
        try {
            g.placePiece(1, 1);
        } catch (ModelException e) {
            assertFalse(g.getCurrentPlayer().hasPlacedFirstPiece());
        }
    }

    /**
     * During a game, placing piece without selecting a piece causes an
     * exception.
     */
    @Test(expected = IllegalStateException.class)
    public void placePiece_case_1() {
        Blokus g = new Blokus();
        g.endFirstRound();
        g.selectCurrentPlayerPiece(Shape.SHAPE_01);
        g.placePiece(0, 0);
        g.nextPlayer();
        g.placePiece(0, 0);
    }

    /**
     * Placing a piece at an out of bounds location causes an exception.
     */
    @Test(expected = ModelException.class)
    public void placePiece_case_2() {
        Blokus g = new Blokus();
        g.endFirstRound();
        g.selectCurrentPlayerPiece(Shape.SHAPE_01);
        g.placePiece(-1, 0);
    }

    /**
     * Placing a piece on another one causes an exception.
     */
    @Test(expected = ModelException.class)
    public void placePiece_case_3() {
        Blokus g = new Blokus();
        g.endFirstRound();
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
    public void placePiece_case_4() {
        Blokus g = new Blokus();
        g.endFirstRound();
        g.selectCurrentPlayerPiece(Shape.SHAPE_21);
        g.placePiece(18, 0);
    }

    /**
     * Placed piece should be located where it is expected to.
     */
    @Test
    public void placePiece_case_5() {
        Blokus g = new Blokus();
        g.endFirstRound();
        g.selectCurrentPlayerPiece(Shape.SHAPE_04);
        g.placePiece(0, 0);
        assertEquals(BlokusColor.BLUE, g.getBoard().getColorAt(0, 0));
    }

    /**
     * Placing a piece at a out of bounds position should cause an exception.
     * When caught the piece should not be removed from the current player
     * stock.
     */
    @Test
    public void placePiece_case_6() {
        Blokus g = new Blokus();
        g.endFirstRound();
        g.selectCurrentPlayerPiece(Shape.SHAPE_01);
        try {
            g.placePiece(0, -1);
        } catch (ModelException e) {
            assertFalse(g.getCurrentPlayer().hasPlacedFirstPiece());
        }
    }

    /**
     * Placing a piece on another one should cause an exception. When caught the
     * piece should not be removed from the current player stock.
     */
    @Test
    public void placePiece_case_7() {
        Blokus g = new Blokus();
        g.endFirstRound();
        g.selectCurrentPlayerPiece(Shape.SHAPE_01);
        g.placePiece(1, 1);
        g.nextPlayer();
        g.selectCurrentPlayerPiece(Shape.SHAPE_01);
        try {
            g.placePiece(1, 1);
        } catch (ModelException e) {
            assertFalse(g.getCurrentPlayer().hasPlacedFirstPiece());
        }
    }

    void placePiece01(Blokus g, int row, int column) {
        g.selectCurrentPlayerPiece(Shape.SHAPE_01);
        g.placePiece(row, column);
        g.nextPlayer();
    }

}
