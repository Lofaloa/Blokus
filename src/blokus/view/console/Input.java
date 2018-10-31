package blokus.view.console;

import blokus.model.Game;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

/**
 * Manages the input of the user.
 *
 * @author g47923
 */
class Input {

    private final Scanner in;
    private final String[] commandsNames;
    private final Game game;
    private final Output display;

    public Input(Game game) {
        this.in = new Scanner(System.in);
        this.commandsNames = new String[]{"show", "stock", "play"};
        this.game = game;
        this.display = new Output(game);
    }

    /**
     * Reads the current a command.
     *
     * @return the tokens of the read command.
     */
    String[] readCommand() {
        display.printPrompt();
        String line = in.nextLine();
        while (line.length() == 0) {
            display.printPrompt();
            line = in.nextLine();
        }
        return line.split("\\s+");
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
     * ]
     * Plays the identified piece at the given board position.
     *
     * @param pieceId is the id of a piece.
     * @param row is the row of the board.
     * @param column is the column of the board.
     */
    void play(int pieceId, int row, int column) {
        game.selectCurrentPlayerPiece(pieceId);
        game.placePiece(row, column);
        game.nextPlayer();
    }

    /**
     * Executes the command represented by the given tokens.
     *
     * @param tokens are the tokens representing the command to execute.
     */
    void executeCommand(String[] tokens) {
        if (tokens.length == 0) {
            throw new IllegalArgumentException("No command to execute.");
        }
        switch (requireCommandName(tokens[0])) {
            case "play":
                if (tokens.length < 4) {
                    throw new IllegalArgumentException("For playing a piece, "
                            + "please enter its id and the position where to "
                            + "place it.");
                }
                play(parseInt(tokens[1]), parseInt(tokens[2]), parseInt(tokens[3]));
                break;
            case "show":
                display.printBoard();
                break;
            case "stock":
                display.printCurrentPlayerStock();
                break;
        }
    }

}
