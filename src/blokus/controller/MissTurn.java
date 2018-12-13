package blokus.controller;

import blokus.model.Game;
import blokus.view.fx.FxView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
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

    @Override
    public void handle(MouseEvent event) {
        System.out.println("test");
        game.getCurrentPlayer().missTurn();
        game.nextPlayer();

    }

}
