package blokus.view.fx;

import blokus.model.FirstMove;
import blokus.model.Game;
import blokus.model.MainRoundsMove;
import blokus.model.Move;
import blokus.model.WithdrawMove;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Logan Farci (47923)
 */
public class HistoricWindow extends Stage implements Observer {

    private static final String TITLE = "Historique";
    private static final int MIN_WIDTH = 250;
    private static final int MIN_HEIGHT = 500;

    private final Game game;
    private final VBox historicBox;
    private final ScrollPane sp;
    private final Text title;
    private final Text historic;
    private Scene scene;

    /**
     * Constructs a window displaying the historic of moves made during the
     * game.
     *
     * @param game is the game to display the historic for.
     */
    public HistoricWindow(Game game) {
        this.game = game;
        this.historicBox = new VBox();
        this.sp = new ScrollPane(historicBox);
        this.title = new Text(TITLE);
        if (game.getMoves().isEmpty()) {
            this.historic = new Text("Vide");
        } else {
            this.historic = new Text(historicToString());
        }
        this.scene = new Scene(sp);
        setStyle();
        setContent();
        game.addObserver(this);
    }

    public void initialize() {
        setMinWidth(MIN_WIDTH);
        setMinHeight(MIN_HEIGHT);
        setTitle(TITLE);
        setResizable(false);

        setScene(scene);
        show();
    }

    String toString(Move move) {
        StringBuilder str = new StringBuilder();
        if (move instanceof FirstMove || move instanceof MainRoundsMove) {
            str.append(move.getPlayer().getColor());
            str.append(" player: ");
            str.append(move.getPiece().getShape());
            str.append("\n");
        } else if (move instanceof WithdrawMove) {
            str.append(move.getPlayer().getColor());
            str.append(" player: ");
            str.append(" has withdrawn\n");
        } else {
            str.append(move.getPlayer().getColor());
            str.append(" player: ");
            str.append(" has missed the turn\n");
        }
        return str.toString();
    }

    final String historicToString() {
        StringBuilder str = new StringBuilder();
        for (Move move : game.getMoves()) {
            str.append(toString(move));
        }
        return str.toString();
    }

    final void setStyle() {
        title.setFont(Font.font("arial", 24));
    }

    final void setContent() {
        historicBox.getChildren().addAll(title, historic);
    }

    @Override
    public void update(Observable o, Object arg) {
        historic.setText(historicToString());
    }

}
