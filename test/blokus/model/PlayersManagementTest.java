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
        g.getBoard().addAt(0, 0, new Piece(Shape.SHAPE_01, BlokusColor.BLUE));
        //Players are free to place a piece wherever they like on the board
        g.endFirstRound();
        g.selectCurrentPlayerPiece(Shape.SHAPE_02);
        g.placePiece(1, 1);
        assertEquals(-87, g.getWinner().get(0).getScore());
    }

    /**
     * A player with an empty stock is the winner if he/ she is the only one to
     * have placed all his/ her pieces.
     */
    @Test
    public void getWinner_case_2() {
        Blokus g = new Blokus();
        //Players are free to place a piece wherever they like on the board
        g.endFirstRound();
        g.getCurrentPlayer().clearStock();
        Player winner = g.getCurrentPlayer();
        assertTrue(g.getWinner().contains(winner));
    }

    /**
     * Two players that have the same highest score are the winners of the game.
     */
    @Test
    public void getWinner_case_3() {
        Blokus g = new Blokus();
        g.getBoard().addAt(0, 0, new Piece(Shape.SHAPE_01, BlokusColor.BLUE));
        g.getBoard().addAt(19, 0, new Piece(Shape.SHAPE_01, BlokusColor.YELLOW));
        Player w1 = g.getCurrentPlayer();
        //Players are free to place a piece wherever they like on the board
        g.endFirstRound();
        g.selectCurrentPlayerPiece(Shape.SHAPE_02);
        g.placePiece(1, 1);
        g.nextPlayer();
        Player w2 = g.getCurrentPlayer();
        g.selectCurrentPlayerPiece(Shape.SHAPE_02);
        g.placePiece(17, 1);
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
    public void nextPlayer_case_1() {
        Blokus g = new Blokus();
        assertEquals(BlokusColor.BLUE, g.getCurrentPlayer().getColor());
    }

    /**
     * The yellow player follows the blue player.
     */
    @Test
    public void nextPlayer_case_2() {
        Blokus g = new Blokus();
        g.nextPlayer();
        assertEquals(BlokusColor.YELLOW, g.getCurrentPlayer().getColor());
    }

    /**
     * The red player follows the yellow player.
     */
    @Test
    public void nextPlayer_case_3() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(BlokusColor.RED, g.getCurrentPlayer().getColor());
    }

    /**
     * The green player follows the red player.
     */
    @Test
    public void nextPlayer_case_4() {
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
    public void nextPlayer_case_5() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(BlokusColor.BLUE, g.getCurrentPlayer().getColor());
    }

    /**
     * When blue player withdraws at first round, she/ he should not be included
     * in the game anymore.
     */
    @Test
    public void nextPlayer_case_6() {
        Blokus g = new Blokus();
        g.getCurrentPlayer().withdraw();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(BlokusColor.YELLOW, g.getCurrentPlayer().getColor());
    }

    /**
     * When yellow player withdraws at first round, she/ he should not be
     * included in the game anymore.
     */
    @Test
    public void nextPlayer_case_7() {
        Blokus g = new Blokus();
        //Passes to yellow
        g.nextPlayer();
        g.getCurrentPlayer().withdraw();
        //Passes to red
        g.nextPlayer();
        //Passes to green
        g.nextPlayer();
        //Passes to blue
        g.nextPlayer();
        //Passes to red, not to yellow
        g.nextPlayer();
        assertEquals(BlokusColor.RED, g.getCurrentPlayer().getColor());
    }

    /**
     * When red player withdraws at first round, she/ he should not be included
     * in the game anymore.
     */
    @Test
    public void nextPlayer_case_8() {
        Blokus g = new Blokus();
        //Passes to yellow
        g.nextPlayer();
        //Passes to red
        g.nextPlayer();
        g.getCurrentPlayer().withdraw();
        //Passes to green
        g.nextPlayer();
        //Passes to blue
        g.nextPlayer();
        //Passes to yellow
        g.nextPlayer();
        //Passes to green, not to red
        g.nextPlayer();
        assertEquals(BlokusColor.GREEN, g.getCurrentPlayer().getColor());
    }

    /**
     * When green player withdraws at first round, she/ he should not be
     * included in the game anymore.
     */
    @Test
    public void nextPlayer_case_9() {
        Blokus g = new Blokus();
        //Passes to yellow
        g.nextPlayer();
        //Passes to red
        g.nextPlayer();
        //Passes to green
        g.nextPlayer();
        g.getCurrentPlayer().withdraw();
        //Passes to blue
        g.nextPlayer();
        //Passes to yellow
        g.nextPlayer();
        //Passes to red
        g.nextPlayer();
        //Passes to blue, not to green
        g.nextPlayer();
        assertEquals(BlokusColor.BLUE, g.getCurrentPlayer().getColor());
    }

    /**
     * When two players are withdrawn, there should be only 2 playing players
     * left.
     */
    @Test
    public void nextPlayer_case_10() {
        Blokus g = new Blokus();
        //Blue is withdrawn.
        g.getCurrentPlayer().withdraw();
        //Passes to yellow
        g.nextPlayer();
        //Passes to red
        g.nextPlayer();
        //Passes to green
        g.nextPlayer();
        //Passes to blue
        g.nextPlayer();
        //Passes to yellow
        g.nextPlayer();
        //Passes to red
        g.nextPlayer();
        //Passes to blue, not to green
        g.nextPlayer();
        assertEquals(BlokusColor.BLUE, g.getCurrentPlayer().getColor());
    }

}
