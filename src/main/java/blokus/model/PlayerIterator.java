package blokus.model;

import java.util.Iterator;
import java.util.List;

/**
 * Represents an iterator over a list of players. This iterator passes the
 * players who are withdrawn from the game.
 *
 * @author Logan Farci (47923)
 */
class PlayerIterator implements Iterator<Player> {

    private final List<Player> players;
    private int currentPlayerIndex = 0;

    PlayerIterator(List<Player> players) {
        this.players = players;
    }

    boolean areAllPlayersWithdrawn() {
        return players.stream().allMatch(player -> player.isWithdrawn());
    }

    Player current() {
        return players.get(currentPlayerIndex);
    }

    Player getFirst() {
        currentPlayerIndex = 0;
        return players.get(0);
    }

    Player getNext() {
        if (current().is(BlokusColor.GREEN)) {
            return getFirst();
        } else {
            return players.get(++currentPlayerIndex);
        }
    }

    @Override
    public Player next() {
        Player nextPlayer = getNext();
        while (!areAllPlayersWithdrawn() && nextPlayer.isWithdrawn()) {
            nextPlayer = getNext();
        }
        return nextPlayer;
    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
