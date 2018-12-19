package blokus.model;

import blokus.exception.ModelException;
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

    private static final int NB_OF_PIECES = 21;

    private final Blokus game;
    private final List<Square> validSquares;

    DumbPlayerStrategy(Blokus game) {
        this.game = game;
        validSquares = new ArrayList<>(Arrays.asList(new Square(0, 0),
                new Square(0, Board.SIZE - 1),
                new Square(Board.SIZE - 1, 0),
                new Square(Board.SIZE - 1, Board.SIZE - 1)));
    }

    List<Square> getValidSquare() {
        return validSquares;
    }

    Player getBot() {
        return game.getCurrentPlayer();
    }

    boolean isPlayingBot() {
        return !getBot().isWithdrawn() && !getBot().isDone();
    }

    int getRandomPieceId() {
        return (int) (Math.random() * getBot().getStock().size());
    }

    void selectRandomPiece() {
        if (!getBot().getStock().isEmpty()) {
            Shape random = getBot().getStock().get(getRandomPieceId()).getShape();
            game.selectCurrentPlayerPiece(random);
        }
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

    Square getValidCorner() {
        for (Square validSquare : validSquares) {
            if (isPlacableAtFirstRound(getBot().getCurrentPiece(), validSquare)) {
                return validSquare;
            }
        }
        return null;
    }

    void makeFirstMove() {
        selectRandomPiece();
        Square dest = validSquares.get(0);
        while (!isPlacableAtFirstRound(getBot().getCurrentPiece(), dest)) {
            dest = getValidCorner();
            while (dest == null) {
                selectRandomPiece();
                dest = getValidCorner();
            }
        }
        validSquares.remove(dest);
        game.placePiece(dest.getRow(), dest.getColumn());
    }

    boolean isColorRestrictedSquare(Square square) {
        return game.getBoard().isSquareTouchingSameColorAtCorner(square, getBot().getColor())
                && !game.getBoard().isSquareTouchingSameColorBySide(square, getBot().getColor());
    }

    void updateValidSquares() {
        validSquares.clear();
        for (int row = 0; row < Board.SIZE; row++) {
            for (int column = 0; column < Board.SIZE; column++) {
                Square current = new Square(row, column);
                if (isColorRestrictedSquare(current)) {
                    validSquares.add(current);
                }
            }
        }
    }

    Square getColorRestrictedSquare() {
        for (Square validSquare : validSquares) {
            if (isPlacableAtMainRound(getBot().getCurrentPiece(), validSquare)) {
                return validSquare;
            }
        }
        return null;
    }

    void makeMainRoundsMove() {
        updateValidSquares();
        selectRandomPiece();
        Square dest = validSquares.get(0);
        int nbOfTries = 0;
        if (isPlayingBot()) {
            while (nbOfTries < 21 && !isPlacableAtMainRound(getBot().getCurrentPiece(), dest)) {
                dest = getColorRestrictedSquare();
                while (nbOfTries < 21 && dest == null) {
                    selectRandomPiece();
                    dest = getColorRestrictedSquare();
                    nbOfTries++;
                }
                if (nbOfTries == NB_OF_PIECES) {
                    getBot().withdraw();
                }
            }
        }
        if (nbOfTries < 21 && isPlayingBot()) {
            validSquares.remove(dest);
            try {
                game.placePiece(dest.getRow(), dest.getColumn());
            } catch (ModelException e) {}
        }
    }

    @Override
    public void execute() {
        if (game.isFirstRound()) {
            makeFirstMove();
        } else {
            makeMainRoundsMove();
        }
    }

}
