package blokus.view.fx;

import blokus.model.Game;
import javafx.scene.layout.VBox;

/**
 * Represents the view of a player data. This pane player score, his/ her score
 * and his/her stock are displaid.
 *
 * @author Logan Farci (47923)
 */
public class PlayerDataPane extends VBox {

    private final HeaderBox header;
    private final StockPane stock;

    /**+
     * Initializes this pane with the given player.
     *
     * @param blokus is the game.
     * @param playerId is the player id  of the player this pane display data for.
     */
    public PlayerDataPane(Game blokus, int playerId) {
        this.header = new HeaderBox(blokus, playerId);
        this.stock = new StockPane(blokus, playerId);
        setContent();
        setStyle();
    }

    /**
     * Sets the content of this stock view. This stock contains a header and the
     * pieces.
     */
    final void setContent() {
        this.getChildren().addAll(header, stock);
    }
    
    /**
     * Updates this player data pane.
     */
    void update() {
        header.updateScore();
        stock.update();
    }

    /**
     * Sets the style of this player data pane.
     */
    final void setStyle() {
        String style = "-fx-spacing: 5;\n"
                + "-fx-padding: 0 5 0 5;\n"
                + "-fx-border-color: black;\n"
                + "-fx-border-width: 1;\n"
                + "-fx-border-style: solid;\n";
        this.setStyle(style);
    }

}
