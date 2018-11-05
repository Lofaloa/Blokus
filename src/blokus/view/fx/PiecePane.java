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

//    private final int PANE_SIZE = 5;
    private final int size;
    private final Piece piece;

    /**
     * Initializes this piece pane with the piece to represent.
     *
     * @param piece is the piece to represent.
     */
    public PiecePane(Piece piece) {
        this.piece = piece;
        this.size = piece.getShape().getSize();
        setPiece();
    }

    /**
     * Converts the given piece to a color. A piece can be blue, yellow, red or
     * green.
     *
     * @param piece the piece to convert.
     * @return the color corresponding to the given piece.
     */
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
     * Draws a square at row and column of the given color.
     *
     * @param color is the color of the square.
     * @param row is the row of the square.
     * @param column is the column of the square.
     * @param hasStroke if set to true the square will have a black stroke.
     */
    void setSquare(Color color, int row, int column, boolean hasStroke) {
        Rectangle r = new Rectangle(7, 7);
        r.setFill(color);
        if (hasStroke) {
            r.setStroke(Color.BLACK);
        }
        this.add(r, column, row);
    }

    /**
     * Draws the piece of this pane.
     */
    void setPiece() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (piece.contains(i, j)) {
                    setSquare(toColor(piece), i, j, true);
                } else {
                    setSquare(Color.TRANSPARENT, i, j, false);
                }
            }
        }
    }

}
