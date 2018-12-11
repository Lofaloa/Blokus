package blokus.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Tests the management of the players state.
 *
 * @author Logan Farci (47923)
 */
public class PlayerStateManagementTest {

    /**
     * When the game starts, current player should be <i>playing</i>.
     */
    @Test
    public void playerState_case_1() {
        Blokus g = new Blokus();
        assertEquals(PlayerState.PLAYING, g.getCurrentPlayer().getState());
    }

    /**
     * When passing to a next player, the new current player should be
     * <i>playing</i>, the previous one should be <i>waiting</i>.
     */
    @Test
    public void playerState_case_2() {
        Blokus g = new Blokus();
        Player previousPlayer = g.getCurrentPlayer();
        g.nextPlayer();
        assertEquals(PlayerState.WAITING, previousPlayer.getState());
        assertEquals(PlayerState.PLAYING, g.getCurrentPlayer().getState());
    }

    /**
     * When passing to a next player twice, the new current player should be
     * <i>playing</i>, the previous ones should be <i>waiting</i>.
     */
    @Test
    public void playerState_case_3() {
        Blokus g = new Blokus();
        Player previousPlayerA = g.getCurrentPlayer();
        g.nextPlayer();
        Player previousPlayerB = g.getCurrentPlayer();
        g.nextPlayer();
        assertEquals(PlayerState.WAITING, previousPlayerA.getState());
        assertEquals(PlayerState.WAITING, previousPlayerB.getState());
        assertEquals(PlayerState.PLAYING, g.getCurrentPlayer().getState());
    }

    /**
     * When a player decides to miss a turn, he should be missing all the
     * current turn, as expected. And should be back to normal at next round.
     */
    @Test
    public void playerState_missing_turn() {
        Blokus g = new Blokus();
        Player missingTurnPlayer = g.getCurrentPlayer();
        missingTurnPlayer.missTurn();
        for (int turn = 0; turn < 4; turn++) {
            assertEquals(PlayerState.MISSING_TURN, missingTurnPlayer.getState());
            g.nextPlayer();
        }
        assertEquals(PlayerState.PLAYING, missingTurnPlayer.getState());
    }

    /**
     * When a player decides to withdrawn, he/ she should have the expected
     * state.
     */
    @Test
    public void playerState_withdrawn() {
        Player p = new Player(BlokusColor.BLUE);
        p.withdraw();
        assertEquals(PlayerState.WITHDRAWN, p.getState());
    }

    /**
     * When a player has placed all her/ his pieces. He should be <i>done</i>.
     */
    @Test
    public void playerState_done() {
        Player p = new Player(BlokusColor.BLUE);
        for (int shapeIdx = 0; shapeIdx < 21; shapeIdx++) {
            p.selectPiece(Shape.values()[shapeIdx]);
            p.takeCurrentPiece();
        }
        assertEquals(PlayerState.DONE, p.getState());
    }

}
