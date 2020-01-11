package Repository;


import Model.Student;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private EntityManager em;

    public StudentRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Student getStudentById(Integer id) {
        return em.find(Student.class,id);
    }

    @Override
    public List<Student> getAll() {
        return em.createQuery("from Student").getResultList();
    }

    @Override
    public Student addStudent(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        return student;
    }

    @Override
    public void deleteStudent(Student student) {
        em.getTransaction().begin();
        em.remove(student.getId());
        em.getTransaction().commit();
    }
}
