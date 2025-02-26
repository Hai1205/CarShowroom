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
public class ListDiscount {

    private ArrayList<DiscountDTO> list = new ArrayList<>();

    public ListDiscount() {
        this.list = DiscountDAL.getAllDiscounts();
    }

    public ArrayList<DiscountDTO> getList() {
        return list;
    }
    
    public boolean checkNameExist(String name){
        for(DiscountDTO dcDTO : list) {
              if(dcDTO.getDiscountName().equalsIgnoreCase(name)){
                return false;
              }
        }
        return true;
    }

    public void add(String discountID, String discountName, double percentDiscount, String begin, String end) {
        list.add(0, new DiscountDTO(discountID, discountName, percentDiscount, begin, end));
    }

    public void fix(int i, String discountID, String discountName, double percentDiscount, String begin, String end) {
        DiscountDTO discount = list.get(i);
        discount.setAll(discountID, discountName, percentDiscount, begin, end);
    }

    public ArrayList<DiscountDTO> search(String info) {
        return DiscountDAL.search(info);
    }

    public String createDiscountID() {
        String discountID;
        do {
            discountID = "DC" + Tool.randomID();
        } while (searchByDiscountID(discountID) != -1);

        return discountID;
    }

    public int searchByDiscountID(String discountID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDiscountID().equals(discountID)) {
                return i;
            }
        }
        return -1;
    }

    public DiscountDTO searchByName(String name) {
        for (DiscountDTO dcDTO : list) {
            if (dcDTO.getDiscountName().equals(name)) {
                return dcDTO;
            }
        }
        return null;
    }

    public ArrayList<String> getListDiscountName() {
        ArrayList<String> listDiscountName = new ArrayList<>();
        listDiscountName.add("Nhấp để chọn");
        String date = Tool.getCurrentDate();
        for (DiscountDTO dcDTO : list) {
            if (!Tool.strToDate(dcDTO.getEnd()).isBefore(Tool.strToDate(date))) {
                listDiscountName.add(dcDTO.getDiscountName());
            }
        }
        return listDiscountName;
    }

}
