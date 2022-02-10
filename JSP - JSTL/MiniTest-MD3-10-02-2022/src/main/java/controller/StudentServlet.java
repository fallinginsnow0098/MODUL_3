package controller;

import model.Student;
import service.IStudentService;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/home")
public class StudentServlet extends HttpServlet {
    private final IStudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "all";
        }
        switch (action) {
            case "creatGet":
                showCreatePage(request, response);
                break;
            case "creatPost":
                createPost(request, response);
                break;
            case "editGet":
                showEditPage(request, response);
                break;
            case "editPost":
                editPost(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "detail":
                displayDetail(request, response);
                break;
            case "all":
                displayAll(request, response);
                break;
            case "find-by-keyword":
                findByKeyword(request,response);
                break;
        }
    }

    private void findByKeyword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        Student student = studentService.findStudentByKeyword(keyword);
        request.setAttribute("student", student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-detail");
        requestDispatcher.forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.deleteStudent(id);
        List<Student> students = studentService.getAllStudent();
        request.setAttribute("students", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request,response);
    }

    public void displayDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findStudentById(id);
        request.setAttribute("student", student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view-detail");
        requestDispatcher.forward(request,response);
    }
    public void displayAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentService.getAllStudent();
        request.setAttribute("students", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view.jsp");
        requestDispatcher.forward(request,response);
    }
    public void showEditPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("edit.jsp");
        rd.forward(request,response);
    }
    public void editPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void showCreatePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
        rd.forward(request,response);
    }
    public void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        String className = request.getParameter("className");
        Student student = new Student(name,age,address,className);
        studentService.createStudent(student);
        List<Student> students = studentService.getAllStudent();
        request.setAttribute("students", students);
        RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
        rd.forward(request,response);

    }
}
