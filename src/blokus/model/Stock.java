package blokus.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a stock of 21 pieces. 
 * 
 * @author g47923
 */
public class Stock {
    
    private Color color;
    private final List<Piece> pieces;

    public Stock(Color color) {
        this.pieces = new ArrayList<>();
    }
    
}
