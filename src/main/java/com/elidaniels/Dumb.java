package com.elidaniels;

public class Dumb {
    
    public static void main(String[] args) {

        int x = 100;

        float multi = 1.0f;

        
        for (int i=1; i<=11; i++) {

            x = (int) Math.round(x * Math.pow(1.2, 2.5)); 
    
                System.out.println("lv" + Integer.toString(i) + ": " + Integer.toString(x));
    
            }

        // for (int k=1; k<=9; k++) {

        //     x = 100;

        //     multi += 0.1;

        //     System.out.println("multi is: " + Float.toString(multi));

        //     for (int i=1; i<=11; i++) {
        //         x =  multi ;
    
        //         System.out.println("lv" + Integer.toString(i) + ": " + Integer.toString(x));
    
        //     }
        // }
        
    }

}
