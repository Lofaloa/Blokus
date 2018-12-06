package blokus.view.fx;

import blokus.model.Piece;
import blokus.model.Player;
import java.util.Objects;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * Represents the layout for a stock.
 *
 * @author Logan Farci (47923)
 */
public class StockPane extends GridPane {

    static final int NB_OF_PIECE_PER_ROW = 8;
    private final Player owner;
    private Piece selectedPiece;

    /**
     * Initializes this pane with the owner of the stock to represent.
     *
     * @param owner is the owner of the stock to represent.
     */
    public StockPane(Player owner) {
        this.owner = Objects.requireNonNull(owner, "No player when initializing "
                + "a stock pane.");
        this.selectedPiece = null;
        setPieces();
        setStyle();
        addSelectionHandler();
    }

    /**
     * Gets the selected piece.
     *
     * @return the selected piece.
     */
    Piece getSelectedPiece() {
        return selectedPiece;
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

    /**
     * Selects the piece selected by the current player.
     */
    void selectPiece() {
        for (Node child : getChildren()) {
            PiecePane current = (PiecePane) child;
            if (current.isSelected()) {
                selectedPiece = current.getPiece();
                current.deselect();
            }
        }
    }

    /**
     * Adds a selection handler to this stock pane. The selection handler
     * selects a piece in the stock based on the choice of the owner.
     */
    final void addSelectionHandler() {
        addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
            if (owner.isCurrentPlayer()) {
                selectPiece();
            } else {
                event.consume();
            }
        });
    }

}
