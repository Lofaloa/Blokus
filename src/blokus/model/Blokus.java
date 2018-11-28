package blokus.model;

import blokus.exception.ModelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;
import java.util.stream.Collectors;

/**
 * Represents <i>Blokus</i>.
 *
 * @author Logan Farci (47923)
 */
public class Blokus extends Observable implements Game {

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
                new Player(BlokusColor.BLUE),
                new Player(BlokusColor.YELLOW),
                new Player(BlokusColor.RED),
                new Player(BlokusColor.GREEN)));
        this.playerIterator = players.listIterator();
        this.currentPlayer = playerIterator.next();
        this.currentPlayerPiece = null;
        this.board = new Board();
    }

    @Override
    public Board getBoard() {
        return board;
    }

    Piece getCurrentPlayerPiece() {
        return currentPlayerPiece;
    }

    @Override
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
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
        return players.stream().allMatch(p -> p.getStock().isEmpty());
    }

    @Override
    public void selectCurrentPlayerPiece(int pieceId) throws ModelException {
        if (pieceId < 0 || 20 < pieceId) {
            throw new ModelException(pieceId + " is not a valid piece id, there "
                    + "are 21 pieces.");
        }
        currentPlayerPiece = currentPlayer.getPiece(pieceId);
    }

    @Override
    public void placePiece(int row, int column) throws ModelException {
        board.requireValidSquare(row, column);
        currentPlayer.remove(currentPlayerPiece);
        board.addPiece(currentPlayerPiece, row, column);
        setChanged();
        notifyObservers();
    }

    @Override
    public void nextPlayer() {
        if (currentPlayer.getColor() == BlokusColor.GREEN) {
            playerIterator = players.listIterator(0);
            currentPlayer = playerIterator.next();
        } else {
            currentPlayer = playerIterator.next();
        }
    }

}
