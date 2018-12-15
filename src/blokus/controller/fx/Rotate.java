package blokus.controller.fx;

import blokus.model.Game;
import blokus.view.fx.FxView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Logan Farci (47923)
 */
public class Rotate extends ButtonAction {

    public Rotate(Game game, FxView view) {
        super(game, view);
    }

    @Override
    public void handle(MouseEvent event) {
//        if (isMousePrimaryButton(event.getButton())) {
            try {
                game.rotateCurrentPlayerPiece();
            } catch (IllegalStateException e) {
                FxView.displayAlert("Erreur de rotation", "Attention!", e.getMessage());
            }
//        } else {
//            event.consume();
//        }
    }

}
