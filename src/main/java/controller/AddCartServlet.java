package controller;

import DAO.UserDAO;
import model.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddCartServlet", value = "/AddCartServlet")
public class AddCartServlet extends HttpServlet {
    UserDAO userdao;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String id = request.getParameter("product_id");
        String user_id = request.getParameter("user_id");
        Cart cart = new Cart(user_id,id);
        userdao = new UserDAO();
        boolean addCart = userdao.insertCart(cart);
        if (addCart){
            request.setAttribute("status","success");
            String isLogin="isLogin";
            response.sendRedirect("shop.jsp");

        }else{
            request.setAttribute("status","error");
            response.sendRedirect("404.jsp");


        }
    }
}
