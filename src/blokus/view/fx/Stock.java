package blokus.view.fx;

import blokus.model.Player;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Represents the view of a player stock.
 *
 * @author Logan Farci (47923)
 */
public class Stock extends VBox {

    private final Player owner;
    private final HBox header;

    public Stock(Player owner) {
        this.owner = owner;
        this.header = new HBox();
    }

}
