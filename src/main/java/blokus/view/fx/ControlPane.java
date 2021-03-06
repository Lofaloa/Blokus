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
    private final Button turnOver;

    ControlPane() {
        this.restart = new Button("Nouvelle partie");
        this.pass = new Button("Passer");
        this.stop = new Button("Arrêter");
        this.rotate = new Button("Tourner");
        this.turnOver = new Button("Retourner");
        setContent();
        setStyle();
    }

    public Button getRotateButton() {
        return rotate;
    }

    public Button getMissTurnButton() {
        return pass;
    }

    public Button getWithdrawButton() {
        return stop;
    }

    public Button getRestartButton() {
        return restart;
    }

    public Button getTurnOverButton() {
        return turnOver;
    }

    /**
     * Sets the content of this pane.
     */
    final void setContent() {
        this.getChildren().addAll(restart, pass, stop, rotate, turnOver);
    }

    /**
     * Sets this pane style.
     */
    final void setStyle() {
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
    }

}
