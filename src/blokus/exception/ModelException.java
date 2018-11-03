package blokus.exception;

/**
 * Thrown when the model of <i>Blokus</i> is not respected.
 * 
 * @author Logan Farci (47923)
 */
public class ModelException extends RuntimeException {
        
        public ModelException(String msg) {
            super(msg);
        }
    
}
