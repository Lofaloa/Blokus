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
        assertEquals("BLUE", g.getBoardColorAt(0, 0));
    }

    @Test
    public void gameShouldGetANullColorInBoardAtEmptyPosition() {
        Blokus g = new Blokus();
        assertNull(g.getBoardColorAt(0, 0));
    }

    @Test
    public void gameShouldTellIfBoardIsEmptyAtGivenPosition() {
        Blokus g = new Blokus();
        assertTrue(g.isBoardEmptyAt(0, 0));
    }

    @Test
    public void gameShouldTellIfAPieceContainsAGivenSquare() {
        Blokus g = new Blokus();
        assertTrue(g.isInsideShape(2, 0, 0));
        assertTrue(g.isInsideShape(2, 1, 0));
        assertTrue(g.isInsideShape(2, 2, 0));
    }

    @Test
    public void gameShouldGetExpectedShapeSize() {
        Blokus g = new Blokus();
        assertEquals(5, g.getShapeSize(20));
    }

    @Test
    public void gameShouldTellIfAPlayerOwnsAPiece() {
        Blokus g = new Blokus();
        assertTrue(g.playerOwnsPieceOf(0, 0));
    }

    @Test
    public void gameShouldTellIfAPlayerDoesNotOwnAPiece() {
        Blokus g = new Blokus();
        g.getPlayer(0).getStock().remove(0);
        assertFalse(g.playerOwnsPieceOf(0, 0));
    }

    @Test
    public void winnerShouldBeThePlayerWithTheHighestScore() {
        Blokus g = new Blokus();
        Player currentPlayer = g.getPlayer(g.getCurrentPlayerId());
        g.selectCurrentPlayerPiece(3);
        g.placePiece(0, 0);
        assertEquals(-86, g.getHighestScore());
        assertEquals(currentPlayer.getColor(), g.getWinner().get(0).getColor());
    }

    @Test
    public void secondPlayerShouldBeWinnerWithEmptyStock() {
        Blokus g = new Blokus();
        Player winner = g.getPlayer(1);
        winner.take(new Piece(Shape.SHAPE_21, Color.YELLOW));
        assertEquals(-84, g.getHighestScore());
        assertEquals(winner.getColor(), g.getWinner().get(0).getColor());
    }

    @Test
    public void gameShouldGetExpectedPlayerScore() {
        Blokus g = new Blokus();
        g.getPlayer(0).take(new Piece(Shape.SHAPE_01, Color.BLUE));
        g.getPlayer(0).take(new Piece(Shape.SHAPE_02, Color.BLUE));
        g.getPlayer(0).take(new Piece(Shape.SHAPE_03, Color.BLUE));
        assertEquals(-83, g.getPlayerScore(0));
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
        assertEquals(Color.BLUE, g.getWinner().get(0).getColor());
        assertEquals(Color.YELLOW, g.getWinner().get(1).getColor());
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
    public void placedPieceShouldBeOnBoardAtGivenPosition() {
        Blokus g = new Blokus();
        g.selectCurrentPlayerPiece(0);
        g.placePiece(0, 0);
        assertEquals(Shape.SHAPE_01, g.getBoard()[0][0].getShape());
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
        assertEquals("BLUE", g.getPlayerColor(g.getCurrentPlayerId()));
    }

    @Test
    public void yellowPlayerShouldFollowBluePlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        assertEquals("YELLOW", g.getPlayerColor(g.getCurrentPlayerId()));
    }

    @Test
    public void redPlayerShouldFollowYellowPlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals("RED", g.getPlayerColor(g.getCurrentPlayerId()));
    }

    @Test
    public void greenPlayerShouldFollowRedPlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals("GREEN", g.getPlayerColor(g.getCurrentPlayerId()));
    }

    @Test
    public void bluePlayerShouldFollowGreenPlayer() {
        Blokus g = new Blokus();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        g.nextPlayer();
        assertEquals("BLUE", g.getPlayerColor(g.getCurrentPlayerId()));
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
