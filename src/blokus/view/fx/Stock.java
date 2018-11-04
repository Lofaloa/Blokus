package blokus.view.fx;

import blokus.model.Piece;
import blokus.model.Player;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Represents the view of a player stock.
 *
 * @author Logan Farci (47923)
 */
public class Stock extends VBox {

    private final Player owner;
    private final HBox header;
    private final GridPane pieces;

    public Stock(Player owner) {
        this.owner = owner;
        this.header = new HBox();
        this.pieces = new GridPane();
        setContent();
        
    }
    
    void setHeaderContent() {
        Text txt1 = new Text("Score: " + owner.getScore());
        this.header.getChildren().add(txt1);
    }
    
    void draw() {

    }
    
    void setContent() {
        setHeaderContent();
        draw();
    }

}
