package blokus.model;

import blokus.exception.ModelException;

/**
 * Represents a move that follows the first move.
 *
 * @author Logan Farci (47923)
 */
public class FollowingMove implements Move {

    private final Player player;
    private final Board board;
    private final Square dest;

    public FollowingMove(Player player, Board board, Square dest) {
        this.player = player;
        this.board = board;
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
    final void requireValidSquare(int row, int column) throws ModelException {
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
     * Requires a piece the can be placed at the given position.
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

    @Override
    public void execute() {
        requirePlacablePiece(player.getCurrentPiece(), dest.getRow(), dest.getColumn());
        board.addPiece(player.takeCurrentPiece(), dest.getRow(), dest.getColumn());
    }

}
