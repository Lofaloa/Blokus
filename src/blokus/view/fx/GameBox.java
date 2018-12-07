package blokus.view.fx;

import blokus.model.Game;
import blokus.model.Piece;
import blokus.model.Square;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * Represents the box containing the game display.
 *
 * @author Logan Farci (47923)
 */
public class GameBox extends HBox {

    private final Game game;
    private final PlayersDataPane playersData;
    private final BoardPane board;

    GameBox(Game blokus) {
        this.game = blokus;
        this.playersData = new PlayersDataPane(blokus);
        this.board = new BoardPane(blokus.getBoard());
        setContent();
        setStyle();
    }

    /**
     * Gets current player piece.
     *
     * @return current player piece.
     */
    Piece getCurrentPlayerPiece() {
        return playersData.getCurrentPlayerPiece();
    }

    Square getSelectedSquare() {
        return board.getSelectedSquare();
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
