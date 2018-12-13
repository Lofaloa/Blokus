package blokus.controller;

import blokus.model.Game;
import blokus.view.fx.FxView;
import blokus.view.fx.PiecePane;
import javafx.event.EventHandler;
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

    @Override
    public void handle(MouseEvent event) {
        try {
            if (game.getCurrentPlayer().getColor() == piecePane.getPiece().getColor()) {
                game.selectCurrentPlayerPiece(piecePane.getPiece().getShape());
            } else {
                event.consume();
            }
        } catch (IllegalStateException e) {
            FxView.displayAlert(e.getMessage());
        }
    }

}
