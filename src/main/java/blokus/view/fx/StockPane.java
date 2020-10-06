package blokus.view.fx;

import blokus.model.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javafx.scene.layout.GridPane;

/**
 * Represents the layout for a stock.
 *
 * @author Logan Farci (47923)
 */
public class StockPane extends GridPane {

    static final int NB_OF_PIECE_PER_ROW = 8;
    private final Player owner;
    private final List<PiecePane> piecePanes;

    /**
     * Initializes this pane with the owner of the stock to represent.
     *
     * @param owner is the owner of the stock to represent.
     */
    public StockPane(Player owner) {
        this.owner = Objects.requireNonNull(owner, "No player when initializing "
                + "a stock pane.");
        this.piecePanes = new ArrayList<>();
        setPieces();
        setContent();
        setStyle();
    }

    Player getOwner() {
        return owner;
    }

    public List<PiecePane> getPiecePanes() {
        return Collections.unmodifiableList(piecePanes);
    }

    final void setPieces() {
        owner.getStock().forEach((piece) -> {
            piecePanes.add(new PiecePane(piece));
        });
    }

    final void setContent() {
        int row = 0;
        int col = 0;
        int added = 0;
        for (PiecePane pane : piecePanes) {
            if (owner.owns(pane.getPiece())) {
                add(pane, col, row);
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
        setContent();
    }

    /**
     * Sets the pieces pane style.
     */
    final void setStyle() {
        setHgap(5);
        setVgap(5);
    }

}
