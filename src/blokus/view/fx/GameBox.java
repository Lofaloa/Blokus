package blokus.view.fx;

import blokus.model.Game;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;

/**
 * Represents the box containing the game display.
 *
 * @author Logan Farci (47923)
 */
public class GameBox extends HBox {

    private final PlayersDataPane playersData;
    private final BoardPane board;

    GameBox(Game blokus) {
        this.playersData = new PlayersDataPane(blokus);
        this.board = new BoardPane(blokus.getBoard());
        setContent();
        setStyle();
    }

    List<StockPane> getStockPanes() {
        return playersData.getStockPanes();
    }

    List<Rectangle> getBoardSquares() {
        return board.getSquares();
    }

    /**
     * Sets this game pane content.
     */
    final void setContent() {
        this.getChildren().addAll(playersData, board);
    }

    /**
     * Sets the style of this game pane.
     */
    final void setStyle() {
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Updates this pane content.
     */
    void updateContent() {
        playersData.update();
        board.update();
    }

}
