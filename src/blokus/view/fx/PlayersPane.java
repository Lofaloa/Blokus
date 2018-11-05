package blokus.view.fx;

import blokus.model.Game;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 * Represents a view of the players. Contains a view of the stock, the number
 * and the score of each player.
 *
 * @author Logan Farci (47923)
 */
public class PlayersPane extends VBox {

    private final Game blokus;
    private final PlayerDataPane player1Stock;
    private final PlayerDataPane player2Stock;
    private final PlayerDataPane player3Stock;
    private final PlayerDataPane player4Stock;
    
    public PlayersPane(Game blokus) {
        this.blokus = blokus;
        this.player1Stock = new PlayerDataPane(blokus.getPlayers().get(0));
        this.player2Stock = new PlayerDataPane(blokus.getPlayers().get(1));
        this.player3Stock = new PlayerDataPane(blokus.getPlayers().get(2));
        this.player4Stock = new PlayerDataPane(blokus.getPlayers().get(3));
        this.getChildren().addAll(player1Stock, player2Stock, player3Stock, player4Stock);
    }
    
}
