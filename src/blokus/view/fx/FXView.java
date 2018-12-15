package blokus.view.fx;

import blokus.controller.fx.ButtonAction;
import blokus.controller.fx.ButtonActionFactory;
import blokus.controller.fx.ActionType;
import blokus.controller.fx.PlacePieceAction;
import blokus.controller.fx.SelectCurrentPiece;
import blokus.exception.ModelException;
import blokus.model.Game;
import blokus.model.Piece;
import blokus.model.Square;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Represents main box of <i>Blokus</i>.
 *
 * @author Logan Farci (47923)
 */
public class FXView extends VBox implements Observer {

    /**
     * Maximal width of the view.
     */
    public static final int MAX_WIDTH = 1_000;

    /**
     * Maximal height of the view.
     */
    public static final int MAX_HEIGHT = 750;

    /**
     * Title of the view.
     */
    public static final String TITLE = "Blokus";

    private final Stage stage;
    private final MenuBar menu;
    private final Game game;
    private final GameBox gameBox;
    private final ControlPane control;

    /**
     * Constructs the main view of the <i>Blokus</i> application.
     *
     * @param stage javaFX stage build by the Application class.
     * @param game is the game to display.
     */
    public FXView(Stage stage, Game game) {
        this.stage = Objects.requireNonNull(stage, "No given stage in arguments");
        this.game = game;
        this.gameBox = new GameBox(game);
        this.menu = new MenuBar(new Menu("File"), new Menu("Options"), new Menu("Help"));
        this.control = new ControlPane();
        setContent();
        setStyle();
    }

    /**
     * Initialize the stage and show it to the screen.
     */
    public void initialize() {
        initializeStage();
        stage.show();
    }

    private void initializeStage() {
        Scene scene = new Scene(this);
        stage.setMaxWidth(MAX_WIDTH);
        stage.setMaxHeight(MAX_HEIGHT);
        stage.setTitle(TITLE);
        stage.setResizable(false);
        stage.setScene(scene);
        prefWidthProperty().bind(scene.widthProperty());
        prefHeightProperty().bind(scene.heightProperty());
    }

    /**
     * Adds an handler to each piece of the stock. It allows piece selection.
     */
    public void setSelectCurrentPieceAction() {
        gameBox.getStockPanes().forEach((stockPane) -> {
            stockPane.getPiecePanes().forEach((piecePane) -> {
                piecePane.setOnMousePressed(new SelectCurrentPiece(game, piecePane));
            });
        });
    }

    /**
     * Adds an handler to each square of the board. It allows piece placement.
     */
    public void setPlacePieceAction() {
        gameBox.getBoardSquares().forEach((node) -> {
            Square current = new Square(GridPane.getRowIndex(node),
                    GridPane.getColumnIndex(node));
            node.setOnMousePressed(new PlacePieceAction(current, game));
        });
    }

    private void setPiecePreviewAction(Node node, Square dest) {
        node.setOnMouseEntered(event -> {
            if (game.getCurrentPlayer().getCurrentPiece() == null) {
                event.consume();
            } else {
                try {
                    Piece currentPiece = game.getCurrentPlayer().getCurrentPiece();
                    gameBox.getBoard().previewPiece(currentPiece, dest);
                } catch (ModelException e) {
                    System.err.println(e.getMessage());
                }
            }
        });
    }

    private void setBoardUpdateAction(Node node) {
        node.setOnMouseExited(event -> {
            gameBox.getBoard().update();
        });
    }

    /**
     * Adds an handler to each squares of the board. The current piece is
     * displaid on the board at the mouse position.
     */
    public void setPiecePreviewAction() {
        gameBox.getBoardSquares().forEach((node) -> {
            Square current = new Square(GridPane.getRowIndex(node),
                    GridPane.getColumnIndex(node));
            setPiecePreviewAction(node, current);
            setBoardUpdateAction(node);
        });
    }

    private void setButtonAction(Button button, ButtonAction action) {
        button.setOnMousePressed(action);
    }

    /**
     * Adds the actions to the control buttons.
     */
    public void setButtonActions() {
        ButtonActionFactory factory = new ButtonActionFactory(game, this);
        setButtonAction(control.getRestartButton(),
                factory.getButtonAction(ActionType.RESTART));
        setButtonAction(control.getRotateButton(),
                factory.getButtonAction(ActionType.ROTATE));
        setButtonAction(control.getMissTurnButton(),
                factory.getButtonAction(ActionType.MISS_TURN));
        setButtonAction(control.getTurnOverButton(),
                factory.getButtonAction(ActionType.TURN_OVER));
        setButtonAction(control.getWithdrawButton(),
                factory.getButtonAction(ActionType.WITHDRAW));
    }

    /**
     * Sets this main view content.
     */
    final void setContent() {
        this.getChildren().addAll(menu, this.gameBox, control);
    }

    /**
     * Sets this main view style.
     */
    final void setStyle() {
        this.setSpacing(20);
    }

    /**
     * Updates the content of this main view.
     *
     * @param o the game.
     * @param o1 nothing.
     */
    @Override
    public void update(Observable o, Object o1) {
        gameBox.updateContent();
    }

    /**
     * Displays a warning to the user.
     *
     * @param title is the title of the warning.
     * @param header is the header of the warning.
     * @param content is the content of the warning.
     */
    public static void displayAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    /**
     * Displays a warning to the user.
     *
     * @param title is the title of the warning.
     * @param header is the header of the warning.
     * @param content is the content of the warning.
     */
    public static Optional<ButtonType> askConfirmation(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        return alert.showAndWait();
    }

}
