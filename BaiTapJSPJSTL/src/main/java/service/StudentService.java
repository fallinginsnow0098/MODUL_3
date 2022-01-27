package service;

import model.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentService {
    private static final ArrayList<Student> students ;

    static {
        students = new ArrayList<>();
        students.add(new Student(1, "Trung", 24, "BN", 9.5));
        students.add(new Student(2, "Huan", 23, "HD", 7.5));
        students.add(new Student(3, "Hung", 19, "HD", 8.5));
        students.add(new Student(4, "Tung", 20, "HN", 5.5));
    }
    public Student getStudent(int id){
        for (Student student : students) {
            if (student.getId() == id){
                return student;
            }
        }
        return null;
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public void deleteStudent(Student student){
        students.remove(student);
    }
    public void editStudent(int index, Student student){
        students.set(index, student);
    }
    public ArrayList<Student> display(){
        return students;
    }
    public ArrayList<Student> sortByAvg(){
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAvg() > o2.getAvg()) return 1;
                else if (o1.getAvg() < o2.getAvg()) return -1;
                else return 0;
            }
        });
        return students;
    }
    public ArrayList<Student> studentWithAVG(){
        ArrayList<Student> newStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getAvg() >= 8.0){
                newStudents.add(student);
            }
        }
        return newStudents;
    }
    public ArrayList<Student> findStudentByName(String name){
        ArrayList<Student> studentListByName = new ArrayList<>();
        for (Student st : students) {
            if (st.getName().equals(name)){
                studentListByName.add(st);
            }
        }
        return studentListByName;
    }
}
