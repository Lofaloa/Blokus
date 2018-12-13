package blokus.controller;

import blokus.model.Game;
import blokus.view.fx.FxView;

/**
 * Handles the logic of the game.
 *
 * @author Logan Farci (47923)
 */
public class FXController {

    private final Game game;
    private final FxView view;

    /**
     * Initializes this controller with the game to control.
     *
     * @param game is the game to control.
     * @param view is the view representing the game.
     */
    public FXController(Game game, FxView view) {
        this.game = game;
        this.view = view;
        view.setSelectCurrentPieceAction();
        view.setSelectBoardSquareAction();
        view.setRotateAction();
        view.setMissTurnAction();
        view.setWithdrawAction();
        view.setRestartAction();
    }

    /**
     * Add the view as an observer to the game (observable).
     */
    public void addObserver() {
        game.addObserver(view);
    }

    public void initialize() {
        game.initialize();
        view.initialize();
    }

}
