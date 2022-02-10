package service;

import model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudent();
    void deleteStudent(int id);
    void editStudent(Student student,int id);
    boolean createStudent(Student student);
    Student findStudentByKeyword(String keyword);
    Student findStudentById(int id);
}

