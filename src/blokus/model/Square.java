package blokus.model;

/**
 * Represents a unit square.
 *
 * @author g47923
 */
public class Square {

    private final int row;
    private final int column;

    /**
     * Initializes this square to the given coordinates.
     *
     * @param row is the row of this square.
     * @param column is the column of this square.
     */
    public Square(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Gets the row of this square.
     *
     * @return the row of this square.
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column of this square.
     *
     * @return the column of this square.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Creates a new square based on this square and the given offsets.
     *
     * @param rowOffset is the offset to apply to this square row.
     * @param columnOffset is the offset to apply to this square column.
     * @return a new position based on this position and the given offsets.
     */
    public Square move(int rowOffset, int columnOffset) {
        return new Square(row + rowOffset, column + columnOffset);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Square other = (Square) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }

    

}
