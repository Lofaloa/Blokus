package blokus.view.fx;

import blokus.model.Player;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

/**
 * Represents a view of the players data. The data displayed are the player
 * number, his/ her score and his/ her stock.
 *
 * @author Logan Farci (47923)
 */
public class PlayersDataPane extends VBox {

    private final List<Player> players;

    /**
     * Initializes this pane with the given game. The players data of this
     * display the given players data information of the given game.
     *
     * @param players are the players to represent.
     */
    public PlayersDataPane(List<Player> players) {
        this.players = players;
        setContent();
        setStyle();
    }

    /**
     * Updates this pane content.
     */
    void update() {
        getChildren().forEach((node) -> {
            ((PlayerDataPane) node).update();
        });
    }

    /**
     * Sets this pane content.
     */
    final void setContent() {
        players.forEach((player) -> {
            getChildren().add(new PlayerDataPane(player));
        });
    }

    final void setStyle() {
        String style = "-fx-spacing: 5;\n";
        this.setStyle(style);
    }

}
