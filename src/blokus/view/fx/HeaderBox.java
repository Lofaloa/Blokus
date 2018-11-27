package blokus.view.fx;

import blokus.model.Player;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * Represents a layout for the header of the player data box.
 *
 * @author Logan Farci (47923)
 */
public class HeaderBox extends HBox {

    private final Player player;
    private final Text playerNumber;
    private final Text score;

    /**
     * Initializes this box with given game and player id.
     *
     * @param player is the player to display data for.
     */
    public HeaderBox(Player player) {
        this.player = player;
        playerNumber = new Text("Joueur n°" + getPlayerNumber(player));
        score = new Text("Score: " + player.getScore());
        setContent();
        setStyle();
    }

    final int getPlayerNumber(Player player) {
        switch (player.getColor()) {
            case BLUE:
                return 1;
            case YELLOW:
                return 2;
            case RED:
                return 3;
            default:
                return 4;
        }
    }

    /**
     * Updates the displaid score to the current score of the player.
     */
    void updateScore() {
        score.setText("Score: " + player.getScore());
    }

    /**
     * Sets the content of this header.
     */
    final void setContent() {
        getChildren().addAll(playerNumber, score);
    }

    /**
     * Sets the style of this header.
     */
    final void setStyle() {
        setSpacing(10);
    }

}
