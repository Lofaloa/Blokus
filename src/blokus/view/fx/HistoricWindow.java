package blokus.view.fx;

import blokus.model.Game;
import blokus.model.Move;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Logan Farci (47923)
 */
public class HistoricWindow extends Stage {

    private static final String TITLE = "Historique";
    private static final int MIN_WIDTH = 250;

    private final Game game;
    private final VBox historicBox;
    private final Text title;
    private final Text historic;

    /**
     * Constructs a window displaying the historic of moves made during the
     * game.
     *
     * @param game is the game to display the historic for.
     */
    public HistoricWindow(Game game) {
        this.game = game;
        this.historicBox = new VBox();
        this.title = new Text(TITLE);
        if (game.getMoves().isEmpty()) {
            this.historic = new Text("Vide");
        } else {
            this.historic = new Text(historicToString());
        }
        setStyle();
        setContent();
    }

    public void initialize() {
        Scene scene = new Scene(historicBox);
        setMinWidth(MIN_WIDTH);
        setTitle(TITLE);
        setResizable(false);
        setScene(scene);
        show();
    }

    final String historicToString() {
        StringBuilder str = new StringBuilder();
        for (Move move : game.getMoves()) {
            str.append(move.getPlayer().getColor());
            str.append(" player: ");
            str.append(move.getPiece().getShape());
            str.append("\n");
        }
        return str.toString();
    }

    final void setStyle() {
        title.setFont(Font.font("arial", 24));
    }

    final void setContent() {
        historicBox.getChildren().addAll(title, historic);
    }

}
