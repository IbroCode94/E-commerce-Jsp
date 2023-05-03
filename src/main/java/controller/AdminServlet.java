package controller;

import DAO.AdminDAO;
import connection.DBConnection;
import model.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AdminServlet", value = "/AddProduct")
public class AdminServlet extends HttpServlet {
DBConnection connection;
Products products;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

response.setContentType("text/html");
String prodName = request.getParameter("productName");
String price = request.getParameter("price");
int quantity = Integer.parseInt(request.getParameter("quantity"));
String category = request.getParameter("category");
String image = request.getParameter("image");
connection = new DBConnection();
Products products = new Products("1",prodName,price,quantity,category,image);
        AdminDAO adminDAO = new AdminDAO();
        try {
            adminDAO.addGoods(products);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
