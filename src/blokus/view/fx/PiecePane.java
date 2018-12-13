package blokus.view.fx;

import blokus.model.BlokusColor;
import blokus.model.Piece;
import javafx.scene.effect.DropShadow;
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

    /**
     * Initializes this piece pane with the piece to represent.
     *
     * @param piece is the piece to represent.
     */
    public PiecePane(Piece piece) {
        this.piece = piece;
        setPiece();
        setShadowAction();
    }

    /**
     * Gets this pane piece.
     *
     * @return this pane piece.
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Gets the color of this pane piece.
     *
     * @return the color of this pane piece.
     */
    final Color toColor(BlokusColor color) {
        switch (color) {
            case BLUE:
                return Color.BLUE;
            case YELLOW:
                return Color.YELLOW;
            case RED:
                return Color.RED;
            default:
                return Color.GREEN;
        }
    }

    /**
     * Displays a square at row and column of the given color.
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
     * Displays the piece of this pane.
     */
    final void setPiece() {
        for (int i = 0; i < piece.getSize(); i++) {
            for (int j = 0; j < piece.getSize(); j++) {
                if (piece.contains(i, j)) {
                    setSquare(toColor(piece.getColor()), i, j, true);
                } else {
                    setSquare(Color.TRANSPARENT, i, j, false);
                }
            }
        }
    }

    void setShadowAction() {
        setOnMousePressed(event -> {
            DropShadow ds = new DropShadow();
            ds.setOffsetY(3.0);
            ds.setOffsetX(3.0);
            ds.setColor(Color.GRAY);
            this.setEffect(ds);
        });
    }

}
