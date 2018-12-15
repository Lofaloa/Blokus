package blokus.controller.fx;

import blokus.exception.ModelException;
import blokus.model.Game;
import blokus.model.Square;
import blokus.view.fx.FXView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * The PlacePieceAction command places the piece selected by the current player
 * of the game.
 *
 * @author Logan Farci (47923)
 */
public class PlacePieceAction implements EventHandler<MouseEvent> {

    private final Square destination;
    private final Game game;

    public PlacePieceAction(Square destination, Game game) {
        this.destination = destination;
        this.game = game;
    }

    boolean isMousePrimaryButton(MouseButton b) {
        return b == MouseButton.PRIMARY;
    }

    void selectBoardSquare() {
        try {
            game.placePiece(destination.getRow(), destination.getColumn());
            game.nextPlayer();
        } catch (IllegalStateException
                | ModelException
                | NullPointerException e) {
            FXView.displayAlert("Erreur de placement", "Attention!", e.getMessage());
        }
    }

    @Override
    public void handle(MouseEvent event) {
        if (isMousePrimaryButton(event.getButton())) {
            selectBoardSquare();
        }
    }

}
