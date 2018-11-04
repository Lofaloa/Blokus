package blokus;

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
            primaryStage.setTitle("Basal Metabolic Rate Calculator");
            
            
            
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
