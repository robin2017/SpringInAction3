/**
 * Created by robin on 2017/7/31.
 */

import interfaces.UserOperation;
import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;


public class Client {
    private static SqlSessionFactory sqlSessionFactory;

    static{
        try{

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("configuration.xml"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
    public static void main(String[] args) {

        getUserById(1);
        System.out.println("-----------");
        getUserList("summer");
        System.out.println("-----------");
        addUser();
        System.out.println("-----------");
        updateUser();
        deleteUser(2);

    }
    public static void getUserById(int id){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserOperation userOperation=session.getMapper(UserOperation.class);
            User user = userOperation.selectUserByID(id);
            System.out.println(user.getUserAddress());
            System.out.println(user.getUserName());
        } finally {
            session.close();
        }
    }


    public static void getUserList(String userName){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserOperation userOperation=session.getMapper(UserOperation.class);
            List<User> users = userOperation.selectUsers(userName);
            for(User user:users){
                System.out.println(user.getId()+":"+user.getUserName()+":"+user.getUserAddress());
            }
        } finally {
            session.close();
        }
    }

    public static void addUser(){
        User user=new User();
        user.setUserAddress("remmianguanchang");
        user.setUserName("flybird");
        user.setUserAge("80");
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserOperation userOperation=session.getMapper(UserOperation.class);
            userOperation.addUser(user);
            session.commit();
            System.out.println("当前增加的用户 id为:"+user.getId());
        } finally {
            session.close();
        }
    }

    public static void updateUser(){
        //先得到用户,然后修改，提交。
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserOperation userOperation=session.getMapper(UserOperation.class);
            User user = userOperation.selectUserByID(4);
            user.setUserAddress("modify has done");
            userOperation.updateUser(user);
            session.commit();

        } finally {
            session.close();
        }
    }

    public static void deleteUser(int id){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserOperation userOperation=session.getMapper(UserOperation.class);
            userOperation.deleteUser(id);
            session.commit();
        } finally {
            session.close();
        }
    }
}