package com.elidaniels;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.elidaniels.fighterdata.ElementType;
import com.elidaniels.fighterdata.playerdata.Player;
import com.elidaniels.miscdata.Display;
import com.elidaniels.miscdata.IOManager;

public class CharacterCreation {

    
    public static void main(String[] args) {
        createCharacter();
    }
    
    public static Player createCharacter() {
        final Scanner scn = new Scanner(System.in);
        String name = chooseName(scn);
        ElementType elementType = chooseElementType(scn);
        scn.close();
        
        return new Player(name, elementType);
    }

    private static ElementType chooseElementType(Scanner scn) {
        Display.displayChooseElementType();
        String inputElement;

        while (true) {
            inputElement = scn.nextLine().toUpperCase();
            if (checkValidElement(inputElement)) {
                break;
            }
        }

        return ElementType.valueOf(inputElement);
    }
    
    private static String chooseName(Scanner scn) {
        Display.displayChooseName();
        String name;

        while (true) {
            name = scn.nextLine();
            if (IOManager.confirmPrompt(name)) {
                break;
            }
        }

        return name;
    }

    private static boolean checkValidElement(String elementString) {
        List<String> validElements = Arrays.asList("WATER", "WIND", "FIRE", "EARTH");

        if (validElements.contains(elementString)) {
            return true;
        }
        Display.displayInvalidInput(elementString);

        return false;
    }

}
