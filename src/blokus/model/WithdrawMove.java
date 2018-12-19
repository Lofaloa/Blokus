package blokus.model;

import java.util.Objects;

/**
 * Represents a move of a player that has withdrawn.
 *
 * @author Logan Farci (47923)
 */
public class WithdrawMove implements Move {

    private final Player player;

    WithdrawMove(Player player) {
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
        player.withdraw();
    }
}
