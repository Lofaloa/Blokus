package blokus.view.console;

import blokus.model.Game;
import blokus.model.Piece;

/**
 * Manages the display of the game.
 *
 * @author g47923
 */
class Output {

    private final Game game;

    /**
     * Initializes this view for the given game.
     *
     * @param game is the game for which manage the view.
     */
    Output(Game game) {
        this.game = game;
    }

    /**
     * Prints the title of the game.
     */
    void printTitle() {
        System.out.println("BLOKUS - Logan Farci (47923), cours d'ateliers logiciel");
    }

    /**
     * Prints a help for the players.
     */
    void printHelp() {
        System.out.println("COMMANDS:");
        System.out.println("show - shows the board of the game");
        System.out.println("stock - shows the stock of the current player");
        System.out.println("play n i j - place the piece n of the current player"
                + " stock in the board a (i; j).");
    }

    void printCurrentPlayer() {
        System.out.println(game.getCurrentPlayer().getColor() + " is playing...");
    }

    /**
     * Prints a prompt for the user.
     */
    void printPrompt() {
        System.out.print("> ");
    }

    /**
     * Prints the given piece.
     *
     * @param container is the piece containing the square to print.
     */
    void printSquare(Piece container) {
        switch (container.getColor()) {
            case BLUE:
                System.out.print(" b ");
                break;
            case YELLOW:
                System.out.print(" y ");
                break;
            case RED:
                System.out.print(" r ");
                break;
            case GREEN:
                System.out.print(" g ");
                break;
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
        Piece[][] board = game.getBoard();
        printColumnNumbers();
        for (int i = 0; i < 20; i++) {
            System.out.printf("%02d ", i);
            for (int j = 0; j < 20; j++) {
                if (board[i][j] == null) {
                    System.out.print(" . ");
                } else {
                    printSquare(board[i][j]);
                }
            }
            System.out.println(" ");
        }
    }

    /**
     * Prints the given piece.
     *
     * @param piece is piece to print.
     */
    void printPiece(Piece piece) {
        System.out.println(piece.getShape());
        for (int i = 0; i < piece.getShape().getSize(); i++) {
            for (int j = 0; j < piece.getShape().getSize(); j++) {
                if (piece.contains(i, j)) {
                    printSquare(piece);
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println(" ");
        }
    }

    /**
     * Prints the stock of the current player.
     */
    void printCurrentPlayerStock() {
        for (Piece piece : game.getCurrentPlayerStock()) {
            printPiece(piece);
        }
    }

}