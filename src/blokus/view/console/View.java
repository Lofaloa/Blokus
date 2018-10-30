package blokus.view.console;

import blokus.model.Game;
import blokus.model.Piece;
import java.util.Scanner;

/**
 * Manages the user interaction.
 *
 * @author g47923
 */
public class View {

    private final Scanner in;
    private final Game game;

    /**
     * Initializes this view for the given game.
     *
     * @param game is the game for which manage the view.
     */
    public View(Game game) {
        this.in = new Scanner(System.in);
        this.game = game;
    }

    /**
     * Prints the given piece.
     *
     * @param piece is the piece to print.
     */
    public void print(Piece piece) {
        switch (piece.getColor()) {
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
     * Prints the current state of the game board.
     */
    public void printBoard() {
        Piece[][] board = game.getBoard();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (board[i][j] == null) {
                    System.out.print(" . ");
                } else {
                    print(board[i][j]);
                }
            }
            System.out.println(" ");
        }
    }

    public void printCurrentPlayerStock() {

    }

}
