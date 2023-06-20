package org.example.FinanzÜbersicht.Backend.Security;

import java.security.NoSuchAlgorithmException;

import static java.nio.charset.StandardCharsets.*;
import static java.security.MessageDigest.getInstance;

/**
 * Class SHA256.
 * <p>
 *     This class contains logic to hash sensitive userdata.
 * </p>
 * @version 1.0
 * @author Simon Balcke
 */
public class SHA256 {
    /**
     * Method hash.
     * <p>
     *     Uses SHA256 algorithm to hash sensitive data.
     * </p>
     * @param plaintext the text to be hashed.
     * @return the hash as {@link java.lang.String}.
     * @throws SecurityException if encryption fails.
     */
    public String hash(String plaintext) throws SecurityException {
        byte[] plaintextBytes = plaintext.getBytes(UTF_8);
        try {
            return new String(getInstance("SHA-256").digest(plaintextBytes));
        } catch (NoSuchAlgorithmException e) {
            throw new SecurityException("Encryption failed: " + e.getMessage(), e.getCause());
        }
    }
}
