package blokus.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a piece shape
 * 
 * @author g47923
 */
public class Shape {
    
    private List<Position> positions;
    
    public Shape() {
        this.positions = new ArrayList<>();
    }
    
    public Shape(Shape shape) {
    
    }
    
}
