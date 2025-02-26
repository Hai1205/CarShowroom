/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.*;
import DTO.*;
import GUI.JPanelSupplier;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class SupplierBUS implements ActionListener {

    private final ListSupplier listSp;
    private JPanelSupplier jPanelSupplier;
    private String supplierID, name, address, phone;

    public SupplierBUS() {
        listSp = new ListSupplier();
    }

    public SupplierBUS(ListSupplier listSp, JPanelSupplier jPanelSupplier) {
        this.listSp = listSp;
        this.jPanelSupplier = jPanelSupplier;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jPanelSupplier.getButtonAdd()) {
            add();
        } else if (e.getSource() == jPanelSupplier.getButtonFix()) {
            fix();
        } else if (e.getSource() == jPanelSupplier.getButtonShowAll()) {
            showAll();
        } else {
            jPanelSupplier.showList(search());
        }
    }

    private void getSupplier() {
        supplierID = jPanelSupplier.getTextFieldSupplierID().getText().trim();
        name = jPanelSupplier.getTextFieldSupplierName().getText().trim();
        address = jPanelSupplier.getTextFieldSupplierAddress().getText().trim();
        phone = jPanelSupplier.getTextFieldSupplierNumberPhone().getText().trim();
    }

    private void clear() {
        setEnabled(true);
        jPanelSupplier.getTextFieldSupplierID().setText("");
        jPanelSupplier.getTextFieldSupplierName().setText("");
        jPanelSupplier.getTextFieldSupplierAddress().setText("");
        jPanelSupplier.getTextFieldSupplierNumberPhone().setText("");
    }
    
    public void setEnabled(boolean bool) {
        jPanelSupplier.getButtonAdd().setEnabled(bool);
        jPanelSupplier.getTextFieldSupplierName().setEnabled(bool);
    }

    private void add() {
        if (jPanelSupplier.isFlat()) {
            return;
        }
        
        getSupplier();
        if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelSupplier, "Tên nhà cung cấp không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (address == null || address.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelSupplier, "Địa chỉ nhà cung không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (phone == null || phone.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelSupplier, "Số điện thoại nhà cung không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        supplierID = listSp.createSupplierID();
        listSp.add(supplierID, name, address, phone);
        SupplierDAL.setAllSuppliers(listSp.getList());
        jPanelSupplier.showList(listSp.getList());
        clear();
    }

    private void fix() {
        if (jPanelSupplier.isFlat()) {
            return;
        }
        
        int selectedRow = jPanelSupplier.getJTableSupplier().getSelectedRow();
        getSupplier();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(jPanelSupplier, "Xin hãy chọn nhà cung cấp cần sửa.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (name == null || name.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelSupplier, "Tên nhà cung cấp không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (address == null || address.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelSupplier, "Địa chỉ nhà cung không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (phone == null || phone.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelSupplier, "Số điện thoại nhà cung không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

        listSp.fix(selectedRow, supplierID, name, address, phone);
        SupplierDAL.setAllSuppliers(listSp.getList());
        jPanelSupplier.showList(listSp.getList());
        clear();
    }

    private void showAll() {
        clear();
        jPanelSupplier.showList(listSp.getList());
    }

    private ArrayList<SupplierDTO> search() {
        String info = jPanelSupplier.getTextFieldSearch().getText().trim();
        ArrayList<SupplierDTO> ls = listSp.search(info);

        if (ls.isEmpty()) {
            return null;
        }
        return ls;
    }

}
