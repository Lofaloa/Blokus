package blokus.model;

import blokus.exception.IllegalActionException;
import blokus.exception.ModelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 * Represents <i>Blokus</i>.
 *
 * @author Logan Farci (47923)
 */
public class Blokus implements Game {

    private final List<Player> players;
    private ListIterator<Player> playerIterator;
    private final Board board;
    private Player currentPlayer;
    private Piece currentPlayerPiece;

    /**
     * Initializes this game with four players of different colors: blue,
     * yellow, red and green (the players play in this order). The game has an
     * empty board.
     */
    public Blokus() {
        this.players = new ArrayList<>(Arrays.asList(
                new Player(Color.BLUE),
                new Player(Color.YELLOW),
                new Player(Color.RED),
                new Player(Color.GREEN)));
        this.playerIterator = players.listIterator();
        this.currentPlayer = playerIterator.next();
        this.board = new Board();
    }

    /**
     * Gets this game players
     *
     * @return this game players.
     */
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public Piece getCurrentPlayerPiece() {
        return currentPlayerPiece;
    }

    @Override
    public List<Piece> getCurrentPlayerStock() {
        return currentPlayer.getStock().getPieces();
    }

    @Override
    public Piece[][] getBoard() {
        return board.getSquares();
    }

    /**
     * Gets the highest score of this game players.
     *
     * @return the highest score of this game players.
     */
    int getHighestScore() {
        int highestScore = players.get(0).getScore();
        for (int i = 1; i < players.size(); i++) {
            Player currentPlayer = players.get(i);
            if (highestScore < currentPlayer.getScore()) {
                highestScore = currentPlayer.getScore();
            }
        }
        return highestScore;
    }

    @Override
    public List<Player> getWinner() {
        int highestScore = getHighestScore();
        return players.stream()
                .filter(p -> p.getScore() == highestScore)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isOver() {
        for (Player player : players) {
            if (player.getStock().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void placePiece(int row, int column) throws ModelException {
        if (currentPlayerPiece.getColor() != currentPlayer.getColor()) {
            throw new IllegalActionException("The current player has not selected "
                    + "a piece.");
        }
        board.add(currentPlayerPiece, row, column);
    }

    @Override
    public void selectCurrentPlayerPiece(int id) throws ModelException {
        if (id < 1 || 21 < id) {
            throw new ModelException(id + " is not a valid piece id, there "
                    + "are 21 pieces.");
        }
        currentPlayerPiece = currentPlayer.getPiece(Shape.values()[--id]);
    }

    @Override
    public void nextPlayer() {
        if (currentPlayer.getColor() == Color.GREEN) {
            playerIterator = players.listIterator(0);
            currentPlayer = playerIterator.next();
        } else {
            currentPlayer = playerIterator.next();
        }
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
