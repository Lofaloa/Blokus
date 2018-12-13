package blokus;

import blokus.controller.FXController;
import blokus.model.Blokus;
import blokus.model.Game;
import blokus.view.fx.FxView;
import javafx.application.Application;
import javafx.scene.Scene;
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
     * @param primaryStage nothing.
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Blokus");
        Game game = new Blokus();
        FxView view = new FxView(game);
        FXController controller = new FXController(game, view);
        controller.addObserver();
        controller.initialize();
        Scene scene = new Scene(view, 1000, 750);
        primaryStage.setScene(scene);
        primaryStage.show();
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
