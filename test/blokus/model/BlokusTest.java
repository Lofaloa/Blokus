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
        assertEquals("BLUE", g.getBoard().getColorAt(0, 0));
    }

    @Test
    public void gameShouldTellIfBoardIsEmptyAtGivenPosition() {
        Blokus g = new Blokus();
        assertTrue(g.isBoardEmptyAt(0, 0));
    }

    @Test
    public void gameShouldGetExpectedShapeSize() {
        Blokus g = new Blokus();
        assertEquals(5, g.getShapeSize(20));
    }

    @Test
    public void winnerShouldBeThePlayerWithTheHighestScore() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(3);
        g.placePiece(0, 0);
        assertEquals(-86, g.getHighestScore());
        assertEquals(new Integer(0), g.getWinner().get(0));
    }

    @Test
    public void secondPlayerShouldBeWinnerWithEmptyStock() {
        Blokus g = new Blokus();
        Player winner = g.getPlayer(1);
        winner.remove(new Piece(Shape.SHAPE_21, BlokusColor.YELLOW));
        assertEquals(-84, g.getHighestScore());
        assertEquals(new Integer(1), g.getWinner().get(0));
    }

    @Test
    public void playersWithSameHighestScoreShouldBeBothWinners() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(3);
        g.placePiece(0, 0);
        g.nextPlayer();
        g.selectCurrentPlayerPiece(3);
        g.placePiece(5, 5);
        assertEquals(-86, g.getHighestScore());
        assertEquals(new Integer(0), g.getWinner().get(0));
        assertEquals(new Integer(1), g.getWinner().get(1));
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
        assertEquals("BLUE", g.getCurrentPlayer().getColor());
    }

    @Test
    public void yellowPlayerShouldFollowBluePlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        assertEquals("YELLOW", g.getCurrentPlayer().getColor());
    }

    @Test
    public void redPlayerShouldFollowYellowPlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals("RED", g.getCurrentPlayer().getColor());
    }

    @Test
    public void greenPlayerShouldFollowRedPlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals("GREEN", g.getCurrentPlayer().getColor());
    }

    @Test
    public void bluePlayerShouldFollowGreenPlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals("BLUE", g.getCurrentPlayer().getColor());
    }

    @Test
    public void blokusShouldBeOverWhenAllPlayersHaveAnEmptyStock() {
        Blokus g = new Blokus();
        g.getPlayer(0).clearStock();
        g.getPlayer(1).clearStock();
        g.getPlayer(2).clearStock();
        g.getPlayer(3).clearStock();
        assertTrue(g.isOver());
    }

    @Test
    public void blokusShouldNotBeOverWhenOneOfThePlayerHasNotAnEmptyStock() {
        Blokus g = new Blokus();
        g.getPlayer(0).clearStock();
        g.getPlayer(1).clearStock();
        g.getPlayer(3).clearStock();
        assertFalse(g.isOver());
    }

}
