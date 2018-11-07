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

    /**
     * Initializes this player of the given color with a score of 0 and a stock
     * of 21 distinct piece.
     *
     * @param color is the color of this player.
     */
    Player(Color color) {
        this.color = color;
        this.score = 0;
        this.stock = new Stock(color);
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
    public Stock getStock() {
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
     * Gets a piece in this player stock.
     *
     * @param shape is the shape of the wanted piece.
     * @return the wanted piece.
     */
    Piece getPiece(Shape shape) {
        return stock.getPieceBy(shape);
    }
    
    /**
     * Clears this player stock.
     */
    void clearStock() {
        stock.getPieces().clear();
    }

}
