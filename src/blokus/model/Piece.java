package blokus.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a piece.
 * 
 * @author g47923
 */
public class Piece {
    
    Shape shape;
    Color color;

    /**
     * Initializes this piece with a given shape and color;
     */
    public Piece(Shape shape, Color color) {
        this.color = color;
        this.shape = new Shape(shape);
    }
    
}
