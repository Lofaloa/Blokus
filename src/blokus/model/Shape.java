package blokus.model;

import blokus.exception.ModelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a piece shape defined by an id. The list of id's can be found in
 * the game <a href="https://bit.ly/2ENXpH3">instructions</a> (see list of
 * parts).
 *
 * @author Logan Farci (47923)
 */
public enum Shape {

    /**
     * Represents the shape of piece 01.
     */
    SHAPE_01(new Square(0, 0)),
    /**
     * Represents the shape of piece 02.
     */
    SHAPE_02(new Square(0, 0), new Square(1, 0)),
    /**
     * Represents the shape of piece 03.
     */
    SHAPE_03(new Square(0, 0), new Square(1, 0), new Square(2, 0)),
    /**
     * Represents the shape of piece 04.
     */
    SHAPE_04(new Square(0, 0), new Square(1, 0), new Square(1, 1)),
    /**
     * Represents the shape of piece 05.
     */
    SHAPE_05(new Square(0, 0), new Square(1, 0), new Square(2, 0),
            new Square(3, 0)),
    /**
     * Represents the shape of piece 06.
     */
    SHAPE_06(new Square(2, 0), new Square(2, 1), new Square(1, 1),
            new Square(0, 1)),
    /**
     * Represents the shape of piece 07.
     */
    SHAPE_07(new Square(0, 0), new Square(1, 0), new Square(2, 0),
            new Square(1, 1)),
    /**
     * Represents the shape of piece 08.
     */
    SHAPE_08(new Square(0, 0), new Square(1, 0), new Square(1, 1),
            new Square(0, 1)),
    /**
     * Represents the shape of piece 09.
     */
    SHAPE_09(new Square(0, 0), new Square(0, 1), new Square(1, 1),
            new Square(1, 2)),
    /**
     * Represents the shape of piece 10.
     */
    SHAPE_10(new Square(0, 0), new Square(1, 0), new Square(2, 0),
            new Square(3, 0), new Square(4, 0)),
    /**
     * Represents the shape of piece 11.
     */
    SHAPE_11(new Square(3, 0), new Square(3, 1), new Square(2, 1),
            new Square(1, 1), new Square(0, 1)),
    /**
     * Represents the shape of piece 12.
     */
    SHAPE_12(new Square(0, 1), new Square(1, 1), new Square(2, 0),
            new Square(2, 1), new Square(3, 0)),
    /**
     * Represents the shape of piece 13.
     */
    SHAPE_13(new Square(0, 1), new Square(1, 0), new Square(1, 1),
            new Square(2, 0), new Square(2, 1)),
    /**
     * Represents the shape of piece 14.
     */
    SHAPE_14(new Square(0, 0), new Square(0, 1),
            new Square(1, 1), new Square(2, 0), new Square(2, 1)),
    /**
     * Represents the shape of piece 15.
     */
    SHAPE_15(new Square(0, 0), new Square(1, 0),
            new Square(1, 1), new Square(2, 0), new Square(3, 0)),
    /**
     * Represents the shape of piece 16.
     */
    SHAPE_16(new Square(0, 1), new Square(1, 1), new Square(2, 0),
            new Square(2, 1), new Square(2, 2)),
    /**
     * Represents the shape of piece 17.
     */
    SHAPE_17(new Square(0, 0), new Square(1, 0), new Square(2, 0),
            new Square(2, 1), new Square(2, 2)),
    /**
     * Represents the shape of piece 18.
     */
    SHAPE_18(new Square(0, 0), new Square(0, 1), new Square(1, 1),
            new Square(1, 2), new Square(2, 2)),
    /**
     * Represents the shape of piece 19.
     */
    SHAPE_19(new Square(0, 0), new Square(1, 0), new Square(1, 1),
            new Square(1, 2), new Square(2, 2)),
    /**
     * Represents the shape of piece 20.
     */
    SHAPE_20(new Square(0, 0), new Square(1, 0), new Square(1, 1),
            new Square(1, 2), new Square(2, 1)),
    /**
     * Represents the shape of piece 21.
     */
    SHAPE_21(new Square(0, 1), new Square(1, 1), new Square(1, 0),
            new Square(1, 2), new Square(2, 1));

    private final List<Square> squares;

    /**
     * Initializes this shape with a set of Squares.
     *
     * @param Squares is the set of Squares of this shape.
     */
    Shape(Square... Squares) {
        this.squares = new ArrayList<>(Arrays.asList(Squares));
    }

    /**
     * Gets the Squares of this shape.
     *
     * @return the Squares of this shape.
     */
    public List<Square> getSquares() {
        return squares;
    }

    /**
     * Gets the size of this shape.
     *
     * @return the size of this shape.
     */
    public int getSize() {
        return squares.size();
    }

}
