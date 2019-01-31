package com.ibm.internship.onlineshop.repositories;

import com.ibm.internship.onlineshop.model.Product;
import com.ibm.internship.onlineshop.utils.jdbc.MySQLConnectionUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private Connection connection;

    public ProductRepository(MySQLConnectionUtils mySQLConnection) throws SQLException {
        try {
            connection = mySQLConnection.getMySQLConnection();
        } catch (SQLException e) {
            throw new SQLException("Connection failed.");
        }
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Product product;
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM Products";
            ResultSet resultSet = statement.executeQuery(sql);
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
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}