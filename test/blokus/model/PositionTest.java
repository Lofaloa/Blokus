package blokus.model;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests a position.
 *
 * @author g47923
 */
public class PositionTest {

    @Test
    public void initAPosition() {
        Square pos = new Square(2, 3);
        assertTrue(pos.getRow() == 2 && pos.getColumn() == 3);
    }

    @Test
    public void moveAPosition() {
        Square pos = new Square(2, 3);
        Square movedPos = pos.move(2, 3);
        assertTrue(movedPos.getRow() == 4 && movedPos.getColumn() == 6);
    }

}
