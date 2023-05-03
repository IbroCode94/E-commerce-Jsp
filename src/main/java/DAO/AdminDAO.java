package DAO;

import connection.DBConnection;
import model.Products;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static connection.DBConnection.queryProduct;


public class AdminDAO {

    Products products;
    User user;
    static Connection dbconnection = DBConnection.getConnection();
    public static ResultSet getAllProd() throws SQLException {
        String query = "select * from products";
        Statement statement = dbconnection.createStatement();
        return statement.executeQuery(query);
    }

    public static List<Products> getAllProducts() throws SQLException {
        ResultSet allProducts = getAllProd();
        List<Products> productList = new ArrayList<>();

        while (allProducts.next()) {
            productList.add(new Products(allProducts.getString("products_id"),
                    allProducts.getString("prod_name"),
                    allProducts.getString("prod_price"),
                    allProducts.getInt("product_qty"),
                    allProducts.getString("prod_category"),
                    allProducts.getString("prod_img")
                    ));
        }
        return productList;
    }
    public boolean addGoods(Products products) throws SQLException {
        boolean isSuccess = false;
        PreparedStatement statement = dbconnection.prepareStatement(queryProduct);
        statement.setString(1, products.getProdName());
        statement.setString(2, products.getPrice());
        statement.setInt(3, products.getQuantity());
        statement.setString(4, products.getCategory());
        statement.setString(5, products.getImage());
        int addUp = statement.executeUpdate();
        if (addUp > 0) {
            isSuccess = true;
            statement.close();

        }
        return true;



    }

    public static void main(String[] args) throws SQLException {
        AdminDAO admin = new AdminDAO();
        Products products = new Products("rice","$12", 20,"Grains", "img.png");
        admin.addGoods(products);

        System.out.println(getAllProducts());
    }

}

