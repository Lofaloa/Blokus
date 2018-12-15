/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokus.controller.fx;

import blokus.model.Game;
import blokus.view.fx.FXView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Logan Farci (47923)
 */
public class Restart extends ButtonAction {

    public Restart(Game game, FXView view) {
        super(game, view);
    }

    @Override
    public void handle(MouseEvent event) {
        if (isMousePrimaryButton(event.getButton())) {
            //TODO: confirmation dialog
            game.initialize();
        } else {
            event.consume();
        }
    }

}
