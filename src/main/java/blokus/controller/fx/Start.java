/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokus.controller.fx;

import blokus.model.Game;
import blokus.view.fx.FxView;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

/**
 * Starts the bot players on start.
 *
 * @author Logan Farci (47923)
 */
public class Start implements EventHandler<WindowEvent> {

    private final Game game;
    private final FxView view;

    public Start(Game game, FxView view) {
        this.game = game;
        this.view = view;
    }

    @Override
    public void handle(WindowEvent event) {
        while (!game.isOver() && game.getCurrentPlayer().isBot()) {
            game.getCurrentPlayer().executeStrategy();
            game.nextPlayer();
        }
    }
}
