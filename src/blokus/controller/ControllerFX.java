package blokus.controller;

import blokus.model.Blokus;
import blokus.view.fx.MainBox;

/**
 *
 * @author Logan Farci (47923)
 */
public class ControllerFX {

    private final MainBox main;
    private final Blokus game;
    
    public ControllerFX(Blokus game, MainBox main) {
        this.game = game;
        this.main = main;
    }

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
