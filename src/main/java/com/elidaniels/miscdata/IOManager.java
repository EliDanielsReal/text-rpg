package com.elidaniels.miscdata;

import java.util.Scanner;

public class IOManager {
    
    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Handle exceptions as needed
            e.printStackTrace();
        }
    }

    public static boolean confirmPrompt(String str) {
        Scanner scn = new Scanner(System.in);
        System.out.println(str + ". Is this ok? y/n");
        String confirmInput = scn.nextLine();
        if (confirmInput.equals("y")) {
            return true;
        }
        return false;
    }
}
