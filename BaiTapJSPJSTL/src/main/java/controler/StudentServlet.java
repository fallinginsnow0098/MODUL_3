package controler;

import model.Student;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }


    public void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("param");
        if (action == null){
            action = "";
        }
        switch (action){
            case "createGet":
                createGet(request, response);
                break;
            case "createPost":
                createPost(request, response);
                break;
            case "edit":
                editStudent(request,response);
                break;
            case "editGet":
                editGet(request,response);
                break;
            case "sort":
                sortByAVG(request,response);
                break;
            case "great":
                displayStudentWithAVG(request,response);
                break;
            case "delete":
                deleteStudent(request,response);
                break;
            default:
                displayStudent(request,response);
        }
    }


    public void displayStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = studentService.display();
        request.setAttribute("students", students);
        RequestDispatcher rd = request.getRequestDispatcher("/view/view.jsp");
        rd.forward(request,response);
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        double avg = Double.parseDouble(request.getParameter("avg"));
        studentService.addStudent(new Student(id, name, age, address, avg));
        ArrayList<Student> students = studentService.display();
        request.setAttribute("students", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/view.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/view/create.jsp");
    }
    public void editGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.getStudent(id);
        if (student != null){
            request.setAttribute("student", student);

            RequestDispatcher rd = request.getRequestDispatcher("/view/edit.jsp");
            rd.forward(request,response);
        }
    }
    public void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Student editStudent = studentService.getStudent(id);
        if (editStudent!=null){
            editStudent.setName(request.getParameter("name"));
            editStudent.setAge(Integer.parseInt(request.getParameter("age")));
            editStudent.setAddress(request.getParameter("address"));
            editStudent.setAvg(Double.parseDouble(request.getParameter("avg")));
        }
        int index = -1;
        ArrayList<Student> students = studentService.display();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id){
                index = i;
            }
        }
        studentService.editStudent(index, editStudent);
        students = studentService.display();

        request.setAttribute("students", students);

        RequestDispatcher rd = request.getRequestDispatcher("/view/view.jsp");
        rd.forward(request,response);
    }
    public void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.getStudent(id);
        if (student != null) {
            studentService.deleteStudent(student);
        }
        ArrayList<Student> students = studentService.display();
        request.setAttribute("students", students);
        RequestDispatcher rd = request.getRequestDispatcher("/view/view.jsp");
        rd.forward(request, response);
    }
    public void sortByAVG(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = studentService.sortByAvg();

        request.setAttribute("students", students);
        RequestDispatcher rd = request.getRequestDispatcher("/view/view.jsp");
        rd.forward(request,response);
    }
    public void displayStudentWithAVG(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = studentService.studentWithAVG();

        request.setAttribute("students", students);
        RequestDispatcher rd = request.getRequestDispatcher("/view/view.jsp");
        rd.forward(request,response);
    }
    public void findStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        ArrayList<Student> students = studentService.findStudentByName(name);
        request.setAttribute("students", students);
        RequestDispatcher rd = request.getRequestDispatcher("/view/view.jsp");
        rd.forward(request, response);
    }
}
