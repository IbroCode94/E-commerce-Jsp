package controller;

import DAO.UserDAO;
import connection.DBConnection;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegistrationServlet", value = "/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    DBConnection connection;
    UserDAO userDAO = new UserDAO();



    ;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
String username = request.getParameter("username");
String email = request.getParameter("email");
String password = request.getParameter("password");
connection = new DBConnection();

if(username.isEmpty() || email.isEmpty() || password.isEmpty()){
    response.sendRedirect("register.jsp");
}else {
    User user = new User("1", username, email, password);

    UserDAO userDAO = new UserDAO();

    boolean isSuccess = false;
    try {
        isSuccess = userDAO.registerUser(user);
        int id = userDAO.getUserId(email, password);

        if (isSuccess) {

            HttpSession httpSession = request.getSession();
            System.out.println("Success");
            httpSession.setAttribute("email", email);
            httpSession.setAttribute("id", id);
            httpSession.setAttribute("Registration Status", "successfully registered! Login to continue.");
            response.sendRedirect("index.jsp");
        } else {

            String errorMessage = "failed";
            response.sendRedirect("register.jsp");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}

}



