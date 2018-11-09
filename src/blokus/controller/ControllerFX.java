package blokus.controller;

import blokus.model.Blokus;

/**
 * Emulate the first turn of a <i>Blokus</i> game.
 * 
 * @author Logan Farci (47923)
 */
public class ControllerFX {

    private final Blokus game;
    
    /**
     * Initializes this controller with the given game.
     * 
     * @param game is the game to control.
     */
    public ControllerFX(Blokus game) {
        this.game = game;
    }

    /**
     * Start the emulation of the first turn of the game.
     */
    public void start() {
        game.selectCurrentPlayerPiece(15);
        game.placePiece(0, 0);
        game.nextPlayer();
        game.selectCurrentPlayerPiece(11);
        game.placePiece(16, 0);
        game.nextPlayer();
        game.selectCurrentPlayerPiece(10);
        game.placePiece(0, 19);
        game.nextPlayer();
        game.selectCurrentPlayerPiece(9);
        game.placePiece(18, 17);

    }

}
