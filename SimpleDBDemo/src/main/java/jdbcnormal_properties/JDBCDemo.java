package jdbcnormal_properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by robin on 2017/8/9.
 */
public class JDBCDemo {
    private static String url="jdbc:mysql://localhost:3306/springinaction";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,"root","123456");
            PreparedStatement pstmt=
                    connection.prepareStatement("insert into student(id,name,sex)values(?,?,?)");
            pstmt.setInt(1, 11);
            pstmt.setString(2, "hhh");
            pstmt.setString(3,"female");
            int n=pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
