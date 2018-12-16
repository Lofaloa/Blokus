package blokus.model;

import blokus.exception.ModelException;
import java.util.Objects;

/**
 * Represents a move taking places during the main rounds.
 *
 * @author Logan Farci (47923)
 */
class MainRoundsMove implements Move {

    private final Player player;
    private final Board board;
    private final Square dest;

    /**
     * Initializes this move with the given player board and destination.
     *
     * @param player is the player who makes this move.
     * @param board is the board where this move take place.
     * @param dest is the destination square of the piece selected by a player.
     */
    MainRoundsMove(Player player, Board board, Square dest) {
        Objects.requireNonNull(dest);
        this.player = Objects.requireNonNull(player);
        this.board = Objects.requireNonNull(board);
        requireValidSquare(dest.getRow(), dest.getColumn());
        this.dest = dest;
    }

    /**
     * Makes sure the given square is valid. A valid square is free and is
     * inside the board.
     *
     * @param square is the square to check.
     * @return a valid square.
     */
    final void requireValidSquare(int row, int column) {
        Objects.requireNonNull(board, "Board is null");
        if (!board.contains(row, column)) {
            throw new ModelException("Square at position row "
                    + row + ", " + column + " is out of the board bounds.");
        }
        if (!board.isEmptyAt(row, column)) {
            throw new ModelException("not a free position at row " + row + ", "
                    + "column " + column + " is occupied by "
                    + board.getPieceAt(row, column).getColor() + " player.");
        }
    }

    /**
     * Requires a piece that can be placed at the given position.
     *
     * @param piece is the piece that should be placable.
     * @param row is the row where to place the piece.
     * @param column is the column where to place the piece.
     */
    void requirePlacablePiece(Piece piece, int row, int column) {
        if (!board.hasSpaceFor(piece, row, column)) {
            throw new ModelException("piece " + piece.getColor() + " of shape "
                    + piece.getShape() + "cannot be place at row " + row
                    + ", column " + column + ".");
        }
    }

    /**
     * Requires a color restricted piece. A color restricted piece touches
     * another same color piece at corner. And does not touch another same color
     * piece by side.
     *
     * @param piece is the piece that need to be color restricted.
     * @param row is the row of the piece.
     * @param column is the column of the piece.
     */
    void requireColorRestrictedPiece(Piece piece, int row, int column) {
        if (!board.isColorRestrictedPiece(piece, row, column)) {
            throw new ModelException("piece " + piece.getColor() + " of shape "
                    + piece.getShape() + " should touch another same color piece"
                    + " at corner and should not touch a same piece color by side.");
        }
    }

    @Override
    public void execute() {
        requirePlacablePiece(player.getCurrentPiece(), dest.getRow(), dest.getColumn());
        requireColorRestrictedPiece(player.getCurrentPiece(), dest.getRow(), dest.getColumn());
        board.addPiece(player.takeCurrentPiece(), dest.getRow(), dest.getColumn());
    }

}
