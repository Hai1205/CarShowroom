/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class TempImportDTO {

    private String supplierName, productName;
    private int quantity;
    private Double importPrice, productPrice, cost;

    public TempImportDTO(String supplierName, String productName, Double importPrice, int quantity, Double productPrice, Double cost) {
        this.supplierName = supplierName;
        this.productName = productName;
        this.quantity = quantity;
        this.importPrice = importPrice;
        this.productPrice = productPrice;
        this.cost = cost;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getImportPrice() {
        return importPrice;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public Double getCost() {
        return cost;
    }
}
