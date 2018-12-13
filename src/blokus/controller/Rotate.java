package blokus.controller;

import blokus.model.Game;
import blokus.view.fx.FxView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Logan Farci (47923)
 */
public class Rotate implements EventHandler<MouseEvent> {

    private final FxView view;
    private final Game game;

    public Rotate(FxView view, Game game) {
        this.view = view;
        this.game = game;
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println(" rotated");
        game.rotateCurrentPlayerPiece();
    }

}
