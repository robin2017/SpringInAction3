package jdbcnormal;

import common.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by robin on 2017/7/31.
 */
public class StudentDaoImpl implements StudentDao {
    private DataSource dataSource;
    private static final String SQL_SELECT_STUDENT=
            "select * from student where id= ? ";
    public StudentDaoImpl(DataSource dataSource){
        this.dataSource=dataSource;
    }









    public Student getStudentById(int id) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            connection=dataSource.getConnection();
            preparedStatement=connection.prepareStatement(SQL_SELECT_STUDENT);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            Student student=null;
            if(resultSet.next()){
                student=new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSex(resultSet.getString("sex"));
            }
            return student;
        }catch(SQLException e){
        }finally {
            if(resultSet!=null)
                try{
                    resultSet.close();
                }catch(SQLException e){}
        }
        if(preparedStatement!=null){
            try{
                preparedStatement.close();
            }catch(SQLException e){}
        }
        if(connection!=null){
            try{
                connection.close();
            }catch(SQLException e){}
        }
        return null;
    }

    public void addStudent(Student student) {

    }
}
