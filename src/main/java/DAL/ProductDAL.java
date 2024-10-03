/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.ProductDTO;
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
public class ProductDAL {

    public static ArrayList<ProductDTO> getAllProducts(boolean bool) {
        ArrayList<ProductDTO> products = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = Database.getConnection();
            statement = connection.createStatement();

            String query;
            if (bool == true) {
                query = "SELECT * FROM product";
            } else {
                query = "SELECT * FROM product WHERE status = true";
            }
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String productID = resultSet.getString("productID");
                String supplierID = resultSet.getString("supplierID");
                String productName = resultSet.getString("productName");
                String supplierName = resultSet.getString("supplierName");
                String type = resultSet.getString("type");
                int quantity = resultSet.getInt("quantity");
                Double price = resultSet.getDouble("price");
                boolean status = resultSet.getBoolean("status");

                products.add(new ProductDTO(productID, supplierID, productName, supplierName, type, quantity, price, status));
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
        return products;
    }

    public static void deleteAllProducts() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = Database.getConnection();
            String sql = "DELETE FROM product";
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

    public static void setAllProducts(ArrayList<ProductDTO> list) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            deleteAllProducts();
            connection = Database.getConnection();

            String sql = "INSERT INTO product (productID, supplierID, productName, supplierName, type, quantity, price, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            for (ProductDTO Product : list) {
                pstmt.setString(1, Product.getProductID());
                pstmt.setString(2, Product.getSupplierID());
                pstmt.setString(3, Product.getProductName());
                pstmt.setString(4, Product.getSupplierName());
                pstmt.setString(5, Product.getType());
                pstmt.setInt(6, Product.getQuantity());
                pstmt.setDouble(7, Product.getPrice());
                pstmt.setBoolean(8, Product.getStatus());

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

    public static ArrayList<ProductDTO> search(String info, String statusSearch) {
        ArrayList<ProductDTO> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            String query;
            if (info != null && !info.isEmpty()) {
                query = "SELECT * FROM product WHERE";
                if (statusSearch.equals("Còn bán")) {
                    query += " status = 1 AND";
                } else if (statusSearch.equals("Ngưng bán")) {
                    query += " status = 0 AND";
                }
                query += " (productID LIKE ? OR supplierID LIKE ? OR productName LIKE ? OR supplierName LIKE ? OR type LIKE ? OR quantity LIKE ? OR price LIKE ?)";
                pstmt = connection.prepareStatement(query);
                String searchPattern = "%" + info + "%";
                pstmt.setString(1, searchPattern);
                pstmt.setString(2, searchPattern);
                pstmt.setString(3, searchPattern);
                pstmt.setString(4, searchPattern);
                pstmt.setString(5, searchPattern);
                pstmt.setString(6, searchPattern);
                pstmt.setString(7, searchPattern);
            } else {
                query = "SELECT * FROM product";
                if (statusSearch.equals("Còn bán")) {
                    query += " WHERE status = 1";
                } else if (statusSearch.equals("Ngưng bán")) {
                    query += " WHERE status = 0";
                }
                pstmt = connection.prepareStatement(query);
            }

            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                String resultProductID = resultSet.getString("productID");
                String resultSupplierID = resultSet.getString("supplierID");
                String resultProductName = resultSet.getString("productName");
                String resultSupplierName = resultSet.getString("supplierName");
                String resultType = resultSet.getString("type");
                int resultQuantity = resultSet.getInt("quantity");
                Double resultPrice = resultSet.getDouble("price");
                boolean resultStatus = resultSet.getBoolean("status");

                result.add(new ProductDTO(resultProductID, resultSupplierID, resultProductName, resultSupplierName, resultType, resultQuantity, resultPrice, resultStatus));
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
        return result;
    }

}
