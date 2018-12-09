package blokus.model;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Logan Farci (47923)
 */
class PlayerIterator implements Iterator<Player> {

    private final List<Player> players;
    private int currentPlayerIndex = 0;

    /**
     * Initializes this iterator with the
     *
     * @param players
     */
    public PlayerIterator(List<Player> players) {
        this.players = players;
    }

    //le dernier joueur est constament modifié
    boolean isLast() {
        return currentPlayerIndex == players.size() - 1;
    }

    /**
     * Gets the player currently pointed by this iterator.
     *
     * @return the player currently pointed by this iterator.
     */
    Player current() {
        return players.get(currentPlayerIndex);
    }

    /**
     * Find the first playing player. A player stop playing when she/ he has
     * withdraw from the game.
     *
     * @return the first playing player.
     */
    Player findFirstPlayingPlayer() {
        return players.stream()
                .filter(player -> !player.isWithdrawn())
                .findFirst()
                .get();
    }

    Player findNextPlayingPlayer() {
        while (players.get(currentPlayerIndex + 1).isWithdrawn()) {
            currentPlayerIndex++;
        }
        currentPlayerIndex++;
        return players.get(currentPlayerIndex);
    }



    @Override
    public Player next() {
        Player nextPlayer;
        if (isLast()) {
            nextPlayer = findFirstPlayingPlayer();
        } else {
            nextPlayer = findNextPlayingPlayer();
        }
        currentPlayerIndex = players.indexOf(nextPlayer);
        return nextPlayer;
    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
