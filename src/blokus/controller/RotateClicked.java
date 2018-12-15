package blokus.controller;

import blokus.model.Game;
import blokus.view.fx.FxView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author g47923
 */
public class RotateClicked implements EventHandler<MouseEvent> {

    private final Game game;
    private final FxView view;

    public RotateClicked(Game game, FxView view) {
        this.game = game;
        this.view = view;
    }

    boolean isMouseSecondaryButton(MouseButton b) {
        return b == MouseButton.SECONDARY;
    }

    @Override
    public void handle(MouseEvent event) {
        if (isMouseSecondaryButton(event.getButton())) {
            game.rotateCurrentPlayerPiece();
        } else {
            event.consume();
        }
    }
}
