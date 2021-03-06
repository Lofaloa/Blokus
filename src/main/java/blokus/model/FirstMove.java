package blokus.model;

import blokus.exception.ModelException;

/**
 * Represents a first move made by a player during the first round.
 *
 * @author Logan Farci (47923)
 */
public class FirstMove implements Move {

    private final Player player;
    private final Board board;
    private final Square dest;
    private final Piece piece;

    /**
     * Initializes this move with the given player board and destination.
     *
     * @param player is the player who makes this move.
     * @param board is the board where this move take place.
     * @param dest is the destination square of the piece selected by a player.
     */
    FirstMove(Player player, Board board, Square dest, Piece piece) {
        this.player = player;
        this.board = board;
        requireValidSquare(dest.getRow(), dest.getColumn());
        this.dest = dest;
        this.piece = new Piece(piece);
    }

    @Override
    public Piece getPiece() {
        return new Piece(piece);
    }

    @Override
    public Player getPlayer() {
        return player;
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

    /**
     * Requires a pieces in a corner.
     *
     * @param piece the piece that should be in a corner.
     * @param row the row of the piece.
     * @param column the column of the piece.
     */
    void requirePieceInCorner(Piece piece, int row, int column) {
        if (!board.isPieceInCorner(piece, row, column)) {
            throw new ModelException("piece " + piece.getColor() + " of shape "
                    + piece.getShape() + " should be placed in a board corner");
        }
    }

    @Override
    public void execute() {
        requirePlacablePiece(piece, dest.getRow(), dest.getColumn());
        requirePieceInCorner(piece, dest.getRow(), dest.getColumn());
        board.addPiece(player.takeCurrentPiece(), dest.getRow(), dest.getColumn());
    }

}
