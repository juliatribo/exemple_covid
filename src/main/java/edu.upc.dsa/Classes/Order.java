package edu.upc.dsa.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private List<String> productNames = new ArrayList<String>();
    private String userName;
    private String id;

    public Order() {
        this.id = UUID.randomUUID().toString();
    }

    public Order(String user)
    {
        this.id = UUID.randomUUID().toString();
        this.userName = user;
    }

    public void addProduct(String productName){

        productNames.add(productName);
    }


    public List<String> getProductNames() {
        return productNames;
    }
    public void setProductNames(List<String> names) {
        this.productNames = names;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String toString() {
        return "Order [comprador= "+ userName+ "lista de productos = " + productNames + "]";
    }

}
