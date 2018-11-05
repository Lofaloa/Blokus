package blokus;

import blokus.model.Blokus;
import blokus.model.Game;
import blokus.view.fx.MainWindow;
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
            
            
            MainWindow main = new MainWindow(blokus);
            
            Scene scene = new Scene(main, 1000, 750);
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
