package blokus;

import blokus.model.Blokus;
import blokus.model.Game;
import blokus.view.fx.Stock;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 *
 * @author Logan Farci (47923)
 */
public class BlokusFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Blokus");

            Game blokus = new Blokus();

            Stock s = new Stock(blokus.getCurrentPlayer());

            Scene scene = new Scene(s);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            Platform.exit();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }

}
