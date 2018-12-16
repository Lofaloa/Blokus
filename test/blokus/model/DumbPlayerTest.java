package blokus.model;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Tests the behavior of a dumb player.
 *
 * @author Logan Farci (47923)
 */
public class DumbPlayerTest {

    /**
     * At first round, the dumb player should place a piece in a corner of the
     * board.
     */
    @Test
    public void makeFirstRoundMove_case_1() {
        Blokus blokus = new Blokus();
        Strategy s = new DumbPlayerStrategy(blokus);
        BlokusColor currentPlayerColor = blokus.getCurrentPlayer().getColor();
        s.execute();
        assertTrue(blokus.getBoard().getColorAt(0, 0) == currentPlayerColor
                || blokus.getBoard().getColorAt(19, 0) == currentPlayerColor
                || blokus.getBoard().getColorAt(19, 19) == currentPlayerColor
                || blokus.getBoard().getColorAt(0, 19) == currentPlayerColor);
    }

}
