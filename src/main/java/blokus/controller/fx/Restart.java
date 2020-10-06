/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blokus.controller.fx;

import blokus.model.Game;
import blokus.view.fx.FxView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Logan Farci (47923)
 */
public class Restart extends ButtonAction {

    public Restart(Game game, FxView view) {
        super(game, view);
    }

    boolean askConfirmation() {
        return view.askConfirmation("Confirmation", "Voulez-vous vraiment "
                + "recommencer une partie?", "En recommençant la partie courante, "
                + "votre avancé sera perdue.");
    }

    @Override
    public void handle(MouseEvent event) {
        if (isMousePrimaryButton(event.getButton())) {
            if (askConfirmation()) {
                game.initialize();
            } else {
                event.consume();
            }
        } else {
            event.consume();
        }
    }

}
