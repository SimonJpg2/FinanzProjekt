package org.example.FinanzÜbersicht.Backend.Exceptions;

/**
 * Class SecurityException.
 * <p>
 *     Is thrown if security issues occur.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 * @see java.lang.RuntimeException
 */
public class SecurityException extends RuntimeException {
    public SecurityException(String message) {
        super(message);
    }

    public SecurityException(String message, Throwable cause) {
        super(message, cause);
    }
}
