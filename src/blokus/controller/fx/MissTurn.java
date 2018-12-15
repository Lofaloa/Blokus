package blokus.controller.fx;

import blokus.model.Game;
import blokus.view.fx.FXView;
import javafx.scene.input.MouseEvent;

/**
 * TODO: fusionner classes buttons -> switch sur la source de l'event (check
 * factory design pattern)
 *
 * @author Logan Farci (47923)
 */
public class MissTurn extends ButtonAction {

    public MissTurn(Game game, FXView view) {
        super(game, view);
    }

    @Override
    public void handle(MouseEvent event) {
        if (isMousePrimaryButton(event.getButton())) {
            game.getCurrentPlayer().missTurn();
            game.nextPlayer();
        } else {
            event.consume();
        }
    }

}
