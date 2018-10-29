package blokus.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents the game.
 *
 * @author g47923
 */
public class Game implements Blokus {

    private final List<Player> players;
    private final Board board;
    private Player currentPlayer;

    public Game() {
        this.players = new ArrayList<>(Arrays.asList(
                new Player(Color.BLUE),
                new Player(Color.YELLOW),
                new Player(Color.RED),
                new Player(Color.GREEN)));
        this.currentPlayer = players.get(0);
        this.board = new Board();
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isOver() {
        //is over when all players are stuck OR one player stock is empty
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Player> getWinner() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public void placePiece(int row, int column) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Piece[][] getBoard() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
