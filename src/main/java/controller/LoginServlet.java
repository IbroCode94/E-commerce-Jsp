package controller;

import DAO.UserDAO;
import connection.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    DBConnection connection;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email.equals("ibrahimozigis0@gmail.com") && password.equals("1234")) {
            response.sendRedirect("Admin.jsp");
        } else {

            connection = new DBConnection();
            if (email.isEmpty() || password.isEmpty()) {
                response.sendRedirect("/register.jsp");
            }
            int user_id;


            try {
                user_id = UserDAO.getUserId(email, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            boolean isSuccess;
            try {
                isSuccess = UserDAO.loginUser(email, password);
                if (isSuccess) {
                    HttpSession session = request.getSession();
                    session.setAttribute("email", email);
                    session.setAttribute("id", user_id);
                    response.setContentType("text/html");
                    response.sendRedirect("index.jsp");


                } else {
                    response.sendRedirect("register.jsp");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
