package blokus.model;

import java.util.Iterator;
import java.util.List;

/**
 * Represents an iterator over a list of players.
 * 
 * @author Logan Farci (47923)
 */
class PlayerIterator implements Iterator<Player> {

    private final List<Player> players;
    private int currentPlayerIndex = 0;

    PlayerIterator(List<Player> players) {
        this.players = players;
    }

    Player current() {
        return players.get(currentPlayerIndex);
    }

    Player getFirst() {
        currentPlayerIndex = 0;
        return players.get(0);
    }

    @Override
    public Player next() {
        Player nextPlayer;
        if (current().is(BlokusColor.GREEN)) {
            nextPlayer = getFirst();
        } else {
            nextPlayer = players.get(++currentPlayerIndex);
        }
        return nextPlayer;
    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
