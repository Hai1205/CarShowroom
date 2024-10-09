/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.ImportDAL;
import DAL.DetailImportDAL;
import DTO.*;
import GUI.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author ASUS
 */
public class ImportBUS implements ActionListener {

    private ListImport listIp;
    private ListDetailImport listDip;
    private ListProduct listPd;
    private ListSupplier listSp;
    private JPanelImport jPanelImport;
    private DefaultTableModel importTempTable;

    private String importID, supplierID, supplierName;
    private String info, date, productID, productName, productPriceStr, quantityStr, importPriceStr;
    private Double importPrice, productPrice, cost;
    private int selectedRowIndex, quantity;
    private final ArrayList<TempImportDTO> listTempImport = new ArrayList<>();

    public ImportBUS() {
    }

    public ImportBUS(ListImport listIp, JPanelImport jPanelImport) {
        this.listIp = listIp;
        this.listDip = new ListDetailImport();
        this.listPd = new ListProduct();
        this.listSp = new ListSupplier();
        this.jPanelImport = jPanelImport;
        date = Tool.getCurrentDate();
        importTempTable = (DefaultTableModel) jPanelImport.getJTableTempImport().getModel();
        showListTempImport();

        jTableTempImportMouseClicked();
        jTableTempImportKeyPressed();
    }

    private void jTableTempImportMouseClicked() {
        jPanelImport.getJTableTempImport().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRowIndex = jPanelImport.getJTableTempImport().getSelectedRow();
//                setEnabled(false);
                getInfoTable();
                setInfo();
            }
        });
    }

    private void jTableTempImportKeyPressed() {
        jPanelImport.getJTableTempImport().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                selectedRowIndex = jPanelImport.getJTableTempImport().getSelectedRow();
                int rowCount = jPanelImport.getJTableTempImport().getRowCount();

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> {
                        if (selectedRowIndex > 0) {
                            jPanelImport.getJTableTempImport().changeSelection(selectedRowIndex--, 0, false, false);
                        } else {
                        }
                    }
                    case KeyEvent.VK_DOWN -> {
                        if (selectedRowIndex == rowCount - 1) {
                        } else {
                            jPanelImport.getJTableTempImport().changeSelection(selectedRowIndex++, 0, false, false);
                        }
                    }
                }
//                setEnabled(false);
                getInfoTable();
                setInfo();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jPanelImport.getButtonAdd()) {
            add();
        } else if (e.getSource() == jPanelImport.getButtonFix()) {
            fix();
        } else if (e.getSource() == jPanelImport.getButtonConfirm()) {
            confirm();
        } else if (e.getSource() == jPanelImport.getButtonCancle()) {
            cancle();
        } else if (e.getSource() == jPanelImport.getButtonDelete()) {
            delete();
        } else {
            search();
        }
    }

