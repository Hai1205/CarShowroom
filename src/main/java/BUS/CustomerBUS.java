/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.*;
import DTO.*;
import GUI.JPanelCustomer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class CustomerBUS implements ActionListener {

    private ListCustomer listCtm;
    private JPanelCustomer jPanelCustomer;
    private String customerID, firstname, lastname, address, phone;

    public CustomerBUS(ListCustomer listCtm, JPanelCustomer jPanelCustomer) {
        this.listCtm = listCtm;
        this.jPanelCustomer = jPanelCustomer;
    }

    public CustomerBUS() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jPanelCustomer.getButtonAdd()) {
            add();
        } else if (e.getSource() == jPanelCustomer.getButtonFix()) {
            fix();
        } else if (e.getSource() == jPanelCustomer.getButtonShowAll()) {
            showAll();
        } else {
            jPanelCustomer.showList(search());
        }
    }

    private void getCustomer() {
        customerID = jPanelCustomer.getTextFieldCustomerID().getText().trim();
        firstname = jPanelCustomer.getTextFieldCustomerFirstname().getText().trim();
        lastname = jPanelCustomer.getTextFieldCustomerLastname().getText().trim();
        address = jPanelCustomer.getTextFieldCustomerAddress().getText().trim();
        phone = jPanelCustomer.getTextFieldCustomerPhone().getText().trim();
    }

    private void clear() {
        setEnabled(true);
        jPanelCustomer.getTextFieldCustomerID().setText("");
        jPanelCustomer.getTextFieldCustomerFirstname().setText("");
        jPanelCustomer.getTextFieldCustomerLastname().setText("");
        jPanelCustomer.getTextFieldCustomerAddress().setText("");
        jPanelCustomer.getTextFieldCustomerPhone().setText("");
        jPanelCustomer.getTextFieldSearch().setText("");
    }

    public void setEnabled(boolean bool) {
        jPanelCustomer.getButtonAdd().setEnabled(bool);
    }

    private boolean valid() {
        if (firstname == null || firstname.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelCustomer, "Họ của khách hàng không được để trống.", "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            jPanelCustomer.getTextFieldCustomerFirstname().requestFocus();
            return false;
        } else if (lastname == null || lastname.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelCustomer, "Tên của khách hàng không được để trống.", "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            jPanelCustomer.getTextFieldCustomerLastname().requestFocus();
            return false;
        } else if (address == null || address.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelCustomer, "Địa chỉ của khách hàng không được để trống.", "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            jPanelCustomer.getTextFieldCustomerAddress().requestFocus();
            return false;
        } else if (phone == null || phone.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelCustomer, "Số điện thoại của khách hàng không được để trống.", "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            jPanelCustomer.getTextFieldCustomerPhone().requestFocus();
            return false;
        }
        return true;
    }

    private void add() {
        if (jPanelCustomer.isFlat()) {
            return;
        }

        getCustomer();
        if (!valid()) {
            return;
        }

        customerID = listCtm.createCustomerID();
        listCtm.add(customerID, firstname, lastname, address, phone);
        CustomerDAL.setAllCustomers(listCtm.getList());
        jPanelCustomer.showList(listCtm.getList());
        clear();
    }

    private void fix() {
        if (jPanelCustomer.isFlat()) {
            return;
        }

        int selectedRow = jPanelCustomer.getJTableCustomer().getSelectedRow();
        getCustomer();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(jPanelCustomer, "Xin hãy chọn khách hàng cần sửa.", "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!valid()) {
            return;
        }

        listCtm.fix(selectedRow, customerID, firstname, lastname, address, phone);
        CustomerDAL.setAllCustomers(listCtm.getList());
        jPanelCustomer.showList(listCtm.getList());
        clear();
    }

    private void showAll() {
        clear();
        jPanelCustomer.showList(listCtm.getList());
    }

    private ArrayList<CustomerDTO> search() {
        String info = jPanelCustomer.getTextFieldSearch().getText().trim();
        ArrayList<CustomerDTO> ls = listCtm.search(info);

        if (ls.isEmpty()) {
            return null;
        }
        return ls;
    }
}
