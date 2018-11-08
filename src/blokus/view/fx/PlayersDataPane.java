package blokus.view.fx;

import blokus.model.Game;
import javafx.scene.layout.VBox;

/**
 * Represents a view of the players data. The data displayed are the player
 * number, his/ her score and his/ her stock.
 *
 * @author Logan Farci (47923)
 */
public class PlayersDataPane extends VBox {

    private final PlayerDataPane bluePlayerData;
    private final PlayerDataPane yellowPlayerData;
    private final PlayerDataPane redPlayerData;
    private final PlayerDataPane greenPlayerData;

    /**
     * Initializes this pane with the given game. The players data of this
     * display the given players data information of the given game.
     *
     * @param blokus is the game this pane will display player data for.
     */
    public PlayersDataPane(Game blokus) {
        this.bluePlayerData = new PlayerDataPane(blokus, 0);
        this.yellowPlayerData = new PlayerDataPane(blokus, 1);
        this.redPlayerData = new PlayerDataPane(blokus, 2);
        this.greenPlayerData = new PlayerDataPane(blokus, 3);
        setContent();
        setStyle();
    }

    /**
     * Updates this pane content.
     */
    void update() {
        bluePlayerData.update();
        yellowPlayerData.update();
        redPlayerData.update();
        greenPlayerData.update();
    }
    
    /**
     * Sets this pane content.
     */
    final void setContent() {
        this.getChildren().addAll(bluePlayerData, yellowPlayerData,
                redPlayerData, greenPlayerData);
    }

    final void setStyle() {
        String style = "-fx-spacing: 5;\n";
        this.setStyle(style);
    }

}
