/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class EmployeeDAL {

    public static ArrayList<EmployeeDTO> getAllEmployees(boolean bool) {
        ArrayList<EmployeeDTO> employees = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = Database.getConnection();
            String query;
            if (bool == true) {
                query = "SELECT * FROM employee WHERE status = '1'";
            } else {
                query = "SELECT * FROM employee";
            }
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                String employeeID = resultSet.getString("employeeID");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String DOB = resultSet.getString("DOB");
                Double salary = resultSet.getDouble("salary");
                boolean status = resultSet.getBoolean("status");

                employees.add(new EmployeeDTO(employeeID, username, password, firstname, lastname, DOB, salary, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    public static void deleteAllEmployees() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = Database.getConnection();
            String sql = "DELETE FROM employee";
            pstmt = connection.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<EmployeeDTO> search(String info, String statusSearch) {
        ArrayList<EmployeeDTO> employees = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = Database.getConnection();
            String query;

            if (info != null && !info.isEmpty()) {
                query = "SELECT * FROM employee WHERE";
                if (statusSearch.equals("Còn làm việc")) {
                    query += " status = 1 AND";
                } else if (statusSearch.equals("Đã nghỉ việc")) {
                    query += " status = 0 AND";
                }
                query += " (employeeID LIKE ? OR username LIKE ? OR CONCAT(firstname, ' ', lastname) LIKE ? OR DOB LIKE ? OR salary LIKE ?)";
                pstmt = connection.prepareStatement(query);
                String searchValue = "%" + info + "%";
                pstmt.setString(1, searchValue);
                pstmt.setString(2, searchValue);
                pstmt.setString(3, searchValue);
                pstmt.setString(4, searchValue);
                pstmt.setString(5, searchValue);
            } else {
                query = "SELECT * FROM employee";
                if (statusSearch.equals("Còn làm việc")) {
                    query += " WHERE status = 1";
                } else if (statusSearch.equals("Đã nghỉ việc")) {
                    query += " WHERE status = 0";
                }
                pstmt = connection.prepareStatement(query);
            }

            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                String employeeID = resultSet.getString("employeeID");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String DOB = resultSet.getString("DOB");
                Double salary = resultSet.getDouble("salary");
                boolean status = resultSet.getBoolean("status");

                employees.add(new EmployeeDTO(employeeID, username, password, firstname, lastname, DOB, salary, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employees;
    }

    public static void setAllEmployees(ArrayList<EmployeeDTO> list) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            deleteAllEmployees();
            connection = Database.getConnection();

            String sql = "INSERT INTO employee (employeeID, username, password, firstname, lastname, DOB, salary, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            for (EmployeeDTO employee : list) {
                pstmt.setString(1, employee.getEmployeeID());
                pstmt.setString(2, employee.getUsername());
                pstmt.setString(3, employee.getPassword());
                pstmt.setString(4, employee.getFirstname());
                pstmt.setString(5, employee.getLastname());
                pstmt.setString(6, employee.getDOB());
                pstmt.setDouble(7, employee.getSalary());
                pstmt.setBoolean(8, employee.getStatus());

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
