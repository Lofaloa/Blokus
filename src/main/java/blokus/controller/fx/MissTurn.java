package blokus.controller.fx;

import blokus.model.Game;
import blokus.view.fx.FxView;
import javafx.scene.input.MouseEvent;

/**
 * TODO: fusionner classes buttons -> switch sur la source de l'event (check
 * factory design pattern)
 *
 * @author Logan Farci (47923)
 */
public class MissTurn extends ButtonAction {

    public MissTurn(Game game, FxView view) {
        super(game, view);
    }

    @Override
    public void handle(MouseEvent event) {
        if (isMousePrimaryButton(event.getButton())) {
            game.missTurnCurrentPlayer();
            game.nextPlayer();
        } else {
            event.consume();
        }
    }

}
