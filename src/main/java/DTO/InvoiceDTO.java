/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class InvoiceDTO {

    private String invoiceID, customerID, employeeID, discountID, date;
    private double tempCost, reducedCost, totalCost;

    public InvoiceDTO() {
    }

    public InvoiceDTO(String invoiceID, String customerID, String employeeID, String discountID, String date, double tempCost, double reducedCost, double totalCost) {
        this.invoiceID = invoiceID;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.discountID = discountID;
        this.date = date;
        this.tempCost = tempCost;
        this.reducedCost = reducedCost;
        this.totalCost = totalCost;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getDiscountID() {
        return discountID;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getTempCost() {
        return tempCost;
    }

    public double getReducedCost() {
        return reducedCost;
    }

    public String getDate() {
        return date;
    }
}
