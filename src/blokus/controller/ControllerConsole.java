package blokus.controller;

import blokus.exception.IllegalActionException;
import blokus.exception.ModelException;
import blokus.model.Blokus;
import blokus.view.console.BlokusView;
import blokus.view.console.View;
import static java.lang.Integer.parseInt;
import java.util.Arrays;
import java.util.Locale;

/**
 * Manages the logic of the console version of the game.
 *
 * @author g47923
 */
public class ControllerConsole {

    private final Blokus game;
    private final BlokusView view;
    private final String[] commandsNames;
     

    /**
     * Initializes this controller with the given view and game.
     *
     * @param game is the game to control.
     * @param view is the view of the game to control.
     */
    public ControllerConsole(Blokus game, View view) {
        this.game = game;
        this.view = view;
        this.commandsNames  = new String[]{"show", "stock", "play", "score"};
    }

    /**
     * Plays the identified piece at the given board position.
     *
     * @param pieceId is the id of a piece.
     * @param row is the row of the board.
     * @param column is the column of the board.
     */
    void play(int pieceId, int row, int column) {
        game.selectCurrentPlayerPiece(--pieceId);
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
                if (tokens.length < 4) {
                    throw new IllegalArgumentException("for playing a piece, "
                            + "please enter its id and the position where to "
                            + "place it.");
                }
                play(parseInt(tokens[1]), parseInt(tokens[2]), parseInt(tokens[3]));
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
            default:
                throw new IllegalArgumentException("The command is not defined.");
        }
    }

    /**
     * Launches <i>Blokus</i>.
     */
    public void launch() {
        view.printStart();
        while (!game.isOver()) {
            try {
                view.printCurrentPlayer();
                executeCommand(view.readCommand());
            } catch (ModelException | IllegalActionException
                    | IllegalArgumentException e) {
                view.printExceptionMessage(e);
            }
        }
    }

}
