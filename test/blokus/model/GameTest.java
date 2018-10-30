package blokus.model;

import java.util.Collections;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests tha game.
 * 
 * @author g47923
 */
public class GameTest {
    
    @Test
    public void initializedGameShouldHaveFourPlayersAndAnEmptyBoard() {
        Game g = new Game();
        assertTrue(g.getPlayers().size() == 4);
    }
    
    
    
}
