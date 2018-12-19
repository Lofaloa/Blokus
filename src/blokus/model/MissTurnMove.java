package blokus.model;

import java.util.Objects;

/**
 * Represents a move of a player that has missed the current turn.
 *
 * @author Logan Farci (47923)
 */
public class MissTurnMove implements Move {
    private final Player player;

    MissTurnMove(Player player) {
        this.player = Objects.requireNonNull(player);
    }

    @Override
    public Piece getPiece() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public void execute() {
        player.missTurn();
    }
}
