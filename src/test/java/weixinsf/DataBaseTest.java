package weixinsf;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataBaseTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  //加载JDBC驱动
        String dbURL = "jdbc:sqlserver://192.168.30.19:1433;DatabaseName=Chome2013Site";  //连接服务器和数据库test
        String userName = "Chome2013sitewrite";  //默认用户名
        String userPwd = "centaline@123";  //密码
        Connection dbConn;
        try {
            Class.forName(driverName);
            dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
            System.out.println("Connection Successful!");  //如果连接成功 控制台输出Connection Successful!
           } catch (Exception e) {
            e.printStackTrace();
           }
    }

}
