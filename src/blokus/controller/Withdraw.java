package blokus.controller;

import blokus.model.Game;
import blokus.view.fx.FxView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Logan Farci (47923)
 */
public class Withdraw implements EventHandler<MouseEvent> {

    private final FxView view;
    private final Game game;

    public Withdraw(FxView view, Game game) {
        this.view = view;
        this.game = game;
    }

    boolean isMousePrimaryButton(MouseButton b) {
        return b == MouseButton.PRIMARY;
    }

    @Override
    public void handle(MouseEvent event) {
        if (isMousePrimaryButton(event.getButton())) {
            game.getCurrentPlayer().withdraw();
            game.nextPlayer();
        }
    }

}
