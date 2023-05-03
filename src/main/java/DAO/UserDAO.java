package DAO;

import connection.DBConnection;
import lombok.Getter;
import model.Cart;
import model.Products;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static connection.DBConnection.queryInserted;
@Getter
public class UserDAO {
    static Connection dbconnection = DBConnection.getConnection();

    public static ResultSet getAllUser() throws SQLException {
        String query = "select * from user";
        Statement statement = dbconnection.createStatement();
        return statement.executeQuery(query);
    }

    public boolean registerUser(User user) throws SQLException {
boolean isSuccess = false;
        PreparedStatement statement = dbconnection.prepareStatement(queryInserted);
        statement.setString(1,user.getUserName());
        statement.setString(2,user.getEmail());
        statement.setString(3,user.getPassword());
        int addUp= statement.executeUpdate();
        if(addUp > 0){
            isSuccess = true;
            statement.close();
        }
        return isSuccess;
    }
    public static User getUserById(String user_Id) throws SQLException {
        User user = new User();
        String query = "select * from user where user_id = ?";
        PreparedStatement statement = dbconnection.prepareStatement(query);
        statement.setString(1, user_Id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            user.setUserName(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            statement.close();
        } else {
            throw new RuntimeException("User not found! Please enter correct details.");
        }
        return user;
    }
    public static int getUserId(String email, String password) throws SQLException{
        int user_Id = 0;
        String query = "select user_Id from user where email = ? and password = ?";
        PreparedStatement statement = dbconnection.prepareStatement(query);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            user_Id = resultSet.getInt("user_Id");
            statement.close();
        } else {
            throw new RuntimeException("User not found! Please enter correct details.");
        }
        return user_Id;
    }

    public static boolean loginUser(String email, String password) throws SQLException {
        boolean isSuccess = false;
        String query = "select user_id from user where email = ? and password = ?";
        PreparedStatement statement = dbconnection.prepareStatement(query);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()){
            isSuccess = true;
            statement.close();
        }
        return isSuccess;
    }


    public boolean insertCart(Cart cart) {
        boolean status = false;

        try {
            PreparedStatement preparedStatement = dbconnection.prepareStatement("INSERT INTO cart(user_id,product_id)VALUES(?,?)");
            preparedStatement.setString(1, cart.getUser_id());
            preparedStatement.setString(2, cart.getProduct_id());
            if (preparedStatement.executeUpdate() == 1) {

                status = true;
                preparedStatement.close();
            }
            return status;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ResultSet getProductByID(String id) throws SQLException, ClassNotFoundException {

        Statement statement = dbconnection.createStatement();
        return statement.executeQuery("SELECT * FROM products WHERE products_id='"+id+"'");
    }
    public static ArrayList<Products> getAllProductid(String id) throws SQLException, ClassNotFoundException {

        ResultSet cartS = getProductByID(id);
        ArrayList<Products> list = new ArrayList<>();
        while (cartS.next()) {
            list.add(new Products(
                    cartS.getString("products_id"),
                    cartS.getString("prod_name"),
                    cartS.getString("prod_price"),
                    cartS.getInt("product_qty"),
                    cartS.getString("prod_category"),
                    cartS.getString("prod_img")
            ));
        }
        return list;
    }
    public static ResultSet getCartByID(String id) throws SQLException, ClassNotFoundException {

        Statement statement = dbconnection.createStatement();
        return statement.executeQuery("SELECT * FROM cart WHERE user_id='"+id+"'");
    }
    public static List<Cart> getAllCartid(String id) throws SQLException, ClassNotFoundException {

        ResultSet cartS = getCartByID(id);
        List<Cart> list = new ArrayList<>();
        while (cartS.next()) {
            list.add(new Cart(
                    cartS.getInt("id"),
                    cartS.getString("user_id"),
                    cartS.getString("product_id")

            ));
        }
        return list;
    }
    public static void main(String[] args) throws SQLException {
        UserDAO userDAO = new UserDAO();
        userDAO.insertCart(new Cart("24","7"));
    }
}
