package blokus.view.fx;

import blokus.model.Game;
import javafx.scene.Node;
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

    /**
     * Converts the given name color to a color.
     *
     * @param color is the name of the color.
     * @return a color carresponding to the given color name.
     */
    Color toColor(String color) {
        if (color == null) {
            return Color.GREY;
        } else {
            switch (color) {
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
    }

    /**
     * Sets an empty square in the board at the given position. An empty square
     * is grey.
     *
     * @param row is the row of the square to set.
     * @param column is the column of the square to set.
     */
    void setEmptySquare(int row, int column) {
        Rectangle r = new Rectangle(30, 30);
        r.setFill(Color.GREY);
        this.add(r, column, row);
    }

    /**
     * Sets a filled square in the board at the given position.
     *
     * @param color is the color of the filled square to set.
     * @param row is the row of the filled square to set.
     * @param column is the column of the filled square to set.
     */
    void setFilledSquare(Color squareColor, int row, int column) {
        Rectangle r = new Rectangle(30, 30);
        r.setFill(squareColor);
        this.add(r, column, row);
    }

    /**
     * Sets a square in the board at the given position.
     *
     * @param color is the color of the square to set.
     * @param row is the row of the square to set.
     * @param column is the column of the square to set.
     */
    void setSquare(String color, int row, int column) {
        if (color == null) {
            setEmptySquare(row, column);
        } else {
            setFilledSquare(toColor(color), row, column);
        }
    }

    /**
     * Displays the current state of the game board.
     */
    final void setBoard() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                setSquare(blokus.getBoardColorAt(i, j), i, j);
            }
        }
    }

    Rectangle getSquare(int row, int column) {
        for (Node children : getChildren()) {
            if (GridPane.getRowIndex(children) == row
                    && GridPane.getColumnIndex(children) == column) {
                return (Rectangle) children;
            }
        }
        return null;
    }

    void update() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Color color = toColor(blokus.getBoardColorAt(i, j));
                getSquare(i, j).setFill(color);
            }
        }
    }

    /**
     * Set the properties of this pane content.
     */
    final void setProperties() {
        this.setGridLinesVisible(true);
    }

}
