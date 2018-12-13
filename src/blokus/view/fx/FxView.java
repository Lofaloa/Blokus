package blokus.view.fx;

import blokus.controller.MissTurn;
import blokus.controller.Rotate;
import blokus.controller.SelectBoardSquare;
import blokus.controller.SelectCurrentPiece;
import blokus.controller.Withdraw;
import blokus.model.Game;
import blokus.model.Piece;
import blokus.model.Square;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Represents main box of <i>Blokus</i>.
 *
 * @author Logan Farci (47923)
 */
public class FxView extends VBox implements Observer {

    private final MenuBar menu;
    private final Game game;
    private final GameBox gameBox;
    private final ControlPane control;

    /**
     * Initializes this main box with the given game. The main box contains a
     * menu bar, a display for the game and controls.
     *
     * @param game is the game to represent.
     */
    public FxView(Game game) {
        this.game = game;
        this.gameBox = new GameBox(game);
        this.menu = new MenuBar(new Menu("File"), new Menu("Options"), new Menu("Help"));
        this.control = new ControlPane();
        setContent();
        setStyle();
    }

    public void initialize() {
        setSelectBoardSquareAction();
        setSelectCurrentPieceAction();
        setRotateAction();
        //setPiecePreviewAction();
        setMissTurnAction();
        setWithdrawAction();
    }

    void setSelectCurrentPieceAction() {
        gameBox.getStockPanes().forEach((stockPane) -> {
            stockPane.getPiecePanes().forEach((piecePane) -> {
                piecePane.setOnMousePressed(new SelectCurrentPiece(game, piecePane));
            });
        });
    }

    void setSelectBoardSquareAction() {
        gameBox.getBoardSquares().forEach((node) -> {
            Square current = new Square(GridPane.getRowIndex(node),
                    GridPane.getColumnIndex(node));
            node.setOnMousePressed(new SelectBoardSquare(current, game));
        });
    }

    void setRotateAction() {
        control.getRotateButton().setOnMousePressed(new Rotate(this, game));
    }

    void setMissTurnAction() {
        control.getMissTurnButton().setOnMousePressed(new MissTurn(game, this));
    }

    void setWithdrawAction() {
        control.getWithdrawButton().setOnMousePressed(new Withdraw(this, game));
    }

    void setPiecePreviewAction() {
        gameBox.getBoardSquares().forEach((node) -> {
            Square current = new Square(GridPane.getRowIndex(node),
                    GridPane.getColumnIndex(node));
            setOnMouseEntered(event -> {
                Piece currentPiece = game.getCurrentPlayer().getCurrentPiece();
                gameBox.getBoard().previewPiece(currentPiece, current);
            });
        });
    }

    /**
     * Sets this box content.
     */
    final void setContent() {
        this.getChildren().addAll(menu, this.gameBox, control);
    }

    /**
     * Sets this box style.
     */
    final void setStyle() {
        this.setSpacing(20);
    }

    /**
     * Updates the content of game box.
     *
     * @param o the game.
     * @param o1 nothing.
     */
    @Override
    public void update(Observable o, Object o1) {
        gameBox.updateContent();
    }

    public static void displayAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Piece placement warning");
        alert.setHeaderText("Be aware...");
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
