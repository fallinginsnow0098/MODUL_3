package service;

import DAO.IStudentDAO;
import DAO.StudentDAO;
import model.Student;

import java.util.List;

public class StudentService implements IStudentService{
    private final IStudentDAO studentDAO = new StudentDAO();


    @Override
    public List<Student> getAllStudent() {
        return studentDAO.getAllStudent();
    }

    @Override
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }

    @Override
    public void editStudent(Student student, int id) {
        studentDAO.editStudent(student,id);
    }


    @Override
    public boolean createStudent(Student student) {
        return studentDAO.createStudent(student);
    }

    @Override
    public Student findStudentByKeyword(String keyword) {
        return studentDAO.findStudentByKeyword(keyword);
    }

    @Override
    public Student findStudentById(int id) {
        return studentDAO.findStudentById(id);
    }

}
