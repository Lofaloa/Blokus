package blokus.view.fx;

import blokus.controller.fx.ActionType;
import blokus.controller.fx.ButtonActionFactory;
import blokus.controller.fx.PlacePieceAction;
import blokus.controller.fx.RotateClicked;
import blokus.controller.fx.SelectCurrentPiece;
import blokus.controller.fx.ChooseNumberOfPlayers;
import blokus.controller.fx.Historic;
import blokus.controller.fx.Start;
import blokus.exception.ModelException;
import blokus.model.Game;
import blokus.model.Piece;
import blokus.model.Player;
import blokus.model.Square;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Represents main box of <i>Blokus</i>.
 *
 * @author Logan Farci (47923)
 */
public class FxView extends VBox implements Observer {

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
    private final MyMenuBar menu;
    private final Game game;
    private final GameBox gameBox;
    private final ControlPane control;

    /**
     * Constructs the main view of the <i>Blokus</i> application.
     *
     * @param stage javaFX stage build by the Application class.
     * @param game is the game to display.
     */
    public FxView(Stage stage, Game game) {
        this.stage = Objects.requireNonNull(stage, "No given stage in arguments");
        this.game = game;
        this.gameBox = new GameBox(game);
        this.menu = new MyMenuBar();
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

    public void setOnStartAction() {
        stage.setOnShowing(new ChooseNumberOfPlayers(game, this));
        stage.setOnShown(new Start(game, this));
    }

    /**
     * Adds an handler to each squares of the board. It allows piece selection.
     */
    public void setSelectCurrentPieceAction() {
        gameBox.getStockPanes().forEach((stockPane) -> {
            stockPane.getPiecePanes().forEach((piecePane) -> {
                piecePane.setOnMousePressed(new SelectCurrentPiece(game, piecePane));
            });
        });
    }

    /**
     * Adds an
     */
    public void setPlacePieceAction() {
        gameBox.getBoardSquares().forEach((node) -> {
            Square current = new Square(GridPane.getRowIndex(node),
                    GridPane.getColumnIndex(node));
            node.setOnMousePressed(new PlacePieceAction(current, game));
        });
    }

    public void setRotateByRightClickAction() {
        gameBox.getBoard().setOnMousePressed(new RotateClicked(game, this));
    }

    public void setButtonsActions() {
        ButtonActionFactory factory = new ButtonActionFactory(game, this);
        control.getRestartButton().setOnMousePressed(factory.getButtonAction(ActionType.RESTART));
        control.getRotateButton().setOnMousePressed(factory.getButtonAction(ActionType.ROTATE));
        control.getTurnOverButton().setOnMousePressed(factory.getButtonAction(ActionType.TURN_OVER));
        control.getMissTurnButton().setOnMousePressed(factory.getButtonAction(ActionType.MISS_TURN));
        control.getWithdrawButton().setOnMousePressed(factory.getButtonAction(ActionType.WITHDRAW));
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
    
    public void setHistoricAction() {
        menu.getHistoric().setOnAction(new Historic(game, this));            
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
        if (game.isOver()) {
            if (displayEndDialog()) {
                game.initialize();
            } else {
                Platform.exit();
            }
        }
    }

    public static void displayAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public boolean askConfirmation(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        return alert.showAndWait().get() == ButtonType.OK;
    }

    private String getEndDialogContent() {
        StringBuilder str = new StringBuilder();
        for (Player winner : game.getWinner()) {
            str.append("Joueur ");
            str.append(winner.getColor());
            str.append(" avec un score de ");
            str.append(winner.getScore());
            str.append(".\n");
        }
        return str.toString();
    }

    public boolean displayEndDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Fin du jeu");
        alert.setHeaderText("Gagnants du jeu");
        alert.setContentText(getEndDialogContent());

        ButtonType restart = new ButtonType("Nouvelle partie");
        ButtonType leave = new ButtonType("Quitter");

        alert.getButtonTypes().setAll(restart, leave);

        return alert.showAndWait().get() == restart;
    }

    public String displayNbOfPlayersChoiceDialog() {
        List<String> choices = new ArrayList<>();
        choices.add("1");
        choices.add("2");
        choices.add("3");
        choices.add("4");
        ChoiceDialog<String> dialog = new ChoiceDialog<>("4", choices);
        dialog.setTitle("Choix du nombre de joueurs");
        dialog.setHeaderText("Combien de personnes participeront au jeu?");
        dialog.setContentText("Choisissez le nombre de joueurs parmis les "
                + "propositions");
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }
    
    public void showHistoric() {
        HistoricWindow historic = new HistoricWindow(game);
        historic.initialize();
    }

}
