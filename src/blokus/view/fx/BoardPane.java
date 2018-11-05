package blokus.view.fx;

import blokus.model.Game;
import blokus.model.Piece;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * Represents the pane containing the board of the game.
 *
 * @author Logan Farci (47923)
 */
public class BoardPane extends GridPane {

    private final Game blokus;

    /**
     * Initializes this board pane with the given game.
     *
     * @param blokus is the game for which represent the board.
     */
    public BoardPane(Game blokus) {
        this.blokus = blokus;
        setBoard();
        setProperties();
    }

    Color toColor(Piece piece) {
        switch (piece.getColor()) {
            case BLUE:
                return Color.BLUE;
            case YELLOW:
                return Color.YELLOW;
            case RED:
                return Color.RED;
            case GREEN:
                return Color.GREEN;
            default:
                return Color.GREY;
        }
    }

    /**
     * Displays the current state of the game board.
     */
    final void setBoard() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (blokus.getBoard()[i][j] == null) {
                    Rectangle r = new Rectangle(25, 25);
                    r.setFill(Color.GREY);
                    this.add(r, j, i);
                } else {
                    Piece p = blokus.getBoard()[i][j];
                    Rectangle r = new Rectangle(25, 25);
                    r.setFill(toColor(p));
                    this.add(r, j, i);
                }

            }
        }
    }

    /**
     * Set the properties of this pane content.
     */
    void setProperties() {
        this.setGridLinesVisible(true);
    }

}
