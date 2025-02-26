/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DetailProductDTO;
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
public class DetailProductDAL {

    public static ArrayList<DetailProductDTO> getAllProductDetails() {
        ArrayList<DetailProductDTO> productDetails = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Database.getConnection();
            statement = connection.createStatement();

            String query = "SELECT * FROM productdetail";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String productID = resultSet.getString("productID");
                String MFG = resultSet.getString("MFG");
                int seat = resultSet.getInt("seat");
                String series = resultSet.getString("series");
                int petrol = resultSet.getInt("petrol");
                int pin = resultSet.getInt("pin");

                productDetails.add(new DetailProductDTO(productID, MFG, seat, series, petrol, pin));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return productDetails;
    }

    public static void deleteAllProductDetails() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = Database.getConnection();
            String sql = "DELETE FROM productdetail";
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

    public static void setAllProductDetails(ArrayList<DetailProductDTO> list) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            deleteAllProductDetails();
            connection = Database.getConnection();

            String sql = "INSERT INTO productdetail (productID, MFG, seat, series, petrol, pin) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            for (DetailProductDTO ProductDetail : list) {
                pstmt.setString(1, ProductDetail.getProductID());
                pstmt.setString(2, ProductDetail.getMFG());
                pstmt.setInt(3, ProductDetail.getSeat());
                pstmt.setString(4, ProductDetail.getSeries());
                pstmt.setInt(5, ProductDetail.getPetrol());
                pstmt.setInt(6, ProductDetail.getPin());

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
