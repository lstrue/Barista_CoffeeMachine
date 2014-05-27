/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usd.edu.david;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 *
 * @author David Lee
 */
public class Util {
    
    public double addDouble(double a, double b){
        BigDecimal bd1 = BigDecimal.valueOf(a);
        BigDecimal bd2 = BigDecimal.valueOf(b);
        return bd1.add(bd2).doubleValue();
    }
    
    public double multiplyDouble(double a, double b){
        BigDecimal bd1 = BigDecimal.valueOf(a);
        BigDecimal bd2 = BigDecimal.valueOf(b);
        return bd1.multiply(bd2).doubleValue();
    }
    
    public String doubleToString(double value){
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(value);
    }
    
//    public static void main(String[] args) {
//        Util util = new Util();
//        String s = util.doubleToString(2.7);
//        System.out.println("" + s);
//    }
}
