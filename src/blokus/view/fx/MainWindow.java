package blokus.view.fx;

import blokus.model.Game;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
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
    
    public MainWindow(Game blokus) {
        this.game = new GamePane(blokus);
        this.menu = new MenuBar(new Menu("File"), new Menu("Options"), new Menu("Help"));
        this.getChildren().addAll(menu, game);
        this.setSpacing(20);
    }
    
}
