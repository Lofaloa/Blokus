package blokus.model;

import blokus.exception.ModelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;

/**
 * Represents <i>Blokus</i>.
 *
 * @author Logan Farci (47923)
 */
public class Blokus extends Observable implements Game {

    public final static int NB_PLAYERS = 4;

    private final List<Player> players;
    private final PlayerIterator playerIterator;
    private final Board board;
    private Player currentPlayer;
    private Move currentMove;
    private BlokusState state;

    /**
     * Initializes this game with four players of different colors: blue,
     * yellow, red and green (the players play in this order). The game has
     * initially an empty board.
     */
    public Blokus() {
        this.players = new ArrayList<>(Arrays.asList(new Player(BlokusColor.BLUE),
                new Player(BlokusColor.YELLOW),
                new Player(BlokusColor.RED),
                new Player(BlokusColor.GREEN)));
        this.playerIterator = new PlayerIterator(players);
        this.currentPlayer = players.get(0);
        this.currentMove = null;
        this.board = new Board();
        this.state = BlokusState.FIRST_ROUND;
        currentPlayer.startPlaying();
    }

    @Override
    public void setBotPlayers(int nb_of_bots) {
        if (nb_of_bots < 0 || NB_PLAYERS < nb_of_bots) {
            throw new IllegalArgumentException(nb_of_bots + " is not a valid "
                    + "number of bots, is should be between 0 and 4.");
        }
        for (int i = 0; i < nb_of_bots; i++) {
            Strategy strategy = new DumbPlayerStrategy(this);
            players.get(i).setStrategy(strategy);
        }
    }

    @Override
    public void initialize() {
        for (Player player : players) {
            player.initialize();
        }
        currentPlayer = players.get(0);
        board.initialize();
        state = BlokusState.FIRST_ROUND;
        currentPlayer.startPlaying();
        notifyView();
    }

    @Override
    public Board getBoard() {
        return new Board(board);
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
        return players.stream().mapToInt(p -> p.getScore()).max().getAsInt();
    }

    @Override
    public List<Player> getWinner() {
        int highestScore = getHighestScore();
        List<Player> winners = players.stream()
                .filter(p -> p.getScore() == highestScore)
                .collect(Collectors.toList());
        return Collections.unmodifiableList(winners);
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
     * Tells if this game is at first round.
     *
     * @return true if this game is at first round.
     */
    boolean isFirstRound() {
        return state == BlokusState.FIRST_ROUND;
    }

    boolean hasAnyPlayerAnStockEmpty() {
        return players.stream().anyMatch(p -> p.getStock().isEmpty());
    }

    boolean areAllPlayersWithDrawn() {
        return players.stream().allMatch(p -> p.isWithdrawn());
    }

    @Override
    public boolean isOver() {
        return hasAnyPlayerAnStockEmpty() || areAllPlayersWithDrawn();
    }

    /**
     * Tells if the first round of this game is over.
     *
     * @return true if the first round of the game is over.
     */
    boolean isFirstRoundOver() {
        return players.stream()
                .allMatch(player -> player.getStock().size() == Stock.CAPACITY - 1);
    }

    /**
     * Ends the first round.
     */
    void endFirstRound() {
        this.state = BlokusState.PLAYING;
    }

    /**
     * Requires a placable piece in the board. A placable piece can be placed at
     * the given position in the board.
     *
     * @throws ModelException if the board has not enough place for the piece
     * the current player selected.
     */
    void requirePlacablePiece(int row, int column) {
        if (!board.hasSpaceFor(currentPlayer.getCurrentPiece(), row, column)) {
            throw new ModelException("The current piece cannot be place at row "
                    + row + ", column " + column + " of the board.");
        }
    }

    /**
     * Requires a placable corner piece in the board. A placable corner piece
     * can be placed at the given position in the board. It must be in a corner.
     *
     * @throws ModelException if the board has not enough place for the piece
     * the current player selected or if the piece is not in a corner.
     */
    void requirePlacableCornerPiece(int row, int column) {
        if (!board.isPieceInCorner(currentPlayer.getCurrentPiece(), row, column)) {
            throw new ModelException("The current piece should be placed in a "
                    + "one of the corner of the board.");
        }
        if (!board.hasSpaceFor(currentPlayer.getCurrentPiece(), row, column)) {
            throw new ModelException("The current piece cannot be place at row "
                    + row + ", column " + column + " of the board.");
        }
    }

    @Override
    public void selectCurrentPlayerPiece(Shape shape) {
        currentPlayer.requireNonEmptyStock();
        currentPlayer.selectPiece(shape);
        notifyView();
    }

    @Override
    public void placePiece(int row, int column) {
        if (currentPlayer.getCurrentPiece() == null) {
            throw new IllegalStateException("The current player has not selected"
                    + " a piece.");
        }
        if (isFirstRound()) {
            currentMove = new FirstMove(currentPlayer, board, new Square(row, column));
            currentMove.execute();
        } else {
            currentMove = new MainRoundsMove(currentPlayer, board, new Square(row, column));
            currentMove.execute();
        }
        if (isFirstRoundOver()) {
            endFirstRound();
        }
        notifyView();
    }

    @Override
    public void rotateCurrentPlayerPiece() {
        if (!currentPlayer.hasSelectedAPiece()) {
            throw new IllegalStateException("Player " + currentPlayer.getColor()
                    + " is trying to rotate a piece but has not selected one.");
        }
        currentPlayer.rotateSelectedPiece();
        notifyView();
    }

    @Override
    public void turnCurrentPlayerPieceOver() {
        if (!currentPlayer.hasSelectedAPiece()) {
            throw new IllegalStateException("Player " + currentPlayer.getColor()
                    + " is trying to turn a piece over but has not selected one.");
        }
        currentPlayer.turnSelectedPieceOver();
        notifyView();
    }

    @Override
    public void nextPlayer() {
        currentPlayer.startWaiting();
        currentPlayer = playerIterator.next();
        currentPlayer.startPlaying();
        notifyView();
    }

    void notifyView() {
        setChanged();
        notifyObservers();
    }

}
