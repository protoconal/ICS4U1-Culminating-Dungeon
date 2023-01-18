package Dungeon.Game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    final static String[] VALID_MOVEMENT_KEYS = {
            // keeping same from dungeon
            "W", // up
            "A", // left
            "S", // down
            "D", // right
    };

    final static String[] VALID_DIRECTIONS = {
            // keeping same from dungeon
            "UP", // up
            "LEFT", // left
            "DOWN", // down
            "RIGHT", // right
    };

    final static String[] TOOLTIP_DIRECTIONS = {
            // keeping same from dungeon
            "W: Up", // up
            "A: Left", // left
            "S: Down", // down
            "D: Right", // right
    };

    final static String[] VALID_MENU_KEYS = {
            "B", // begin
            ";", // menu
    };

    final static String[] VALID_INTERACTION_KEYS = {
            "O", // loot
            "K", // monster
            "L", // inventory
            ";", // menu
    };

    final static Scanner SCAN = new Scanner(System.in);

    public static String getMove(String[] movableDirections) {
        // i know this is inefficient. - oh well.

        // efficiency - convert representation of directions and movement into a int[]
        ArrayList<String> possibleMovementKeys = new ArrayList<>();
        StringBuilder toolTip = new StringBuilder();
        for (int x = 0; x < movableDirections.length; x++) {
            // calculate the possible key combinations that are allowed given the directions
            int index = Util.index(VALID_DIRECTIONS, movableDirections[x]);
            possibleMovementKeys.add(VALID_MOVEMENT_KEYS[index]);
            toolTip.append(TOOLTIP_DIRECTIONS[index]);

            if (x != movableDirections.length - 1) {
                toolTip.append(" ");
            }
        }

        System.out.println(toolTip);
        // return the direction, rather than the key
        return VALID_DIRECTIONS[Util.index(VALID_MOVEMENT_KEYS, getValidKeystroke(possibleMovementKeys,"Move: "))];
    }

    public static String getValidKeystroke(String[] validKeys, String consoleText) {
        System.out.print(consoleText);
        String key = SCAN.nextLine();
        while (!checkKey(key, validKeys)) {
            System.out.println("Sorry, Invalid option.");
            System.out.print(consoleText);
            key = SCAN.nextLine();
        }
        return key.toUpperCase();
    }

    public static String getValidKeystroke(ArrayList<String> validKeys, String consoleText) {
        System.out.print(consoleText);
        String key = SCAN.nextLine();
        while (!checkKey(key, validKeys)) {
            System.out.println("Sorry, Invalid option.");
            System.out.print(consoleText);
            key = SCAN.nextLine();
        }
        return key.toUpperCase();
    }

    private static boolean checkKey(String key, String[] validKeys) {
        // case ignorant
        for (int x = 0; x < validKeys.length; x++) {
            if (key.equalsIgnoreCase(validKeys[x])) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkKey(String key, ArrayList<String> validKeys) {
        // case ignorant
        for (int x = 0; x < validKeys.size(); x++) {
            if (key.equalsIgnoreCase(validKeys.get(x))) {
                return true;
            }
        }
        return false;
    }

    public static void waitForKeyPress() {
        System.out.print("Press enter key to continue...");
        SCAN.nextLine();
    }

    public static String getMenuKeys() {
        return getValidKeystroke(VALID_MENU_KEYS,"Input: ");
    }

    public static String getInteraction() {
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

