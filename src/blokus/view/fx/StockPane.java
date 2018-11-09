package blokus.view.fx;

import blokus.model.Game;
import blokus.model.Piece;
import javafx.scene.layout.GridPane;

/**
 * Represents the layout for a stock.
 *
 * @author Logan Farci (47923)
 */
public class StockPane extends GridPane {

    private final int PIECES_PER_ROW = 8;
    
    private final int ownerId;
    private final Game blokus;

    public StockPane(Game blokus, int ownerId) {
        this.ownerId = ownerId;
        this.blokus = blokus;
        setPieces();
        setStyle();
    }

    /**
     * Sets the pieces contained in the represented stock.
     */
    final void setPieces() {
        int row = 0;
        int col = 0;
        int added = 0;
        for (Piece piece : blokus.getPlayerStock(ownerId)) {
            add(new PiecePane(blokus, piece), col, row);
            col++;
            added++;
            if (added % PIECES_PER_ROW == 0) {
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
        setPieces();
    }

    /**
     * Sets the pieces pane style.
     */
    final void setStyle() {
        setHgap(5);
        setVgap(5);
    }

}
