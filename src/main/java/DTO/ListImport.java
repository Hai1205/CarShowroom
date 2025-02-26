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
public class ListImport {

    private ArrayList<ImportDTO> list = new ArrayList<>();

    public ListImport() {
        this.list = ImportDAL.getAllImports();
    }

    public ArrayList<ImportDTO> getList() {
        return list;
    }

    public void add(String importID, String date, double totalCost) {
        list.add(0, new ImportDTO(importID, date, totalCost));
    }

    public ArrayList<ImportDTO> search(String info) {
        return ImportDAL.search(info);
    }

    public String getImportID(int index) {
        return list.get(index).getImportID();
    }

    public void updateTotalCost(String importID, double totalCost) {
        int index = searchByImportID(importID);
        list.get(index).setTotalCost(totalCost);
    }

    public String createImportID() {
        String importID;
        do {
            importID = "IP" + Tool.randomID();
        } while (searchByImportID(importID) != -1);

        return importID;
    }

    public int searchByImportID(String importID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getImportID().equals(importID)) {
                return i;
            }
        }
        return -1;
    }
}
