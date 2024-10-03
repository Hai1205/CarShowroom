/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DetailImportDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class DetailImportDAL {

    public static ArrayList<DetailImportDTO> getAllImportDetails(String importID) {
        ArrayList<DetailImportDTO> imports = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstm = null;
        try {
            connection = Database.getConnection();

            String condition = "";
            if (importID != null && !importID.isEmpty()) {
                condition += " WHERE importID = ?";
            }

            String query = "SELECT * FROM importdetail" + condition;
            pstm = connection.prepareStatement(query);
            if (importID != null && !importID.isEmpty()) {
                pstm.setString(1, importID);
            }

            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                importID = resultSet.getString("importID");
                String supplierID = resultSet.getString("supplierID");
                String productId = resultSet.getString("productID");
                int price = resultSet.getInt("price");
                int quantity = resultSet.getInt("quantity");
                int cost = resultSet.getInt("cost");

                imports.add(new DetailImportDTO(importID, supplierID, productId, quantity, price, cost));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return imports;
    }

    public static void deleteAllImportDetails() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = Database.getConnection();
            String sql = "DELETE FROM importdetail";
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

    public static void setAllImportDetails(ArrayList<DetailImportDTO> list) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            deleteAllImportDetails();
            connection = Database.getConnection();

            String sql = "INSERT INTO importdetail (importID, supplierID, productID, quantity, price, cost) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            for (DetailImportDTO dipDTO : list) {
                pstmt.setString(1, dipDTO.getImportID());
                pstmt.setString(2, dipDTO.getSupplierID());
                pstmt.setString(3, dipDTO.getProductID());
                pstmt.setInt(4, dipDTO.getQuantity());
                pstmt.setDouble(5, dipDTO.getPrice());
                pstmt.setDouble(6, dipDTO.getCost());

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
