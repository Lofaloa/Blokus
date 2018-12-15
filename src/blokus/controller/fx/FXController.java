package blokus.controller.fx;

import blokus.model.Game;
import blokus.view.fx.FXView;

/**
 * Handles the logic of the game.
 *
 * @author Logan Farci (47923)
 */
public class FXController {

    private final Game game;
    private final FXView view;

    /**
     * Constructs this controller with the game to control and its view.
     *
     * @param game is the game to control.
     * @param view is the view representing the game.
     */
    public FXController(Game game, FXView view) {
        this.game = game;
        this.view = view;
        view.setSelectCurrentPieceAction();
        view.setPlacePieceAction();
        view.setPiecePreviewAction();
        view.setButtonActions();
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
