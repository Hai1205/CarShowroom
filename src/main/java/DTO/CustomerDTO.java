/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class CustomerDTO {

    private String customerID, firstname, lastname, address, phone;

    public CustomerDTO() {
    }

    public CustomerDTO(String customerID, String firstname, String lastname, String address, String phone) {
        this.customerID = customerID;
        this.firstname = firstname;
        this.phone = phone;
        this.lastname = lastname;
        this.address = address;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getPhone() {
        return phone;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setAll(String customerID, String firstname, String lastname, String address, String phone){
        setCustomerID(customerID);
        setFirstname(firstname);
        setPhone(phone);
        setLastname(lastname);
        setAddress(address);
    }
}
