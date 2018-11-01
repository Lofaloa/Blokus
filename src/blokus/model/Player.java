package blokus.model;

/**
 * Represents a player.
 *
 * @author Logan Farci (47923)
 */
public class Player {

    private final Color color;
    private int score;
    private final Stock stock;
    private boolean isStuck;

    Player(Color color) {
        this.color = color;
        this.score = 0;
        this.stock = new Stock(color);
        this.isStuck = false;
    }

    /**
     * Gets the score of this player.
     *
     * @return the score of this player.
     */
    int getScore() {
        return stock.getScore();
    }

    /**
     * Gets this player stock.
     *
     * @return this player stock.
     */
    Stock getStock() {
        return stock;
    }

    /**
     * Gets this player color.
     *
     * @return this player color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Tells if this player is stuck. A player is stuck when she/ he cannot
     * place any of her/ his pieces on the board.
     *
     * @return true if this player is stuck.
     */
    public boolean isStuck() {
        return isStuck;
    }

    /**
     * Makes this player stuck.
     */
    public void stuck() {
        isStuck = true;
    }

    /**
     * Gets a piece in this player stock.
     *
     * @param shape is the shape of the wanted piece.
     * @return the wanted piece.
     */
    Piece getPiece(Shape shape) {
        return stock.getPieceBy(shape);
    }

}
