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

    public void simulateBlokusFirstTurn(Game blokus) {
        blokus.selectCurrentPlayerPiece(15);
        blokus.placePiece(0, 0);
        blokus.nextPlayer();
        blokus.selectCurrentPlayerPiece(11);
        blokus.placePiece(16, 0);
        blokus.nextPlayer();
        blokus.selectCurrentPlayerPiece(10);
        blokus.placePiece(0, 19);
        blokus.nextPlayer();
        blokus.selectCurrentPlayerPiece(9);
        blokus.placePiece(18, 17);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Blokus");
            Game blokus = new Blokus();
            simulateBlokusFirstTurn(blokus);
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
