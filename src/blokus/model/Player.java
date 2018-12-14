package blokus.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents a player.
 *
 * @author Logan Farci (47923)
 */
public class Player {

    private final BlokusColor color;
    private final Stock stock;
    private PlayerState state;
    private boolean isCurrentPlayer;
    private Piece selectedPiece;

    /**
     * Initializes this player with the given color and a stock of 21 distinct
     * piece.
     *
     * @param color is the color of this player.
     */
    Player(BlokusColor color) {
        this.color = color;
        this.stock = new Stock(color);
        this.state = PlayerState.WAITING;
        this.isCurrentPlayer = false;
        this.selectedPiece = null;
    }

    Player(Player player) {
        this.color = player.getColor();
        this.stock = new Stock(player.getStock(), player.getColor());
    }

    /**
     * Gets the score of this player.
     *
     * @return the score of this player.
     */
    public int getScore() {
        return stock.getScore();
    }

    /**
     * Gets this player stock.
     *
     * @return this player stock.
     */
    public List<Piece> getStock() {
        return Collections.unmodifiableList(stock.getPieces());
    }

    /**
     * Gets this player color.
     *
     * @return this player color.
     */
    public BlokusColor getColor() {
        return color;
    }

    /**
     * Gets the current piece of this player.
     *
     * @return the current piece of this player.
     */
    public Piece getCurrentPiece() {
        return selectedPiece;
    }

    /**
     * Tells if this player is the current player of the game.
     *
     * @return true if this player is the current player of the game.
     */
    public boolean isCurrentPlayer() {
        return isCurrentPlayer;
    }

    boolean is(BlokusColor color) {
        return this.color == color;
    }

    boolean isWithdrawn() {
        return state == PlayerState.WITHDRAWN;
    }

    boolean isMissingTurn() {
        return state == PlayerState.MISSING_TURN;
    }

    boolean hasPlacedFirstPiece() {
        return stock.getPieces().size() == 20;
    }

    void initialize() {
        this.state = PlayerState.WAITING;
        this.stock.initialize();
        this.isCurrentPlayer = false;
        this.selectedPiece = null;
    }

    void startPlaying() {
        if (!isWithdrawn()) {
            state = PlayerState.PLAYING;
            isCurrentPlayer = true;
        }
    }

    void startWaiting() {
        if (!isMissingTurn() && !isWithdrawn()) {
            state = PlayerState.WAITING;
        }
        isCurrentPlayer = false;
    }

    /**
     * Makes this player miss the current turn of the game she/ he is playing.
     */
    public void missTurn() {
        state = PlayerState.MISSING_TURN;
    }

    /**
     * Makes this player withdraw form the game she/ he is playing.
     */
    public void withdraw() {
        state = PlayerState.WITHDRAWN;
    }

    void requireNonEmptyStock() {
        stock.requireNonEmpty();
    }

    /**
     * Tells if this player owns a piece of the given shape.
     *
     * @param piece is the piece to look for.
     * @return true if the given shape is this player stock.
     */
    public boolean owns(Piece piece) {
        Objects.requireNonNull(piece, "No given piece.");
        return stock.contains(piece);
    }

    /**
     * Gets this player state
     *
     * @return this player.
     */
    public PlayerState getState() {
        return state;
    }

    Piece takeCurrentPiece() {
        requireNonEmptyStock();
        Objects.requireNonNull(selectedPiece, "This player has not selected a piece.");
        stock.remove(selectedPiece);
        Piece taken = selectedPiece;
        selectedPiece = null;
        if (stock.isEmpty()) {
            state = PlayerState.DONE;
        }
        return taken;
    }

    void remove(Piece piece) {
        requireNonEmptyStock();
        Objects.requireNonNull(piece);
        stock.remove(piece);
    }

    void selectPiece(Shape shape) {
        requireNonEmptyStock();
        Piece piece = Objects.requireNonNull(stock.getPiece(shape), "Selected "
                + "piece has not been found.");
        selectedPiece = piece;
    }

    /**
     * Rotates this player selected piece 90 degrees clockwise.
     */
    void rotateSelectedPiece() {
        selectedPiece.rotate();
    }

    /**
     * Rotates this player selected piece 90 degrees clockwise.
     */
    void turnSelectedPieceOver() {
        selectedPiece.turnOver();
    }

    void clearStock() {
        requireNonEmptyStock();
        stock.clear();
    }

    void clearStockSmallestPieceAtEnd() {
        requireNonEmptyStock();
        for (int i = 1; i < Stock.CAPACITY; i++) {
            remove(stock.getPieces().get(1));
        }
        remove(getStock().get(0));
    }

}
