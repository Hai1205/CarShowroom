/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.ImportDTO;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ASUS
 */
public class ImportDAL {

    public static ArrayList<ImportDTO> getAllImports() {
        ArrayList<ImportDTO> imports = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = Database.getConnection();
            String query = "SELECT * FROM import ORDER BY SUBSTRING(date, 7, 4) DESC";
            pstmt = connection.prepareStatement(query);
            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                String importID = resultSet.getString("importID");
                String date = resultSet.getString("date");
                Double totalCost = resultSet.getDouble("totalCost");

                imports.add(new ImportDTO(importID, date, totalCost));
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
        return imports;
    }

    public static void deleteAllImports() {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = Database.getConnection();
            String query = "DELETE FROM import";
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
                e.printStackTrace();
            }
        }
    }

    public static void setAllImports(ArrayList<ImportDTO> list) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            deleteAllImports();
            connection = Database.getConnection();

            String query = "INSERT INTO import (importID, date, totalCost) VALUES (?, ?, ?)";
            pstmt = connection.prepareStatement(query);

            for (ImportDTO ip : list) {
                pstmt.setString(1, ip.getImportID());
                pstmt.setString(2, ip.getDate());
                pstmt.setDouble(3, ip.getTotalCost());

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

    public static ArrayList<ImportDTO> search(String info) {
        ArrayList<ImportDTO> result = new ArrayList<>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            String query;

            if (info != null && !info.isEmpty()) {
                query = "SELECT * FROM import WHERE importID LIKE ? OR date LIKE ? OR totalCost LIKE ? ORDER BY SUBSTRING(date, 7, 4) DESC";
                pstmt = connection.prepareStatement(query);
                String searchValue = "%" + info + "%";
                pstmt.setString(1, searchValue);
                pstmt.setString(2, searchValue);
                pstmt.setString(3, searchValue);
            } else {
                query = "SELECT * FROM import ORDER BY SUBSTRING(date, 7, 4) DESC";
                pstmt = connection.prepareStatement(query);
            }

            resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                String resultImportID = resultSet.getString("importID");
                String resultDate = resultSet.getString("date");
                int resultTotalCost = resultSet.getInt("totalCost");

                result.add(new ImportDTO(resultImportID, resultDate, resultTotalCost));
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

    public static JFreeChart createImportChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            Connection connection = Database.getConnection();
            String query = """
                   SELECT SUBSTRING(date, 7, 4) AS year, CAST(SUM(totalCost) AS UNSIGNED) AS total_import_cost
                   FROM Import
                   GROUP BY SUBSTRING(date, 7, 4)
                   ORDER BY year DESC
                   LIMIT 5""";

            try (Statement statement = connection.createStatement(); ResultSet rs = statement.executeQuery(query)) {
                // Tạo list để lưu trữ dữ liệu
                List<String[]> dataList = new ArrayList<>();

                // Lưu trữ dữ liệu vào list
                while (rs.next()) {
                    String year = rs.getString("year");
                    int totalImportCost = rs.getInt("total_import_cost");
                    dataList.add(new String[]{year, String.valueOf(totalImportCost)});
                }

                // Đảo ngược thứ tự list
                Collections.reverse(dataList);

                // Thêm dữ liệu từ list đã đảo ngược vào dataset
                for (String[] data : dataList) {
                    dataset.addValue(Integer.parseInt(data[1]), "Chi phí nhập", data[0]);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Thống kê tổng tiền nhập hàng hằng năm",
                "Năm",
                "Tổng tiền nhập hàng",
                dataset
        );
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.CYAN);

        return chart;
    }
}
