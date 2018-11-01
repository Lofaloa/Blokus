package blokus.model;

import blokus.exception.BoardPositionOutOfBounds;
import blokus.exception.IllegalActionException;

/**
 * Represents a board.
 *
 * @author Logan Farci (47923)
 */
public class Board {

    private final static int BOARD_SIZE = 20;
    private final Piece[][] squares;

    /**
     * Initializes this board with a 20 by 20 empty grid of squares.
     */
    Board() {
        this.squares = new Piece[BOARD_SIZE][BOARD_SIZE];
    }

    /**
     * Gets the squares of this board.
     *
     * @return the squares of this board.
     */
    Piece[][] getSquares() {
        return squares;
    }

    /**
     * Tells if the given square is free. A free square does not contains a
     * piece.
     *
     * @param row is the row of the square to test.
     * @param column is the column of the square to test.
     * @return true if the given position is an empty square.
     */
    boolean isFreeAt(int row, int column) {
        return squares[row][column] == null;
    }

    /**
     * Tells if the given square is in this board bounds.
     *
     * @param row is the row of the square to test.
     * @param column is the column of the square to test.
     * @return true if the given square is in the board bounds.
     */
    boolean contains(int row, int column) {
        return 0 <= row && row < BOARD_SIZE && 0 <= column && column < BOARD_SIZE;
    }

    /**
     * Tells if the given square is valid. A valid square is in this board
     * bounds and free.
     *
     * @param row is the row of the square to test.
     * @param column is the column of the square to test.
     * @return true if the given square is in the board bounds and free.
     */
    boolean isValid(int row, int column) {
        return contains(row, column) && isFreeAt(row, column);
    }

    /**
     * Makes sure the given square is valid. A valid square is free and is
     * inside the board.
     *
     * @param square is the square to check.
     * @return a valid square.
     */
    Square requireValidSquare(Square square) {
        if (!contains(square.getRow(), square.getColumn())) {
            throw new BoardPositionOutOfBounds(square.getRow(), square.getColumn());
        }
        if (!isFreeAt(square.getRow(), square.getColumn())) {
            throw new IllegalActionException("Square at position ("
                    + square.getRow() + "; " + square.getColumn() + ") is not free.");
        }
        return square;
    }

    /**
     * Indicates that a piece can be add or not on this board.
     *
     * @param piece is piece to add.
     * @return true if the given piece can be added.
     */
    boolean canAddAt(Piece piece, int row, int column) {
        for (Square pieceSquare : piece.getShape().getSquares()) {
            Square boardSquare = pieceSquare.move(row, column);
            if (!isValid(boardSquare.getRow(), boardSquare.getColumn())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds the given piece at the given row and column.
     *
     * @param piece is the piece to add to this board.
     * @param row is the row of the square of destination in this board.
     * @param column is the column of the square of destination in this board.
     */
    void add(Piece piece, int row, int column) {
        for (Square pieceSquare : piece.getShape().getSquares()) {
            Square boardSquare = requireValidSquare(pieceSquare.move(row, column));
            squares[boardSquare.getRow()][boardSquare.getColumn()] = piece;
        }
    }

}
