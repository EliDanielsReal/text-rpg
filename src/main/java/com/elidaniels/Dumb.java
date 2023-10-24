package com.elidaniels;

import java.util.Scanner;

import com.elidaniels.battledata.turn.Turn;
import com.elidaniels.fighterdata.Enemy;
import com.elidaniels.fighterdata.Player;

public class Dumb {
    
    public static void main(String[] args) {

        Player eli = new Player("Eli");
        Enemy en = new Enemy("gob", 10, 3);

        System.out.println(eli.getName());
        System.out.println(en.getName());
        eli.setName("nice");
        System.out.println(eli.getName());
        System.out.println(en.getName());
        
    }



}
