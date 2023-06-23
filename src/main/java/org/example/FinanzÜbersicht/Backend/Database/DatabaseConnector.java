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

    /**
     * Constructor DatabaseConnector.
     * <p>
     *     Used for testing purposes
     * </p>
     * @param url {@link java.lang.String} to test Database.
     */
    @SuppressWarnings("unused")
    public DatabaseConnector(String url) {
        this.url = url;
    }

    /**
     * Constructor DatabaseConnector.
     * <p>
     *     Default URL to database.
     * </p>
     */
    public DatabaseConnector() {
        /*
        * Change URL if you have an own database.
        * Pattern: "jdbc:mysql://{host}:{port}/{your database name}";
        * If your database is on your current machine, use localhost as host
        * Port 3306 is the default port for MySQL.
        */
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
        /*
        * Change the password and the username with your own credentials.
        * NOTE: Always use strong passwords for more security.
        */
        String password = "";
        String username = "";
        System.out.println("(~) INFO: Connecting to MySQL database.");
        try {
            connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            throw new ConnectionFailedException("Connection to database failed. \n", e.getCause());
        }
    }

    /**
     * Method disconnect.
     * <p>
     *     Closes connection to database.
     * </p>
     */
    @SuppressWarnings("unused")
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.printf("(!) ERROR: Connection can't be closed.%n%s%n", e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("(!) WARNING: Connection can't be closed, because there is no connection.\n");
        }
    }
}
