package blokus.model;

import java.util.List;
import java.util.Objects;

/**
 * Represents a piece.
 *
 * @author Logan Farci (47923)
 */
public class Piece {

    static final int MAX_SIZE = 5;
    private final Shape shape;
    private final BlokusColor color;

    /**
     * Initializes this piece with the given positions.
     *
     * @param shape is the shape of this piece.
     * @param color is the color of this piece.
     */
    public Piece(Shape shape, BlokusColor color) {
        Objects.requireNonNull(shape, "No initializing shape given for this piece");
        Objects.requireNonNull(color, "No initializing color given for this piece");
        this.shape = shape;
        this.color = color;
    }

    Piece(Piece other) {
        this(other.getShape(), other.getColor());
    }

    /**
     * Gets the size of this piece.
     *
     * @return the size of this piece.
     */
    public int getSize() {
        return shape.getNbOfSquares();
    }

    /**
     * Gets this shape color.
     *
     * @return this shape color.
     */
    public BlokusColor getColor() {
        return color;
    }

    /**
     * Gets this shape size.
     *
     * @return this shape size.
     */
    public Shape getShape() {
        return shape;
    }

    /**
     * Gets the squares of this piece.
     *
     * @return the squares of this piece.
     */
    List<Square> getSquares() {
        return shape.getSquares();
    }

    /**
     * Tells if this piece is the smallest of the game. The smallest being a
     * piece of one square.
     *
     * @return true if this piece is smallest piece of the game.
     */
    boolean isSmallestPiece() {
        return shape == Shape.SHAPE_01;
    }

    /**
     * Indicates if the given position is contained in this piece.
     *
     * @param row is the row of the square to look for.
     * @param column is the column of the square to look for.
     * @return true if the given position in contained on this piece.
     * @throws IllegalArgumentException if the given coordinates are negative or
     * greater than 5.
     */
    public boolean contains(int row, int column) {
        if (row < 0 || MAX_SIZE < row || column < 0 || MAX_SIZE < column) {
            throw new IllegalArgumentException("Position " + row + ", " + column
                    + " is not a valid position.");
        }
        return shape.contains(row, column);
    }

    /**
     * Rotates this piece by 90 degrees clockwise.
     */
    public void rotate() {
        shape.rotate();
    }

    /**
     * Turns this shape over.
     */
    public void turnOver() {
        shape.turnOver();
    }

    /**
     * Gets a hash code based on this piece color and shape.
     *
     * @return a hash code based on this piece color and shape.
     */
    @Override
    public int hashCode() {
        return Objects.hash(shape, color);
    }

    /**
     * Indicates whether some other object is "equal to" this piece.
     *
     * @param obj the reference object with which to compare.
     * @return true if this piece is the same as the obj argument; false
     * otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Piece other = (Piece) obj;
        if (this.shape != other.shape) {
            return false;
        }
        if (this.color != other.color) {
            return false;
        }
        return true;
    }

}
