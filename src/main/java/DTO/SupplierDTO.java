/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class SupplierDTO {

    private String supplierID, name, address, phone;

    public SupplierDTO() {
    }

    public SupplierDTO(String supplierID, String name, String address, String phone) {
        this.supplierID = supplierID;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setAll(String supplierID, String name, String address, String phone){
        setSupplierID(supplierID);
        setName(name);
        setPhone(phone);
        setAddress(address);
    }
}
