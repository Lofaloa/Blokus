package blokus.controller;

import blokus.model.Blokus;
import blokus.model.Shape;

/**
 * Manages the logic of the first turn of a game.
 *
 * @author Logan Farci (47923)
 */
public class ControllerFX {

    private final Blokus game;

    /**
     * Initializes this controller with the game to control.
     *
     * @param game is the game to control.
     */
    public ControllerFX(Blokus game) {
        this.game = game;
    }

    /**
     * Emulates the first turn of a game.
     */
    public void start() {
        game.selectCurrentPlayerPiece(Shape.SHAPE_04);
        game.placePiece(0, 0);
        game.nextPlayer();
        game.selectCurrentPlayerPiece(Shape.SHAPE_10);
        game.placePiece(15, 0);
        game.nextPlayer();
        game.selectCurrentPlayerPiece(Shape.SHAPE_09);
        game.placePiece(0, 17);
        game.nextPlayer();
        game.selectCurrentPlayerPiece(Shape.SHAPE_08);
        game.placePiece(18, 18);
    }

}
