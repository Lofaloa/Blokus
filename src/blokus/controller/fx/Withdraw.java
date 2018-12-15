package blokus.controller.fx;

import blokus.model.Game;
import blokus.view.fx.FXView;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Logan Farci (47923)
 */
public class Withdraw extends ButtonAction {

    public Withdraw(Game game, FXView view) {
        super(game, view);
    }

    @Override
    public void handle(MouseEvent event) {
        if (isMousePrimaryButton(event.getButton())) {
            game.getCurrentPlayer().withdraw();
            game.nextPlayer();
//            if (game.isOver()) {
//                if (view.displayEndDialog()) {
//                    game.initialize();
//                } else {
//                    Platform.exit();
//                }
//            }
        } else {
            event.consume();
        }
    }

}
