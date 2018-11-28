package blokus.view.fx;

import blokus.model.Game;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * Represents the box containing the game display.
 *
 * @author Logan Farci (47923)
 */
public class GameBox extends HBox {

    private final PlayersDataPane playersData;
    private final BoardPane board;

    GameBox(Game blokus) {
        this.playersData = new PlayersDataPane(blokus.getPlayers());
        this.board = new BoardPane(blokus.getBoard());
        setContent();
        setStyle();
    }

    /**
     * Sets this game pane content.
     */
    final void setContent() {
        this.getChildren().addAll(playersData, board);
    }

    /**
     * Sets the style of this game pane.
     */
    final void setStyle() {
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Updates this pane content.
     */
    void updateContent() {
        playersData.update();
        board.update();
    }

}
