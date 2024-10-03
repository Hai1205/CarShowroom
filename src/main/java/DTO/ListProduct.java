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
public class ListProduct {

    private ArrayList<ProductDTO> list = new ArrayList<>();

    public ListProduct() {
        this.list = ProductDAL.getAllProducts(true);
    }

    public ArrayList<ProductDTO> getList() {
        return list;
    }
    
    public boolean checkNameExist(String name){
        for(ProductDTO pdDTO : list) {
              if(pdDTO.getProductName().equals(name)){
                return false;
              }
        }
        return true;
    }

    public ArrayList<ProductDTO> getListStillSell() {
        return ProductDAL.getAllProducts(false);

    }

    public void add(String productID, String supplierID, String productName, String supplierName, String type, int quantity, double price, boolean status) {
        list.add(0, new ProductDTO(productID, supplierID, productName, supplierName, type, quantity, price, status));
    }

    public ArrayList<ProductDTO> search(String info, String statusSearch) {
        return ProductDAL.search(info, statusSearch);
    }

    public void fix(int i, String productName, String supplierName, Double price, boolean status) {
        ProductDTO pdDTO = list.get(i);
        pdDTO.setAll(productName, supplierName, price, status);
    }

    public ArrayList<String> getListProductName(String supplierName) {
        ArrayList<String> listProductName = new ArrayList<>();
        listProductName.add("Nhấp để chọn");
        for (ProductDTO pd : list) {
            if (pd.getSupplierName().equals(supplierName)) {
                listProductName.add(pd.getProductName());
            }
        }
        return listProductName;
    }

    public String createProductID() {
        String productID;
        do {
            productID = "PD" + Tool.randomID();
        } while (searchByProductID(productID) != -1);

        return productID;
    }

    public int searchByProductID(String productID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductID().equals(productID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchByProductName(String productName) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductName().equals(productName)) {
                return i;
            }
        }
        return -1;
    }

    public String getProductID(String productName) {
        int index = searchByProductName(productName);
        return list.get(index).getProductID();
    }

    public double getPrice(String productName) {
        int index = searchByProductName(productName);
        return list.get(index).getPrice();
    }

    public void increaseQuantityAndPrice(String productID, int quantity, Double price) {
        int index = searchByProductID(productID);
        ProductDTO pdDTO = list.get(index);
        pdDTO.setQuantity(pdDTO.getQuantity() + quantity);
        pdDTO.setPrice(price);
    }

    public void decreaseQuantity(String productID, int quantity) {
        int index = searchByProductID(productID);
        ProductDTO pdDTO = list.get(index);
        pdDTO.setQuantity(pdDTO.getQuantity() - quantity);
    }

    public ProductDTO searchProductByProductID(String productID) {
        if (searchByProductID(productID) != -1) {
            return list.get(searchByProductID(productID));
        }
        return null;
    }

    public void setAllProducts(ArrayList<ProductDTO> temp) {
        ProductDAL.setAllProducts(temp);
    }
}
