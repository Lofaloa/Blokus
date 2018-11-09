package blokus.view.console;

import blokus.model.Blokus;

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

    /**
     * Prints a message telling the current player.
     */
    void printCurrentPlayer() {
        int currentPlayerId = game.getCurrentPlayerId();
        System.out.println(game.getPlayerColor(currentPlayerId) + " is playing...");
    }

    /**
     * Prints a prompt for the user.
     */
    void printPrompt() {
        System.out.print("> ");
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
    void printFilledSquare(String color) {
        switch (color) {
            case "BLUE":
                System.out.print(" b ");
                break;
            case "YELLOW":
                System.out.print(" y ");
                break;
            case "RED":
                System.out.print(" r ");
                break;
            case "GREEN":
                System.out.print(" g ");
                break;
        }
    }

    /**
     * Prints a square.
     *
     * @param color is the color name of the square to print if filled.
     */
    void printSquare(String color) {
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
                printSquare(game.getBoardColorAt(row, column));
            }
            System.out.println(" ");
        }
    }

    /**
     * Prints the given piece.
     *
     * @param shapeId is piece to print.
     */
    void printPiece(int shapeId) {
        for (int i = 0; i < game.getShapeSize(shapeId); i++) {
            for (int j = 0; j < game.getShapeSize(shapeId); j++) {
                if (game.isInsideShape(shapeId, i, j)) {
                    System.out.print(" x ");
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
        int currentPlayerId = game.getCurrentPlayerId();
        for (int pieceId = 0; pieceId < 21; pieceId++) {
            if (game.playerOwnsPieceOf(currentPlayerId, pieceId)) {
                printPiece(pieceId);
            }
            System.out.println(" ");
        }
    }

}
