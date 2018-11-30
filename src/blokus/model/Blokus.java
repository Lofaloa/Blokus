package blokus.model;

import blokus.exception.ModelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
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
    private BlokusState state;

    /**
     * Initializes this game with four players of different colors: blue,
     * yellow, red and green (the players play in this order). The game has an
     * empty board.
     */
    public Blokus() {
        this.players = new ArrayList<>(Arrays.asList(new Player(BlokusColor.BLUE),
                new Player(BlokusColor.YELLOW),
                new Player(BlokusColor.RED),
                new Player(BlokusColor.GREEN)));
        this.playerIterator = players.listIterator();
        this.currentPlayer = playerIterator.next();
        this.board = new Board();
        this.state = BlokusState.FIRST_ROUND;
    }

    @Override
    public Board getBoard() {
        return board;
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

    /**
     * Gets this game state.
     *
     * @return this game state.
     */
    BlokusState getState() {
        return state;
    }

    /**
     * Ends the first round.
     */
    void endFirstRound() {
        this.state = BlokusState.PLAYING;
    }

    /**
     * Tells if this game is at first round.
     *
     * @return true if this game is at first round.
     */
    boolean isFirstRound() {
        return state == BlokusState.FIRST_ROUND;
    }

    /**
     * Tells if the first round of this game is over.
     *
     * @return true if the first round of the game is over.
     */
    boolean isFirstRoundOver() {
        return currentPlayer.is(BlokusColor.GREEN) && currentPlayer.hasPlacedFirstPiece();
    }

    /**
     * Requires a valid square in the board.
     */
    void requireValidSquareInBoard(int row, int column) {
        Objects.requireNonNull(currentPlayer.getCurrentPiece(), "No given piece "
                + "when trying to know if it is placable.");
        if (!board.hasSpaceFor(currentPlayer.getCurrentPiece(), row, column)) {
            throw new ModelException("The current piece cannot be place at row "
                    + row + ", column " + column + " of the board.");
        }
    }

    @Override
    public boolean isOver() {
        return players.stream().allMatch(p -> p.getStock().isEmpty());
    }

    @Override
    public void selectCurrentPlayerPiece(Shape shape) {
        currentPlayer.selectPiece(shape);
    }

    @Override
    public void placePiece(int row, int column) {
        Objects.requireNonNull(currentPlayer.getCurrentPiece(), "The current "
                + "player has not selected a piece.");
        requireValidSquareInBoard(row, column);

        if (isFirstRound()) {
            board.requireCornerPiece(currentPlayer.getCurrentPiece(), row, column);
            board.requirePlacablePiece(currentPlayer.getCurrentPiece(), row, column);
            board.addCornerPiece(currentPlayer.takeCurrentPiece(), row, column);
        } else {
            board.requirePlacablePiece(currentPlayer.getCurrentPiece(), row, column);
            board.addPiece(currentPlayer.takeCurrentPiece(), row, column);
        }
        if (isFirstRoundOver()) {
            endFirstRound();
        }
        notifyView();
    }

    @Override
    public void nextPlayer() {
        if (currentPlayer.is(BlokusColor.GREEN)) {
            playerIterator = players.listIterator(0);
            currentPlayer = playerIterator.next();
        } else {
            currentPlayer = playerIterator.next();
        }
    }

    void notifyView() {
        setChanged();
        notifyObservers();
    }

}
