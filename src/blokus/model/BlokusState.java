package blokus.model;

/**
 * Represents the state of advancement of a game of <i>Blokus</i>.
 *
 * @author Logan Farci (47923)
 */
public enum BlokusState {

    /**
     * The players are placing their first pieces on a corner of the board.
     */
    FIRST_ROUND,

    /**
     * The players are playing the game.
     */
    PLAYING,

    /**
     * The game is over. The winner(s) is/ are known.
     */
    OVER;

}
