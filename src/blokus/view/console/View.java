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
     * @param container is the piece containing the square to print.
     */
    public void printSquare(Piece container) {
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
     * Prints the current state of the game board.
     */
    public void printBoard() {
        Piece[][] board = game.getBoard();
        for (int i = 0; i < 20; i++) {
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
    public void printPiece(Piece piece) {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                if (piece.contains(i, j)) {
                    printSquare(piece);
                }
            }
            System.out.println(" ");
        }
    }

    /**
     * Prints the stock of the current player.
     */
    public void printCurrentPlayerStock() {
        for (Piece piece : game.getCurrentPlayerStock()) {
            printPiece(piece);
        }
    }

}

class TestView {

    public static void main(String[] args) {
        Game g = new Game();
        View view = new View(g);
        g.selectCurrentPlayerPiece(21);
        g.placePiece(5, 5);
        g.nextPlayer();
        g.selectCurrentPlayerPiece(19);
        g.placePiece(0, 0);
//        view.printBoard();
        view.printCurrentPlayerStock();
    }
}
