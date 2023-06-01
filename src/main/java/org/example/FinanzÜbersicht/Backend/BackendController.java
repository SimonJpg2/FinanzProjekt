package org.example.FinanzÜbersicht.Backend;

import org.example.FinanzÜbersicht.Backend.Database.DatabaseConnector;
import org.example.FinanzÜbersicht.Backend.Database.Finances;
import org.example.FinanzÜbersicht.Backend.Database.User;
import org.example.FinanzÜbersicht.Backend.Exceptions.ConnectionFailedException;
import org.example.FinanzÜbersicht.Backend.Security.SHA256;
import org.example.FinanzÜbersicht.Backend.Service.FinanzService;
import org.example.FinanzÜbersicht.Backend.Service.UserService;

import java.sql.Connection;

/**
 * Class BackendController.
 * <p>
 *     Coordinates backend logic.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 */
public class BackendController {
    private final UserService userService;
    private final FinanzService finanzService;

    /**
     * Constructor BackendController.
     * <p>
     *     Initializes the backend of the application.
     * </p>
     */
    public BackendController(SHA256 sha256) {
        // initialize database connection.
        Connection databaseConnection = initDatabase();

        // avoid NullPointerException.
        if (databaseConnection == null) {
            userService = null;
            finanzService = null;
            System.err.println("(!) Services not initialized.");
            return;
        }
        System.out.println("(+) Connection to database established.\n(~) Initializing services.");
        // initialize the services.
        userService = new UserService(databaseConnection, sha256);
        finanzService = new FinanzService(databaseConnection);
        System.out.println("(+) Services initialized successfully.");
    }

    /**
     * Method init.
     * <p>
     *     Initializes connection to database.
     *     If connection fails, null is returned.
     * </p>
     * @return a {@link java.sql.Connection} or null.
     */
    private Connection initDatabase() {
        try {
            return new DatabaseConnector().connect();
        } catch (ConnectionFailedException e) {
            System.err.printf("(!) Database initialization failed%n%s", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Method getUserService.
     * @return {@link org.example.FinanzÜbersicht.Backend.Service.UserService} or null
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * Method getFinanzService.
     * @return {@link org.example.FinanzÜbersicht.Backend.Service.FinanzService} or null
     */
    public FinanzService getFinanzService() {
        return finanzService;
    }
}
