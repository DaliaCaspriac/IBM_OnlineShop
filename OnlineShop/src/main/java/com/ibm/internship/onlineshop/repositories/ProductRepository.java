package com.ibm.internship.onlineshop.repositories;

import com.ibm.internship.onlineshop.model.Product;
import com.ibm.internship.onlineshop.utils.jdbc.MySQLConnectionUtils;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public List<Product> getAllProducts() throws IllegalAccessException, ClassNotFoundException, SQLException {
        Connection connection = new MySQLConnectionUtils().getMySQLConnection();
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
        } finally {
            connection.close();
        }
        return null;
    }

    public List<Product> getProductsByCategory(int categoryCode) throws ClassNotFoundException, IllegalAccessException {
        Connection conn = new MySQLConnectionUtils().getMySQLConnection();
        List<Product> products = new ArrayList<>();
        Product product;
        try {
            String sql = "SELECT * FROM Products WHERE categoryCode = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,categoryCode);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
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
