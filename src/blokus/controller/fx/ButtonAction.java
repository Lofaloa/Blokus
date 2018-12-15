/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokus.controller.fx;

import blokus.model.Game;
import blokus.view.fx.FXView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Logan Farci (47923)
 */
public abstract class ButtonAction implements EventHandler<MouseEvent> {

    protected final Game game;
    protected final FXView view;

    public ButtonAction(Game game, FXView view) {
        this.game = game;
        this.view = view;
    }

    boolean isMousePrimaryButton(MouseButton b) {
        return b == MouseButton.PRIMARY;
    }

    boolean isMouseSecondaryButton(MouseButton b) {
        return b == MouseButton.SECONDARY;
    }

    @Override
    abstract public void handle(MouseEvent event);

}