package blokus.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a piece.
 *
 * @author g47923
 */
public class Piece {

    List<Position> shape;

    /**
     * Initializes this piece with the given positions.
     *
     * @param positions are the positions of this piece.
     */
    public Piece(Position... positions) {
        if (positions.length < 1 || 7 < positions.length) {
            System.out.println("test");
            throw new IllegalArgumentException(positions.length + " positions"
                    + " but 1 to 7 positions are required.");
        }
        this.shape = new ArrayList<>(Arrays.asList(positions));
    }

    /**
     * Gets this shape size.
     *
     * @return this shape size.
     */
    public int getSize() {
        return shape.size();
    }

}
