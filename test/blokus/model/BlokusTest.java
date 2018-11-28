package blokus.model;

import blokus.exception.ModelException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the game.
 *
 * @author g47923
 */
public class BlokusTest {

    @Test
    public void initializedGameShouldHaveFourPlayersAndAnEmptyBoard() {
        Blokus g = new Blokus();
        assertTrue(g.getPlayers().size() == 4);
    }

    @Test
    public void gameShouldGetTheExpectedColorInBoardAtGivenPosition() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(3);
        g.placePiece(0, 0);
        assertEquals(BlokusColor.BLUE, g.getBoard().getColorAt(0, 0));
    }

    @Test
    public void winnerShouldBeThePlayerWithTheHighestScore() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(20);
        g.placePiece(0, 0);
        assertEquals(-84, g.getWinner().get(0).getScore());
    }

    @Test
    public void secondPlayerShouldBeWinnerWithEmptyStock() {
        Blokus g = new Blokus();
        Player winner = g.getCurrentPlayer();
        winner.clearStock();
        assertEquals(winner, g.getWinner().get(0));
    }

    @Test
    public void playersWithSameHighestScoreShouldBeBothWinners() {
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

    @Test(expected = ModelException.class)
    public void tooSmallPieceIdShouldCauseExceptionWhenSelectingPiece() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(-1);
    }

    @Test(expected = ModelException.class)
    public void tooBigPieceIdShouldCauseExceptionWhenSelectingPiece() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(22);
    }

    @Test
    public void currentPlayerPieceShouldBeTheOneSelected() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(1);
        assertEquals(Shape.SHAPE_02, g.getCurrentPlayerPiece().getShape());
    }

    @Test
    public void currentPlayerIsBluePlayerAfterInitialization() {
        Blokus g = new Blokus();
        assertEquals(BlokusColor.BLUE, g.getCurrentPlayer().getColor());
    }

    @Test
    public void yellowPlayerShouldFollowBluePlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        assertEquals(BlokusColor.YELLOW, g.getCurrentPlayer().getColor());
    }

    @Test
    public void redPlayerShouldFollowYellowPlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(BlokusColor.RED, g.getCurrentPlayer().getColor());
    }

    @Test
    public void greenPlayerShouldFollowRedPlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(BlokusColor.GREEN, g.getCurrentPlayer().getColor());
    }

    @Test
    public void bluePlayerShouldFollowGreenPlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(BlokusColor.BLUE, g.getCurrentPlayer().getColor());
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
