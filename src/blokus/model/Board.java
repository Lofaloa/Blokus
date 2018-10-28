package blokus.model;

import blokus.exception.BoardPositionOutOfBounds;
import blokus.exception.IllegalActionException;

/**
 * Represents a board.
 *
 * @author g47923
 */
public class Board {

    private final static int BOARD_SIZE = 20;
    private final Piece[][] cells;

    /**
     * Initializes this board with a 20 by 20 empty grid.
     */
    public Board() {
        this.cells = new Piece[BOARD_SIZE][BOARD_SIZE];
    }

    /**
     * Gets the cells of this board.
     *
     * @return the cells of this board.
     */
    Piece[][] getCells() {
        return cells;
    }

    /**
     * Tells if the given cell position is free. A free cell does not contains a
     * piece.
     *
     * @param row is the row of the cell to test.
     * @param column is the column of the cell to test.
     * @return true if the given position is an empty cell.
     */
    boolean isFree(int row, int column) {
        return cells[row][column] == null;
    }

    /**
     * Makes sure the given position is free.
     *
     * @param pos is the position to test.
     * @throws IllegalActionException if the given position points to a filled
     * cell.
     */
    void requireFreePosition(Position pos) {
        if (!isFree(pos.getX(), pos.getY())) {
            throw new IllegalActionException("Position (row: " + pos.getX()
                    + ", column: " + pos.getY() + ") is not free.");
        }
    }

    /**
     * Tells if the given position is valid. A valid position is in the board
     * bounds.
     *
     * @param row is the row of the cell to test.
     * @param column is the column of the cell to test.
     * @return true if the given position in the board bounds.
     */
    boolean isValid(int row, int column) {
        return 0 <= row && row < BOARD_SIZE && 0 <= column && column < BOARD_SIZE;
    }

    /**
     * Makes sure the given position is valid.
     *
     * @param pos is the position to test.
     * @throws BoardPositionOutOfBounds if the position is not valid.
     */
    void requireValidPosition(Position pos) {
        if (!isValid(pos.getX(), pos.getY())) {
            throw new BoardPositionOutOfBounds(pos.getX(), pos.getY());
        }
    }

    /**
     * Adds the given piece at the given row and column.
     *
     * @param piece is the piece to add to this board.
     * @param row is the row of the destination in this board.
     * @param column is the column of the destination in this board.
     */
    void add(Piece piece, int row, int column) {
        requireValidPosition(new Position(row, column));
        for (Position pos : piece.getShape().getPositions()) {
            Position cellPosition = pos.move(row, column);
            requireValidPosition(cellPosition);
            requireFreePosition(cellPosition);
            cells[cellPosition.getX()][cellPosition.getY()] = piece;
        }
    }
    
}
