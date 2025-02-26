/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class ImportDTO {

    private String importID, date;
    private double totalCost;

    public ImportDTO() {
    }

    public ImportDTO(String importID, String date, double totalCost) {
        this.importID = importID;
        this.totalCost = totalCost;
        this.date = date;
    }

    public String getImportID() {
        return importID;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public String getDate() {
        return date;
    }

    public void setImportID(String importID) {
        this.importID = importID;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAll(String importID, String date, double totalCost) {
        setImportID(importID);
        setTotalCost(totalCost);
        setDate(date);
    }
}
