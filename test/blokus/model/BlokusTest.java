package blokus.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the integrity of <i>Blokus</i>.
 *
 * @author g47923
 */
public class BlokusTest {

    /**
     * Game after construction should have an empty board and four players of
     * different colors.
     */
    @Test
    public void construction() {
        Blokus g = new Blokus();
        g.getPlayers().forEach((player) -> {
            assertEquals(1, Collections.frequency(g.getPlayers(), player));
        });
        assertTrue(g.getBoard().isEmpty() && g.getState() == BlokusState.FIRST_ROUND);
    }

    /**
     * Game after initialization should have an empty board and four players of
     * different colors.
     */
    @Test
    public void initialization() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(Shape.SHAPE_01);
        g.placePiece(0, 0);
        g.getCurrentPlayer().withdraw();
        g.initialize();
        g.getPlayers().forEach((player) -> {
            assertEquals(1, Collections.frequency(g.getPlayers(), player));
        });
        assertTrue(g.getBoard().isEmpty() && g.getState() == BlokusState.FIRST_ROUND);
    }

    /**
     * Setting a negative number of bot players should cause an exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void setBotPlayers_case_1() {
        Blokus g = new Blokus();
        g.setBotPlayers(-1);
    }

    /**
     * Setting a number of bot players greater than 4 should cause an exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void setBotPlayers_case_2() {
        Blokus g = new Blokus();
        g.setBotPlayers(5);
    }

    /**
     * Setting bots should set the expected number of bot player in the game.
     */
    @Test
    public void setBotPlayers_case_3() {
        Blokus g = new Blokus();
        g.setBotPlayers(3);
        int nb_of_bots = (int) g.getPlayers().stream().filter(p -> p.isBot()).count();
        assertEquals(3, nb_of_bots);
    }

    /**
     * Blokus should not be over if no players have withdrawn from the game and
     * no one have an empty stock.
     */
    @Test
    public void isOver_case_1() {
        Blokus g = new Blokus();
        g.endFirstRound();
        for (Player player : g.getPlayers()) {
            player.clearStock();
        }
        assertTrue(g.isOver());
    }

    /**
     * Blokus should be over when one of the player has placed all his/ her
     * pieces.
     */
    @Test
    public void isOver_case_2() {
        Blokus g = new Blokus();
        g.endFirstRound();
        g.getCurrentPlayer().clearStock();
        assertTrue(g.isOver());
    }

    /**
     * Blokus is over when all the players are withdrawn.
     */
    @Test
    public void isOver_case_3() {
        Blokus g = new Blokus();
        g.endFirstRound();
        for (Player player : g.getPlayers()) {
            player.withdraw();
        }
        assertTrue(g.isOver());
    }

    /**
     * Blokus should not be over when one of the players is not withdrawn.
     */
    @Test
    public void isOver_case_4() {
        Blokus g = new Blokus();
        g.endFirstRound();
        for (int i = 0; i < 3; i++) {
            g.getPlayers().get(i).withdraw();
        }
        assertFalse(g.isOver());
    }

    /**
     * The first round should be over when players all have plaid once.
     */
    @Test
    public void isFirstRoundOver_case_1() {
        Blokus g = new Blokus();
        List<Square> corners = new ArrayList<>();
        corners.addAll(Arrays.asList(new Square(0, 0),
                new Square(0, 19),
                new Square(19, 19),
                new Square(19, 0)));
        for (Square corner : corners) {
            g.selectCurrentPlayerPiece(Shape.SHAPE_01);
            g.placePiece(corner.getRow(), corner.getColumn());
            g.nextPlayer();
        }
        assertTrue(g.isFirstRoundOver());
    }

}
