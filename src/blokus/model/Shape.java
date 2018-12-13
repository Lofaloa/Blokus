package blokus.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    static final int MAX_SIZE = 5;
    private final List<Square> squares;

    /**
     * Initializes this shape with a set of Squares.
     *
     * @param squares is the set of Squares of this shape.
     */
    Shape(Square... squares) {
        this.squares = new ArrayList<>(Arrays.asList(squares));
    }

    /**
     * Gets the Squares of this shape.
     *
     * @return the Squares of this shape.
     */
    public List<Square> getSquares() {
        return Collections.unmodifiableList(squares);
    }

    /**
     * Gets the number of squares of this shape.
     *
     * @return the number of square of this shape.
     */
    int getNbOfSquares() {
        return squares.size();
    }

    /**
     * Gets the size of this shape. The size of this shape represents the size
     * of the array necessary to store this shape. For instance, shape n7 has a
     * size of 3 because it would fit in a 3 by 3 array.
     *
     * @return the size of this shape.
     */
    int getSize() {
        int maxRow = squares.stream()
                .mapToInt(s -> s.getRow())
                .max().getAsInt();
        int maxColumn = squares.stream()
                .mapToInt(s -> s.getColumn())
                .max().getAsInt();
        return Integer.max(maxRow + 1, maxColumn + 1);
    }

    /**
     * Tells if the given square is in this shape.
     *
     * @param row is the row of the square.
     * @param column is the column of the square.
     * @return true if the square is in the shape.
     * @throws IllegalArgumentException if the given coordinates are negative or
     * greater than 5.
     */
    boolean contains(int row, int column) {
        if ((row < 0 || MAX_SIZE < row) || (column < 0 || MAX_SIZE < column)) {
            throw new IllegalArgumentException("Position " + row + ", " + column
                    + " is not a valid position.");
        }
        return squares.stream().anyMatch(s -> s.getRow() == row
                && s.getColumn() == column);
    }

    /**
     * Rotates this shape 90 degrees clockwise.
     */
    void rotate() {
        for (int i = 0; i < getNbOfSquares(); i++) {
            Square current = squares.get(i);
            squares.set(i, new Square(current.getColumn(),
                    getSize() - current.getRow() - 1));
        }
    }

    /**
     * Turns this shape over.
     */
    void turnOver() {
        for (int i = 0; i < getNbOfSquares(); i++) {
            Square current = squares.get(i);
            squares.set(i, new Square(current.getRow(),
                    getSize() - current.getColumn() - 1));
        }
    }

}