package blokus.view.fx;

import blokus.model.Game;
import javafx.scene.layout.GridPane;

/**
 * Represents the layout for a stock.
 *
 * @author Logan Farci (47923)
 */
public class StockPane extends GridPane {

    private final int ownerId;
    private final Game blokus;

    /**
     * Initializes this pane with the game to represent and the id of the stock 
     * owner.
     * 
     * @param blokus is the game of the stock to represent.
     * @param ownerId is the id of the owner of the stock to represent.
     */
    public StockPane(Game blokus, int ownerId) {
        this.ownerId = ownerId;
        this.blokus = blokus;
        setPieces(8);
        setStyle();
    }

    /**
     * Sets the pieces contained in the represented stock.
     */
    final void setPieces(int nbOfPiecesPerRow) {
        int row = 0;
        int col = 0;
        int added = 0;
        for (int i = 0; i < 21; i++) {
            add(new PiecePane(blokus, i, blokus.getPlayerColor(ownerId)), col, row);
            col++;
            added++;
            if (added % nbOfPiecesPerRow == 0) {
                col = 0;
                row++;
            }
        }
    }
    
    /**
     * Updates this stock content.
     */
    void update() {
        getChildren().clear();
        setPieces(8);
    }

    /**
     * Sets the pieces pane style.
     */
    final void setStyle() {
        setHgap(5);
        setVgap(5);
    }

}
