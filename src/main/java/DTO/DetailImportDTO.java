/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class DetailImportDTO {

    private String importID, supplierID, productID;
    private double price, cost;
    private int quantity;

    public DetailImportDTO() {
    }

    public DetailImportDTO(String importID, String supplierID, String productID, int quantity, double price, double cost) {
        this.importID = importID;
        this.supplierID = supplierID;
        this.productID = productID;
        this.cost = cost;
        this.price = price;
        this.quantity = quantity;
    }

    public String getImportID() {
        return importID;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getProductID() {
        return productID;
    }

    public double getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setImportID(String importID) {
        this.importID = importID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAll(String importID, String supplierID, String productID, int quantity, double price, double cost) {
        setImportID(importID);
        setSupplierID(supplierID);
        setProductID(productID);
        setCost(cost);
        setQuantity(quantity);
        setPrice(price);
    }
}
