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
        Position pos = new Position(2, 3);
        assertTrue(pos.getX() == 2 && pos.getY() == 3);
    }

    @Test
    public void moveAPosition() {
        Position pos = new Position(2, 3);
        pos.move(2, 3);
        assertTrue(pos.getX() == 4 && pos.getY() == 6);
    }

}
