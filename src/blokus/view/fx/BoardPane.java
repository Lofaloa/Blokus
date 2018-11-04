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

    public BoardPane(Game blokus) {
        this.blokus = blokus;
        this.setHgap(1);
        this.setVgap(1);
        printBoard();
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
    final void printBoard() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (blokus.getBoard()[i][j] == null) {
                    Rectangle r = new Rectangle(15, 15);
                    r.setFill(Color.GREY);
                    this.add(r, j, i);
                } else {
                    Piece p = blokus.getBoard()[i][j];
                    Rectangle r = new Rectangle(15, 15);
                    r.setFill(toColor(p));
                    this.add(r, j, i);
                }

            }
        }
    }

}
