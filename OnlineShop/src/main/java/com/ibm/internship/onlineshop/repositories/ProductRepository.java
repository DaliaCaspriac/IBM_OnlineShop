package com.ibm.internship.onlineshop.repositories;

import com.ibm.internship.onlineshop.model.Product;
import com.ibm.internship.onlineshop.utils.jdbc.MySQLConnectionUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    /**
     * Get all products
     *
     * @return a list of products
     * @throws IllegalAccessException if the execution of query fails
     * @throws ClassNotFoundException
     */
    public List<Product> getAllProducts() throws IllegalAccessException, ClassNotFoundException {
        try {
            PreparedStatement statement = createPreparedStatementToGetAllProducts();
            ResultSet resultSet = statement.executeQuery();
            return getProductRecords(resultSet);
        } catch (SQLException e) {
            throw new IllegalAccessException(e.getMessage());
        }
    }

    /**
     * Create a statement to get all products from database
     *
     * @return a PreparedStatement
     * @throws ClassNotFoundException
     * @throws IllegalAccessException if the creation of PreparedStatement fails
     */
    private static PreparedStatement createPreparedStatementToGetAllProducts() throws ClassNotFoundException, IllegalAccessException {
        Connection connection = startConnection();
        try {
            String sql = "SELECT * FROM Products";
            PreparedStatement statement = connection.prepareStatement(sql);
            return statement;
        } catch (SQLException e) {
            throw new IllegalAccessException(e.getMessage());
        } finally {
            //connection.close();
        }
    }

    /**
     * Filter products by category
     *
     * @param categoryCode - specified category code
     * @return a list with filtered products
     * @throws ClassNotFoundException
     * @throws IllegalAccessException if the execution of query fails
     */
    public List<Product> getProductsByCategory(int categoryCode) throws ClassNotFoundException, IllegalAccessException {
        try {
            PreparedStatement statement = createPreparedStatementToGetProductsByCategory(categoryCode);
            ResultSet resultSet = statement.executeQuery();
            return getProductRecords(resultSet);
        } catch (SQLException e) {
            throw new IllegalAccessException(e.getMessage());
        }
    }

    /**
     * Retrieve values from ResultSet and parse them to Product
     *
     * @param resultSet -
     * @return list of Product objects
     * @throws IllegalAccessException
     */
    private static List<Product> getProductRecords(ResultSet resultSet) throws IllegalAccessException {
        List<Product> products = new ArrayList<>();
        Product product;
        try {
            while (resultSet.next()) {
                product = new Product(resultSet.getInt("productCode"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("color"),
                        resultSet.getString("dimension"),
                        resultSet.getDouble("weight"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("quantity"),
                        resultSet.getInt("categoryCode"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new IllegalAccessException(e.getMessage());
        }
        return products;
    }

    /**
     * Create a statement to get products by category from database
     *
     * @param categoryCode
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    private static PreparedStatement createPreparedStatementToGetProductsByCategory(int categoryCode) throws ClassNotFoundException, IllegalAccessException {
        Connection connection = startConnection();
        try {

            String sql = "SELECT * FROM Products WHERE categoryCode = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, categoryCode);
            return statement;
        } catch (SQLException e) {
            throw new IllegalAccessException(e.getMessage());
        } finally {
            //connection.close();
        }
    }

    /**
     * Establish a connection to MySQL database
     *
     * @return Connection object
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    private static Connection startConnection() throws IllegalAccessException, ClassNotFoundException {
        return new MySQLConnectionUtils().getMySQLConnection();
    }
}
