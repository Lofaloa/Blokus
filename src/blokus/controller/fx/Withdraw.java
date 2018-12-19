package blokus.controller.fx;

import blokus.model.Game;
import blokus.view.fx.FxView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Logan Farci (47923)
 */
public class Withdraw extends ButtonAction {

    public Withdraw(Game game, FxView view) {
        super(game, view);
    }

    @Override
    public void handle(MouseEvent event) {
        if (isMousePrimaryButton(event.getButton())) {
            game.withdrawCurrentPlayer();
            game.nextPlayer();
        } else {
            event.consume();
        }
    }

}
