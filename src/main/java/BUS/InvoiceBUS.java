/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAL.InvoiceDAL;
import DTO.*;
import GUI.JPanelInvoice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author ASUS
 */
public class InvoiceBUS implements ActionListener {
    private ListInvoice listIv;
    private JPanelInvoice jPanelInvoice;

    public InvoiceBUS(ListInvoice listIv, JPanelInvoice jPanelInvoice) {
        this.listIv = listIv;
        this.jPanelInvoice = jPanelInvoice;
    }

    public InvoiceBUS() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jPanelInvoice.getButtonInvoiceSearch()) {
            search();
        }
    }

    private void search() {
        String info = jPanelInvoice.getTextFieldSearch().getText().trim();
        ArrayList<InvoiceDTO> result = listIv.search(info);
        jPanelInvoice.showListInvoice(result);
        jPanelInvoice.showListInvoiceDetail(null);
    }

    public JFreeChart createChart(){
        return InvoiceDAL.createInvoiceChart();
    }
}
