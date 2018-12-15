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
 * @author g47923
 */
public class TurnOver extends ButtonAction {

    public TurnOver(Game game, FXView view) {
        super(game, view);
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
