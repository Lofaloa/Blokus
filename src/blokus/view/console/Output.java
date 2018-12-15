package blokus.view.console;

import blokus.model.Blokus;
import blokus.model.BlokusColor;
import blokus.model.Piece;
import blokus.model.Player;
import blokus.model.Stock;

/**
 * Manages the display of the game.
 *
 * @author Logan Farci (47923)
 */
class Output {

    private final Blokus game;

    /**
     * Initializes this view for the given game.
     *
     * @param game is the game for which manage the view.
     */
    Output(Blokus game) {
        this.game = game;
    }

    /**
     * Prints the title of the game.
     */
    void printTitle() {
        System.out.println("BLOKUS - Logan Farci (47923), cours d'ateliers logiciel");
        System.out.println("Hi! Type \"help\" to print the commands of the game and their actions");
    }

    void printCommand(String name, String description) {
        System.out.printf("%-25s%-5s\n", name, description);
    }

    /**
     * Prints a help for the players.
     */
    void printHelp() {
        System.out.println("**Commands list**");
        printCommand("play n i j r", "places the piece n of the current player"
                + " stock in the board at row i, column j rotated r times.");
        printCommand("show", "shows the board of the game at its current state.");
        printCommand("stock", "shows the stock of the current player");
        printCommand("miss", "makes the current play miss the current turn");
        printCommand("withdraw", "makes the current player withdraw from the game");
        printCommand("players", "prints all the players with their state and score");
        printCommand("restart", "restarts the game");
        printCommand("help", "prints this command list");
        printCommand("exit", "exit the game.");
    }

    /**
     * Prints the message of the given exception.
     *
     * @param exception is the exception to print the message for.
     */
    void printExceptionMessage(Exception exception) {
        System.err.println(exception.getMessage());
    }

    /**
     * Prints a message telling the current player.
     */
    void printCurrentPlayer() {
        System.out.println(game.getCurrentPlayer().getColor() + " is playing...");
    }

    /**
     * Prints the score of the current player.
     */
    void printCurrentPlayerScore() {
        System.out.println(game.getCurrentPlayer().getColor() + " player, your"
                + " current score is " + game.getCurrentPlayer().getScore() + "!");
    }

    /**
     * Prints a rotation message.
     *
     * @param rotation is the number of rotation.
     */
    void printRotation(int rotation) {
        if (rotation > 0) {
            System.out.println("You just rotate your piece " + rotation + " times.");
        }
    }

    void printRestart() {
        System.out.print("Are you sure? The progress will be lost. (y/ n) ");
    }

    /**
     * Prints all the players of the game with their score and state.
     */
    void printPlayers() {
        for (Player player : game.getPlayers()) {
            System.out.println(player.getColor() + " is " + player.getState() + "(score: " + player.getScore() + ").");
        }
    }

    /**
     * Prints an empty square.
     */
    void printEmptySquare() {
        System.out.print(" . ");
    }

    /**
     * Prints a square of the given color name.
     *
     * @param color is the color name of the square to print.
     */
    void printFilledSquare(BlokusColor color) {
        switch (color) {
            case BLUE:
                System.out.print(" b ");
                break;
            case YELLOW:
                System.out.print(" y ");
                break;
            case RED:
                System.out.print(" r ");
                break;
            default:
                System.out.print(" g ");
        }
    }

    /**
     * Prints a square.
     *
     * @param color is the color name of the square to print if filled.
     */
    void printSquare(BlokusColor color) {
        if (color == null) {
            printEmptySquare();
        } else {
            printFilledSquare(color);
        }
    }

    /**
     * Prints the columns number of the board.
     */
    void printColumnNumbers() {
        System.out.printf("%4c", ' ');
        for (int i = 0; i < 20; i++) {
            System.out.printf("%02d ", i);
        }
        System.out.println(" ");
    }

    /**
     * Prints the current state of the game board.
     */
    void printBoard() {
        printColumnNumbers();
        for (int row = 0; row < 20; row++) {
            System.out.printf("%02d ", row);
            for (int column = 0; column < 20; column++) {
                printSquare(game.getBoard().getColorAt(row, column));
            }
            System.out.println(" ");
        }
    }

    /**
     * Prints the given piece.
     *
     * @param piece is the piece to print.
     */
    void print(Piece piece) {
        for (int i = 0; i < piece.getSize(); i++) {
            for (int j = 0; j < piece.getSize(); j++) {
                if (piece.contains(i, j)) {
                    System.out.print(" x ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println(" ");
        }
    }

    /**
     * Prints current player stock.
     */
    void printCurrentPlayerStock() {
        for (int i = 0; i < Stock.CAPACITY; i++) {
            Piece piece = game.getCurrentPlayer().getStock().get(i);
            if (game.getCurrentPlayer().owns(piece)) {
                print(piece);
                System.out.println(" ");
            }
        }
    }

    /**
     * Prints winners of the game.
     */
    void printWinners() {
        game.getWinner().forEach(winner -> {
            System.out.print(winner.getColor() + " player, ");
        });
        System.out.println("win the game.");
    }

    /**
     * Prints end.
     */
    void printEnd() {
        System.out.println("End of the game!");
        printWinners();
        System.out.print("Do you want to restart the game? (y/ n) ");
    }

}
