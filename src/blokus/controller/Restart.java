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
 * @author Logan Farci (47923)
 */
public class Restart implements EventHandler<MouseEvent> {

    private final FxView view;
    private final Game game;

    public Restart(FxView view, Game game) {
        this.view = view;
        this.game = game;
    }

    boolean isMousePrimaryButton(MouseButton b) {
        return b == MouseButton.PRIMARY;
    }

    @Override
    public void handle(MouseEvent event) {
        if (isMousePrimaryButton(event.getButton())) {
            System.out.println("test");
            game.initialize();
        } else {
            event.consume();
        }
    }

}
