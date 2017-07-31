package jdbctemplate;

import common.Student;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by robin on 2017/7/31.
 */
public class StudentDaoImpl implements StudentDao {
    private SimpleJdbcTemplate jdbcTemplate;
    private static final String SQL_SELECT_STUDENT=
            "select * from student where id= ? ";
    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public Student getStudentById(int id) {
      return jdbcTemplate.queryForObject(SQL_SELECT_STUDENT,
              new ParameterizedBeanPropertyRowMapper<Student>(){
                  public Student mapRow(ResultSet rs,int rowNum)
                      throws SQLException{
                      Student student=new Student();
                      student.setId(rs.getInt(1));
                      student.setName(rs.getString(2));
                      student.setSex(rs.getString(3));
                      return student;
                  }
              },id
              );
    }

    public void addStudent(Student student) {

    }
}
