package blokus.view.fx;

import blokus.model.Piece;
import blokus.model.Player;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Represents the view of a player stock.
 *
 * @author Logan Farci (47923)
 */
public class PlayerDataPane extends VBox {

    private final Player owner;
    private final HBox header;
    private final GridPane pieces;

    public PlayerDataPane(Player owner) {
        this.owner = owner;
        this.header = new HBox();
        this.pieces = new GridPane();
        setContent();
        setStyle();
    }

    /**
     * Gets the number of the owner.
     *
     * @return the number of the owner.
     */
    int getOwnerNumber() {
        switch (owner.getColor()) {
            case BLUE:
                return 1;
            case YELLOW:
                return 2;
            case RED:
                return 3;
            case GREEN:
                return 4;
        }
        return -1;
    }

    /**
     * Sets the content of this stock header. The header contains the owner
     * number, her/ his score and his/ her status.
     */
    void setHeaderContent() {
        Text player = new Text("Joueur n°" + getOwnerNumber());
        Text score = new Text("Score: " + owner.getScore());
        header.getChildren().addAll(player, score);
    }

    /**
     * Sets the pieces contained in the represented stock.
     */
    void setPieces(int nbOfPiecesPerRow) {
        int row = 0;
        int col = 0;
        int added = 0;
        for (Piece piece : owner.getStock().getPieces()) {
            this.pieces.add(new PiecePane(piece), col, row);
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
