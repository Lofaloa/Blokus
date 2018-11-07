package blokus.model;

import blokus.exception.IllegalActionException;
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
    public void winnerShouldBeThePlayerWithTheHighestScore() {
        Blokus g = new Blokus();
        Player currentPlayer = g.getPlayer(g.getCurrentPlayer());
        g.selectCurrentPlayerPiece(4);
        g.placePiece(0, 0);
        assertEquals(-86, g.getHighestScore());
        assertEquals(currentPlayer.getColor(), g.getWinner().get(0).getColor());
    }

    @Test
    public void sencondPlayerWithAnEmptyStockShouldBeTheWinner() {
        Blokus g = new Blokus();
        Player player = g.getPlayers().get(2);
        g.selectCurrentPlayerPiece(1);
        g.placePiece(0, 0);
        g.nextPlayer();
        g.selectCurrentPlayerPiece(3);
        g.getPlayer(g.getCurrentPlayer()).clearStock();
        assertEquals(Color.YELLOW, g.getWinner().get(0).getColor());
    }

    @Test
    public void playersWithSameHighestScoreShouldBeBothWinners() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(4);
        g.placePiece(0, 0);
        g.nextPlayer();
        g.selectCurrentPlayerPiece(4);
        g.placePiece(5, 5);
        assertEquals(-86, g.getHighestScore());
        assertEquals(Color.BLUE, g.getWinner().get(0).getColor());
        assertEquals(Color.YELLOW, g.getWinner().get(1).getColor());
    }

    @Test(expected = ModelException.class)
    public void tooSmallPieceIdShouldCauseExceptionWhenSelectingPiece() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(0);
    }

    @Test(expected = ModelException.class)
    public void tooBigPieceIdShouldCauseExceptionWhenSelectingPiece() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(22);
    }

    @Test
    public void placedPieceShouldBeOnBoardAtGivenPosition() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(1);
        g.placePiece(0, 0);
        assertEquals(Shape.SHAPE_01, g.getBoard()[0][0].getShape());
    }

    @Test(expected = IllegalActionException.class)
    public void currentPlayerCannotPlaceWithoutSelectingPiece() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(2);
        g.nextPlayer();
        g.placePiece(0, 0);
    }

    @Test
    public void currentPlayerPieceShouldBeTheOneSelected() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(2);
        assertEquals(Shape.SHAPE_02, g.getCurrentPlayerPiece().getShape());
    }

    @Test
    public void currentPlayerIsBluePlayerAfterInitialization() {
        Blokus g = new Blokus();
        assertEquals(Color.BLUE, g.getPlayerColor(g.getCurrentPlayer()));
    }

    @Test
    public void yellowPlayerShouldFollowBluePlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        assertEquals(Color.YELLOW, g.getPlayerColor(g.getCurrentPlayer()));
    }

    @Test
    public void redPlayerShouldFollowYellowPlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(Color.RED, g.getPlayerColor(g.getCurrentPlayer()));
    }

    @Test
    public void greenPlayerShouldFollowRedPlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(Color.GREEN, g.getPlayerColor(g.getCurrentPlayer()));
    }

    @Test
    public void bluePlayerShouldFollowGreenPlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals(Color.BLUE, g.getPlayerColor(g.getCurrentPlayer()));
    }

    @Test
    public void blokusShouldBeOverWhenAllPlayersHaveAnEmptyStock() {
        Game g = new Blokus();
        g.getPlayer(0).clearStock();
        g.getPlayer(1).clearStock();
        g.getPlayer(2).clearStock();
        g.getPlayer(3).clearStock();
        assertTrue(g.isOver());
    }

    @Test
    public void blokusShouldNotBeOverWhenOneOfThePlayerHasNotAnEmptyStock() {
        Game g = new Blokus();
        g.getPlayer(0).clearStock();
        g.getPlayer(1).clearStock();
        g.getPlayer(3).clearStock();
        assertFalse(g.isOver());
    }

}
