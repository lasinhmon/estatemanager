package dao.util;

import java.sql.*;

public class ConnectionUtil {
    //"jdbc:mysql://localhost:3306/charonbus?useSSL=false","root","1234"
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Connection getNewConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/estate?useSSL=false&allowPublicKeyRetrieval=true","root","1234");
    }
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }

    }

    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }

    }
    public static void close(CallableStatement cs) {
        try {
            if (cs != null) {
                cs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }

    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace(System.out);
        }

    }
}
