package com.myproject.dao;

import com.myproject.connectionmanager.ConnectionManager;
import com.myproject.pojo.Laptop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * LaptopDaoJdbcImpl.
 *
 * @author Roman Khokhlov
 */
public class LaptopDaoJdbcImpl implements LaptopDao {
    public static final String INSERT_INTO_PRODUCTS = "INSERT INTO products values (DEFAULT, ?, ?, ?)";
    public static final String SELECT_FROM_PRODUCTS = "SELECT * FROM products WHERE id = ?";
    public static final String SELECT_ALL_FROM_PRODUCTS = "SELECT * FROM products";
    public static final String UPDATE_PRODUCTS = "UPDATE products SET name=?, productGroup=?, price=? WHERE id=?";
    public static final String DELETE_FROM_PRODUCTS = "DELETE FROM products WHERE id=?";
    public static final String CREATE_TABLE_PRODUCTS
            = "DROP TABLE IF EXISTS products;\n"
            + "create table products\n"
            + "(\n"
            + "    id int \n"
            + "    auto_increment\n"
            + "    primary key,\n"
            + "    name varchar(100),\n"
            + "    productGroup varchar(100),\n"
            + "    price double\n"
            + ");\n";

    private static final Logger LOGGER = LoggerFactory.getLogger(LaptopDaoJdbcImpl.class);
    private ConnectionManager connectionManager;

    @Inject
    public LaptopDaoJdbcImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public boolean addLaptop(Laptop laptop) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_PRODUCTS)) {
            preparedStatement.setString(1, laptop.getName());
            preparedStatement.setString(2, laptop.getProductGroup());
            preparedStatement.setDouble(3, laptop.getPrice());
            preparedStatement.execute();

        } catch (SQLException e) {
            LOGGER.error("Something wrong in addLaptop method", e);
            return false;
        }
        return true;
    }

    @Override
    public Laptop getLaptopById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_PRODUCTS)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Laptop(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4));
                }
            }
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in getLaptopById method", e);
        }
        return null;
    }

    @Override
    public void createTable() {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_PRODUCTS)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in createTable method", e);
        }
    }

    @Override
    public List<Laptop> getAllLaptop() {
        List<Laptop> laptops = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FROM_PRODUCTS);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                laptops.add(new Laptop(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDouble(4)));
            }
            return laptops;
        } catch (SQLException e) {
            LOGGER.error("Some thing wrong in getLaptopById method", e);
        }
        return new ArrayList<>();
    }


}



