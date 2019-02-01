import com.ibm.internship.onlineshop.utils.jdbc.MySQLConnectionUtils;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class MySQLConnectionUtilsTest {
    private MySQLConnectionUtils conn = new MySQLConnectionUtils();
    @Test
    public void getConnectionTest(){

       // Assert.assertTrue(conn.getMySQLConnection() instanceof Connection);
    }
}
