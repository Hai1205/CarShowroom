/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import BUS.Tool;
import DAL.*;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ListEmployee {
    
    private ArrayList<EmployeeDTO> list = new ArrayList<>();

    public ListEmployee() {
        this.list = EmployeeDAL.getAllEmployees(true);
    }

    public ArrayList<EmployeeDTO> getList() {
        return list;
    }
    
    public ArrayList<EmployeeDTO> getListStillWork() {
        return EmployeeDAL.getAllEmployees(true);
    }

    public void add(String EmployeeID, String username, String password, String firstname, String lastname, String DOB, double salary, boolean status) {
        list.add(0, new EmployeeDTO(EmployeeID, username, password, firstname, lastname, DOB, salary, status));
    }

    public void fix(int i, String EmployeeID, String username, String password, String firstname, String lastname, String DOB, double salary, boolean status) {
        EmployeeDTO epDTO = list.get(i);
        epDTO.setAll(EmployeeID, username, password, firstname, lastname, DOB, salary, status);
    }

    public ArrayList<EmployeeDTO> search(String info, String statusSearch) {
        return EmployeeDAL.search(info, statusSearch);
    }

    public ArrayList<String> getListEmployeeID() {
        ArrayList<String> listEmployeeID = new ArrayList<>();
        listEmployeeID.add("Nhấp để chọn");
        for (EmployeeDTO epDTO : list) {
            listEmployeeID.add(epDTO.getEmployeeID());
        }
        return listEmployeeID;
    }

    public String createEmployeeID() {
        String employeeID;
        do {
            employeeID = "EP" + Tool.randomID();
        } while (searchByEmployeeID(employeeID) != -1);

        return employeeID;
    }

    public int searchByEmployeeID(String employeeID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmployeeID().equals(employeeID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchByUsername(String username) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }
}
