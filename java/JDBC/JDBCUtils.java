package ImmortalSoul.JDBC;

import java.sql.*;

public class JDBCUtils {

    public static void close(Connection con){
        close(null,null,null,con);
    }

    public static void close(ResultSet rs, Statement stmt , Connection con){
        close(rs,stmt,null,con);
    }

    public static void close(ResultSet rs, PreparedStatement pstmt , Connection con){
        close(rs,null,pstmt,con);
    }

    public static void close(PreparedStatement pstmt , Connection con){
        close(null,null,pstmt,con);
    }

    public static void close(ResultSet rs, Statement stmt, PreparedStatement pstmt , Connection con){
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
        if (pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
