package blokus.exception;

/**
 * Thrown to indicate that an action does not respect <i>Blokus</i> rules.
 *
 * @author g47923
 */
public class IllegalActionException extends RuntimeException {

    private final int id;

    /**
     * Initializes this <code>IllegalActionException</code> with a message.
     *
     * @param msg is the message of this exception.
     */
    public IllegalActionException(String msg) {
        super(msg);
        this.id = 0;
    }

    /**
     * Initializes this <code>IllegalActionException</code> with a message and
     * an id.
     *
     * @param msg is the message of this exception.
     */
    public IllegalActionException(int id, String msg) {
        super(msg);
        this.id = id;
    }

    /**
     * Gets this exception id.
     *
     * @return this exception id.
     */
    public int getId() {
        return id;
    }

}
