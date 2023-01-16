package Dungeon.Game;

import java.util.Scanner;

public class Input {  
    final String[] VALID_MOVEMENT_KEYS = {
            "W", // up
            "A", // left
            "S", // down
            "D", // right
    };
    final Scanner SCAN = new Scanner(System.in);

    public String getMove() {
        return getValidKeystroke(VALID_MOVEMENT_KEYS,"Move: ");
    }

    public String getValidKeystroke(String[] validKeys, String consoleText) {
        System.out.print(consoleText);
        String key = SCAN.nextLine();
        while (!checkKey(key, validKeys)) {
            System.out.println("Sorry, Invalid option.");
            System.out.print(consoleText);
            key = SCAN.nextLine();
        }
        return key;
    }

    private boolean checkKey(String key, String[] validKeys) {
        // case ignorant
        for (int x = 0; x < validKeys.length; x++) {
            if (key.equalsIgnoreCase(validKeys[x])) {
                return true;
            }
        }
        return false;
    }

    final String[] VALID_MENU_KEYS = {
            "B", // begin
            ";", // menu
    };

    public String getMenuKeys() {
        return getValidKeystroke(VALID_MENU_KEYS,"Input: ");
    }

  
    final String[] VALID_INTERACTION_KEYS = {
            "O", // loot
            "K", // monster
            "L", // inventory
            ";", // menu
    };

    public String getInteraction() {
        return getValidKeystroke(VALID_INTERACTION_KEYS,"Interact: ");
    }

}


// Hello, brave adventurer. You’ve been selected to explore the newly-discovered dungeon of Vaquera. Your bravery will help you fight monsters, find treasure, and help Vaquera learn more about the treasures that lie beneath the surface.

// Oh, I didn't tell you how to move!

// Press W to move up
// Press A to move left
// Press S to move down
// Press D to move right

// I also need to help you use your equipment.

// Press O to collect loot
// Press K to fight monster
// Press L to open inventory

// Finally, if you're a coward, press ; to go to the menu.

// Are you ready? Press B to begin!

// ***

// You have met [insert monster here]. Prepare for battle! Which attack would you like to use?

// Shopkeeper: Hi, [player name]! What would you like to buy?

