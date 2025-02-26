/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import DAL.*;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ListDetailImport {

    private ArrayList<DetailImportDTO> list = new ArrayList<>();

    public ListDetailImport() {
        this.list = DetailImportDAL.getAllImportDetails(null);
    }

    public ArrayList<DetailImportDTO> getListTemp(String importID) {
        return DetailImportDAL.getAllImportDetails(importID);
    }

    public ArrayList<DetailImportDTO> getList() {
        return list;
    }

    public void setList(ArrayList<DetailImportDTO> list) {
        this.list = list;
    }

    public void add(String importID, String supplierID, String productID, int quantity, double price, double cost) {
        list.add(0, new DetailImportDTO(importID, supplierID, productID, quantity, price, cost));
    }

    public int searchByImportIDProductID(String importID, String productID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getImportID().equals(importID) && list.get(i).getProductID().equals(productID)) {
                return i;
            }
        }
        return -1;
    }

    public void updateQuantity(int i, int quantity) {
        DetailImportDTO dipDTO = list.get(i);
        dipDTO.setQuantity(dipDTO.getQuantity() + quantity);
        dipDTO.setCost(dipDTO.getQuantity() * dipDTO.getPrice());
    }
    
}
