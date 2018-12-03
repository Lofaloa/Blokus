package blokus.model;

import blokus.exception.ModelException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the board.
 *
 * @author g47923
 */
public class BoardTest {

    /**
     * Checks the state of a board after initialization. A board should be empty
     * initially.
     */
    @Test
    public void initialization() {
        Board board = new Board();
        for (int row = 0; row < Board.SIZE; row++) {
            for (int column = 0; column < Board.SIZE; column++) {
                assertTrue(board.isEmptyAt(row, column));
            }
        }
    }

    /**
     * Out of bounds squares should not be contained in the board.
     */
    @Test
    public void contains_cases_x() {
        Board board = new Board();
        assertFalse(board.contains(-1, -1));
        assertFalse(board.contains(-1, 1));
        assertFalse(board.contains(1, -1));
        assertFalse(board.contains(0, 20));
        assertFalse(board.contains(20, 0));
        assertFalse(board.contains(20, 20));
    }

    /**
     * Asking if an out of bounds position is a corner should cause an
     * exception.
     */
    @Test(expected = ModelException.class)
    public void isCorner_case_1() {
        Board board = new Board();
        board.isCorner(-34, 5);
    }

    /**
     * Board corners should return true.
     */
    @Test
    public void isCorner_case_2x() {
        Board board = new Board();
        assertTrue(board.isCorner(0, 0));
        assertTrue(board.isCorner(0, 19));
        assertTrue(board.isCorner(19, 0));
        assertTrue(board.isCorner(19, 19));
    }

    /**
     * Squares in the middle of the board should not be corners.
     */
    public void isCorner_case_3() {
        Board board = new Board();
        assertFalse(board.isCorner(3, 5));
    }

    /**
     * Shape 04 should be in corner when right location is given.
     */
    public void isInCorner_case_1x() {
        Board board = new Board();
        Piece p = new Piece(Shape.SHAPE_04, BlokusColor.BLUE);
        assertTrue(board.isPieceInCorner(p, 18, 18));
        assertTrue(board.isPieceInCorner(p, 0, 0));
        assertTrue(board.isPieceInCorner(p, 18, 0));
    }

    /**
     * Piece should not be in corner when placed in the middle.
     */
    public void isInCorner_case_2x() {
        Board board = new Board();
        Piece p = new Piece(Shape.SHAPE_04, BlokusColor.BLUE);
        assertFalse(board.isPieceInCorner(p, 1, 1));
        assertFalse(board.isPieceInCorner(p, 17, 17));
        assertFalse(board.isPieceInCorner(p, 17, 0));
    }

    /**
     * Filled square should not be empty.
     */
    @Test
    public void isEmptyAt_case_1() {
        Board board = new Board();
        Piece p = new Piece(Shape.SHAPE_04, BlokusColor.BLUE);
        board.addPiece(p, 0, 0);
        assertFalse(board.isEmptyAt(0, 0));
    }

    /**
     * Asking if the board is empty at out of bounds location should cause an
     * exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void isEmptyAt_case_2() {
        Board board = new Board();
        board.isEmptyAt(-1, 23);
    }

    /**
     * Square should be valid when not filled and in the board.
     */
    @Test
    public void isValid_case_1() {
        Board board = new Board();
        assertTrue(board.isValid(0, 0));
    }

    /**
     * Square should not be valid when out of bounds.
     */
    @Test
    public void isValid_cases_2_x() {
        Board board = new Board();
        assertFalse(board.isValid(-1, -1));
        assertFalse(board.isValid(-1, 1));
        assertFalse(board.isValid(1, -1));
        assertFalse(board.isValid(0, 20));
        assertFalse(board.isValid(20, 0));
        assertFalse(board.isValid(20, 20));
    }

    /**
     * Filled square should cause an exception when valid square is required.
     */
    @Test(expected = ModelException.class)
    public void requireValidSquare_case_1() {
        Board board = new Board();
        Piece fillingPiece = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        board.addPiece(fillingPiece, 1, 1);
        board.requireValidSquare(1, 1);
    }

    /**
     * Out of bounds square should cause an exception when valid square is
     * required.
     */
    @Test(expected = ModelException.class)
    public void requireValidSquare_case_2() {
        Board board = new Board();
        board.requireValidSquare(-1, 23);
    }

    /**
     * Square should not be free after being filled with piece.
     */
    @Test
    public void addPiece_case_1() {
        Board board = new Board();
        Piece fillingPiece = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        board.addPiece(fillingPiece, 0, 0);
        assertFalse(board.isEmptyAt(0, 0));
    }

    /**
     * Square should not be valid when filled.
     */
    @Test
    public void addPiece_case_2() {
        Board board = new Board();
        Piece fillingPiece = new Piece(Shape.SHAPE_01, BlokusColor.BLUE);
        board.addPiece(fillingPiece, 0, 0);
        assertFalse(board.isValid(0, 0));
    }

    /**
     * Adding a piece with squares getting out of bounds should cause an
     * exception.
     */
    @Test(expected = ModelException.class)
    public void addPiece_case_3() {
        Board b = new Board();
        Piece p = new Piece(Shape.SHAPE_04, BlokusColor.BLUE);
        b.addPiece(p, 0, 19);
    }

    /**
     * Adding a piece on an other should cause an exception.
     */
    @Test(expected = ModelException.class)
    public void addPiece_case_4() {
        Board b = new Board();
        Piece piece = new Piece(Shape.SHAPE_04, BlokusColor.BLUE);
        Piece overlappingPiece = new Piece(Shape.SHAPE_04, BlokusColor.RED);
        b.addPiece(piece, 0, 0);
        b.addPiece(overlappingPiece, 0, 1);
    }

    /**
     * Adding a piece out of bounds should cause an exception.
     */
    @Test(expected = ModelException.class)
    public void addPiece_case_5() {
        Board b = new Board();
        Piece p = new Piece(Shape.SHAPE_04, BlokusColor.BLUE);
        b.addPiece(p, -1, 0);
    }

    /**
     * A piece should be on the board after being added.
     */
    @Test
    public void addPiece_case_6() {
        Board b = new Board();
        Piece p = new Piece(Shape.SHAPE_04, BlokusColor.BLUE);
        b.addPiece(p, 0, 0);
        assertFalse(b.isEmptyAt(0, 0) && b.isEmptyAt(1, 0) && b.isEmptyAt(1, 1));
    }

}
