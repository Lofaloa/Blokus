package blokus.model;

import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Tests the rotation and the action of turning a piece over.
 *
 * @author Logan Farci (47923)
 */
public class PieceManipulationTest {

    /**
     * Trying to rotate a piece without selecting one should causes an
     * exception.
     */
    @Test(expected = IllegalStateException.class)
    public void rotate_case_1() {
        Game g = new Blokus();
        g.rotateCurrentPlayerPiece();
    }

    /**
     * To rotate once a line piece should produce the expected result
     */
    @Test
    public void rotate_case_2() {
        Game g = new Blokus();
        g.selectCurrentPlayerPiece(Shape.SHAPE_02);
        g.rotateCurrentPlayerPiece();
        List<Square> currentPieceSquares = g.getCurrentPlayer().getCurrentPiece().getSquares();
        assertTrue(currentPieceSquares.contains(new Square(0, 0)));
        assertTrue(currentPieceSquares.contains(new Square(0, 1)));
    }

    /**
     * To rotate once an asymmetric piece should produce the expected result
     */
    @Test
    public void rotate_case_3() {
        Game g = new Blokus();
        g.selectCurrentPlayerPiece(Shape.SHAPE_04);
        g.rotateCurrentPlayerPiece();
        List<Square> currentPieceSquares = g.getCurrentPlayer().getCurrentPiece().getSquares();
        assertTrue(currentPieceSquares.contains(new Square(0, 0)));
        assertTrue(currentPieceSquares.contains(new Square(0, 1)));
        assertTrue(currentPieceSquares.contains(new Square(-1, 1)));
    }

    /**
     * Trying to turn a piece over without selecting one should cause an
     * exception.
     */
    @Test(expected = IllegalStateException.class)
    public void turnOver_case_1() {
        Game g = new Blokus();
        g.turnCurrentPlayerPieceOver();
    }

    /**
     * To turn an asymmetric piece over should give the expected result.
     */
    @Test
    public void turnOver_case_2() {
        Game g = new Blokus();
        g.selectCurrentPlayerPiece(Shape.SHAPE_06);
        g.turnCurrentPlayerPieceOver();
        List<Square> currentPieceSquares = g.getCurrentPlayer().getCurrentPiece().getSquares();
        assertTrue(currentPieceSquares.contains(new Square(0, -1)));
        assertTrue(currentPieceSquares.contains(new Square(1, -1)));
        assertTrue(currentPieceSquares.contains(new Square(2, -1)));
        assertTrue(currentPieceSquares.contains(new Square(2, 0)));
    }

    /**
     * To turn a symmetric piece over should not modify it.
     */
    @Test
    public void turnOver_case_3() {
        Game g = new Blokus();
        g.selectCurrentPlayerPiece(Shape.SHAPE_05);
        g.turnCurrentPlayerPieceOver();
        List<Square> currentPieceSquares = g.getCurrentPlayer().getCurrentPiece().getSquares();
        assertTrue(currentPieceSquares.contains(new Square(0, 0)));
        assertTrue(currentPieceSquares.contains(new Square(1, 0)));
        assertTrue(currentPieceSquares.contains(new Square(2, 0)));
        assertTrue(currentPieceSquares.contains(new Square(3, 0)));
    }

}
