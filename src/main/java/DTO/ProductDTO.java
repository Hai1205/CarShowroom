/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class ProductDTO {

    private String productID, productName, type, supplierID, supplierName;
    private int quantity;
    private double price;
    private boolean status;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String supplierID, String productName, String supplierName, String type, int quantity, double price, boolean status) {
        this.productID = productID;
        this.productName = productName;
        this.supplierName = supplierName;
        this.type = type;
        this.supplierID = supplierID;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getType() {
        return type;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public boolean getStatus() {
        return status;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setAll(String productID, String supplierID, String productName, String supplierName, String type, int quantity, double price, boolean status) {
        setProductID(productID);
        setProductName(productName);
        setSupplierName(supplierName);
        setType(type);
        setSupplierID(supplierID);
        setQuantity(quantity);
        setPrice(price);
        setStatus(status);
    }

    public void setAll(String productName, String supplierName, double price, boolean status) {
        setProductName(productName);
        setSupplierName(supplierName);
        setPrice(price);
        setStatus(status);
    }
}
