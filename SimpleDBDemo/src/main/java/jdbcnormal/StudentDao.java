package jdbcnormal;

import common.Student;

/**
 * Created by robin on 2017/7/31.
 */
public interface StudentDao {
    public Student getStudentById(int id);
    public void addStudent(Student student);
}
