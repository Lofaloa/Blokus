package blokus.view.fx;

import blokus.model.Game;
import blokus.model.Piece;
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

    private final Game blokus;
    private final List<Player> players;

    /**
     * Initializes this pane with the given game. The players data of this
     * display the given players data information of the given game.
     *
     * @param blokus is game to represent the players for.
     */
    public PlayersDataPane(Game blokus) {
        this.blokus = blokus;
        this.players = blokus.getPlayers();
        setContent();
        setStyle();
    }

    Piece getCurrentPlayerPiece() {
        for (Node child : getChildren()) {
            Player player = ((PlayerDataPane) child).getPlayer();
            if (player.equals(blokus.getCurrentPlayer())) {
                return ((PlayerDataPane) child).getSelectedPiece();
            }
        }
        return null;
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
