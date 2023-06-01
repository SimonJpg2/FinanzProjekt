package org.example.FinanzÜbersicht.Backend.Security;

/**
 * Class BadCharacters.
 * <p>
 *     This class has one static field holding characters, which could lead to an SQL-Injection.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 */
public class BadCharacters {
    public static final String[] FORBIDDEN = {"'", "\"", "<", ">", "&", "*", ";"};
}
