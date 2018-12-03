package blokus.model;

import blokus.exception.ModelException;
import static java.util.Objects.requireNonNull;

/**
 * Represents the board of <i>Blokus</i>.
 *
 * @author Logan Farci (47923)
 */
public class Board {

    /**
     * Is the size of a board.
     */
    public static final int SIZE = 20;

    private final Piece[][] squares;

    /**
     * Initializes this board with a 20 by 20 empty grid of squares.
     */
    Board() {
        this.squares = new Piece[SIZE][SIZE];
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
     * Gets the square at the given position.
     *
     * @param row is the row of the square.
     * @param column is the column of the square.
     * @return the square the given position.
     */
    Piece getPieceAt(int row, int column) {
        if (!contains(row, column)) {
            throw new ModelException("Square at position row "
                    + row + ", " + column + " is out of the board bounds.");
        }
        return squares[row][column];
    }

    /**
     * Gets the color of this board at the given position.
     *
     * @param row is the row of the square.
     * @param column is the column of the square.
     * @return the color of this board at the given position. <code>null</code>
     * is returned if the board is empty at thee given position.
     */
    public BlokusColor getColorAt(int row, int column) {
        if (isEmptyAt(row, column)) {
            return null;
        } else {
            return getPieceAt(row, column).getColor();
        }
    }

    /**
     * Tells if the given square is in this board bounds.
     *
     * @param row is the row of the square to test.
     * @param column is the column of the square to test.
     * @return true if the given square is in the board bounds.
     */
    boolean contains(int row, int column) {
        return 0 <= row && row < SIZE && 0 <= column && column < SIZE;
    }

    /**
     * Tells if the given position is a corner of this board.
     *
     * @param row is the row of the position.
     * @param column is the column of the position.
     * @return true if the given position is a corner.
     */
    boolean isCorner(int row, int column) {
        requireValidSquare(row, column);
        return row == 0 && column == 0
                || row == 0 && column == SIZE - 1
                || row == SIZE - 1 && column == 0
                || row == SIZE - 1 && column == SIZE - 1;
    }

    /**
     * Tells if the given square is free. A free square does not contains a
     * piece.
     *
     * @param row is the row of the square to test.
     * @param column is the column of the square to test.
     * @return true if the given position is an empty square.
     */
    boolean isEmptyAt(int row, int column) {
        if (!contains(row, column)) {
            throw new IllegalArgumentException("Position " + row + ", " + column
                    + " is not in the board.");
        }
        return getPieceAt(row, column) == null;
    }

    /**
     * Tells if the given piece can be placed at the given position.
     *
     * @param piece is the piece to check the placement for.
     * @param row is the row where the piece is to be placed.
     * @param column is the column where the piece is to be placed.
     * @return true if the given piece can placed at the given position.
     */
    boolean hasSpaceFor(Piece piece, int row, int column) {
        requireNonNull(piece, "no given piece.");
        requireValidSquare(row, column);
        return piece.getShape().getSquares().stream()
                .map(s -> s.move(row, column))
                .allMatch(s -> isValid(s.getRow(), s.getColumn()));
    }

    /**
     *
     * @param piece
     * @param row
     * @param column
     * @return
     */
    boolean isPieceInCorner(Piece piece, int row, int column) {
        requireNonNull(piece, "no piece when determining if it is in a corner");
        requireValidSquare(row, column);
        return piece.getShape().getSquares().stream()
                .map(s -> s.move(row, column))
                .anyMatch(s -> isCorner(s.getRow(), s.getColumn()));
    }

    /**
     * Tells if this board is empty.
     *
     * @return true if this board does not contain a piece.
     */
    boolean isEmpty() {
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                if (!isEmptyAt(row, column)) {
                    return false;
                }
            }
        }
        return true;
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
        return contains(row, column) && isEmptyAt(row, column);
    }

    /**
     * Tells if the given square is touching another same color square at
     * corner.
     *
     * @param square is the square.
     * @param colorSquare is the color of the square.
     * @return true if the given square is touching another same color square at
     * corner.
     */
    boolean isSquareTouchingSameColorAtCorner(Square square, BlokusColor colorSquare) {
        return colorSquare == getColorAt(square.getRow() - 1, square.getColumn() - 1)
                || colorSquare == getColorAt(square.getRow() + 1, square.getColumn() - 1)
                || colorSquare == getColorAt(square.getRow() - 1, square.getColumn() + 1)
                || colorSquare == getColorAt(square.getRow() + 1, square.getColumn() + 1);
    }

    /**
     * Tells if the given square is touching another same color square by side.
     *
     * @param square is the square.
     * @param colorSquare is the color of the square.
     * @return true if the given square is touching another same color square by
     * side.
     */
    boolean isSquareTouchingSameColorBySide(Square square, BlokusColor colorSquare) {
        return colorSquare == getColorAt(square.getRow(), square.getColumn() - 1)
                || colorSquare == getColorAt(square.getRow(), square.getColumn() + 1)
                || colorSquare == getColorAt(square.getRow() - 1, square.getColumn())
                || colorSquare == getColorAt(square.getRow() + 1, square.getColumn());
    }

    /**
     * Tells if the given square color restricted. A color restricted square
     * touches another same color square at corner. And does not touch another
     * same color square by side.
     *
     * @param square is the square.
     * @param colorSquare is the color of the square.
     * @return true if the given square is touching another same color square by
     * side.
     */
    boolean isColorRestrictedSquare(Square square, BlokusColor colorSquare) {
        return isSquareTouchingSameColorAtCorner(square, colorSquare)
                && !isSquareTouchingSameColorBySide(square, colorSquare);
    }

    /**
     * Tells if the given piece is color restricted. A color restricted piece
     * touches another same color piece at corner. And does not touch another
     * same color piece by side.
     *
     * @param piece is the piece.
     * @param row is the row of the piece.
     * @param column is the column of the piece.
     *
     * @return true if the given piece touches another same color piece at
     * corner
     */
    boolean isColorRestrictedPiece(Piece piece, int row, int column) {
        return piece.getSquares().stream()
                .map(s -> s.move(row, column))
                .anyMatch(s -> isColorRestrictedSquare(s, piece.getColor()));
    }

    /**
     * Makes sure the given square is valid. A valid square is free and is
     * inside the board.
     *
     * @param square is the square to check.
     * @return a valid square.
     */
    void requireValidSquare(int row, int column) throws ModelException {
        if (!contains(row, column)) {
            throw new ModelException("Square at position row "
                    + row + ", " + column + " is out of the board bounds.");
        }
        if (!isEmptyAt(row, column)) {
            throw new ModelException("not a free position at row " + row + ", "
                    + "column " + column + " is occupied by "
                    + getPieceAt(row, column).getColor() + " player.");
        }
    }

    /**
     * Requires a piece the can be placed at the given position.
     *
     * @param piece is the piece that should be placable.
     * @param row is the row where to place the piece.
     * @param column is the column where to place the piece.
     */
    void requirePlacablePiece(Piece piece, int row, int column) {
        if (!hasSpaceFor(piece, row, column)) {
            throw new ModelException("piece " + piece.getColor() + " of shape "
                    + piece.getShape() + "cannot be place at row " + row
                    + ", column " + column + ".");
        }
    }

    /**
     * Adds a given piece square to the given position.
     *
     * @param row is the row where to add the piece square.
     * @param column is the column where to add the piece square.
     * @param piece is the piece to add a square in this board for.
     */
    void addAt(int row, int column, Piece piece) {
        squares[row][column] = piece;
    }

    /**
     * Adds the given piece at the given row and column.
     *
     * @param piece is the piece to addPiece to this board.
     * @param row is the row of the square of destination in this board.
     * @param column is the column of the square of destination in this board.
     */
    void addPiece(Piece piece, int row, int column) {
        requireNonNull(piece, "no piece to add.");
        requireValidSquare(row, column);
        requirePlacablePiece(piece, row, column);
        for (Square square : piece.getSquares()) {
            Square boardSquare = square.move(row, column);
            addAt(boardSquare.getRow(), boardSquare.getColumn(), piece);
        }
    }

}
