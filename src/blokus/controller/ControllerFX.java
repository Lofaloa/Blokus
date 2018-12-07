package blokus.controller;

import blokus.exception.ModelException;
import blokus.model.Game;
import blokus.model.Piece;
import blokus.model.Square;
import blokus.view.fx.MainBox;
import static java.util.Objects.requireNonNull;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;

/**
 * Handles the logic of the game.
 *
 * @author Logan Farci (47923)
 */
public class ControllerFX implements EventHandler<MouseEvent> {

    private final Game game;
    private final MainBox view;
    private boolean currentPlayerSelectedAPiece = false;

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
        System.out.println(game.getCurrentPlayer().getColor() + " player just "
                + "selected piece of shape " + p.getShape() + " of color "
                + p.getColor());
    }

    void print(Square s) {
        System.out.println(game.getCurrentPlayer().getColor() + " player just has"
                + " selected square: " + s.getRow() + " " + s.getColumn());
    }

    boolean hasCurrentPlayerClickedAPiece() {
        return view.getCurrentPlayerPiece() != null;
    }

    boolean hasCurrentPlayerClickedDestination() {
        return view.getSelectedSquare() != null;
    }

    void selectCurrentPlayerPiece() {
        Piece selectedPiece = view.getCurrentPlayerPiece();
        print(selectedPiece);
        game.selectCurrentPlayerPiece(selectedPiece.getShape());
    }

    void placeCurrentPlayerPiece() {
        Square selectedSquare = requireNonNull(view.getSelectedSquare());
        print(selectedSquare);
        game.placePiece(selectedSquare.getRow(), selectedSquare.getColumn());
    }

    void displayAlert(Exception e) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Piece placement warning");
        alert.setHeaderText("Be aware...");
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }

    @Override
    public void handle(MouseEvent event) {
        System.out.println(game.getCurrentPlayer().getColor() + " has clicked...");
        try {
            if (!currentPlayerSelectedAPiece && hasCurrentPlayerClickedAPiece()) {
                selectCurrentPlayerPiece();
                currentPlayerSelectedAPiece = true;
            }
            if (currentPlayerSelectedAPiece && hasCurrentPlayerClickedDestination()) {
                placeCurrentPlayerPiece();
                game.nextPlayer();
                currentPlayerSelectedAPiece = false;
            }
        } catch (IllegalArgumentException | IllegalStateException | ModelException e) {
            displayAlert(e);
        }
    }

}
