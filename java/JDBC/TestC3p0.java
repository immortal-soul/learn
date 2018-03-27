package ImmortalSoul.JDBC;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by tansibin on 2018/3/27.
 */
public class TestC3p0 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";

    public static final String ID = "id";

    public static void main(String[] args) {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(URL+"?user=root&password=root");
        try {
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        //最大连接数
        dataSource.setMaxPoolSize(5);
        //最小连接数
        dataSource.setMinPoolSize(1);
        //初始连接数
        dataSource.setInitialPoolSize(1);

        Runnable run = () -> {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                conn = dataSource.getConnection();
                String sql = "SELECT * FROM learnJava";
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    System.out.println(" id :" + rs.getInt(ID));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                if (conn!=null){
                    try {
                        conn.rollback();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }finally {
                close(rs,stmt,conn);
            }
        };

        Thread one = new Thread(run);
        Thread two = new Thread(run);
        Thread three = new Thread(run);
        Thread four = new Thread(run);
        Thread five = new Thread(run);
        Thread six = new Thread(run);

        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
        six.start();

    }

    public static void close(ResultSet rs , Statement stmt , Connection connection){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
