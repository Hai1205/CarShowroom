/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import BUS.Tool;
import DAL.InvoiceDAL;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ListInvoice {

    private ArrayList<InvoiceDTO> list = new ArrayList<>();

    public ListInvoice() {
        this.list = InvoiceDAL.getAllInvoices();
    }

    public ArrayList<InvoiceDTO> getList() {
        return list;
    }

    public void add(String invoiceID, String customerID, String employeeID, String discountID, String date, double tempCost, double reducedCost, double totalCost) {
        list.add(0, new InvoiceDTO(invoiceID, customerID, employeeID, discountID, date, tempCost, reducedCost, totalCost));
    }

    public ArrayList<InvoiceDTO> search(String info) {
        return InvoiceDAL.search(info);
    }

    public String getInvoiceID(int index) {
        return list.get(index).getInvoiceID();
    }
    
    public void setAllInvoices(ArrayList<InvoiceDTO> temp) {
        InvoiceDAL.setAllInvoices(temp);
    }
    
    public String createInvoiceID() {
        String invoiceID;
        do {
            invoiceID = "IV" + Tool.randomID();
        } while (searchByInvoiceID(invoiceID) != -1);

        return invoiceID;
    }
    
    public int searchByInvoiceID(String invoiceID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getInvoiceID().equals(invoiceID)) {
                return i;
            }
        }
        return -1;
    }
}
