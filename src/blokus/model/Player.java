package blokus.model;

/**
 * Represents a player.
 *
 * @author g47923
 */
class Player {

    private final Color color;
    private int score;
    private final Stock stock;


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
    int getScore() {
        return stock.getScore();
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
