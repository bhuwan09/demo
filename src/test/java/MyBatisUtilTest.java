import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import com.example.demo.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;


public class MyBatisUtilTest {


   public static void main(String[] args) {
      String resource = "META-INF/mybatis-config.xml";
      MyBatisUtil myBatisUtil = new MyBatisUtil();

      try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
         SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream, myBatisUtil.configDbProperties());

         sessionFactory.getConfiguration().getEnvironment().getDataSource().getConnection();
         System.out.println("Connected");

      } catch (IOException e) {
         throw new RuntimeException(e);
      } catch (SQLException e) {
         System.err.println("Failed to connect to the database: "+ e.getMessage());
      }
   }

}

