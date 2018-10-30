package blokus.model;

import blokus.exception.IllegalActionException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 * Represents the game.
 *
 * @author g47923
 */
public class Game implements Blokus {

    private final LinkedList<Player> players;
    private ListIterator<Player> playerIterator;
    private final Board board;
    private Player currentPlayer;
    private Piece currentPlayerPiece;

    public Game() {
        this.players = new LinkedList<>(Arrays.asList(
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
    List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Piece getCurrentPlayerPiece() {
        return currentPlayerPiece;
    }

    public Stock getCurrentPlayerStock() {
        return currentPlayer.getStock();
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

    /**
     * Gets the winner of this game. If more than one players have the same
     * highest score then they are all consider winners.
     *
     * @return the winner(s).
     */
    @Override
    public List<Player> getWinner() {
        int highestScore = getHighestScore();
        return players.stream()
                .filter(p -> p.getScore() == highestScore)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isOver() {
        //is over when all players are stuck OR one player stock is empty
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void placePiece(int row, int column) {
        if (currentPlayerPiece.getColor() != currentPlayer.getColor()) {
            throw new IllegalActionException("The current player has not selected "
                    + "a piece.");
        }
        board.add(currentPlayerPiece, row, column);
    }

    @Override
    public void selectCurrentPlayerPiece(int id) {
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
