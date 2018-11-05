package blokus.view.fx;

import blokus.model.Game;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

/**
 *
 * @author logan
 */
public class GamePane extends HBox {
    
    private final PlayersPane playersData;
    private final BoardPane board;
    
    GamePane(Game blokus) {
        this.playersData = new PlayersPane(blokus);
        this.board = new BoardPane(blokus);
        this.getChildren().addAll(playersData, board);
        this.setSpacing(10);
        this.setHgrow(playersData, Priority.ALWAYS);
        this.setHgrow(board, Priority.ALWAYS);
        
    }
    
}
