package blokus.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a piece shape defined by an id. The list of id's can be found in
 * the game <a href="https://bit.ly/2ENXpH3">instructions</a> (see list of
 * parts).
 *
 * @author g47923
 */
public enum Shape {

    /**
     * Represents the shape of piece 01.
     */
    SHAPE_01(new Position(0, 0)),
    /**
     * Represents the shape of piece 02.
     */
    SHAPE_02(new Position(0, 0), new Position(1, 0)),
    /**
     * Represents the shape of piece 03.
     */
    SHAPE_03(new Position(0, 0), new Position(1, 0), new Position(2, 0)),
    /**
     * Represents the shape of piece 04.
     */
    SHAPE_04(new Position(0, 0), new Position(1, 0), new Position(1, 1)),
    /**
     * Represents the shape of piece 05.
     */
    SHAPE_05(new Position(0, 0), new Position(1, 0), new Position(2, 0),
            new Position(3, 0)),
    /**
     * Represents the shape of piece 06.
     */
    SHAPE_06(new Position(2, 0), new Position(2, 1), new Position(1, 1),
            new Position(0, 1)),
    /**
     * Represents the shape of piece 07.
     */
    SHAPE_07(new Position(0, 0), new Position(1, 0), new Position(2, 0),
            new Position(1, 1)),
    /**
     * Represents the shape of piece 08.
     */
    SHAPE_08(new Position(0, 0), new Position(1, 0), new Position(1, 1),
            new Position(0, 1)),
    /**
     * Represents the shape of piece 09.
     */
    SHAPE_09(new Position(0, 0), new Position(0, 1), new Position(1, 1),
            new Position(1, 2)),
    /**
     * Represents the shape of piece 10.
     */
    SHAPE_10(new Position(0, 0), new Position(1, 0), new Position(2, 0),
            new Position(3, 0), new Position(4, 0)),
    /**
     * Represents the shape of piece 11.
     */
    SHAPE_11(new Position(3, 0), new Position(3, 1), new Position(2, 1),
            new Position(1, 1), new Position(0, 1)),
    /**
     * Represents the shape of piece 12.
     */
    SHAPE_12(new Position(0, 1), new Position(1, 1), new Position(2, 0),
            new Position(2, 1), new Position(3, 0)),
    /**
     * Represents the shape of piece 13.
     */
    SHAPE_13(new Position(0, 1), new Position(1, 0), new Position(1, 1),
            new Position(2, 0), new Position(2, 1)),
    /**
     * Represents the shape of piece 14.
     */
    SHAPE_14(new Position(0, 0), new Position(0, 1),
            new Position(1, 1), new Position(2, 0), new Position(2, 1)),
    /**
     * Represents the shape of piece 15.
     */
    SHAPE_15(new Position(0, 0), new Position(1, 0),
            new Position(1, 1), new Position(2, 0), new Position(3, 0)),
    /**
     * Represents the shape of piece 16.
     */
    SHAPE_16(new Position(0, 1), new Position(1, 1), new Position(2, 0),
            new Position(2, 1), new Position(2, 2)),
    /**
     * Represents the shape of piece 17.
     */
    SHAPE_17(new Position(0, 0), new Position(1, 0), new Position(2, 0),
            new Position(2, 1), new Position(2, 2)),
    /**
     * Represents the shape of piece 18.
     */
    SHAPE_18(new Position(0, 0), new Position(0, 1), new Position(1, 1),
            new Position(1, 2), new Position(2, 2)),
    /**
     * Represents the shape of piece 19.
     */
    SHAPE_19(new Position(0, 0), new Position(1, 0), new Position(1, 1),
            new Position(1, 2), new Position(2, 2)),
    /**
     * Represents the shape of piece 20.
     */
    SHAPE_20(new Position(0, 0), new Position(1, 0), new Position(1, 1),
            new Position(1, 2), new Position(2, 1)),
    /**
     * Represents the shape of piece 21.
     */
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

    /**
     * Gets the positions of this shape.
     *
     * @return the positions of this shape.
     */
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
