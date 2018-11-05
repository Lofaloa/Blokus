package blokus.view.fx;

import blokus.model.Piece;
import blokus.model.Player;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
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
        setProperties();
    }
    
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
        Text player = new Text("Joueur: " + getOwnerNumber());
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
    void setContent() {
        setHeaderContent();
        setPieces(7);
        this.getChildren().addAll(header, pieces);
    }
    
    /**
     * Sets the properties of this player data pane.
     */
    void setProperties() {
        header.setSpacing(10);
        pieces.setGridLinesVisible(true);
        this.setSpacing(10);
        this.setStyle("-fx-padding: 10;");
    }
    
}
