/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class OrderDTO{
    private final String idProduct, nameProduct, type;
    private final int quantity, seat;
    private double price, discoutPercent, cost;
    
    public OrderDTO(String idProduct, String nameProduct, String type, int seat, int quantity, double price, double cost){
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.quantity = quantity;
        this.type = type;
        this.seat = seat;
        this.price = price;
        this.cost = cost;
    }
    
    public String getIdProduct(){
        return idProduct;
    }
    
    public String getNameProduct(){
        return nameProduct;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public String getType(){
        return type;
    }
    
    public int getSeat(){
        return seat;
    }
    
    public double getPrice(){
        return price;
    }
    
    public double getDiscoutPercent(){
        return discoutPercent;
    }
    
    public double getCost(){
        return cost;
    }
}
