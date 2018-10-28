package blokus.model;

/**
 * Represents a position.
 *
 * @author g47923
 */
public class Position {

    private final int x;
    private final int y;

    /**
     * Initializes this position to the given coordinates.
     *
     * @param x is the x coordinate of this position.
     * @param y is the y coordinate of this position.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the x coordinate of this position.
     *
     * @return x coordinate of this position.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y coordinate of this position.
     *
     * @return y coordinate of this position.
     */
    public int getY() {
        return y;
    }

    /**
     * Makes a new position based on this position and the given offsets.
     *
     * @param offsetX is the offset to apply to this x position.
     * @param offsetY is the offset to apply to this y position.
     * @return a new position based on this position and the given offsets.
     */
    public Position move(int offsetX, int offsetY) {
        return new Position(x + offsetX, y + offsetY);
    }

}
