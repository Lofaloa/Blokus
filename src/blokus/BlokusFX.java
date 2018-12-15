package blokus;

import blokus.controller.fx.FXController;
import blokus.model.Blokus;
import blokus.model.Game;
import blokus.view.fx.FxView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class of <i>Blokus</i> graphical interface version.
 *
 * @author Logan Farci (47923)
 */
public class BlokusFX extends Application {

    /**
     * Starts <i>Blokus</i>.
     *
     * @param stage nothing.
     */
    @Override
    public void start(Stage stage) {
        Game game = new Blokus();
        FxView view = new FxView(stage, game);
        FXController controller = new FXController(game, view);
        controller.addObserver();
        controller.initialize();
    }

    /**
     * Entry point for <i>Blokus</i> graphical interface version.
     *
     * @param args nothing.
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

}
