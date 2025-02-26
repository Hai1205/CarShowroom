/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DiscountDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class DiscountDAL {

    public static ArrayList<DiscountDTO> getAllDiscounts() {
        ArrayList<DiscountDTO> discounts = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = Database.getConnection();
            String query = "SELECT * FROM discount";
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                String discountID = resultSet.getString("discountID");
                String discountName = resultSet.getString("name");
                String percentDiscount = resultSet.getString("percentDiscount");
                String begin = resultSet.getString("begin");
                String end = resultSet.getString("end");

                discounts.add(new DiscountDTO(discountID, discountName, Double.parseDouble(percentDiscount), begin, end));
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
        return discounts;
    }

    public static void deleteAllDiscounts() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = Database.getConnection();
            String query = "DELETE FROM discount";
            pstmt = connection.prepareStatement(query);
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
            }
        }
    }

    public static ArrayList<DiscountDTO> search(String info) {
        ArrayList<DiscountDTO> discounts = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            String query;

            if (info != null && !info.isEmpty()) {
                query = "SELECT * FROM discount WHERE discountID LIKE ? OR name LIKE ? OR percentDiscount LIKE ? OR begin LIKE ?";
                pstmt = connection.prepareStatement(query);
                String searchValue = "%" + info + "%";
                pstmt.setString(1, searchValue);
                pstmt.setString(2, searchValue);
                pstmt.setString(3, searchValue);
                pstmt.setString(4, searchValue);
            } else {
                query = "SELECT * FROM discount";
                pstmt = connection.prepareStatement(query);
            }

            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                String discountID = resultSet.getString("discountID");
                String discountName = resultSet.getString("name");
                double percentDiscount = resultSet.getDouble("percentDiscount");
                String begin = resultSet.getString("begin");
                String end = resultSet.getString("end");

                discounts.add(new DiscountDTO(discountID, discountName, percentDiscount, begin, end));
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

        return discounts;
    }

    public static void setAllDiscounts(ArrayList<DiscountDTO> list) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            deleteAllDiscounts();
            connection = Database.getConnection();

            String query = "INSERT INTO discount (discountID, name, percentDiscount, begin, end) VALUES (?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(query);

            for (DiscountDTO discount : list) {
                pstmt.setString(1, discount.getDiscountID());
                pstmt.setString(2, discount.getDiscountName());
                pstmt.setDouble(3, discount.getPercentDiscount());
                pstmt.setString(4, discount.getBegin());
                pstmt.setString(5, discount.getEnd());

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
