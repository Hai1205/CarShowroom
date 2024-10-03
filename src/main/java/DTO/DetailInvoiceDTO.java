/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class DetailInvoiceDTO {

    private String invoiceID, productID;
    private double price, cost;
    private int quantity;

    public DetailInvoiceDTO() {
    }

    public DetailInvoiceDTO(String invoiceID, String productID, double price, int quantity, double cost) {
        this.invoiceID = invoiceID;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public String getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getCost() {
        return cost;
    }
}
