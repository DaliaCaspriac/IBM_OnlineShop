
import com.ibm.internship.onlineshop.repositories.ProductRepository;
import com.ibm.internship.onlineshop.utils.jdbc.MySQLConnectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class ProductRepositoryTest {

    private ProductRepository productRepository;

    @Before
    public void setUp(){
    }

    @Test
    public void getAllProductsTest(){
        //Assert.assertEquals(productRepository.getAllProducts().size(),3);
    }
}
