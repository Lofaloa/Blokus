package blokus.view.fx;

import blokus.controller.fx.Historic;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 *
 * @author Logan Farci (47923)
 */
class MyMenuBar extends MenuBar {
    
    private static final String LABEL = "Edit";
    
    private final Menu edit;
    private final MenuItem historic;

    public MyMenuBar() {
        this.edit = new Menu(LABEL);
        this.historic = new MenuItem("Historique");
        setContent();
    }
    
    MenuItem getHistoric() {
        return historic;
    }
    
    final void setContent() {
        edit.getItems().add(historic);
        getMenus().add(edit);
    }
    
    
}
