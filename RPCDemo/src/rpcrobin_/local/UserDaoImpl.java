package rpcrobin_.local;


import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by robin on 2017/8/9.
 */
public class UserDaoImpl implements UserDao {
//    public static void main(String[] args){
//        new UserDaoImpl().getNameById(1);
//    }
    private UserDaoImpl(){}
    private static UserDaoImpl instance=null;
    public static UserDaoImpl getInstance(){
        if(instance!=null){}
        else{
            synchronized (UserDaoImpl.class){
                if(instance==null)
                    instance=new UserDaoImpl();
            }
        }
        return instance;
    }
    private static Properties p=new Properties();
    private static Connection connection=null;
    static{
        try {
            p.load(UserDaoImpl.class.getResourceAsStream("database.properties"));
            Class.forName(String.valueOf(p.get("driver")));
            connection= DriverManager.getConnection(String.valueOf(p.get("url")), String.valueOf(p.get("user")), String.valueOf(p.get("password")));

        } catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public User logon(int id, String password) throws IdPassException{
        List<User> list=getAllUsers();
        for(User user:list){
            if(id==user.getUid())
                if(password.equals(user.getPass()))
                    return user;
                else
                    throw new IdPassException("error password");

        }
        throw new IdPassException("no id");
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list=new ArrayList<User>();
        PreparedStatement pstmt1;
        try {
            pstmt1 = connection.prepareStatement("select * from user");
            ResultSet rs = pstmt1.executeQuery();
            while(rs.next()){
             //   System.out.println(rs.getInt("uid")+","+rs.getString("name")+","+rs.getString("pass")+","+rs.getString("email"));
                User user=new User();
                user.setUid(rs.getInt("uid"));
                user.setName(rs.getString("name"));
                user.setPass(rs.getString("pass"));
                user.setEmail(rs.getString("email"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getNameById(int id) {
        try {
            PreparedStatement pstmt=connection.prepareStatement("select name from user where uid=?");
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                //System.out.println(rs.getString("name"));
                return rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
