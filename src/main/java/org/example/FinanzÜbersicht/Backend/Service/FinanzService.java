package org.example.FinanzÜbersicht.Backend.Service;

import org.example.FinanzÜbersicht.Backend.Database.Finances;
import org.example.FinanzÜbersicht.Backend.Entity.FinanzEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class FinanzService.
 * <p>
 *     Service class for Object Relational Mapping
 * </p>
 * @author Simon Balcke
 * @version 1.0
 * @see org.example.FinanzÜbersicht.Backend.Database.Finances
 */
public class FinanzService implements Finances {
    private final Connection connection;
    private ResultSet resultSet;

    public FinanzService(Connection connection) {
        this.connection = connection;
    }

    /**
     * Method select.
     * <p>
     *     Sends statement to get all entries.
     * </p>
     * @return a {@link java.util.List} with all FinanzEntities.
     */
    @Override
    public List<FinanzEntity> select() {
        List<FinanzEntity> entities = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Finanzen");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                entities.add(
                        new FinanzEntity(
                                resultSet.getInt(1),
                                resultSet.getDate(2),
                                resultSet.getDouble(3)
                        )
                );
            }
            statement.close();
            return entities;
        } catch (SQLException e) {
            System.err.printf("(!) Select finanzen statement failed:%n%s%n", e.getMessage());
            e.printStackTrace();
            resultSet = null;
            return new ArrayList<>();
        }
    }

    /**
     * Method selectById.
     * <p>
     *     Sends statement to get an FinanzEntity by id.
     * </p>
     * @param id id of entity
     * @return a {@link org.example.FinanzÜbersicht.Backend.Entity.FinanzEntity} the specified FinanzEntity.
     */
    @Override
    public FinanzEntity selectById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Finanzen WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            FinanzEntity finanzEntity = new FinanzEntity(
                    resultSet.getInt(1),
                    resultSet.getDate(2),
                    resultSet.getDouble(3)
            );
            statement.close();
            return finanzEntity;
        } catch (SQLException e) {
            System.err.printf("(!) SelectById finanzen statement failed:%n%s%n", e.getMessage());
            e.printStackTrace();
            resultSet = null;
            return new FinanzEntity();
        }
    }

    /**
     * Method create.
     * <p>
     *     Sends statement to store a new FinanzEntity in the database.
     * </p>
     * @param finanzEntity the {@link org.example.FinanzÜbersicht.Backend.Entity.FinanzEntity} to be stored.
     * @return a {@link java.lang.Boolean} if succeeded.
     */
    @Override
    public boolean create(FinanzEntity finanzEntity) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Finanzen (date, value) VALUES (?, ?)");
            statement.setDate(1 , finanzEntity.getDate());
            statement.setDouble(2, finanzEntity.getValue());
            boolean success = statement.executeUpdate() > 0;
            statement.close();
            return success;
        } catch (SQLException e) {
            System.err.printf("(!) Create finanz statement failed:%n%s%n", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Method update.
     * <p>
     *     Sends statement to update an existing FinanzEntity.
     * </p>
     * @param id id of FinanzEntity.
     * @param finanzEntity the {@link org.example.FinanzÜbersicht.Backend.Entity.FinanzEntity} to be updated.
     * @return a {@link java.lang.Boolean} if succeeded.
     */
    @Override
    public boolean update(int id, FinanzEntity finanzEntity) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Finanzen SET date = ?, value = ? WHERE id = ?");
            statement.setDate(1, finanzEntity.getDate());
            statement.setDouble(2, finanzEntity.getValue());
            statement.setInt(3, id);
            boolean success = statement.executeUpdate() > 0;
            statement.close();
            return success;
        } catch (SQLException e) {
            System.err.printf("(!) Update finanz statement failed:%n%s%n", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Method delete.
     * <p>
     *     Sends statement to delete an existing FinanzEntity.
     * </p>
     * @param id id of FinanzEntity.
     * @return a {@link java.lang.Boolean} if succeeded.
     */
    @Override
    public boolean delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Finanzen WHERE id = ?");
            statement.setInt(1, id);
            boolean success = statement.executeUpdate() > 0;
            statement.close();
            return success;
        } catch (SQLException e) {
            System.err.printf("(!) Delete finanz statement failed:%n%s%n", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
