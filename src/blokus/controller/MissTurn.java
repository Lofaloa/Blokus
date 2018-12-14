package blokus.controller;

import blokus.model.Game;
import blokus.view.fx.FxView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * TODO: fusionner classes buttons -> switch sur la source de l'event (check
 * factory design pattern)
 *
 * @author Logan Farci (47923)
 */
public class MissTurn implements EventHandler<MouseEvent> {

    private final Game game;
    private final FxView view;

    public MissTurn(Game game, FxView view) {
        this.game = game;
        this.view = view;
    }

    boolean isMousePrimaryButton(MouseButton b) {
        return b == MouseButton.PRIMARY;
    }

    @Override
    public void handle(MouseEvent event) {
        if (isMousePrimaryButton(event.getButton())) {
            game.getCurrentPlayer().missTurn();
            game.nextPlayer();
        } else {
            event.consume();
        }
    }

}
