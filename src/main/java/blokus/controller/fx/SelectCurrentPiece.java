package blokus.controller.fx;

import blokus.model.Game;
import blokus.view.fx.FxView;
import blokus.view.fx.PiecePane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Logan Farci (47923)
 */
public class SelectCurrentPiece implements EventHandler<MouseEvent> {

    private final Game game;
    private final PiecePane piecePane;

    public SelectCurrentPiece(Game game, PiecePane piece) {
        this.game = game;
        this.piecePane = piece;
    }

    boolean isMousePrimaryButton(MouseButton b) {
        return b == MouseButton.PRIMARY;
    }

    boolean isCurrentPlayerPiece() {
        return game.getCurrentPlayer().getColor() == piecePane.getPiece().getColor();
    }

    @Override
    public void handle(MouseEvent event) {
        try {
            if (isMousePrimaryButton(event.getButton()) && isCurrentPlayerPiece()) {
                game.selectCurrentPlayerPiece(piecePane.getPiece().getShape());
            } else {
                event.consume();
            }
        } catch (IllegalStateException e) {
            FxView.displayAlert("Erreur de sélection", "Attention!", e.getMessage());
        }
    }

}
