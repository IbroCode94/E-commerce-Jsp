package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/e_commerce";
    private static String name = "root";
    private  static String password = "KhAlifA41#";
    public static String queryInserted = "INSERT INTO user(username,email,password)VALUES(?,?,?)";
    public static String queryProduct = "INSERT INTO products(prod_name,prod_price,product_qty,prod_category,prod_img)VALUES(?,?,?,?,?)";

    static  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, name, password);
        } catch (ClassNotFoundException | SQLException e) {

        }
    }
    public static Connection getConnection(){
        return connection;
    }

}
