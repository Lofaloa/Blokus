package blokus;

import blokus.controller.ControllerFX;
import blokus.model.Blokus;
import blokus.view.fx.MainBox;
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
            Blokus blokus = new Blokus();           
            MainBox main = new MainBox(blokus);
            blokus.addObserver(main);
            ControllerFX controller = new ControllerFX(blokus, main);
            controller.start();
            Scene scene = new Scene(main, 1000, 750);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
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
