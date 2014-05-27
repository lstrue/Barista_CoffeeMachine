/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usd.edu.david;

/**
 *
 * @author David Lee
 */
public class Drink {
    
    String name;
    
    public Drink(){
        
    }
    
    public Drink(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice(String name, IngredientCollection ic){
        Util util = new Util();
        double price = 0.0;
        if(name.equals("Coffee")){
            double price1 = util.multiplyDouble(ic.getIngredientByName("Coffee").getPrice(), 3);
            double price2 = util.multiplyDouble(ic.getIngredientByName("Sugar").getPrice(), 1);
            double price3 = util.multiplyDouble(ic.getIngredientByName("Cream").getPrice(), 1);
            price = util.addDouble(price1, price2);
            price = util.addDouble(price, price3);
        }
        if(name.equals("Decaf Coffee")){
            double price1 = util.multiplyDouble(ic.getIngredientByName("Decaf Coffee").getPrice(), 3);
            double price2 = util.multiplyDouble(ic.getIngredientByName("Sugar").getPrice(), 1);
            double price3 = util.multiplyDouble(ic.getIngredientByName("Cream").getPrice(), 1);
            price = util.addDouble(price1, price2);
            price = util.addDouble(price, price3);
        }
        if(name.equals("Caffe Latte")){
            double price1 = util.multiplyDouble(ic.getIngredientByName("Espresso").getPrice(), 2);
            double price2 = util.multiplyDouble(ic.getIngredientByName("Steamed Milk").getPrice(), 1);
            price = util.addDouble(price1, price2);
        }
        if(name.equals("Caffe Americano")){
            double price1 = util.multiplyDouble(ic.getIngredientByName("Espresso").getPrice(), 3);
            price = price1;
        }
        if(name.equals("Caffe Mocha")){
            double price1 = util.multiplyDouble(ic.getIngredientByName("Espresso").getPrice(), 1);
            double price2 = util.multiplyDouble(ic.getIngredientByName("Cocoa").getPrice(), 1);
            double price3 = util.multiplyDouble(ic.getIngredientByName("Steamed Milk").getPrice(), 1);
            double price4 = util.multiplyDouble(ic.getIngredientByName("Whipped Cream").getPrice(), 1);
            price = util.addDouble(price1, price2);
            price = util.addDouble(price, price3);
            price = util.addDouble(price, price4);
        }
        if(name.equals("Cappuccino")){
            double price1 = util.multiplyDouble(ic.getIngredientByName("Espresso").getPrice(), 2);
            double price2 = util.multiplyDouble(ic.getIngredientByName("Steamed Milk").getPrice(), 1);
            double price3 = util.multiplyDouble(ic.getIngredientByName("Foamed Milk").getPrice(), 1);
            price = util.addDouble(price1, price2);
            price = util.addDouble(price, price3);
        }
        return price;
    }

    public boolean getAvailability(String name, IngredientCollection ic){
        if (name.equals("Coffee")) {
            if (ic.getIngredientAvailability("Coffee", 3)
                    && ic.getIngredientAvailability("Sugar", 1)
                    && ic.getIngredientAvailability("Cream", 1)) {
                return true;
            }
        }
        if (name.equals("Decaf Coffee")) {
            if (ic.getIngredientAvailability("Decaf Coffee", 3)
                    && ic.getIngredientAvailability("Sugar", 1)
                    && ic.getIngredientAvailability("Cream", 1)) {
                return true;
            }
        }
        if (name.equals("Caffe Latte")) {
            if (ic.getIngredientAvailability("Espresso", 2)
                    && ic.getIngredientAvailability("Steamed Milk", 1)){
                return true;
            }
        }
        if (name.equals("Caffe Americano")) {
            if (ic.getIngredientAvailability("Espresso", 3)) {
                return true;
            }
        }
        if (name.equals("Caffe Mocha")) {
            if (ic.getIngredientAvailability("Espresso", 1)
                    && ic.getIngredientAvailability("Cocoa", 1)
                    && ic.getIngredientAvailability("Steamed Milk", 1)
                    && ic.getIngredientAvailability("Whipped Cream", 1)) {
                return true;
            }
        }
        if (name.equals("Cappuccino")) {
            if (ic.getIngredientAvailability("Espresso", 2)
                    && ic.getIngredientAvailability("Steamed Milk", 1)
                    && ic.getIngredientAvailability("Foamed Milk", 1)) {
                return true;
            }
        }
        return false;
    }
    
    public void consumeIngredient(String name, IngredientCollection ic){
        if (name.equals("Coffee")) {
            ic.consumeIngredient("Coffee", 3);
            ic.consumeIngredient("Sugar", 1);
            ic.consumeIngredient("Cream", 1);
        }
        if (name.equals("Decaf Coffee")) {
            ic.consumeIngredient("Decaf Coffee", 3);
            ic.consumeIngredient("Sugar", 1);
            ic.consumeIngredient("Cream", 1);
        }
        if (name.equals("Caffe Latte")) {
            ic.consumeIngredient("Espresso", 2);
            ic.consumeIngredient("Steamed Milk", 1);
        }
        if (name.equals("Caffe Americano")) {
            ic.consumeIngredient("Espresso", 3);
        }
        if (name.equals("Caffe Mocha")) {
            ic.consumeIngredient("Espresso", 1);
            ic.consumeIngredient("Cocoa", 1);
            ic.consumeIngredient("Steamed Milk", 1);
            ic.consumeIngredient("Whipped Cream", 1);
        }
        if (name.equals("Cappuccino")) {
            ic.consumeIngredient("Espresso", 2);
            ic.consumeIngredient("Steamed Milk", 1);
            ic.consumeIngredient("Foamed Milk", 1);
        }
    }
    
    
}
