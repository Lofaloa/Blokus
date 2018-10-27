package blokus.model;

import java.util.List;

/**
 * Represents a piece.
 *
 * @author g47923
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
    public Piece(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    List<Position> getPositions() {
        return shape.getPositions();
    }

    /**
     * Gets this shape size.
     *
     * @return this shape size.
     */
    int getSize() {
        return shape.getSize();
    }

    /**
     * Gets this shape color.
     *
     * @return this shape color.
     */
    Color getColor() {
        return color;
    }

}
