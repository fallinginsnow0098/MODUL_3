package controller;

import model.City;
import service.CityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CityServlet", urlPatterns = "/cities")
public class CityServlet extends HttpServlet {
    private final CityService cityService = new CityService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        actions(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        actions(request,response);
    }
    private void actions(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "createGet":
                createGet(request,response);
                break;
            case "createPost":
                createPost(request,response);
                break;
            case "editGet":
                editGet(request,response);
                break;
            case "editPost":
                editPost(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "display-detail":
                displayDetail(request,response);
                break;
            default:
                displayAll(request,response);
        }
    }
    private void createGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<String> countries = cityService.getCountries();
        request.setAttribute("countries", countries);
        RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
        rd.forward(request,response);
    }
    private void createPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double popular = Double.parseDouble(request.getParameter("popular"));
        double area = Double.parseDouble(request.getParameter("area"));
        double gdp = Double.parseDouble(request.getParameter("gdp"));
        String country = request.getParameter("country");
        cityService.createCity(new City(id,name,popular,area,gdp,country));
        ArrayList<City> cities = cityService.getCities();
        request.setAttribute("cities", cities);
        RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
        rd.forward(request,response);
    }
    private void editGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        City city = cityService.getCity(id);
        ArrayList<String> countries = cityService.getCountries();
        request.setAttribute("countries", countries);
        request.setAttribute("city", city);
        RequestDispatcher rd = request.getRequestDispatcher("create.jsp");
        rd.forward(request,response);
    }
    private void editPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double popular = Double.parseDouble(request.getParameter("popular"));
        double area = Double.parseDouble(request.getParameter("area"));
        double gdp = Double.parseDouble(request.getParameter("gdp"));
        String country = request.getParameter("country");
        int index = -1;
        City city = cityService.getCity(id);
        ArrayList<City> cities = cityService.getCities();
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getId() == id){
                index = i;
            }
        }
        cityService.editCity(index, new City(id,name,popular,area,gdp,country));
        cities = cityService.getCities();
        request.setAttribute("cities", cities);
        RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
        rd.forward(request,response);

    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        City city = cityService.getCity(id);
        cityService.deleteCity(city);
        ArrayList<City> cities = cityService.getCities();
        request.setAttribute("cities", cities);
        RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
        rd.forward(request,response);
    }

    private void displayAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<City> cities = cityService.getCities();
        request.setAttribute("cities", cities);
        RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
        rd.forward(request,response);
    }
    private void displayDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        City city = cityService.getCity(id);
        request.setAttribute("city", city);
        RequestDispatcher rd = request.getRequestDispatcher("view-detail.jsp");
        rd.forward(request,response);
    }
}
