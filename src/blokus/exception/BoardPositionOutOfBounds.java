package blokus.exception;

/**
 * Thrown to indicate that a position is of out the board.
 *
 * @author g47923
 */
public class BoardPositionOutOfBounds extends IndexOutOfBoundsException {

    /**
     * Constructs an instance of <code>BoardPositionOutOfBounds</code> with a
     * message adapted to the invalid given position.
     *
     * @param row is the row of the invalid position.
     * @param column is the column of the invalid position.
     */
    public BoardPositionOutOfBounds(int row, int column) {
        super("Position (row " + row + ", column " + column + ") is out of the "
                + "board.");
    }
}
