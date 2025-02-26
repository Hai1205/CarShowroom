/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.SupplierDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class SupplierDAL {

    public static ArrayList<SupplierDTO> getAllSuppliers() {
        ArrayList<SupplierDTO> Suppliers = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Database.getConnection();
            statement = connection.createStatement();

            String query = "SELECT * FROM supplier";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String SupplierID = resultSet.getString("SupplierID");
                String supplierName = resultSet.getString("supplierName");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");

                Suppliers.add(new SupplierDTO(SupplierID, supplierName, address, phone));
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
        return Suppliers;
    }

    public static void deleteAllSuppliers() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = Database.getConnection();
            String sql = "DELETE FROM supplier";
            pstmt = connection.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    public static ArrayList<SupplierDTO> search(String info) {
        ArrayList<SupplierDTO> Suppliers = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = Database.getConnection();
            String query;

            if (info != null && !info.isEmpty()) {
                query = "SELECT * FROM supplier WHERE supplierID LIKE ? OR supplierName LIKE ? OR phone LIKE ? OR address LIKE ?";
                pstmt = connection.prepareStatement(query);
                String searchValue = "%" + info + "%";
                pstmt.setString(1, searchValue);
                pstmt.setString(2, searchValue);
                pstmt.setString(3, searchValue);
                pstmt.setString(4, searchValue);
            } else {
                query = "SELECT * FROM supplier";
                pstmt = connection.prepareStatement(query);
            }

            rs = pstmt.executeQuery();

            while (rs.next()) {
                String retrievedSupplierID = rs.getString("SupplierID");
                String supplierName = rs.getString("supplierName");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                Suppliers.add(new SupplierDTO(retrievedSupplierID, supplierName, address, phone));
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
        return Suppliers;
    }

    public static void setAllSuppliers(ArrayList<SupplierDTO> list) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            deleteAllSuppliers();
            connection = Database.getConnection();

            String sql = "INSERT INTO supplier (SupplierID, supplierName, address, phone) VALUES (?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            for (SupplierDTO supplier : list) {
                pstmt.setString(1, supplier.getSupplierID());
                pstmt.setString(2, supplier.getName());
                pstmt.setString(3, supplier.getAddress());
                pstmt.setString(4, supplier.getPhone());

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }
        }
    }
}
