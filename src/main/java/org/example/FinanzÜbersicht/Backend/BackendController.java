package org.example.FinanzÜbersicht.Backend;

import org.example.FinanzÜbersicht.Backend.Database.DatabaseConnector;
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
    private UserService userService;
    private FinanzService finanzService;

    /**
     *  <h3>Constructor BackendController</h3>
     * <p>
     *     Initializes the backend of the application.
     * </p>
     *
     * <p>
     *     If ConnectionFailedException is thrown, services are null.
     * </p>
     * @param sha256 {@link org.example.FinanzÜbersicht.Backend.Security.SHA256} reference to hash sensible data.
     * @see org.example.FinanzÜbersicht.Backend.Exceptions.ConnectionFailedException
     */
    public BackendController(SHA256 sha256) {
        try {
            // Initialize database connection.
            Connection databaseConnection = new DatabaseConnector().connect();
            System.out.println("(+) INFO: Connection to database established.\n(~) INFO: Initializing services.");

            // Initialize services.
            userService = new UserService(databaseConnection, sha256);
            finanzService = new FinanzService(databaseConnection);
            System.out.println("(+) INFO: Services initialized successfully.");
        } catch (ConnectionFailedException e) {
            System.err.printf("(!) WARNING: %s", e.getMessage());
            System.err.println("(!) WARNING: Services not initialized.");
            userService = null;
            finanzService = null;
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
