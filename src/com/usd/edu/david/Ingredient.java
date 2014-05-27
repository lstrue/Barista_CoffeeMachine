/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usd.edu.david;

/**
 *
 * @author David Lee
 */
public class Ingredient {
    
    String name;
    double price;
    int amount;

    public Ingredient(){
        
    }
    
    public Ingredient(String name, double price, int amount){
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
