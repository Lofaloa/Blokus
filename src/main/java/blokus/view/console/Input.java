package blokus.view.console;

import java.util.Scanner;

/**
 * Manages the input of the user.
 *
 * @author Logan Farci (47923)
 */
class Input {

    private final Scanner in;

    public Input() {
        this.in = new Scanner(System.in, "utf-8");
    }

    /**
     * Reads the current a command.
     *
     * @return the tokens of the read command.
     */
    String[] readCommand() {
        String line = in.nextLine();
        while (line.length() == 0) {
            line = in.nextLine();
        }
        return line.split("\\s+");
    }

    boolean askConfirmation() {
        String answer = in.nextLine();
        while (answer.equals("y") && answer.equals("n")) {
            answer = in.nextLine();
        }
        return answer.equals("y");
    }

}
