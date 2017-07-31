/**
 * Created by robin on 2017/8/1.
 */


import interfaces.UserOperation;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client {

    private static ApplicationContext ctx;

    static
    {
        ctx = new ClassPathXmlApplicationContext("config/applicationcontext.xml");
    }

    public static void main(String[] args)
    {
        UserOperation mapper = (UserOperation)ctx.getBean("userMapper");
        //测试id=1的用户查询，根据数据库中的情况，可以改成你自己的.
        System.out.println("得到用户id=1的用户信息");
        User user = mapper.selectUserByID(1);
        System.out.println(user.getUserAddress());



    }

}
