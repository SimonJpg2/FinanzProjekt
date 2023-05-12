package org.example.FinanzÜbersicht.Backend;

import org.example.FinanzÜbersicht.Backend.Database.DatabaseConnector;
import org.example.FinanzÜbersicht.Backend.Entity.UserEntity;
import org.example.FinanzÜbersicht.Backend.Exceptions.ConnectionFailedException;
import org.example.FinanzÜbersicht.Backend.Service.UserService;

import java.sql.Connection;
import java.util.List;

/**
 * Class BackendController.
 * <p>
 *     Coordinates backend logic.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 */
public class BackendController {
    /**
     * Constructor BackendController.
     * <p>
     *     Prepares backend of the application.
     * </p>
     */
    public BackendController() {
        // initialize database connection.
        Connection databaseConnection = init();

        // avoid NullPointerException.
        if (databaseConnection == null) {
            return;
        }
        // initialize logic for the user.
        UserService userService = new UserService(databaseConnection);
        List<UserEntity> entities = userService.select();

        for (UserEntity userEntity : entities) {
            System.out.println(userEntity.getUsername());
        }
    }

    /**
     * Method init.
     * <p>
     *     Initializes connection to database.
     *     If connection fails, null is returned.
     * </p>
     * @return a {@link java.sql.Connection} or null.
     */
    private Connection init() {
        try {
            return new DatabaseConnector().connect();
        } catch (ConnectionFailedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
