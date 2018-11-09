package blokus.exception;

/**
 * Thrown when the model of <i>Blokus</i> is not respected.
 * 
 * @author Logan Farci (47923)
 */
public class ModelException extends RuntimeException {
        
        /**
         * Initializes this exception with a message.
         * 
         * @param msg is the message to print when thrown.
         */
        public ModelException(String msg) {
            super(msg);
        }
    
}
