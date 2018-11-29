package blokus.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Tests the management of the players in the game.
 *
 * @author Logan Farci (47923)
 */
public class PlayersManagementTest {

    /**
     * Winner should be the player with the highest score.
     */
    @Test
    public void getWinner_case_1() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(20);
        g.placePiece(0, 0);
        assertEquals(-84, g.getWinner().get(0).getScore());
    }

    /**
     * A player with an empty stock is the winner if he/ she is the only one to
     * have placed all his/ her pieces.
     */
    @Test
    public void getWinner_case_2() {
        Blokus g = new Blokus();
        Player winner = g.getCurrentPlayer();
        winner.clearStock();
        assertTrue(g.getWinner().contains(winner));
    }

    /**
     * Two players that have the same highest score are the winners of the game.
     */
    @Test
    public void getWinner_case_3() {
        Blokus g = new Blokus();
        Player w1 = g.getCurrentPlayer();
        g.selectCurrentPlayerPiece(3);
        g.placePiece(0, 0);
        g.nextPlayer();
        Player w2 = g.getCurrentPlayer();
        g.selectCurrentPlayerPiece(3);
        g.placePiece(5, 5);
        assertTrue(g.getWinner().contains(w1) && g.getWinner().contains(w2));
    }

    /**
     * If all the players cleared their stocks, thus all have the same score,
     * they all are winners.
     */
    @Test
    public void getWinner_case_4() {
        Blokus g = new Blokus();
        g.getPlayers().forEach(p -> p.clearStock());
        assertTrue(g.getPlayers().containsAll(g.getWinner()));
    }

    /**
     * The first player should be blue.
     */
    @Test
    public void getCurrentPlayer_case_1() {
        Blokus g = new Blokus();
        assertEquals(BlokusColor.BLUE, g.getCurrentPlayer().getColor());
    }

    /**
     * The yellow player follows the blue player.
     */
    @Test
    public void getCurrentPlayer_case_2() {
        Blokus g = new Blokus();
        g.nextPlayer();
        assertEquals(BlokusColor.YELLOW, g.getCurrentPlayer().getColor());
    }

    /**
     * The red player follows the yellow player.
     */
    @Test
    public void getCurrentPlayer_case_3() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(BlokusColor.RED, g.getCurrentPlayer().getColor());
    }

    /**
     * The green player follows the red player.
     */
    @Test
    public void getCurrentPlayer_case_4() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(BlokusColor.GREEN, g.getCurrentPlayer().getColor());
    }

    /**
     * The blue player follows the green player.
     */
    @Test
    public void getCurrentPlayer_case_5() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(BlokusColor.BLUE, g.getCurrentPlayer().getColor());
    }

}
