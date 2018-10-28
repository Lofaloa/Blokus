package blokus.exception;

/**
 * Thrown to indicate that an action does not respect <i>Blokus</i> rules.
 *
 * @author g47923
 */
public class IllegalActionException extends RuntimeException {

    /**
     * Constructs an instance of <code>ModelException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public IllegalActionException(String msg) {
        super(msg);
    }
}
