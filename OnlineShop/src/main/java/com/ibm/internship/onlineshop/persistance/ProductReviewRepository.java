package com.ibm.internship.onlineshop.persistance;

import com.ibm.internship.onlineshop.model.ProductReview;
import com.ibm.internship.onlineshop.utils.jdbc.MySQLConnectionUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductReviewRepository {
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

    /**
     * Filter productReviews by a given productCode
     *
     * @param productCode specified code
     * @return list of ProductReviews
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public List<ProductReview> getProductReviewsByProductCode(int productCode) throws IllegalAccessException, ClassNotFoundException {
        try {
            PreparedStatement statement = findProductReviewsByProductCode(productCode);
            ResultSet resultSet = statement.executeQuery();
            return getAllRecords(resultSet);
        } catch (SQLException e) {
            throw new IllegalAccessException(e.getMessage());
        }
    }

    /**
     * Parse ResultSet to List<ProductReview>
     *
     * @param resultSet
     * @return list of productReviews
     * @throws IllegalAccessException
     */
    private List<ProductReview> getAllRecords(ResultSet resultSet) throws IllegalAccessException {
        ProductReview productReview;
        List<ProductReview> productReviews = new ArrayList<>();
        try {
            while (resultSet.next()) {
                productReview = new ProductReview(resultSet.getInt("reviewID"),
                        resultSet.getString("comment"),
                        resultSet.getInt("starts"),
                        resultSet.getInt("productCode"));
                productReviews.add(productReview);
            }
            return productReviews;
        } catch (SQLException e) {
            throw new IllegalAccessException(e.getMessage());
        }
    }

    /**
     * Create a statement to fetch productReviews for a specified Product from DB
     *
     * @param productCode
     * @return PreparedStatement
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    private PreparedStatement findProductReviewsByProductCode(int productCode) throws ClassNotFoundException, IllegalAccessException {
        Connection connection = startConnection();
        try {
            String sql = "SELECT * FROM Product_Reviews WHERE productCode = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, productCode);
            return statement;
        } catch (SQLException e) {
            throw new IllegalAccessException(e.getMessage());
        } finally {
            //connection.close();
        }
    }
}
