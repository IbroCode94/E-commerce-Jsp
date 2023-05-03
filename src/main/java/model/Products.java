package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Products {
    private String prod_Id;
private  String prodName;
private  String price;
private int quantity;
 private String category;

 private  String image;

    public Products(String prod_Id,String prodName, String price, int quantity, String category, String image) {
        this.prod_Id = prod_Id;
        this.prodName = prodName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.image = image;
    }
    public Products(String prodName, String price, int quantity, String category, String image) {

        this.prodName = prodName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.image = image;
    }


}
