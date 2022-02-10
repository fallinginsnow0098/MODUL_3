package DAO;

import connection.SQLConnect;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO {
    private final SQLConnect connect = new SQLConnect();

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        try {
            Connection connection = connect.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM hocvien");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String address = rs.getString(4);
                String className = rs.getString(5);
                students.add(new Student(id, name, age, address, className));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public void deleteStudent(int id) {
        try {
            Connection connection = connect.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM hocvien WHERE (`id` = ?);");
            statement.setInt(1, id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editStudent(Student student,int id) {
        try {
            Connection connection = connect.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE hocvien SET `ten` = ?, `tuoi` = ?, `diachi` = ?, `tenlop` = ? WHERE (`id` = ?);");
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getAddress());
            statement.setString(4, student.getClassName());
            statement.setInt(5, id);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean createStudent(Student student) {
        boolean checkCreated = false;
        try {
            Connection connection = connect.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO hocvien (`ten`, `tuoi`, `diachi`, `tenlop`) VALUES (?, ?,?,?);");
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.setString(3, student.getAddress());
            statement.setString(4, student.getClassName());
            checkCreated = statement.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return checkCreated;
    }

    @Override
    public Student findStudentByKeyword(String keyword) {
        Student student = null;
        try {
            Connection connection = connect.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from hocvien where hocvien.ten like \"%\" + ?;");
            statement.setString(1, keyword);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String address = rs.getString(4);
                String className = rs.getString(5);
                student = new Student(name,age,address,className);
            }
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Student findStudentById(int id) {
        Student student = null;
        try {
            Connection connection = connect.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from hocvien where id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String address = rs.getString(4);
                String className = rs.getString(5);
                student = new Student(name,age,address,className);
            }

        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return student;
    }
}
