package Dungeon.Game;

import java.util.Scanner;

class Input {
    final String[] validMovementKeys = {
            "W", // up
            "A", // left
            "S", // down
            "D", // right
    };
    final Scanner scan = new Scanner(System.in);

    public String getMove() {
        return getValidKeystroke(validMovementKeys,"Move: ");
    }

    public String getValidKeystroke(String[] validKeys, String consoleText) {
        String key = getInput(consoleText);
        while (!checkKey(key, validKeys)) {
            System.out.println("Sorry, Invalid option.");
            key = getInput(consoleText);
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

    private String getInput(String consoleText) {
        System.out.println(consoleText);
        String key = scan.nextLine();
        // skip newline
        scan.next();
        return key;
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
// Press ; to...

// Finally, if you're a coward, press M to go to the menu.

// Are you ready? Press B to begin!

// ***

// You have met [insert monster here]. Prepare for battle! Which attack would you like to use?

// Shopkeeper: Hi, [player name]! What would you like to buy?