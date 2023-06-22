package org.example.FinanzÜbersicht.Backend.Service;

import org.example.FinanzÜbersicht.Backend.Database.User;
import org.example.FinanzÜbersicht.Backend.Entity.UserEntity;
import org.example.FinanzÜbersicht.Backend.Security.SHA256;
import org.example.FinanzÜbersicht.Backend.Exceptions.SecurityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.FinanzÜbersicht.Backend.Security.BadCharacters.*;

/**
 * Class UserService.
 *
 * <p>
 *     Service class for Object Relational Mapping.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 * @see org.example.FinanzÜbersicht.Backend.Database.User
 */
public class UserService implements User {
    private final Connection connection;
    private final SHA256 sha256;
    private ResultSet resultSet;

    /**
     * Constructor UserService.
     * <p>
     *     Initializes UserService.
     * </p>
     * @param connection {@link java.sql.Connection} to database.
     * @param sha256 {@link org.example.FinanzÜbersicht.Backend.Security.SHA256} reference to hash sensible data.
     */
    public UserService(Connection connection, SHA256 sha256) {
        this.connection = connection;
        this.sha256 = sha256;
    }

    /**
     * Method select.
     * <p>
     *     Sends statement to get all entries.
     * </p>
     * @return a {@link java.util.List} with all users.
     */
    @Override
    public List<UserEntity> select() {
        List<UserEntity> entities = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM User");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                entities.add(
                        new UserEntity(
                                resultSet.getInt(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4)
                        )
                );
            }
            statement.close();
            return entities;
        } catch (SQLException e) {
            System.err.printf("(!) WARNING: SQL Query failed:%n%s%n%s%n", e.getMessage(), e.getCause().toString());
            e.printStackTrace();
            resultSet = null;
            return new ArrayList<>();
        }
    }

    /**
     * Method selectById.
     * <p>
     *     Sends statement to get an user by id.
     * </p>
     * @param id id of user
     * @return a {@link org.example.FinanzÜbersicht.Backend.Entity.UserEntity} the specified user.
     */
    @Override
    public UserEntity selectById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM User WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            UserEntity userEntity = new UserEntity(
                    id,
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
            statement.close();
            return userEntity;
        } catch (SQLException e) {
            System.err.printf("(!) WARNING: SelectById Query failed:%n%s%n%s%n", e.getMessage(), e.getCause().toString());
            e.printStackTrace();
            resultSet = null;
            return new UserEntity();
        }
    }

    /**
     * Method create.
     * <p>
     *     Sends statement to store a new user in the database.
     * </p>
     * @param userEntity the {@link org.example.FinanzÜbersicht.Backend.Entity.UserEntity} to be stored.
     * @return a {@link java.lang.Boolean} if succeeded.
     */
    @Override
    public boolean create(UserEntity userEntity) {
        String username = userEntity.getUsername();
        String email = userEntity.getEmail();
        String password = userEntity.getPassword();
        try {
            for (String s : FORBIDDEN) {
                if (username.contains(s) || email.contains(s) || password.contains(s)) {
                    throw new SecurityException("Forbidden char entered by user, could lead to SQL-Injection.");
                }
            }
            PreparedStatement statement = connection.prepareStatement("INSERT INTO User (benutzer_name, email, passwort) VALUES (?, ?, ?)");
            statement.setString(1, username);
            statement.setString(2, sha256.hash(email));
            statement.setString(3, sha256.hash(password));
            boolean success = statement.executeUpdate() > 0;
            statement.close();
            return success;
        } catch (SQLException | SecurityException e) {
            System.err.printf("(!) WARNING: Create user statement failed:%n%s%n", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Method update.
     * <p>
     *     Sends statement to update an existing user.
     * </p>
     * @param id id of user.
     * @param userEntity the {@link org.example.FinanzÜbersicht.Backend.Entity.UserEntity} to be updated.
     * @return a {@link java.lang.Boolean} if succeeded.
     */
    @Override
    public boolean update(int id, UserEntity userEntity) {
        String username = userEntity.getUsername();
        String email = userEntity.getEmail();
        String password = userEntity.getPassword();
        try {
            for (String s : FORBIDDEN) {
                if (username.contains(s) || email.contains(s) || password.contains(s)) {
                    throw new SecurityException("Forbidden char entered by user, could lead to SQL-Injection.");
                }
            }
            PreparedStatement statement = connection.prepareStatement("UPDATE User SET benutzer_name = ? email = ? passwort = ? WHERE id = ?");
            statement.setString(1, username);
            statement.setString(2, sha256.hash(email));
            statement.setString(3, sha256.hash(password));
            statement.setInt(4, id);
            boolean success = statement.executeUpdate() > 0;
            statement.close();
            return success;
        } catch (SQLException | SecurityException e) {
            System.err.printf("(!) Update user statement failed:%n%s%n", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Method updateById.
     *
     * <p>
     *      Sends statement to update an existing user.
     * </p>
     * @param id id of User to be updated.
     * @param userEntity the new {@link org.example.FinanzÜbersicht.Backend.Entity.UserEntity}
     * @return if succeeded
     */

    @Override
    public boolean updateById(int id, UserEntity userEntity) {
        String password = userEntity.getPassword();
        try {
            for (String s : FORBIDDEN) {
                if (password.contains(s)) {
                    throw new SecurityException("Forbidden char entered by user, could lead to SQL-Injection.");
                }
            }
            PreparedStatement statement = connection.prepareStatement("UPDATE User SET passwort = ? WHERE id = ?");
            statement.setString(1, sha256.hash(password));
            statement.setInt(2, id);
            boolean success = statement.executeUpdate() > 0;
            statement.close();
            return success;
        } catch (SQLException | SecurityException e) {
            System.err.printf("(!) WARNING: Update user statement failed:%n%s%n", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Method delete.
     * <p>
     *     Sends statement to delete an existing user.
     * </p>
     * @param id id of user.
     * @return a {@link java.lang.Boolean} if succeeded.
     */
    @Override
    public boolean delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM User WHERE id = ?");
            statement.setInt(1, id);
            boolean success = statement.executeUpdate() > 0;
            statement.close();
            return success;
        } catch (SQLException e) {
            System.err.printf("(!) WARNING: Delete user statement failed:%n%s%n%s%n", e.getMessage(), e.getCause().toString());
            e.printStackTrace();
            return false;
        }
    }
}
