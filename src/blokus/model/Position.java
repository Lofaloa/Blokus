package blokus.model;

/**
 * Represents a position.
 *
 * @author g47923
 */
public class Position {

    private int x;
    private int y;

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

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

}
