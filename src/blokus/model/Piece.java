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

    private final List<Position> positions;

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
        this.positions = new ArrayList<>(Arrays.asList(positions));
    }

    List<Position> getPositions() {
        return new ArrayList<>(positions);
    }

    /**
     * Gets this shape size.
     *
     * @return this shape size.
     */
    int getSize() {
        return positions.size();
    }

}
