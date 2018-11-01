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

    /**
     * Initializes this game with four players of different colors: blue,
     * yellow, red and green (the players play in this order). The game has an
     * empty board.
     */
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
        //TEST: pas de test sur les joueurs blockés
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

    /**
     * Tells if the given piece can be added to this game board.
     *
     * @param piece
     * @return
     */
    boolean canBePlaced(Piece piece) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (board.canAddAt(piece, j, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Tells if the current player is stuck. A player is stuck when she/ he
     * cannot place any of the pieces.
     *
     * @return true if the current player is stuck.
     */
    boolean isCurrentPlayerStuck() {
        for (Piece piece : currentPlayer.getStock().getPieces()) {
            if (canBePlaced(piece)) {
                return false;
            }
        }
        return true;
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
        if (isCurrentPlayerStuck()) {
            nextPlayer();
        } else {
            currentPlayerPiece = currentPlayer.getPiece(Shape.values()[--id]);
        }
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
