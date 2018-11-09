package blokus.model;

import java.util.List;

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
    public List<Piece> getStock() {
        return stock.getPieces();
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
        return stock.takePiece(shape);
    }
    
    boolean owns(Shape shape) {
        return stock.getPieces().contains(new Piece(shape, color));
    }
    
    /**
     * Clears this player stock.
     */
    void clearStock() {
        stock.getPieces().clear();
    }

}
