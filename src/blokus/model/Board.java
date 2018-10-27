package blokus.model;

/**
 * Represents a board
 *
 * @author g47923
 */
public class Board {

    private final int BOARD_SIZE = 20;
    private final Piece[][] cells;

    /**
     * Initializes this board with a 20 by 20 empty grid.
     */
    public Board() {
        this.cells = new Piece[BOARD_SIZE][BOARD_SIZE];
    }

    Piece[][] getCells() {
        return cells;
    }

    /**
     * Tells if the given cell position is free. A free cell does not contains a
     * piece.
     *
     * @param pos is the cell position to test.
     * @return true if the given position is an empty cell.
     */
    boolean isFree(Position pos) {
        return cells[pos.getX()][pos.getY()] == null;
    }

    /**
     * Tells if the given position is valid. A valid position is in the board
     * bounds.
     *
     * @param pos is the position to test.
     * @return true if the given position in the board bounds.
     */
    boolean isValid(Position pos) {
        return 0 <= pos.getX() && pos.getX() < BOARD_SIZE
                && 0 <= pos.getY() && pos.getY() < BOARD_SIZE;
    }

    /**
     * Adds the given piece at the given destination.
     *
     * @param piece is the piece to add to this board.
     * @param destination is the destination in this board.
     */
    void add(Piece piece, Position destination) {
        if (!isValid(destination)) {
            //erreur de domaine?
            throw new IndexOutOfBoundsException();
        }
        if (!isFree(destination)) {
            //créer une exception lancée lors une position de pièce n'est utilisable
        }
        for (Position position : piece.getPositions()) {
            position.move(destination.getX(), destination.getY());
            cells[position.getX()][position.getY()] = piece;
        }
    }
}
