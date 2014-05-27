/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usd.edu.david;

import java.util.TreeMap;

/**
 *
 * @author David Lee
 */
public class DrinkCollection {

    TreeMap<String ,Drink> drinkList = new TreeMap<>();

    public TreeMap<String, Drink> getDrinkList() {
        return drinkList;
    }
    
    public boolean consumeDrink(String name, IngredientCollection ic) {
        Drink drink = new Drink();
        if (drink.getAvailability(name, ic)) {
            drink.consumeIngredient(name, ic);
            return true;
        }
        return false;
    }
    
}
