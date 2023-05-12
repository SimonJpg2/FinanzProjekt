package org.example.FinanzÜbersicht.Backend.Entity;

/**
 * Class UserEntity.
 * <p>
 *     Object for a user containing information from or for the database.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 */
public class UserEntity {
    private final int id;
    private final String username;
    private final String email;
    private final String password;

    public UserEntity(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor UserEntity.
     * <p>
     *     Used if there is no information about user in the database.
     * </p>
     */
    public UserEntity() {
        id = -1;
        username = "";
        email = "";
        password = "";
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
