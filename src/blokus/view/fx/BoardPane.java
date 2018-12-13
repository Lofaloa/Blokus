package blokus.view.fx;

import blokus.model.BlokusColor;
import blokus.model.Board;
import blokus.model.Piece;
import blokus.model.Square;
import java.util.ArrayList;
import java.util.List;
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

    private final Board board;
    private final List<Rectangle> squares;

    /**
     * Initializes this board pane with the given game.
     *
     * @param board is the board to represent.
     */
    public BoardPane(Board board) {
        this.board = board;
        this.squares = new ArrayList<>();
        setBoard();
        setStyle();
    }

    List<Rectangle> getSquares() {
        return squares;
    }

    void previewPiece(Piece piece, Square dest) {
        for (Square square : piece.getShape().getSquares()) {
            Square current = new Square(square.getRow() + dest.getRow(),
                    square.getColumn() + dest.getColumn());
            getSquare(current.getRow(), current.getColumn()).setFill(Color.WHITE);
        }
    }

    /**
     * Converts the given <i>Blokus</i> color to a color.
     *
     * @param color is the name of the color.
     * @return a color corresponding to the given color name.
     */
    Color toColor(BlokusColor color) {
        if (color == null) {
            return Color.GRAY;
        }
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
     * Sets an empty square in the board at the given position. An empty square
     * is grey.
     *
     * @param row is the row of the square to set.
     * @param column is the column of the square to set.
     */
    void setEmptySquare(int row, int column) {
        Rectangle r = new Rectangle(30, 30);
        r.setFill(Color.GREY);
        squares.add(r);
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
        squares.add(r);
        this.add(r, column, row);
    }

    /**
     * Sets a square in the board at the given position.
     *
     * @param color is the color of the square to set.
     * @param row is the row of the square to set.
     * @param column is the column of the square to set.
     */
    void setSquare(BlokusColor color, int row, int column) {
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
        for (int row = 0; row < Board.SIZE; row++) {
            for (int column = 0; column < Board.SIZE; column++) {
                setSquare(board.getColorAt(row, column), row, column);
            }
        }
    }

    /**
     * Gets the square located at the given position in this board pane.
     *
     * @param row is the row of the square to get.
     * @param column is the column of the square to get.
     * @return the square located at the given position.
     */
    Rectangle getSquare(int row, int column) {
        for (Node children : getChildren()) {
            if (GridPane.getRowIndex(children) == row
                    && GridPane.getColumnIndex(children) == column) {
                return (Rectangle) children;
            }
        }
        return null;
    }

    /**
     * Updates this board pane.
     */
    void update() {
        for (int row = 0; row < Board.SIZE; row++) {
            for (int column = 0; column < Board.SIZE; column++) {
                Color color = toColor(board.getColorAt(row, column));
                getSquare(row, column).setFill(color);
            }
        }
    }

    /**
     * Set the properties of this pane content.
     */
    final void setStyle() {
        this.setGridLinesVisible(true);
    }

}
