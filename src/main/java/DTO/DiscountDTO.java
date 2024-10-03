/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class DiscountDTO {

    private String discountID, discountName, begin, end;
    private double percentDiscount;

    public DiscountDTO() {
    }

    public DiscountDTO(String discountID, String discountName,  double percentDiscount, String begin, String end) {
        this.discountID = discountID;
        this.discountName = discountName;
        this.percentDiscount = percentDiscount;
        this.begin = begin;
        this.end = end;
    }

    public String getDiscountID() {
        return discountID;
    }

    public String getDiscountName() {
        return discountName;
    }

    public double getPercentDiscount() {
        return percentDiscount;
    }

    public String getBegin() {
        return begin;
    }

    public String getEnd() {
        return end;
    }

    public void setDiscountID(String discountID) {
        this.discountID = discountID;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public void setEnd(String end) {
        this.end = end;
    }
    
    public void setAll(String discountID, String discountName, double percentDiscount, String begin, String end){
        setDiscountID(discountID);
        setDiscountName(discountName);
        setPercentDiscount(percentDiscount);
        setBegin(begin);
        setEnd(end);
    }
}
