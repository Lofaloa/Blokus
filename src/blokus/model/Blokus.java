package blokus.model;

import blokus.exception.IllegalActionException;
import blokus.exception.ModelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;
import java.util.stream.Collectors;
import javafx.beans.InvalidationListener;

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
                new Player(Color.BLUE),
                new Player(Color.YELLOW),
                new Player(Color.RED),
                new Player(Color.GREEN)));
        this.playerIterator = players.listIterator();
        this.currentPlayer = playerIterator.next();
        this.board = new Board();
    }

    @Override
    public Piece[][] getBoard() {
        return board.getSquares();
    }

    @Override
    public String getBoardColorAt(int row, int column) {
        if (isBoardEmptyAt(row, column)) {
            return null;
        } else {
            return board.getSquares()[row][column].getColor().toString();
        }
    }

    /**
     * Tells if the given square located at the given position in the board is
     * empty.
     *
     * @param row is the row of the given square.
     * @param column is the column of the given square.
     * @return true if the given square is empty.
     */
    boolean isBoardEmptyAt(int row, int column) {
        return board.isEmptyAt(row, column);
    }

    @Override
    public boolean isInsidePiece(int pieceId, int row, int column) {
        return Shape.values()[pieceId--].contains(row, column);
    }

    @Override
    public String getPieceColor(Piece piece) {
        return piece.getColor().toString();
    }

    @Override
    public int getPieceSize(Piece piece) {
        return piece.getShape().getSize();
    }

    List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    @Override
    public int getCurrentPlayerId() {
        return players.indexOf(currentPlayer);
    }

    @Override
    public Piece getCurrentPlayerPiece() {
        return currentPlayerPiece;
    }

    @Override
    public Player getPlayer(int playerId) {
        return players.get(playerId);
    }

    @Override
    public int getPlayerScore(int playerId) {
        return players.get(playerId).getScore();
    }

    @Override
    public String getPlayerColor(int playerId) {
        return players.get(playerId).getColor().toString();
    }

    @Override
    public boolean playersOwnsPiece(int playerId, int pieceId) {
        
    }

    @Override
    public List<Piece> getPlayerStock(int playerId) {
        return Collections.unmodifiableList(players.get(playerId).getStock());
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
            if (!player.getStock().isEmpty()) {
                return false;
            }
        }
        return true;
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
    public void placePiece(int row, int column) throws ModelException {
        if (currentPlayerPiece.getColor() != currentPlayer.getColor()) {
            throw new IllegalActionException("The current player has not selected "
                    + "a piece.");
        }
        board.add(currentPlayerPiece, row, column);
        setChanged();
        notifyObservers();
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

}
