package blokus.view.fx;

import blokus.model.Game;
import blokus.model.Player;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

/**
 * Represents a view of the players data. The data displayed are the player
 * number, his/ her score and his/ her stock.
 *
 * @author Logan Farci (47923)
 */
public class PlayersDataPane extends VBox {

    private final Game blokus;

    /**
     * Initializes this pane with the given game. The players data of this
     * display the given players data information of the given game.
     *
     * @param blokus is the game this pane will display player data for.
     */
    public PlayersDataPane(Game blokus) {
        this.blokus = blokus;
        setContent();
        setStyle();
    }

    /**
     * Updates this pane content.
     */
    void update() {
        for (Node node : getChildren()) {
            ((PlayerDataPane) node).update();
        }
    }

    /**
     * Sets this pane content.
     */
    final void setContent() {
        for (Player player : blokus.getPlayers()) {
            getChildren().add(new PlayerDataPane(player));
        }
    }

    final void setStyle() {
        String style = "-fx-spacing: 5;\n";
        this.setStyle(style);
    }

}