//    private void setEnabled(boolean bool) {
//        jPanelImport.getComboBoxSupplierName().setEnabled(bool);
//        jPanelImport.getComboBoxProductName().setEnabled(bool);
//        jPanelImport.getButtonAdd().setEnabled(bool);
//    }
    private boolean valid() {
        if (productID == null || productID.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelImport, "Xin hãy chọn sản phẩm cần thêm.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelImport.getComboBoxProductName().requestFocus();
            return false;
        } else if (importPriceStr == null || importPriceStr.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelImport, "Xin hãy nhập giá nhập vào của sản phẩm cần thêm.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelImport.getTextFieldImportPrice().requestFocus();
            return false;
        } else if (quantityStr == null || quantityStr.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelImport, "Xin hãy nhập số lượng của sản phẩm cần thêm.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelImport.getTextFieldQuantity().requestFocus();
            return false;
        } else if (productPriceStr == null || productPriceStr.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelImport, "Xin hãy nhập giá bán ra của sản phẩm cần thêm.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelImport.getTextFieldProductPrice().requestFocus();
            return false;
        }
        return true;
    }

    private void add() {
        if (jPanelImport.isFlat()) {
            return;
        }

        getInfo();
        if (!valid()) {
            return;
        }

        productName = (String) jPanelImport.getComboBoxProductName().getSelectedItem();
        importPrice = Double.valueOf(importPriceStr);
        productPrice = Double.valueOf(productPriceStr);
        quantity = Integer.parseInt(quantityStr);
        
        boolean productExists = false;
        for (int i = 0; i < importTempTable.getRowCount(); i++) {
            if (importTempTable.getValueAt(i, 1).equals(productName)) {
                productExists = true;
                
                int totalQuantity = quantity + (int) importTempTable.getValueAt(i, 3);
                double price = (double) importTempTable.getValueAt(i, 2);
                
                importTempTable.setValueAt(importPrice, i, 2);
                importTempTable.setValueAt(totalQuantity, i, 3);
                importTempTable.setValueAt(price * totalQuantity, i, 5);
                jPanelImport.getTextFieldTotalCost().setText(getTotalCost() + "");
                
                break;
            }
        }

        if (!productExists) {
            SetValueTable();
        }
        
        jPanelImport.getTextFieldProductPrice().setEnabled(false);
        clearInfo();
    }

    private void SetValueTable() {
        importTempTable.addRow(new Object[]{supplierName, productName, importPrice, quantity, productPrice, importPrice * quantity});
        jPanelImport.getTextFieldTotalCost().setText(getTotalCost() + "");
    }

    private void delete() {
        if (jPanelImport.isFlat()) {
            return;
        }

        if (importTempTable.getRowCount() == 0) {
            JOptionPane.showMessageDialog(jPanelImport, "Phiếu nhập hiện đang trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(jPanelImport, "Xin hãy chọn đơn hàng cần xóa.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int option = JOptionPane.showConfirmDialog(jPanelImport, "Bạn có chắc muốn xóa sản phẩm ra khỏi phiếu nhập không?",
                "Cảnh báo", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {

            importTempTable.removeRow(selectedRowIndex);
            jPanelImport.setTextFieldTotalCost("" + getTotalCost());
            clearInfo();
        }
    }

    private void fix() {
        if (jPanelImport.isFlat()) {
            return;
        }

        getInfo();
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(jPanelImport, "Xin hãy chọn đơn hàng cần sửa.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!valid()) {
            return;
        }

        importPrice = Double.valueOf(importPriceStr);
        quantity = Integer.parseInt(quantityStr);
        productPrice = Double.valueOf(productPriceStr);
        importTempTable.setValueAt(importPrice, selectedRowIndex, 2);
        importTempTable.setValueAt(quantity, selectedRowIndex, 3);
        importTempTable.setValueAt(productPrice, selectedRowIndex, 4);
        cost = quantity * importPrice;
        importTempTable.setValueAt(cost, selectedRowIndex, 5);

        jPanelImport.getTextFieldTotalCost().setText(getTotalCost() + "");

        clearInfo();
//        setEnabled(true);
    }

    private void confirm() {
        if (jPanelImport.isFlat()) {
            return;
        }

        int rowCount = importTempTable.getRowCount();
        if (rowCount == 0) {
            JOptionPane.showMessageDialog(jPanelImport, "Phiếu nhập hiện đang trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int option = JOptionPane.showConfirmDialog(jPanelImport, "Bạn có chắc muốn xác nhận phiếu nhập không?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            Double totalCost = getTotalCost();

            importID = listIp.createImportID();
            listIp.add(importID, date, totalCost);

            for (int i = 0; i < rowCount; i++) {
                quantity = (Integer) importTempTable.getValueAt(i, 3);
                supplierName = (String) importTempTable.getValueAt(i, 0);
                supplierID = listSp.getSupplierID(supplierName);
                productName = (String) importTempTable.getValueAt(i, 1);
                productID = listPd.getProductID(productName);
                importPrice = (Double) importTempTable.getValueAt(i, 2);
                productPrice = (Double) importTempTable.getValueAt(i, 4);
                cost = (Double) importTempTable.getValueAt(i, 5);

                listDip.add(importID, supplierID, productID, quantity, importPrice, cost);
                listPd.increaseQuantityAndPrice(productID, quantity, productPrice);
            }

            DetailImportDAL.setAllImportDetails(listDip.getList());
            ImportDAL.setAllImports(listIp.getList());
            listPd.setAllProducts(listPd.getList());

            importTempTable.setRowCount(0);
            clearAll();
        }
    }

    private void cancle() {
        if (jPanelImport.isFlat()) {
            return;
        }

        int rowCount = importTempTable.getRowCount();
        if (rowCount == 0) {
            JOptionPane.showMessageDialog(jPanelImport, "Phiếu nhập hiện đang trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int option = JOptionPane.showConfirmDialog(jPanelImport, "Bạn có chắc muốn hủy toàn bộ phiếu nhập không?", "Cảnh báo", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            clearAll();
        }
    }

    private void showListTempImport() {
        importTempTable.setRowCount(0);
        if (listTempImport == null) {
            return;
        }

        for (TempImportDTO tipDTO : listTempImport) {
            importTempTable.addRow(new Object[]{tipDTO.getSupplierName(), tipDTO.getProductName(), tipDTO.getQuantity(), tipDTO.getImportPrice(), tipDTO.getProductPrice(), tipDTO.getCost()});
        }
    }

    private void search() {
        getInfo();

        ArrayList<ImportDTO> result = listIp.search(info);
        jPanelImport.showListImport(result);
        jPanelImport.showListDetailImport(null);
    }

    private void getInfo() {
        supplierName = (String) jPanelImport.getComboBoxSupplierName().getSelectedItem();
        if (!supplierName.equals("Nhấp để chọn")) {
            supplierID = listSp.getSupplierID(supplierName);
        }

        productName = (String) jPanelImport.getComboBoxProductName().getSelectedItem();
        if (!productName.equals("Nhấp để chọn")) {
            productID = listPd.getProductID(productName);
        }

        importPriceStr = jPanelImport.getTextFieldImportPrice().getText().trim();
        quantityStr = jPanelImport.getTextFieldQuantity().getText().trim();
        productPriceStr = jPanelImport.getTextFieldProductPrice().getText().trim();
        info = jPanelImport.getTextFieldSearch().getText().trim();
    }

    private void getInfoTable() {
        supplierName = jPanelImport.getJTableTempImport().getValueAt(selectedRowIndex, 0).toString();
        productName = jPanelImport.getJTableTempImport().getValueAt(selectedRowIndex, 1).toString();
        importPrice = Double.valueOf(jPanelImport.getJTableTempImport().getValueAt(selectedRowIndex, 2).toString());
        quantity = Integer.parseInt(jPanelImport.getJTableTempImport().getValueAt(selectedRowIndex, 3).toString());
        productPrice = Double.valueOf(jPanelImport.getJTableTempImport().getValueAt(selectedRowIndex, 4).toString());
    }

    private void setInfo() {
        jPanelImport.getComboBoxSupplierName().setSelectedItem(supplierName);
        jPanelImport.getComboBoxProductName().setSelectedItem(productName);
        jPanelImport.getTextFieldImportPrice().setText(importPrice + "");
        jPanelImport.getTextFieldQuantity().setText(quantity + "");
        jPanelImport.getTextFieldProductPrice().setText(productPrice + "");
        jPanelImport.getTextFieldTotalCost().setText(getTotalCost() + "");
    }

    private void clearInfo() {
        jPanelImport.getComboBoxSupplierName().setSelectedItem("Nhấp để chọn");
        jPanelImport.getComboBoxProductName().setSelectedItem("Nhấp để chọn");
        jPanelImport.getTextFieldImportPrice().setText("");
        jPanelImport.getTextFieldQuantity().setText("");
        jPanelImport.getTextFieldProductPrice().setText("");
        selectedRowIndex = -1;
    }

    private void clearAll() {
        clearInfo();

        jPanelImport.getTextFieldTotalCost().setText("");
        jPanelImport.getTextFieldSearch().setText("");
        jPanelImport.showListDetailImport(null);
        jPanelImport.showListImport(listIp.getList());
        importTempTable.setRowCount(0);
    }

    private Double getTotalCost() {
        cost = 0.0;
        for (int i = 0; i < importTempTable.getRowCount(); i++) {
            cost += (Double) importTempTable.getValueAt(i, 5);
        }
        return cost;
    }

    public JFreeChart createImportChart() {
        return ImportDAL.createImportChart();
    }
}
