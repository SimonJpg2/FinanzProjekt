package org.example.FinanzÜbersicht.Backend.Database;

import org.example.FinanzÜbersicht.Backend.Exceptions.ConnectionFailedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class DatabaseConnector.
 * <p>
 *     Contains logic to establish a database connection.
 * </p>
 * @author Simon Balcke
 * @version 1.0
 */
public class DatabaseConnector {
    private final String url;
    private Connection connection;

    public DatabaseConnector(String url) {
        this.url = url;
    }

    public DatabaseConnector() {
        this.url = "jdbc:mysql://db4free.net:3306/finances";
    }

    /**
     * Method connect.
     * <p>
     *     Connects to MySQL-Database.
     * </p>
     *
     * @return a {@link java.sql.Connection} to database.
     * @throws ConnectionFailedException if connection fails.
     */
    public Connection connect() throws ConnectionFailedException {
        String password = "R8EMJurt02Huitjajpv9";
        String username = "project_dev";
        System.out.println("(~) Connecting to MySQL database.");
        try {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            throw new ConnectionFailedException("Connection to Database finances failed. \n", e.getCause());
        }
    }

    /**
     * Method disconnect.
     * <p>
     *     Closes connection to database.
     * </p>
     */
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.printf("(!) Connection can't be closed.%n%s%n", e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("(!) Connection can't be closed, because there is no connection.\n");
        }
    }
}
