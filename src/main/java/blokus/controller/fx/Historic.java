package blokus.controller.fx;

import blokus.model.Game;
import blokus.view.fx.FxView;
import blokus.view.fx.HistoricWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Opens a new window displaying the historic of moves of the game.
 *
 * @author Logan Farci (47923)
 */
public class Historic implements EventHandler<ActionEvent> {

    private final Game game;
    private final FxView view;

    public Historic(Game game, FxView node) {
        this.game = game;
        this.view = node;
    }

    @Override
    public void handle(ActionEvent t) {
        view.showHistoric();
    }

}
