package blokus.view.fx;

import blokus.model.Game;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Represents GUI view of <i>Blokus</i>.
 * 
 * 
 * @author Logan Farci (47923)
 */
public class MainWindow extends VBox {
    
    private final MenuBar menu;
    private final GamePane game;
    private final ControlPane control;
    
    public MainWindow(Game blokus) {
        this.game = new GamePane(blokus);
        this.menu = new MenuBar(new Menu("File"), new Menu("Options"), new Menu("Help"));
        this.control = new ControlPane();
        this.getChildren().addAll(menu, game, control);
        this.setSpacing(20);
    }
    
}
