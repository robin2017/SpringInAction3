package rpcrobin.test;

import  rpcrobin.local.IdPassException;
import  rpcrobin.local.User;
import  rpcrobin.local.UserService;
import  rpcrobin.local.UserServiceImpl;

import java.util.List;

/**
 * Created by robin on 2017/8/9.
 */
public class LocalBusinessTest {
    public static void main(String[] args){
        try {
            UserService userService=new UserServiceImpl();
           System.out.println(userService.logon(1, "123456"));

            System.out.println("--------------------");

            List<User> list=userService.getAllUsers();
            for(User user:list)
                System.out.println(user);

            System.out.println("--------------------");

            System.out.println(userService.getNameById(1));
        } catch (IdPassException e) {
            System.out.println(e.getMessage());
        }
    }
}
