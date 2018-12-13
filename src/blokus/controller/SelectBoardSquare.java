package blokus.controller;

import blokus.exception.ModelException;
import blokus.model.Game;
import blokus.model.Square;
import blokus.view.fx.FxView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Logan Farci (47923)
 */
public class SelectBoardSquare implements EventHandler<MouseEvent> {

    private final Square destination;
    private final Game game;

    public SelectBoardSquare(Square destination, Game game) {
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
            FxView.displayAlert(e.getMessage());
        }
    }

    @Override
    public void handle(MouseEvent event) {
        if (isMousePrimaryButton(event.getButton())) {
            selectBoardSquare();
        }
    }

}
