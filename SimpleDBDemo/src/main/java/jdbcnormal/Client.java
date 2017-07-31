package jdbcnormal;

import common.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;


/**
 * Created by robin on 2017/7/31.
 */
public class Client {
    public static void main(String[] args){
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("dataSource.xml");
        DataSource dataSource= (DataSource)applicationContext.getBean("dataSource");
        StudentDao studentDao=new StudentDaoImpl(dataSource);
        Student student=studentDao.getStudentById(140754);
        System.out.println(student);
    }
}
