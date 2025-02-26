/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.*;
import DTO.*;
import GUI.JPanelEmployee;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class EmployeeBUS implements ActionListener {

    private ListEmployee listEp;
    private JPanelEmployee jPanelEmployee;
    private String username, password, employeeID, firstname, lastname, DOB, salary;
    private boolean status;

    public EmployeeBUS(ListEmployee listEp, JPanelEmployee jPanelEmployee) {
        this.listEp = listEp;
        this.jPanelEmployee = jPanelEmployee;
    }

    public EmployeeBUS() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jPanelEmployee.getButtonAdd()) {
            add();
        } else if (e.getSource() == jPanelEmployee.getButtonFix()) {
            fix();
        } else if (e.getSource() == jPanelEmployee.getButtonShowAll()) {
            showAll();
        } else {
            jPanelEmployee.showList(search());
        }
    }

    @SuppressWarnings("deprecation")
    private void getEmployee() {
        username = jPanelEmployee.getTextFieldEmployeeUsername().getText().trim();
        password = jPanelEmployee.getTextFieldEmployeePassword().getText().trim();
        employeeID = jPanelEmployee.getTextFieldEmployeeID().getText().trim();
        firstname = jPanelEmployee.getTextFieldEmployeeFirstname().getText().trim();
        lastname = jPanelEmployee.getTextFieldEmployeeLastname().getText().trim();
        DOB = jPanelEmployee.getTextFieldEmployeeDOB().getText().trim();
        salary = jPanelEmployee.getTextFieldEmployeeSalary().getText().trim();
        String statusStr = (String) jPanelEmployee.getComboBoxEmployeeStatus().getSelectedItem();
        status = statusStr.equals("Còn làm việc");
    }

    private void clear() {
        setEnabled(true);
        jPanelEmployee.getTextFieldEmployeeID().setText("");
        jPanelEmployee.getTextFieldEmployeeFirstname().setText("");
        jPanelEmployee.getTextFieldEmployeeUsername().setText("");
        jPanelEmployee.getTextFieldEmployeePassword().setText("");
        jPanelEmployee.getTextFieldEmployeeLastname().setText("");
        jPanelEmployee.getTextFieldEmployeeDOB().setText("");
        jPanelEmployee.getTextFieldEmployeeSalary().setText("");
        jPanelEmployee.getTextFieldSearch().setText("");
        jPanelEmployee.getComboBoxEmployeeStatus().setSelectedIndex(0);
        jPanelEmployee.getComboboxStatusSearch().setSelectedIndex(0);
    }

    public void setEnabled(boolean bool) {
        jPanelEmployee.getButtonAdd().setEnabled(bool);
        jPanelEmployee.getTextFieldEmployeeUsername().setEnabled(bool);
    }

    public boolean searchByUsername(String username) {
        return listEp.searchByUsername(username) != -1;
    }

    private boolean valid() {
        if (username == null || username.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelEmployee, "Tên đăng nhập không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelEmployee.getTextFieldEmployeeUsername().requestFocus();
            return false;
        } else if (password == null || password.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelEmployee, "Mật khẩu không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelEmployee.getTextFieldEmployeePassword().requestFocus();
            return false;
        } else if (firstname == null || firstname.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelEmployee, "Họ của nhân viên không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelEmployee.getTextFieldEmployeeFirstname().requestFocus();
            return false;
        } else if (lastname == null || lastname.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelEmployee, "Tên của nhân viên không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelEmployee.getTextFieldEmployeeLastname().requestFocus();
            return false;
        } else if (DOB == null || DOB.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelEmployee, "Ngày sinh của nhân viên không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelEmployee.getTextFieldEmployeeDOB().requestFocus();
            return false;
        } else if (salary == null || salary.isEmpty()) {
            JOptionPane.showMessageDialog(jPanelEmployee, "Tiền lương của nhân viên không được để trống.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            jPanelEmployee.getTextFieldEmployeeSalary().requestFocus();
            return false;
        }
        return true;
    }

    private void add() {
        if (jPanelEmployee.isFlat()) {
            return;
        }

        getEmployee();
        if (!valid()) {
            return;
        }

        employeeID = listEp.createEmployeeID();
        listEp.add(employeeID, username, password, firstname, lastname, DOB, Double.parseDouble(salary), status);
        EmployeeDAL.setAllEmployees(listEp.getList());
        jPanelEmployee.showList(listEp.getList());

        clear();
    }

    private void fix() {
        if (jPanelEmployee.isFlat()) {
            return;
        }

        int selectedRow = jPanelEmployee.getJTableEmployee().getSelectedRow();
        getEmployee();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(jPanelEmployee, "Xin hãy chọn nhân viên cần sửa.", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!valid()) {
            return;
        }

        listEp.fix(selectedRow, employeeID, username, password, firstname, lastname, DOB, Double.parseDouble(salary), status);
        EmployeeDAL.setAllEmployees(listEp.getList());
        jPanelEmployee.showList(listEp.getList());

        clear();
    }

    private void showAll() {
        clear();
        jPanelEmployee.showList(listEp.getList());
    }

    private ArrayList<EmployeeDTO> search() {
        String info = jPanelEmployee.getTextFieldSearch().getText().trim();
        String statusSearch = (String) jPanelEmployee.getComboboxStatusSearch().getSelectedItem();
        ArrayList<EmployeeDTO> ls = listEp.search(info, statusSearch);

        if (ls.isEmpty()) {
            return null;
        }
        return ls;
    }
}
