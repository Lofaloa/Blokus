package blokus.model;

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

    @Test
    public void currentPlayerIsBluePlayerAfterInitialization() {
        Game g = new Game();
        assertEquals(Color.BLUE, g.getCurrentPlayer().getColor());
    }

    @Test
    public void yellowPlayerShouldFollowBluePlayer() {
        Game g = new Game();
        g.nextPlayer();
        assertEquals(Color.YELLOW, g.getCurrentPlayer().getColor());
    }

    @Test
    public void redPlayerShouldFollowYellowPlayer() {
        Game g = new Game();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(Color.RED, g.getCurrentPlayer().getColor());
    }

    @Test
    public void greenPlayerShouldFollowRedPlayer() {
        Game g = new Game();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(Color.GREEN, g.getCurrentPlayer().getColor());
    }

        @Test
    public void bluePlayerShouldFollowGreenPlayer() {
        Game g = new Game();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(Color.BLUE, g.getCurrentPlayer().getColor());
    }

}
