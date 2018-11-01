package blokus.model;

import blokus.exception.IllegalActionException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the game.
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
    public void winnerShouldBeThePlayerWithTheHighestScore() {
        Game g = new Game();
        Player currentPlayer = g.getCurrentPlayer();
        g.selectCurrentPlayerPiece(4);
        g.placePiece(0, 0);
        assertEquals(-86, g.getHighestScore());
        assertEquals(currentPlayer.getColor(), g.getWinner().get(0).getColor());
    }

    @Test
    public void playersWithSameHighestScoreShouldBeBothWinners() {
        Game g = new Game();
        g.selectCurrentPlayerPiece(4);
        g.placePiece(0, 0);
        g.nextPlayer();
        g.selectCurrentPlayerPiece(4);
        g.placePiece(5, 5);
        assertEquals(-86, g.getHighestScore());
        assertEquals(Color.BLUE, g.getWinner().get(0).getColor());
        assertEquals(Color.YELLOW, g.getWinner().get(1).getColor());
    }

    @Test
    public void placedPieceShouldBeOnBoardAtGivenPosition() {
        Game g = new Game();
        g.selectCurrentPlayerPiece(1);
        g.placePiece(0, 0);
        assertEquals(Shape.SHAPE_01, g.getBoard()[0][0].getShape());
    }

    @Test(expected = IllegalActionException.class)
    public void currentPlayerCannotPlaceWithoutSelectingPiece() {
        Game g = new Game();
        g.selectCurrentPlayerPiece(2);
        g.nextPlayer();
        g.placePiece(0, 0);
    }

    @Test
    public void currentPlayerPieceShouldBeTheOneSelected() {
        Game g = new Game();
        g.selectCurrentPlayerPiece(2);
        assertEquals(Shape.SHAPE_02, g.getCurrentPlayerPiece().getShape());
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
