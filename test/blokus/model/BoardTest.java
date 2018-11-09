package blokus.model;

import blokus.exception.IllegalActionException;
import blokus.exception.ModelException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the board.
 *
 * @author g47923
 */
public class BoardTest {

    @Test
    public void boardShouldBeEmptyAfterInitialization() {
        Board b = new Board();
        for (Piece[] pieces : b.getSquares()) {
            for (Piece piece : pieces) {
                assertNull(piece);
            }
        }
    }

    @Test
    public void squareShouldNotBeFreeAfterBeingFilledWithPiece() {
        Board board = new Board();
        Piece fillingPiece = new Piece(Shape.SHAPE_01, Color.BLUE);
        board.add(fillingPiece, 0, 0);
        assertFalse(board.isEmptyAt(0, 0));
    }

    @Test
    public void squareShouldBeFreeWhenNotFilledWithPiece() {
        Board board = new Board();
        assertTrue(board.isEmptyAt(0, 0));
    }

    @Test
    public void squareShouldNotBeValidWhenFilled() {
        Board board = new Board();
        Piece fillingPiece = new Piece(Shape.SHAPE_01, Color.BLUE);
        board.add(fillingPiece, 0, 0);
        assertFalse(board.isValid(0, 0));
    }

    @Test
    public void squareShouldNBeValidWhenNotFilledWithPiece() {
        Board board = new Board();
        assertTrue(board.isValid(0, 0));
    }

    @Test
    public void outOfBoundsSquarenShouldNotBeContainedInBoard() {
        Board board = new Board();
        assertFalse(board.contains(-1, -1));
        assertFalse(board.contains(-1, 1));
        assertFalse(board.contains(1, -1));
        assertFalse(board.contains(0, 20));
        assertFalse(board.contains(20, 0));
        assertFalse(board.contains(20, 20));
    }

    @Test
    public void squareShouldNotBeValidWhenOutOfBounds() {
        Board board = new Board();
        assertFalse(board.isValid(-1, -1));
        assertFalse(board.isValid(-1, 1));
        assertFalse(board.isValid(1, -1));
        assertFalse(board.isValid(0, 20));
        assertFalse(board.isValid(20, 0));
        assertFalse(board.isValid(20, 20));
    }

    @Test(expected = ModelException.class)
    public void notValidSquareShouldCauseAnException() {
        Board board = new Board();
        Piece fillingPiece = new Piece(Shape.SHAPE_01, Color.BLUE);
        board.add(fillingPiece, 1, 1);
        board.requireValidSquare(1, 1);
    }
    
    @Test(expected = ModelException.class)
    public void outOfBoundsSquareShouldCauseAnException() {
        Board board = new Board();
        board.requireValidSquare(1, -1);
    }

    @Test(expected = ModelException.class)
    public void outOfBoundsPieceSquareShouldCauseExceptionWhenAdding() {
        Board b = new Board();
        Piece p = new Piece(Shape.SHAPE_04, Color.BLUE);
        b.add(p, 0, 19);
    }

    @Test(expected = ModelException.class)
    public void addingAnOverlappingPieceShouldCauseException() {
        Board b = new Board();
        Piece piece = new Piece(Shape.SHAPE_04, Color.BLUE);
        Piece overlappingPiece = new Piece(Shape.SHAPE_04, Color.RED);
        b.add(piece, 0, 0);
        b.add(overlappingPiece, 0, 1);
    }

    @Test
    public void addedPieceInBoardShouldBeFoundAtGivenPosition() {
        Board b = new Board();
        Piece p = new Piece(Shape.SHAPE_04, Color.BLUE);
        b.add(p, 0, 0);
        assertFalse(b.isEmptyAt(0, 0) && b.isEmptyAt(1, 0) && b.isEmptyAt(1, 1));
    }

    @Test(expected = ModelException.class)
    public void addingPieceOutOfBoardBoundsShouldCauseException() {
        Board b = new Board();
        Piece p = new Piece(Shape.SHAPE_04, Color.BLUE);
        b.add(p, -1, 0);
    }

}
