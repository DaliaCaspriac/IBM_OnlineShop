package com.ibm.internship.onlineshop.persistance;

import com.ibm.internship.onlineshop.model.Category;
import com.ibm.internship.onlineshop.utils.jdbc.MySQLConnectionUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {

    private static Logger logger = Logger.getLogger(CategoryRepository.class);

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
     * Create a statement to return all categories from database
     * @return PreparedStatement
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    private static PreparedStatement findAll() throws ClassNotFoundException, IllegalAccessException {
        Connection connection = startConnection();
        logger.debug("Established connection");
        try{
            String sql = "SELECT * FROM Categories";
            PreparedStatement statement = connection.prepareStatement(sql);
            logger.debug("Find all categories");
            return statement;
        }catch (SQLException e){
            throw new IllegalAccessException(e.getMessage());
        }finally{
            //connection.close();
        }
    }

    /**
     * Return all categories
     * @return List<Category>
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public List<Category> getAllCategories() throws IllegalAccessException, ClassNotFoundException {
        try {
            PreparedStatement statement = findAll();
            ResultSet resultSet = statement.executeQuery();
            logger.debug("Return all categories");
            return getRecords(resultSet);
        } catch (SQLException e) {
            throw new IllegalAccessException(e.getMessage());
        }
    }

    /**
     * Retrieve values from ResultSet and parsem them to Category object
     * @param resultSet
     * @return List<Category>
     * @throws IllegalAccessException
     */
    private List<Category> getRecords(ResultSet resultSet) throws IllegalAccessException {
        List<Category> categories = new ArrayList<>();
        Category category;
       try {
           while (resultSet.next()) {
               category = new Category(resultSet.getInt("categoryCode"),
                       resultSet.getString("name"));
               categories.add(category);
           }
           return categories;
       }catch (SQLException e){
           throw new IllegalAccessException(e.getMessage());
       }
    }
}
