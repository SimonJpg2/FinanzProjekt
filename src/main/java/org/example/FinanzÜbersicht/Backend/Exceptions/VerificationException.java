package org.example.FinanzÜbersicht.Backend.Exceptions;

/**
 * Class VerificationException.
 * <p>
 *     Is thrown when an email error occurs.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 * @see java.lang.RuntimeException
 */

public class VerificationException extends RuntimeException {
    public VerificationException(String message) {
        super(message);
    }

    public VerificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
