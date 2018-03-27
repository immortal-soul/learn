package ImmortalSoul.JDBC;


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestDBCP {

    private static BasicDataSource dataSource = null;

    public static void main(String[] args) {

        FileInputStream fis;
        Properties pro = new Properties();
        try {
            fis = new FileInputStream("dbcpconfig.properties");
            pro.load(fis);
            dataSource = BasicDataSourceFactory.createDataSource(pro);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Runnable run = () ->{
            Connection con = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                con = dataSource.getConnection();
                String sql = "SELECT * FROM learnJava";
                stmt = con.createStatement();
                rs = stmt.executeQuery(sql);
                while (rs.next())
                    System.out.println(rs.getString("id"));

            } catch (SQLException e) {
                e.printStackTrace();
                if (con!=null){
                    try {
                        con.rollback();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }finally {
                JDBCUtils.close(rs,stmt,con);
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
}
