package org.example.FinanzÜbersicht.Backend.Exceptions;

/**
 * Class ConnectionFailedException.
 * <p>
 *     Custom Exception if connection to database failed.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 * @see java.lang.RuntimeException
 */

public class ConnectionFailedException extends RuntimeException {

    public ConnectionFailedException(String message) {
        super(message);
    }

    public ConnectionFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
