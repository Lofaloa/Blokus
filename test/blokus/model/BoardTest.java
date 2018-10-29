package blokus.model;

import blokus.exception.BoardPositionOutOfBounds;
import blokus.exception.IllegalActionException;
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
    public void cellShouldNotBeFreeAfterBeingFilledWithPiece() {
        Board board = new Board();
        Piece fillingPiece = new Piece(Shape.SHAPE_01, Color.BLUE);
        board.add(fillingPiece, 0, 0);
        assertFalse(board.isFree(0, 0));
    }

    @Test
    public void cellShouldBeFreeWhenNotFilledWithPiece() {
        Board board = new Board();
        assertTrue(board.isFree(0, 0));
    }

    @Test
    public void freeCellShouldNotCauseAnException() {
        Board board = new Board();
        board.requireFreeSquare(new Square(1, 1));
    }

    @Test(expected = IllegalActionException.class)
    public void filledCellShouldCauseAnException() {
        Board board = new Board();
        Piece fillingPiece = new Piece(Shape.SHAPE_01, Color.BLUE);
        board.add(fillingPiece, 1, 1);
        board.requireFreeSquare(new Square(1, 1));
    }

    @Test
    public void outOfBoundsPositionShouldNotBeValidCells() {
        Board board = new Board();
        assertFalse(board.isValid(10, 20));
        assertFalse(board.isValid(0, 20));
        assertFalse(board.isValid(10, -1));
        assertFalse(board.isValid(0, -1));
    }

    @Test
    public void boardCornersShouldBeValidCells() {
        Board board = new Board();
        assertTrue(board.isValid(0, 0));
        assertTrue(board.isValid(0, 19));
        assertTrue(board.isValid(19, 19));
        assertTrue(board.isValid(19, 0));
    }

    @Test
    public void boardCornersShouldNotCauseAnException() {
        Board board = new Board();
        board.requireValidPosition(new Square(0, 0));
        board.requireValidPosition(new Square(0, 19));
        board.requireValidPosition(new Square(19, 19));
        board.requireValidPosition(new Square(19, 0));
    }

    @Test(expected = BoardPositionOutOfBounds.class)
    public void outOfBoundsPositionShouldCauseAnException() {
        Board board = new Board();
        board.requireValidPosition(new Square(10, 20));
        board.requireValidPosition(new Square(0, 20));
        board.requireValidPosition(new Square(10, -1));
        board.requireValidPosition(new Square(0, -1));
    }

    @Test(expected = BoardPositionOutOfBounds.class)
    public void outOfBoundsPartOfPieceShouldCauseExceptionWhenAdding() {
        Board b = new Board();
        Piece p = new Piece(Shape.SHAPE_04, Color.BLUE);
        b.add(p, 0, 19);
    }

    @Test(expected = IllegalActionException.class)
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
        assertFalse(b.isFree(0, 0) && b.isFree(1, 0) && b.isFree(1, 1));
    }

    @Test(expected = BoardPositionOutOfBounds.class)
    public void addingPieceOutOfBoardBoundsShouldCauseException() {
       Board b = new Board();
        Piece p = new Piece(Shape.SHAPE_04, Color.BLUE);
        b.add(p, -1, 0);
    }

}
