package blokus.controller;

import blokus.exception.ModelException;
import blokus.model.Game;
import blokus.model.Piece;
import blokus.model.Shape;
import blokus.model.Square;
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

    void print(Piece p) {
        System.out.println("Current player piece is of shape "
                + p.getShape() + " of color "
                + p.getColor());
    }

    void print(Square s) {
        System.out.println("Selected square: " + s.getRow() + " " + s.getColumn());
    }

    @Override
    public void handle(MouseEvent event) {
        Piece selectedPiece = view.getCurrentPlayerPiece();
        Square selectedSquare = view.getSelectedSquare();
        try {
            if (selectedPiece != null) {
                print(selectedPiece);
                game.selectCurrentPlayerPiece(selectedPiece.getShape());
                if (selectedSquare != null) {
                    print(selectedSquare);
                    game.placePiece(selectedSquare.getRow(), selectedSquare.getColumn());
                    selectedSquare = null;
                    game.nextPlayer();
                    System.out.println("Current player: " + game.getCurrentPlayer().getColor());
                }
            }
        } catch (IllegalArgumentException
                | IllegalStateException
                | ModelException e) {
            System.err.println(e.getMessage());
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
