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
public class ListDetailProduct {

    private ArrayList<DetailProductDTO> list = new ArrayList<>();

    public ListDetailProduct() {
        this.list = DetailProductDAL.getAllProductDetails();
    }

    public ArrayList<DetailProductDTO> getList() {
        return list;
    }
    
    public void updateList(){
        this.list = DetailProductDAL.getAllProductDetails();
    }

    public void add(String productID, String MFG, int seat, String series, int petrol, int pin) {
        list.add(0, new DetailProductDTO(productID, MFG, seat, series, petrol, pin));
    }

    public void fix(String productID, String MFG, int seat, String series, int fuel) {
        int index = searchByProductID(productID);
        DetailProductDTO dpdDTO = list.get(index);
        if (dpdDTO.getPin() == 0) {
            dpdDTO.setAll(MFG, seat, series, fuel, 0);
        } else {
            dpdDTO.setAll(MFG, seat, series, 0, fuel);
        }
    }

    public int searchByProductID(String productID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductID().equalsIgnoreCase(productID)) {
                return i;
            }
        }
        return -1;
    }

    public void setAllProductDetails(ArrayList<DetailProductDTO> temp) {
        DetailProductDAL.setAllProductDetails(temp);
    }

    public DetailProductDTO searchDetailProductByProductID(String productID) {
        if (searchByProductID(productID) != -1) {
            return list.get(searchByProductID(productID));
        }
        return null;
    }
}
