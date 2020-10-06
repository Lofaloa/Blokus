package blokus.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a Color.
 *
 * @author Logan Farci (47923)
 */
public class ColorTest {

    /**
     * <code>values</code> method should get the four colors.
     */
    @Test
    public void values() {
        assertEquals(4, BlokusColor.values().length);
    }

    /**
     * <code>valueOf</code> should get the expected value.
     */
    @Test
    public void valueOf() {
        assertEquals(BlokusColor.BLUE, BlokusColor.valueOf("BLUE"));
    }

}
