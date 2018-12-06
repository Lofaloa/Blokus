package blokus.view.fx;

import blokus.model.Game;
import blokus.model.Piece;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;

/**
 * Represents main box of <i>Blokus</i>.
 *
 * @author Logan Farci (47923)
 */
public class MainBox extends VBox implements Observer {

    private final MenuBar menu;
    private final GameBox game;
    private final ControlPane control;

    /**
     * Initializes this main box with the given game. The main box contains a
     * menu bar, a display for the game and controls.
     *
     * @param game is the game to represent.
     */
    public MainBox(Game game) {
        this.game = new GameBox(game);
        this.menu = new MenuBar(new Menu("File"), new Menu("Options"), new Menu("Help"));
        this.control = new ControlPane();
        setContent();
        setStyle();
    }

    /**
     * Gets the piece selected by the current player.
     *
     * @return the piece selected by the current player.
     */
    public Piece getCurrentPlayerPiece() {
        return game.getCurrentPlayerPiece();
    }

    /**
     * Sets this box content.
     */
    final void setContent() {
        this.getChildren().addAll(menu, this.game, control);
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
        game.updateContent();
    }

}
