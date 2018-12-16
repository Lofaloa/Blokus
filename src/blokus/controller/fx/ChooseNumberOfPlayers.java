package blokus.controller.fx;

import blokus.model.Blokus;
import blokus.model.Game;
import blokus.view.fx.FxView;
import java.util.Objects;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

/**
 * Displays a choice dialog at start. The dialog allows the user to choose a
 * number of players.
 *
 * @author Logan Farci (47923)
 */
public class ChooseNumberOfPlayers implements EventHandler<WindowEvent> {

    private final Game game;
    private final FxView view;

    public ChooseNumberOfPlayers(Game game, FxView view) {
        this.game = game;
        this.view = view;
    }

    @Override
    public void handle(WindowEvent event) {
        try {
            String result = Objects.requireNonNull(view.displayNbOfPlayersChoiceDialog());
            int nb_of_players = Integer.parseInt(result);
            game.setBotPlayers(Blokus.NB_PLAYERS - nb_of_players);
        } catch (NumberFormatException e) {
            System.err.println("Erreur lors du choix du nombre de joueurs, "
                    + "aucun bots ne participent!");
            game.setBotPlayers(0);
        } catch (NullPointerException e) {
            Platform.exit();
        }
    }

}
