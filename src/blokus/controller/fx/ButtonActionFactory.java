package blokus.controller.fx;

import blokus.model.Game;
import blokus.view.fx.FxView;

/**
 *
 *
 * @author Logan Farci (47923)
 */
public class ButtonActionFactory {

    private final Game game;
    private final FxView view;

    public ButtonActionFactory(Game game, FxView view) {
        this.game = game;
        this.view = view;
    }

    public ButtonAction getButtonAction(ActionType type) {
        if (type == null) {
            return null;
        }
        switch (type) {
            case RESTART:
                return new Restart(game, view);
            case MISS_TURN:
                return new MissTurn(game, view);
            case ROTATE:
                return new Rotate(game, view);
            case TURN_OVER:
                return new TurnOver(game, view);
            default:
                return new Withdraw(game, view);
        }
    }

}
