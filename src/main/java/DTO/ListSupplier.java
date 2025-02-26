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
public class ListSupplier {

    private ArrayList<SupplierDTO> list = new ArrayList<>();

    public ListSupplier() {
        this.list = SupplierDAL.getAllSuppliers();
    }

    public ArrayList<SupplierDTO> getList() {
        return list;
    }
    
    public boolean checkNameExist(String name){
        for(SupplierDTO spDTO : list) {
              if(spDTO.getName().equals(name)){
                return false;
              }
        }
        return true;
    }
    
    public boolean checkPhoneExist(String phone){
        for(SupplierDTO spDTO : list) {
              if(spDTO.getPhone().equals(phone)){
                return false;
              }
        }
        return true;
    }

    public void add(String supplierID, String name, String address, String phone) {
        list.add(0, new SupplierDTO(supplierID, name, address, phone));
    }

    public void fix(int i, String supplierID, String name, String address, String phone) {
        SupplierDTO spDTO = list.get(i);
        spDTO.setAll(supplierID, name, address, phone);
    }

    public ArrayList<SupplierDTO> search(String info) {
        return SupplierDAL.search(info);
    }

    public ArrayList<String> getListSupplierName() {
        ArrayList<String> listSupplierName = new ArrayList<>();
        listSupplierName.add("Nhấp để chọn");
        for (SupplierDTO sp : list) {
            listSupplierName.add(sp.getName());
        }
        return listSupplierName;
    }
    
    public int searchBySupplierID(String supplierID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSupplierID().equals(supplierID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchBySupplierName(String supplierName) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(supplierName)) {
                return i;
            }
        }
        return -1;
    }
    
    public String getSupplierID(String supplierName){
        int index = searchBySupplierName(supplierName);
        if(index!=-1){
            return list.get(index).getSupplierID();
        }
        return null;
    }    
    
    public String createSupplierID() {
        String supplierID;
        do {
            supplierID = "SP" + Tool.randomID();
        } while (searchBySupplierID(supplierID) != -1);

        return supplierID;
    }
}
