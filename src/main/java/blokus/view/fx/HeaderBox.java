package blokus.view.fx;

import blokus.model.Player;
import blokus.model.PlayerState;
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
    private final Text state;
    private final Text score;
    private final Text nb_of_remaining_pieces;

    /**
     * Initializes this box with given game and player id.
     *
     * @param player is the player to display data for.
     */
    public HeaderBox(Player player) {
        this.player = player;
        playerNumber = new Text("Joueur n°" + toNumber(player));
        state = new Text(toString(player.getState()));
        score = new Text("Score: " + player.getScore());
        nb_of_remaining_pieces = new Text("Pièces restantes: " + player.getStock().size());
        setContent();
        setStyle();
    }

    final String toString(PlayerState state) {
        switch (state) {
            case PLAYING:
                return "En train de jouer...";
            case MISSING_TURN:
                return "Passe son tour...";
            case WAITING:
                return "Attend son tour...";
            default:
                return "A abandonné.";
        }
    }

    final int toNumber(Player player) {
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

    void update() {
        score.setText("Score: " + player.getScore());
        state.setText(toString(player.getState()));
        nb_of_remaining_pieces.setText("Pièces restantes: " + player.getStock().size());
    }

    /**
     * Sets the content of this header.
     */
    final void setContent() {
        getChildren().addAll(playerNumber, score, nb_of_remaining_pieces, state);
    }

    /**
     * Sets the style of this header.
     */
    final void setStyle() {
        setSpacing(10);
    }

}
