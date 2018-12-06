package blokus.controller;

import blokus.model.Game;
import blokus.model.Piece;
import blokus.model.Shape;
import blokus.view.fx.MainBox;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Handles the logic of the game.
 *
 * @author Logan Farci (47923)
 */
public class ControllerFX implements EventHandler<MouseEvent> {

    private final Game game;
    private final MainBox view;

    /**
     * Initializes this controller with the game to control.
     *
     * @param game is the game to control.
     */
    public ControllerFX(Game game, MainBox view) {
        this.game = game;
        this.view = view;
    }

    @Override
    public void handle(MouseEvent event) {
        Piece selectedPiece = view.getCurrentPlayerPiece();
        if (selectedPiece != null) {
            System.out.println("Current player piece is of shape "
                    + selectedPiece.getShape() + " of color "
                    + selectedPiece.getColor());
            game.nextPlayer();
        } else {
            System.out.println("Pas de pièce selectionnee");
        }
    }

    void emulateFirstRound() {
        game.selectCurrentPlayerPiece(Shape.SHAPE_01);
        game.placePiece(0, 0);
        game.nextPlayer();
        game.selectCurrentPlayerPiece(Shape.SHAPE_01);
        game.placePiece(19, 0);
        game.nextPlayer();
        game.selectCurrentPlayerPiece(Shape.SHAPE_01);
        game.placePiece(0, 19);
        game.nextPlayer();
        game.selectCurrentPlayerPiece(Shape.SHAPE_01);
        game.placePiece(19, 19);
    }

}
