/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usd.edu.david;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author David Lee
 */
public class IngredientCollection {
    
    TreeMap<String, Ingredient> ingredientList = new TreeMap<>();

    public TreeMap<String, Ingredient> getIngredientList() {
        return ingredientList;
    }
    
    public Ingredient getIngredientByName(String name){
        TreeMap<String, Ingredient> tm = this.getIngredientList();
        Iterator iterator = tm.entrySet().iterator();
        while (iterator.hasNext()) {
		Map.Entry mapEntry = (Map.Entry) iterator.next();
                if(((Ingredient)mapEntry.getValue()).getName().equals(name)){
                    return (Ingredient)mapEntry.getValue();
                }
	}
        return null;
    }
    
    public boolean getIngredientAvailability(String name, int amount){
        Ingredient ingredient = getIngredientByName(name);
        if(ingredient != null){
            if(ingredient.getAmount() - amount >= 0){
                return true;
            }            
        }
        return false;
    }
    
    public void consumeIngredient(String name, int amount){
        Ingredient ingredient = getIngredientByName(name);
        int amountLeft = ingredient.getAmount() - amount;
        ingredient.setAmount(amountLeft);
    }
    
    public void restockIngredient(){
        TreeMap<String, Ingredient> tm = this.getIngredientList();
        Iterator iterator = tm.entrySet().iterator();
        while (iterator.hasNext()) {
		Map.Entry mapEntry = (Map.Entry) iterator.next();                
                ((Ingredient)mapEntry.getValue()).setAmount(10);
	}
    }
}
