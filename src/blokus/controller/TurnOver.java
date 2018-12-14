/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class TurnOver implements EventHandler<MouseEvent> {

    private final Game game;
    private final FxView view;

    public TurnOver(Game game, FxView view) {
        this.game = game;
        this.view = view;
    }

    boolean isMousePrimaryButton(MouseButton b) {
        return b == MouseButton.PRIMARY;
    }

    @Override
    public void handle(MouseEvent event) {
        if (isMousePrimaryButton(event.getButton())) {
            game.turnCurrentPlayerPieceOver();
        } else {
            event.consume();
        }
    }
}
