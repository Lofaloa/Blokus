package blokus.view.fx;

import blokus.model.Game;
import blokus.model.Piece;
import blokus.model.Player;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Represents the view of a player data. This pane player score, his/ her score
 * and his/her stock are displaid.
 *
 * @author Logan Farci (47923)
 */
public class PlayerDataPane extends VBox {

    private final Game game;
    private final int ownerId;
    private final HBox header;
    private final GridPane pieces;

    /**
     * Initializes this pane with the given player.
     *
     * @param owner is the player this pane display data for.
     */
    public PlayerDataPane(Game blokus, int ownerId) {
        this.game = blokus;
        this.ownerId = ownerId;
        this.header = new HBox();
        this.pieces = new GridPane();
        setContent();
        setStyle();
    }

    /**
     * Sets the content of this stock header. The header contains the owner
     * number, her/ his score and his/ her status.
     */
    void setHeaderContent() {
        Text player = new Text("Joueur n°" + ownerId + 1);
        Text score = new Text("Score: " + game.getPlayerScore(ownerId));
        header.getChildren().addAll(player, score);
    }

    /**
     * Sets the pieces contained in the represented stock.
     */
    void setPieces(int nbOfPiecesPerRow) {
        int row = 0;
        int col = 0;
        int added = 0;
        for (Piece piece : game.getPlayerStock(ownerId)) {
            this.pieces.add(new PiecePane(game, piece), col, row);
            col++;
            added++;
            if (added % nbOfPiecesPerRow == 0) {
                col = 0;
                row++;
            }
        }
    }

    /**
     * Sets the content of this stock view. This stock contains a header and the
     * pieces.
     */
    final void setContent() {
        setHeaderContent();
        setPieces(8);
        this.getChildren().addAll(header, pieces);
    }

    /**
     * Sets the header style.
     */
    void setHeaderStyle() {
        String style = "-fx-spacing: 10;\n";
        header.setStyle(style);
    }

    /**
     * Sets the pieces pane style.
     */
    void setPiecesStyle() {
        pieces.setHgap(5);
        pieces.setVgap(5);
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
        setHeaderStyle();
        setPiecesStyle();
        this.setStyle(style);
    }

}
