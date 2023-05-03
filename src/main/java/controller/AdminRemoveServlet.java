package controller;

import connection.DBConnection;
import model.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PipedReader;
import java.sql.PreparedStatement;

@WebServlet(name = "AdminRemoveServlet", value = "/AdminRemoveServlet")
public class AdminRemoveServlet extends HttpServlet {
DBConnection connection;
Products products;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");

//int prod_id = request.getParameter(1,"productID");
//connection = new DBConnection();
    }
}
