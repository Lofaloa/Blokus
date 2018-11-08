package blokus.view.fx;

import blokus.model.Game;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * Represents a layout for the header of the player data box.
 * 
 * @author Logan Farci (47923)
 */
public class HeaderBox extends HBox {

    private final int playerId;
    private final Game blokus;
    private final Text player;
    private final Text score;

    /**
     * Initializes this box with given game and player id.
     * 
     * @param blokus is the game.
     * @param playerId is the player to display data for.
     */
    public HeaderBox(Game blokus, int playerId) {
        this.playerId = playerId;
        this.blokus = blokus;
        player = new Text("Joueur n°" + (playerId + 1));
        score = new Text("Score: " + blokus.getPlayerScore(playerId));
        setContent();
        setStyle();
    }

    /**
     * Updates the displaid score to the current score of the player.
     */
    void updateScore() {
        score.setText("Score: " + blokus.getPlayerScore(playerId));
    }

    /**
     * Sets the content of this header.
     */
    final void setContent() {
        getChildren().addAll(player, score);
    }

    /**
     * Sets the style of this header.
     */
    final void setStyle() {
        setSpacing(10);
    }

}
