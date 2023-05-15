package org.example.FinanzÜbersicht.Backend.Service;

import org.example.FinanzÜbersicht.Backend.Database.Finances;
import org.example.FinanzÜbersicht.Backend.Entity.FinanzEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FinanzService implements Finances {
    private final Connection connection;
    private ResultSet resultSet;

    public FinanzService(Connection connection) {
        this.connection = connection;
    }

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
                                resultSet.getDouble(2)
                        )
                );
            }
            statement.close();
            resultSet.close();
            return entities;
        } catch (SQLException e) {
            System.err.printf("Select finanzen statement failed:%n%s%n", e.getMessage());
            e.printStackTrace();
            resultSet = null;
            return new ArrayList<>();
        }
    }

    @Override
    public FinanzEntity selectById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Finanzen WHERE id = ?");
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            FinanzEntity finanzEntity = new FinanzEntity(
                    resultSet.getInt(1),
                    resultSet.getDouble(2)
            );
            statement.close();
            resultSet.close();
            return finanzEntity;
        } catch (SQLException e) {
            System.err.printf("SelectById finanzen statement failed:%n%s%n", e.getMessage());
            e.printStackTrace();
            resultSet = null;
            return new FinanzEntity();
        }
    }

    @Override
    public boolean create(FinanzEntity finanzEntity) {
        // TODO: Check for illegal chars
        // TODO: Hash password before insertion
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Finanzen (value) VALUES (?)");
            statement.setDouble(1, finanzEntity.getValue());
            statement.close();
            return true;
        } catch (SQLException e) {
            System.err.printf("Create finanz statement failed:%n%s%n", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(int id, FinanzEntity finanzEntity) {
        // TODO: Check for illegal chars
        // TODO: Hash password before insertion
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Finanzen SET vale = ? WHERE id = ?");
            statement.setDouble(1, finanzEntity.getValue());
            statement.setInt(2, id);
            boolean success = statement.executeUpdate() > 0;
            statement.close();
            return success;
        } catch (SQLException e) {
            System.err.printf("Update finanz statement failed:%n%s%n", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Finanzen WHERE id = ?");
            statement.setInt(1, id);
            boolean success = statement.executeUpdate() > 0;
            statement.close();
            return success;
        } catch (SQLException e) {
            System.err.printf("Delete finanz statement failed:%n%s%n", e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
