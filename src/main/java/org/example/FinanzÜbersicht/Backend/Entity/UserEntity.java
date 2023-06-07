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
    private int id;
    private final String username;
    private final String email;
    private final String password;

    /**
     * Constructor UserEntity
     *
     * <p>
     *     Is used to return data of the database.
     * </p>
     * @param id the id of the database table
     * @param username the username of the account
     * @param email the email address of the account
     * @param password the password of the account
     */

    public UserEntity(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor UserEntity.
     * <p>
     *     Is used to represent the user.
     * </p>
     * @param username the username of the account
     * @param email the email address of the account
     * @param password the password of the account
     */
    public UserEntity(String username, String email, String password) {
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
