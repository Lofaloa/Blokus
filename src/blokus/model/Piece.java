package blokus.model;

import blokus.exception.ModelException;
import java.util.Objects;

/**
 * Represents a piece.
 *
 * @author Logan Farci (47923)
 */
public class Piece {

    private final Shape shape;
    private final Color color;

    /**
     * Initializes this piece with the given positions.
     *
     * @param shape is the shape of this piece.
     * @param color is the color of this piece.
     */
    Piece(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    /**
     * Gets this shape size.
     *
     * @return this shape size.
     */
    Shape getShape() {
        return shape;
    }

    /**
     * Gets this shape color.
     *
     * @return this shape color.
     */
    Color getColor() {
        return color;
    }

    /**
     * Indicates if the given position is contained in this piece.
     *
     * @param i is the vertical position.
     * @param j is the horizontal position.
     * @return true if the given position in contained on this piece.
     * @throws ModelException if the given row and column are not valid.
     */
    boolean contains(int i, int j) throws ModelException {
        return shape.getSquares().contains(new Square(i, j));
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
