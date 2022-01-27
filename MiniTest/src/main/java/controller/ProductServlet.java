package controller;

import model.Product;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CityServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }
    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "all":
                displayAllProduct(request,response);
                break;
            case "view-detail":
                displayProduct(request,response);
                break;
            case "view-cart":
                displayCartItems(request,response);
                break;
            case "add":
                addProduct(request,response);
                break;
            case "remove":
                removeProduct(request,response);
                break;
            case "sortUp":
                sortByPriceUp(request,response);
                break;
            case "sortDown":
                sortByPriceDown(request,response);
                break;
            case "pay":
                getTotalPrice(request,response);
                break;
        }
    }

    private void displayCartItems(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> cart = productService.getCartItems();
        request.setAttribute("cart", cart);
        RequestDispatcher rd = request.getRequestDispatcher("view-cart.jsp");
        rd.forward(request,response);
    }

    private void getTotalPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> cart = productService.getCartItems();
        double total = productService.payForCart();
        request.setAttribute("cart", cart);
        request.setAttribute("total", total);
        RequestDispatcher rd = request.getRequestDispatcher("view-cart.jsp");
        rd.forward(request,response);
    }

    private void sortByPriceDown(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productService.sortByPriceDown();
        request.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
        rd.forward(request,response);
    }

    private void sortByPriceUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productService.sortByPriceUp();
        request.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
        rd.forward(request,response);
    }

    private void removeProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.removeFromCart(id);
        ArrayList<Product> cart = productService.getCartItems();
        request.setAttribute("products", cart);
        RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
        rd.forward(request,response);
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.addToCart(id);
        ArrayList<Product> cart = productService.getCartItems();
        request.setAttribute("products", cart);
        RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
        rd.forward(request,response);
    }

    private void displayProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.getProduct(id);
        request.setAttribute("product", product);
        RequestDispatcher rd = request.getRequestDispatcher("view-detail");
        rd.forward(request,response);
    }

    private void displayAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productService.getProducts();
        request.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("view.jsp");
        rd.forward(request,response);
    }
}
