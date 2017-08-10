package day06.homework.rpcrobin.test;


import day06.homework.rpcrobin.local.UserServiceImpl;
import day06.homework.rpcrobin.net_common.IdPassException;
import day06.homework.rpcrobin.net_common.User;
import day06.homework.rpcrobin.net_common.UserService;

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
            System.out.println("--------------------");
            User user=new User(3,"HAH","12","1234@qq.com");
            System.out.println(userService.insertUser(user));
        } catch (IdPassException e) {
            System.out.println(e.getMessage());
        }
    }
}
