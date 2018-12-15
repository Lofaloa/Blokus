package blokus.controller.console;

import blokus.exception.IllegalActionException;
import blokus.exception.ModelException;
import blokus.model.Blokus;
import blokus.view.console.BlokusView;
import blokus.view.console.View;
import static java.lang.Integer.parseInt;
import java.util.Arrays;
import blokus.model.Shape;
import java.util.Locale;

/**
 * Manages the logic of <i>Blokus</i> console version.
 *
 * @author Logan Farci (47923)
 */
public class ControllerConsole {

    private final Blokus game;
    private final BlokusView view;
    private final String[] commandsNames;

    /**
     * Initializes this controller with the given view and game.
     *
     * @param game is the game to control.
     * @param view is the view representing the game to control.
     */
    public ControllerConsole(Blokus game, View view) {
        this.game = game;
        this.view = view;
        this.commandsNames = new String[]{"show", "stock", "play", "score",
            "exit", "miss", "withdraw", "players", "help", "restart"};
    }

    /**
     * Rotates the current player piece n times.
     *
     * @param n the number of time to rotate the piece.
     */
    void rotateBy(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(n + " is not valid, "
                    + "rotation should be positive");
        }
        for (int i = 0; i < n; i++) {
            game.rotateCurrentPlayerPiece();
        }
        view.printRotation(n);
    }

    /**
     * Plays the identified piece at the given board position.
     *
     * @param pieceId is the id of a piece.
     * @param row is the row of the board.
     * @param column is the column of the board.
     */
    void play(int pieceId, int row, int column, int rotation) {
        if (pieceId < 1 || 21 < pieceId) {
            throw new IllegalArgumentException(pieceId + " is not a valid piece "
                    + "number, it should be between 1 and 21.");
        }
        game.selectCurrentPlayerPiece(Shape.values()[--pieceId]);
        rotateBy(rotation);
        game.placePiece(row, column);
        game.nextPlayer();
    }

    /**
     * Tells if the given string is a command name.
     *
     * @param str is the string to analyze.
     * @return true if the given string is a command name.
     */
    boolean isCommandName(String str) {
        return Arrays.asList(commandsNames).contains(str);
    }

    /**
     * Makes sure that the given string is a command name. Three commands are
     * known: show, stock and place.
     *
     * @param str is the string to parse.
     * @return the given command name.
     * @throws IllegalArgumentException if the given string is not a command.
     */
    String requireCommandName(String str) {
        if (!isCommandName(str.toLowerCase(Locale.getDefault()))) {
            throw new IllegalArgumentException("\"" + str + "\" is not "
                    + "a command.");
        }
        return str;
    }

    /**
     * Executes the command represented by the given tokens.
     *
     * @param tokens are the tokens representing the command to execute.
     */
    void executeCommand(String[] tokens) {
        if (tokens.length == 0) {
            throw new IllegalArgumentException("no command to execute.");
        }
        switch (requireCommandName(tokens[0])) {
            case "play":
                if (tokens.length < 5) {
                    throw new IllegalArgumentException("for playing a piece, "
                            + "please enter its id and the position where to "
                            + "place it.");
                }
                play(parseInt(tokens[1]), parseInt(tokens[2]), parseInt(tokens[3]),
                        parseInt(tokens[4]));
                break;
            case "show":
                view.printBoard();
                break;
            case "stock":
                view.printCurrentPlayerStock();
                break;
            case "score":
                view.printCurrentPlayerScore();
                break;
            case "miss":
                System.out.println(game.getCurrentPlayer().getColor() + " player decided to miss this round!");
                game.getCurrentPlayer().missTurn();
                game.nextPlayer();
                break;
            case "withdraw":
                System.out.println(game.getCurrentPlayer().getColor() + " player decided to withdraw from the game! Bye!");
                game.getCurrentPlayer().withdraw();
                game.nextPlayer();
                break;
            case "players":
                view.printPlayers();
                break;
            case "restart":
                view.printRestart();
                if (view.askConfirmation()) {
                    game.initialize();
                }
                break;
            case "help":
                view.printHelp();
                break;
            default:
                System.exit(0);
        }
    }

    void playTurn() {
        try {
            view.printCurrentPlayer();
            executeCommand(view.readCommand());
        } catch (ModelException
                | IllegalActionException
                | IllegalArgumentException
                | NullPointerException
                | IllegalStateException e) {
            view.printExceptionMessage(e);
        }
    }

    /**
     * Starts <i>Blokus</i>.
     */
    public void start() {
        boolean again = true;
        view.printStart();
        while (again) {
            if (!game.isOver()) {
                playTurn();
            } else {
                view.printEnd();
                if (again = view.askConfirmation()) {
                    view.printStart();
                    game.initialize();
                }
            }
        }
    }

}
