package blokus.model;

import blokus.exception.ModelException;
import java.util.Collections;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the integrity of <i>Blokus</i>.
 *
 * @author g47923
 */
public class BlokusTest {

    /**
     * Game after initialization should have an empty board and four players of
     * different colors.
     */
    @Test
    public void initialization() {
        Game g = new Blokus();
        g.getPlayers().forEach((player) -> {
            assertEquals(1, Collections.frequency(g.getPlayers(), player));
        });
        assertTrue(g.getBoard().isEmpty());
    }

    @Test
    public void blokusShouldBeOverWhenAllPlayersHaveAnEmptyStock() {
        Blokus g = new Blokus();
        for (Player player : g.getPlayers()) {
            player.clearStock();
        }
        assertTrue(g.isOver());
    }

    @Test
    public void blokusShouldNotBeOverWhenOneOfThePlayerHasNotAnEmptyStock() {
        Blokus g = new Blokus();
        for (int i = 0; i < 3; i++) {
            g.getPlayers().get(i).clearStock();
        }
        assertFalse(g.isOver());
    }

}
