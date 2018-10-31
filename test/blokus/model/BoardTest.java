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
    public void squareShouldNotBeFreeAfterBeingFilledWithPiece() {
        Board board = new Board();
        Piece fillingPiece = new Piece(Shape.SHAPE_01, Color.BLUE);
        board.add(fillingPiece, 0, 0);
        assertFalse(board.isFreeAt(0, 0));
    }

    @Test
    public void squareShouldBeFreeWhenNotFilledWithPiece() {
        Board board = new Board();
        assertTrue(board.isFreeAt(0, 0));
    }

    @Test
    public void squareShouldNotBeValidWhenFilled() {
        Board board = new Board();
        Piece fillingPiece = new Piece(Shape.SHAPE_01, Color.BLUE);
        board.add(fillingPiece, 0, 0);
        assertFalse(board.isValid(0, 0));
    }

    @Test
    public void squareShouldNotBeValidWhenOutOfBounds() {
        Board board = new Board();
        assertFalse(board.isValid(10, 20));
        assertFalse(board.isValid(0, 20));
        assertFalse(board.isValid(10, -1));
        assertFalse(board.isValid(0, -1));
    }

    @Test(expected = IllegalActionException.class)
    public void notValidSquareShouldCauseAnException() {
        Board board = new Board();
        Piece fillingPiece = new Piece(Shape.SHAPE_01, Color.BLUE);
        board.add(fillingPiece, 1, 1);
        board.requireValidSquare(new Square(1, 1));
    }

    @Test
    public void outOfBoundsSquarenShouldNotBeContainedInBoard() {
        Board board = new Board();
        assertFalse(board.contains(10, 20));
        assertFalse(board.contains(0, 20));
        assertFalse(board.contains(10, -1));
        assertFalse(board.contains(0, -1));
    }

    @Test
    public void boardCornersShouldBeContainedInBoard() {
        Board board = new Board();
        assertTrue(board.contains(0, 0));
        assertTrue(board.contains(0, 19));
        assertTrue(board.contains(19, 19));
        assertTrue(board.contains(19, 0));
    }

    @Test
    public void boardCornersShouldBeValidAndNotCauseAnException() {
        Board board = new Board();
        board.requireValidSquare(new Square(0, 0));
        board.requireValidSquare(new Square(0, 19));
        board.requireValidSquare(new Square(19, 19));
        board.requireValidSquare(new Square(19, 0));
    }

    @Test(expected = BoardPositionOutOfBounds.class)
    public void outOfBoundsSquareShouldCauseAnException() {
        Board board = new Board();
        board.requireValidSquare(new Square(10, 20));
        board.requireValidSquare(new Square(0, 20));
        board.requireValidSquare(new Square(10, -1));
        board.requireValidSquare(new Square(0, -1));
    }

    @Test
    public void pieceToBeAddedInEmptyBoardShouldBeAddable() {
        Board b = new Board();
        Piece p = new Piece(Shape.SHAPE_04, Color.BLUE);
        assertTrue(b.canAddAt(p, 0, 0));
    }

    @Test
    public void pieceToBeAddedNextToAnOtherShouldBeAddable() {
        Board b = new Board();
        Piece neighbor = new Piece(Shape.SHAPE_04, Color.BLUE);
        Piece p = new Piece(Shape.SHAPE_14, Color.BLUE);
        b.add(neighbor, 0, 0);
        assertTrue(b.canAddAt(p, 0, 1));
    }

    @Test
    public void pieceWithOutOfBoundsPieceSquareShouldNotBeAddable() {
        Board b = new Board();
        Piece p = new Piece(Shape.SHAPE_04, Color.BLUE);
        assertFalse(b.canAddAt(p, 0, 19));
    }

    @Test
    public void pieceAddedInFilledSquareShouldNotBeAddable() {
        Board b = new Board();
        Piece piece = new Piece(Shape.SHAPE_04, Color.BLUE);
        Piece overlappingPiece = new Piece(Shape.SHAPE_04, Color.RED);
        b.add(piece, 0, 0);
        assertFalse(b.canAddAt(overlappingPiece, 0, 1));
    }

    @Test(expected = BoardPositionOutOfBounds.class)
    public void outOfBoundsPieceSquareShouldCauseExceptionWhenAdding() {
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
        assertFalse(b.isFreeAt(0, 0) && b.isFreeAt(1, 0) && b.isFreeAt(1, 1));
    }

    @Test(expected = BoardPositionOutOfBounds.class)
    public void addingPieceOutOfBoardBoundsShouldCauseException() {
        Board b = new Board();
        Piece p = new Piece(Shape.SHAPE_04, Color.BLUE);
        b.add(p, -1, 0);
    }

}
