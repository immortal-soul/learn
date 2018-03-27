package ImmortalSoul.JDBC;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;


public class Test {

    /**
     * JDBC URL: jdbc:mysql://<host>:<port>/<database_name>
     * host:地址
     * port:默认端口3306，如果服务器使用默认端口则port可以省略
     * database_name:数据库名
     * 例子：jdbc:mysql://localhost:3306/imooc
     */
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String MONEY = "money";
    public static final String TEACHER = "teacher";
    public static final String STUDENT = "student";


    public static void main(String[] args) {

        Connection conn = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn!=null) {
            test(conn);
//            test1(conn);
//            test2(conn);
        }
    }

    /**
     * 保存点
     * @param conn
     */
    public static void test2(Connection conn){

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "UPDATE learnJava SET money = money + ? WHERE id = ?";

        try {
            //手动提交，不能在自动提交的情况下使用回滚否则报错
            conn.setAutoCommit(false);
            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            pstmt.setInt(1,1000);
            pstmt.setInt(2,1);
            pstmt.executeUpdate();

            pstmt.setInt(1,-1000);
            pstmt.setInt(2,1);
            pstmt.executeUpdate();

            //设置保存点
            Savepoint sp = conn.setSavepoint();

            pstmt.setInt(1,-1000);
            pstmt.setInt(2,1);
            pstmt.executeUpdate();

            //如果金额小于零则回滚到保存点
            sql = "SELECT money FROM learnJava WHERE id = ?";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1,1);
            rs = pstmt.executeQuery();
            rs.next();
            int money = rs.getInt(1);
            if (money<0)
                conn.rollback(sp);

            conn.commit();
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
            JDBCUtils.close(rs,pstmt,conn);
        }


    }

    /**
     * 批处理
     * @param conn
     */
    public static void test1(Connection conn){
        PreparedStatement pstmt = null;
        try {
            //取消自动提交
            conn.setAutoCommit(false);
            String sql = "INSERT INTO learnJava (name,money,teacher,student) VALUES (?,?,?,?)";
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,"1");
            pstmt.setInt(2,2000);
            pstmt.setString(3,"谭老师");
            pstmt.setString(4,"甲");
            pstmt.addBatch();
            pstmt.setString(1,"2");
            pstmt.setInt(2,3000);
            pstmt.setString(3,"谭老师");
            pstmt.setString(4,"乙");
            pstmt.addBatch();
            pstmt.setString(1,"3");
            pstmt.setInt(2,4000);
            pstmt.setString(3,"谭老师");
            pstmt.setString(4,"丙");
            pstmt.addBatch();
            pstmt.executeBatch();
            pstmt.clearBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn!=null){
                try {
                    //防止存储时异常，一旦出现异常，回滚数据
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }finally {
            JDBCUtils.close(pstmt,conn);
        }
    }

    /**
     *
     * @param conn
     */
    public static void test(Connection conn) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = (Statement) conn.createStatement();
            String sql = "SELECT * FROM learnJava";
//            String sql1 = "UPDATE learnJava Set money = 100 where id = 12";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(" id :" + rs.getInt(ID) + " name :" + rs.getString(NAME)
                        + " money :" + rs.getInt(MONEY) + " teacher :" + rs.getString(TEACHER)
                        + " student :" + rs.getString(STUDENT));
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
        } finally {
            JDBCUtils.close(rs,stmt,conn);
        }
    }
}
