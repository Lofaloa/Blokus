package blokus.model;

import blokus.exception.BoardPositionOutOfBounds;
import blokus.exception.IllegalActionException;

/**
 * Represents a board.
 *
 * @author g47923
 */
class Board {

    private final static int BOARD_SIZE = 20;
    private final Piece[][] squares;

    /**
     * Initializes this board with a 20 by 20 empty grid.
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
     * @return true if the given position is an empty cell.
     */
    boolean isFree(int row, int column) {
        return squares[row][column] == null;
    }

    /**
     * Makes sure the given square is free.
     *
     * @param square is the square to test.
     * @throws IllegalActionException if the given square points to a filled
     * cell.
     */
    void requireFreeSquare(Square square) {
        if (!isFree(square.getRow(), square.getColumn())) {
            throw new IllegalActionException("Square (row: " + square.getRow()
                    + ", column: " + square.getColumn() + ") is not free.");
        }
    }

    /**
     * Tells if the given square is valid. A valid square is in the board
     * bounds.
     *
     * @param row is the row of the square to test.
     * @param column is the column of the square to test.
     * @return true if the given square in the board bounds.
     */
    boolean isValid(int row, int column) {
        return 0 <= row && row < BOARD_SIZE && 0 <= column && column < BOARD_SIZE;
    }

    /**
     * Makes sure the given square is valid.
     *
     * @param square is the square to test.
     * @throws BoardPositionOutOfBounds if the square is not valid.
     */
    void requireValidPosition(Square square) {
        if (!isValid(square.getRow(), square.getColumn())) {
            throw new BoardPositionOutOfBounds(square.getRow(), square.getColumn());
        }
    }

    /**
     * Adds the given piece at the given row and column.
     *
     * @param piece is the piece to add to this board.
     * @param row is the row of the square of destination in this board.
     * @param column is the column of the square of destination in this board.
     */
    void add(Piece piece, int row, int column) {
        requireValidPosition(new Square(row, column));
        for (Square pieceSquare : piece.getShape().getSquares()) {
            Square square = pieceSquare.move(row, column);
            requireValidPosition(square);
            requireFreeSquare(square);
            squares[square.getRow()][square.getColumn()] = piece;
        }
    }

}
