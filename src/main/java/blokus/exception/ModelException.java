package blokus.exception;

/**
 * Thrown when the integrity of <i>Blokus</i> is not respected.
 *
 * @author Logan Farci (47923)
 */
public class ModelException extends RuntimeException {

    private final int id;

    /**
     * Initializes this <code>ModelException</code> with a message.
     *
     * @param msg is the message of this exception.
     */
    public ModelException(String msg) {
        super(msg);
        this.id = 0;
    }

    /**
     * Initializes this <code>ModelException</code> with a message and an id.
     *
     * @param id is the id of this exception.
     * @param msg is the message of this exception.
     */
    public ModelException(int id, String msg) {
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
