package jdbctemplate;

import common.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by robin on 2017/7/31.
 */
public class Client {
    public static void main(String[] args){
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("dataSource-jdbctemplate.xml");
        StudentDao studentDao=(StudentDao)applicationContext.getBean("studentDao");


        Student student=studentDao.getStudentById(140754);
        System.out.println(student);
    }
}
