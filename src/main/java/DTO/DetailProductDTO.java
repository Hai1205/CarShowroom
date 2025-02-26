/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class DetailProductDTO {

    private String productID, MFG, series;
    private int seat, petrol, pin;

    public DetailProductDTO() {
    }

    public DetailProductDTO(String productID, String MFG, int seat, String series, int petrol, int pin) {
        this.productID = productID;
        this.seat = seat;
        this.series = series;
        this.petrol = petrol;
        this.MFG = MFG;
        this.pin = pin;
    }

    public String getProductID() {
        return productID;
    }

    public int getSeat() {
        return seat;
    }

    public String getSeries() {
        return series;
    }

    public int getPetrol() {
        return petrol;
    }

    public String getMFG() {
        return MFG;
    }

    public int getPin() {
        return pin;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setFuel(int fuel) {
        this.petrol = fuel;
    }

    public void setMFG(String MFG) {
        this.MFG = MFG;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setAll(String productID, String MFG, int seat, String series, int petrol, int pin) {
        setProductID(productID);
        setSeat(seat);
        setSeries(series);
        setFuel(petrol);
        setMFG(MFG);
        setPin(pin);
    }

    public void setAll(String MFG, int seat, String series, int petrol, int pin) {
        setSeat(seat);
        setSeries(series);
        setFuel(petrol);
        setMFG(MFG);
        setPin(pin);
    }
}
