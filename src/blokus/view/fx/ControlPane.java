package blokus.view.fx;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author Logan Farci (47923)
 */
public class ControlPane extends HBox {
    
    private final Button restart;
    private final Button pass;
    private final Button stop;
    private final Button rotate;
    
    ControlPane() {
        this.restart = new Button("Nouvelle partie");
        this.pass = new Button("Passer");
        this.stop = new Button("Arrêter");
        this.rotate = new Button("Tourner");
        this.getChildren().addAll(restart, pass, stop, rotate);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
    }
    
}
