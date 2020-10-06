package blokus.view.fx;

import blokus.model.Game;
import blokus.model.Player;
import java.util.List;
import java.util.stream.Collectors;
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
     * @param blokus is game to represent the players for.
     */
    public PlayersDataPane(Game blokus) {
        this.players = blokus.getPlayers();
        setContent();
        setStyle();
    }

    List<StockPane> getStockPanes() {
        return getChildren().stream()
                .map(child -> ((PlayerDataPane) child).getStockPane())
                .collect(Collectors.toList());
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
