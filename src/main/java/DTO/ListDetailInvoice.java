/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import DAL.DetailInvoiceDAL;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ListDetailInvoice {

    private ArrayList<DetailInvoiceDTO> list = new ArrayList<>();

    public ListDetailInvoice() {
        this.list = DetailInvoiceDAL.getAllDetailInvoices(null);
    }

    public void setList(String invoiceID) {
        list.clear();
        this.list = DetailInvoiceDAL.getAllDetailInvoices(invoiceID);
    }

    public ArrayList<DetailInvoiceDTO> getList() {
        return list;
    }

    public void setList(ArrayList<DetailInvoiceDTO> list) {
        this.list = list;
    }

    public void add(String invoiceID, String productID, double price, int quantity, double totalCost) {
        list.add(0, new DetailInvoiceDTO(invoiceID, productID, price, quantity, totalCost));
    }

    public void setAllDetailInvoices(ArrayList<DetailInvoiceDTO> temp) {
        DetailInvoiceDAL.setAllDetailInvoices(temp);
    }
}
