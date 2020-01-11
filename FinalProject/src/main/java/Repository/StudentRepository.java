package Repository;

import Model.Student;

import java.util.List;

public interface StudentRepository {
    Student getStudentById(Integer id);
    List<Student> getAll();
    Student addStudent(Student student);
    void deleteStudent(Student student);
}
