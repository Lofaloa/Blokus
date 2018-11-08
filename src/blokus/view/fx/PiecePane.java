package blokus.view.fx;

import blokus.model.Blokus;
import blokus.model.Game;
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

    private final int SIZE;
    private final Piece piece;
    private final Game game;

    /**
     * Initializes this piece pane with the piece to represent.
     *
     * @param game is the game of the piece to represent.
     * @param piece is the piece to represent.
     */
    public PiecePane(Game game, Piece piece) {
        this.piece = piece;
        this.game = game;
        this.SIZE = game.getPieceSize(piece);
        setPiece();
    }

    /**
     * Gets the color of this pane piece.
     *
     * @return the color of this pane piece.
     */
    Color getColor() {
        switch (game.getPieceColor(piece)) {
            case "BLUE":
                return Color.BLUE;
            case "YELLOW":
                return Color.YELLOW;
            case "RED":
                return Color.RED;
            case "GREEN":
                return Color.GREEN;
            default:
                return Color.GREY;
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
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (game.isInsidePiece(piece, i, j)) {
                    setSquare(getColor(), i, j, true);
                } else {
                    setSquare(Color.TRANSPARENT, i, j, false);
                }
            }
        }
    }

}
