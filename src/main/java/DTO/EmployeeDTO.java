/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class EmployeeDTO {

    private String employeeID, username, password, firstname, lastname, DOB;
    private double salary;
    private boolean status;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String employeeID, String username, String password, String firstname, String lastname, String DOB, double salary, boolean status) {
        this.employeeID = employeeID;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.salary = salary;
        this.lastname = lastname;
        this.DOB = DOB;
        this.status = status;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public double getSalary() {
        return salary;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDOB() {
        return DOB;
    }

    public boolean getStatus() {
        return status;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setAll(String employeeID, String username, String password, String firstname, String lastname, String DOB, double salary, boolean status) {
        setEmployeeID(employeeID);
        setUsername(username);
        setPassword(password);
        setFirstname(firstname);
        setSalary(salary);
        setLastname(lastname);
        setDOB(DOB);
        setStatus(status);
    }
}
