package blokus.view.fx;

import blokus.model.Piece;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Represents the view of a piece.
 *
 * @author Logan Farci (47923)
 */
public class PiecePane extends GridPane {

    private final Piece piece;

    public PiecePane(Piece piece) {
        this.piece = piece;
        draw();
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

    void draw() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (piece.contains(i, j)) {
                    Rectangle r = new Rectangle(7, 7);
                    r.setFill(toColor(piece));
                    this.add(r, j, i);
                } else {
                    Rectangle r = new Rectangle(7, 7);
                    r.setFill(Color.WHITE);
                    this.add(r, j, i);
                }
            }
        }
    }

}
