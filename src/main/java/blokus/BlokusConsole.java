package blokus;

import blokus.controller.console.ControllerConsole;
import blokus.model.Blokus;
import blokus.model.Game;
import blokus.view.console.View;

/**
 * Main class of <i>Blokus</i> console version.
 *
 * @author g47923
 */
public class BlokusConsole {

    /**
     * Entry point of <i>Blokus</i> console version.
     *
     * @param args nothing.
     */
    public static void main(String[] args) {
        Game game = new Blokus();
        View view = new View(game);
        ControllerConsole controller = new ControllerConsole(game, view);
        if (args.length > 1) {
            System.err.println("usage: the game requieres zero or one argument "
                    + "to be run.");
        } else if (args.length == 1) {
            int nb_of_players = -1;
            try {
                nb_of_players = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("usage: enter the number of real players");
                System.exit(0);
            }
            if (nb_of_players < 0 || Blokus.NB_PLAYERS < nb_of_players) {
                System.err.println("usage: " + nb_of_players + " is not valid "
                        + "number of players, Blokus is playable by 4 players");
                System.exit(0);
            }
            game.setBotPlayers(Blokus.NB_PLAYERS - nb_of_players);
            controller.start();
        } else {
            controller.start();
        }
    }

}
