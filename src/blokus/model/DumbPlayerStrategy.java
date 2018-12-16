package blokus.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents the strategy of a dumb player. The player always plays random
 * pieces.
 *
 * @author Logan Farci (47923)
 */
class DumbPlayerStrategy implements Strategy {

    private static final int MAX_SHAPE_ID = 20;
    private static final int MIN_SHAPE_ID = 0;

    private final Blokus game;
    private final List<Square> validSquares;

    DumbPlayerStrategy(Blokus game) {
        this.game = game;
        validSquares = new ArrayList<>(Arrays.asList(new Square(0, 0),
                new Square(0, Board.SIZE - 1),
                new Square(Board.SIZE - 1, 0),
                new Square(Board.SIZE - 1, Board.SIZE - 1)));
    }

    Player getBot() {
        return game.getCurrentPlayer();
    }

    int getRandomShapeId() {
        int range = (MAX_SHAPE_ID - MIN_SHAPE_ID) + 1;
        return (int) (Math.random() * range) + MIN_SHAPE_ID;
    }

    Shape getRandomShape() {
        return Shape.values()[getRandomShapeId()];
    }

    void selectRandomPiece() {
        game.selectCurrentPlayerPiece(getRandomShape());
    }

    boolean isPiecePlacable(Piece piece, Square square) {
        return game.getBoard().hasSpaceFor(piece, square.getRow(),
                square.getColumn());
    }

    boolean isPieceInCorner(Piece piece, Square square) {
        return game.getBoard().isPieceInCorner(piece, square.getRow(),
                square.getColumn());
    }

    boolean isPieceColorRestricted(Piece piece, Square square) {
        return game.getBoard().isColorRestrictedPiece(piece, square.getRow(),
                square.getColumn());
    }

    boolean isPlacableAtFirstRound(Piece piece, Square square) {
        return isPiecePlacable(piece, square) && isPieceInCorner(piece, square);
    }

    boolean isPlacableAtMainRound(Piece piece, Square square) {
        return isPiecePlacable(piece, square) && isPieceColorRestricted(piece, square);
    }

    void makeFirstRoundMove() {
        selectRandomPiece();
        int corner;
        Square dest = validSquares.get(0);
        while (!isPlacableAtFirstRound(getBot().getCurrentPiece(), dest)) {
            corner = 0;
            while (corner < validSquares.size()
                    && !isPlacableAtFirstRound(getBot().getCurrentPiece(), dest)) {
                dest = validSquares.get(corner);
                corner++;
            }
            selectRandomPiece();
        }
        validSquares.remove(dest);
        game.placePiece(dest.getRow(), dest.getColumn());
    }

    void makeMainRoundsMove() {
    }

    @Override
    public void execute() {
        if (game.isFirstRound()) {
            makeFirstRoundMove();
        } else {
            makeMainRoundsMove();
        }
    }

}