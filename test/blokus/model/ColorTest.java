package blokus.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests a Color.
 * 
 * @author Logan Farci (47923)
 */
public class ColorTest {
    
    @Test
    public void valuesShouldGetTheFourColors() {
        assertEquals(4, BlokusColor.values().length);
    }
    
    @Test
    public void valueOfShouldGetTheExpectedColor() {
        assertEquals(BlokusColor.BLUE, BlokusColor.valueOf("BLUE"));
    }
    
}
