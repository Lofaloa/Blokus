package blokus.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a piece shape.
 *
 * @author g47923
 */
public enum Shape {

    SHAPE_1(new Position(0, 0)),

    SHAPE_2(new Position(0, 0), new Position(1, 0)),

    SHAPE_3(new Position(0, 0), new Position(1, 0), new Position(2, 0)),

    SHAPE_4(new Position(0, 0), new Position(1, 0), new Position(1, 1)),

    SHAPE_5(new Position(0, 0), new Position(1, 0), new Position(2, 0),
            new Position(3, 0)),

    SHAPE_6(new Position(2, 0), new Position(2, 1), new Position(1, 1),
            new Position(0, 1)),

    SHAPE_7(new Position(0, 0), new Position(1, 0), new Position(2, 0),
            new Position(1, 1)),

    SHAPE_8(new Position(0, 0), new Position(1, 0), new Position(1, 1),
            new Position(0, 1)),

    SHAPE_9(new Position(0, 0), new Position(0, 1), new Position(1, 1),
            new Position(1, 2)),

    SHAPE_10(new Position(0, 0), new Position(1, 0), new Position(2, 0),
            new Position(3, 0), new Position(4, 0)),

    SHAPE_11(new Position(3, 0), new Position(3, 1), new Position(2, 1),
            new Position(1, 1), new Position(0, 1)),

    SHAPE_12(new Position(0, 1), new Position(1, 1), new Position(2, 0),
            new Position(2, 1), new Position(3, 0)),

    SHAPE_13(new Position(0, 1), new Position(1, 0), new Position(1, 1),
            new Position(2, 0), new Position(2, 1)),

    SHAPE_14(new Position(0, 0), new Position(0, 1),
            new Position(1, 1), new Position(2, 0), new Position(2, 1)),

    SHAPE_15(new Position(0, 0), new Position(1, 0),
            new Position(1, 1), new Position(2, 0), new Position(3, 0)),

    SHAPE_16(new Position(0, 1), new Position(1, 1), new Position(2, 0),
            new Position(2, 1), new Position(2, 2)),

    SHAPE_17(new Position(0, 0), new Position(1, 0), new Position(2, 0),
            new Position(2, 1), new Position(2, 2)),

    SHAPE_18(new Position(0, 0), new Position(0, 1), new Position(1, 1),
            new Position(1, 2), new Position(2, 2)),

    SHAPE_19(new Position(0, 0), new Position(1, 0), new Position(1, 1),
            new Position(1, 2), new Position(2, 2)),

    SHAPE_20(new Position(0, 0), new Position(1, 0), new Position(1, 1),
            new Position(1, 2), new Position(2, 1)),

    SHAPE_21(new Position(0, 1), new Position(1, 1), new Position(1, 0),
            new Position(1, 2), new Position(2, 1));

    private final List<Position> positions;

    /**
     * Initializes this shape with a set of positions.
     *
     * @param positions is the set of positions of this shape.
     */
    Shape(Position... positions) {
        this.positions = new ArrayList<>(Arrays.asList(positions));
    }

    public List<Position> getPositions() {
        return positions;
    }

    /**
     * Gets the size of this shape.
     *
     * @return the size of this shape.
     */
    public int getSize() {
        return positions.size();
    }

}
