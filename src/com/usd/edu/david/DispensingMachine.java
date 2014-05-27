/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usd.edu.david;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author David Lee
 */
public class DispensingMachine {
    
    public static IngredientCollection ic = new IngredientCollection();
    public static DrinkCollection dc = new DrinkCollection();
    
    public static void main(String[] args) {
        initIngredientCollection();
        initDrinkCollection();
        printIngredientCollection();
        printDrinkCollection();
        runMachine();
    }
    
    public static void initIngredientCollection(){
        Ingredient ingredient;
        ingredient = new Ingredient("Coffee", 0.75, 10);
        ic.getIngredientList().put("Coffee", ingredient);
        ingredient = new Ingredient("Decaf Coffee", 0.75, 10);
        ic.getIngredientList().put("Decaf Coffee", ingredient);
        ingredient = new Ingredient("Sugar", 0.25, 10);
        ic.getIngredientList().put("Sugar", ingredient);
        ingredient = new Ingredient("Cream", 0.25, 10);
        ic.getIngredientList().put("Cream", ingredient);
        ingredient = new Ingredient("Steamed Milk", 0.35, 10);
        ic.getIngredientList().put("Steamed Milk", ingredient);
        ingredient = new Ingredient("Foamed Milk", 0.35, 10);
        ic.getIngredientList().put("Foamed Milk", ingredient);
        ingredient = new Ingredient("Espresso", 1.10, 10);
        ic.getIngredientList().put("Espresso", ingredient);
        ingredient = new Ingredient("Cocoa", 0.90, 10);
        ic.getIngredientList().put("Cocoa", ingredient);
        ingredient = new Ingredient("Whipped Cream", 1.00, 10);
        ic.getIngredientList().put("Whipped Cream", ingredient);
    }
    
    public static void initDrinkCollection(){
        Drink drink;
        drink = new Drink("Coffee");
        dc.getDrinkList().put("Coffee", drink);
        drink = new Drink("Decaf Coffee");
        dc.getDrinkList().put("Decaf Coffee", drink);
        drink = new Drink("Caffe Latte");
        dc.getDrinkList().put("Caffe Latte", drink);
        drink = new Drink("Caffe Americano");
        dc.getDrinkList().put("Caffe Americano", drink);
        drink = new Drink("Caffe Mocha");
        dc.getDrinkList().put("Caffe Mocha", drink);
        drink = new Drink("Cappuccino");
        dc.getDrinkList().put("Cappuccino", drink);
    }
    
    public static void printIngredientCollection(){
        Ingredient ingredient;
        System.out.println("Inventory:");
        TreeMap<String, Ingredient> tm = ic.getIngredientList();
        Iterator iterator = tm.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();
            ingredient = ((Ingredient)mapEntry.getValue());
            System.out.println(ingredient.getName() + ", " + ingredient.getAmount());
	}
    }
    
    public static void printDrinkCollection(){
        Util util = new Util();
        Drink drink;
        int index = 1;
        System.out.println("Menu:");
        TreeMap<String, Drink> tm = dc.getDrinkList();
        Iterator iterator = tm.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();
            drink = (Drink)mapEntry.getValue();
            System.out.println((index++) + ", " 
                    + drink.getName() + ", $" 
                    + util.doubleToString(drink.getPrice(drink.getName(), ic)) + ", " 
                    + (drink.getAvailability(drink.getName(), ic)==true?"true":"false"));
	}
    }
    
    private static void runMachine() {
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        while(!command.equalsIgnoreCase("q")){
            readCommand(command);
            command = sc.next();
        }
    }

    private static void readCommand(String command){
        if(command.equalsIgnoreCase("r")){
            ic.restockIngredient();
        }else if(command.equals("1") || command.equals("2") || command.equals("3") || command.equals("4") || command.equals("5") || command.equals("6")){
            int i = Integer.parseInt(command);
            Boolean boolDrink = false;
            String drinkName = "";
            //Since drink munu is displayed in alphabetic order, drinkName is also in alphabetic order
            if(i == 1){
                drinkName = "Caffe Americano";
                boolDrink = dc.consumeDrink(drinkName, ic);
            }else if(i == 2){
                drinkName = "Caffe Latte";
                boolDrink = dc.consumeDrink(drinkName, ic);
            }else if(i == 3){
                drinkName = "Caffe Mocha";
                boolDrink = dc.consumeDrink(drinkName, ic);
            }else if(i == 4){
                drinkName = "Cappuccino";
                boolDrink = dc.consumeDrink(drinkName, ic);
            }else if(i == 5){
                drinkName = "Coffee";
                boolDrink = dc.consumeDrink(drinkName, ic);
            }else if(i == 6){
                drinkName = "Decaf Coffee";
                boolDrink = dc.consumeDrink(drinkName, ic);
            }
            if(boolDrink){
                System.out.println("Dispensing: " + drinkName);
            }else{
                System.out.println("Out of stock: " + drinkName);
            }
        }else{
            System.out.println("Invalid Selection: " + command);
        }
        printIngredientCollection();
        printDrinkCollection();
    }
    
    
}
