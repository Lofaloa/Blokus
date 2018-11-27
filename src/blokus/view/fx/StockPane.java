package blokus.view.fx;

import blokus.model.Piece;
import blokus.model.Player;
import javafx.scene.layout.GridPane;

/**
 * Represents the layout for a stock.
 *
 * @author Logan Farci (47923)
 */
public class StockPane extends GridPane {

    static final int NB_OF_PIECE_PER_ROW = 8;
    private final Player owner;

    /**
     * Initializes this pane with the game to represent and the id of the stock
     * owner.
     *
     * @param blokus is the game of the stock to represent.
     * @param owner is the owner of the stock to represent.
     */
    public StockPane(Player owner) {
        this.owner = owner;
        setPieces();
        setStyle();
    }

    final void setPieces() {
        int row = 0;
        int col = 0;
        int added = 0;
        for (Piece piece : owner.getStock()) {
            if (owner.owns(piece)) {
                add(new PiecePane(piece), col, row);
            }
            col++;
            added++;
            if (added % NB_OF_PIECE_PER_ROW == 0) {
                col = 0;
                row++;
            }
        }
    }

    /**
     * Updates this stock display.
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
