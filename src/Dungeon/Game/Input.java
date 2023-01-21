package Dungeon.Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {
  // these definitions could be stored in its own class
  final static String[] VALID_MOVEMENT_KEYS = {
      // keeping same from dungeon
      "W", // up
      "A", // left
      "S", // down
      "D", // right
  };

  final static String[] VALID_INVENTORY_KEYS = {
      "R", // Return -- default behaviour
      "A", // Left
      "D", // Right
      "W", // Weapons
      "S", // Health
      "E", // Use/Equip
      "Q", // Drop/Delete
      ";" // menu
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
      "B", // begin -- default
      "H", // highscores
      ";", // menu
  };

  final static String[] VALID_DEATH_MENU_KEYS = {
      "R", // Reset -- default
      ";", // Exit
  };

  final static String[] VALID_FIGHT_KEYS = {
      "A", // fight -- default
      "H", // heal
      "R", // inventory
      ";", // menu
  };

  final static String[] VALID_PRE_DUNGEON_KEYS = {
      "R", // continue -- default
      "S", // go shop
      ";", // menu
  };

  final static String[] VALID_SHOP_KEYS = {
      "R", // return -- default
      "A", // Left
      "D", // Right
      "W", // Weapons
      "S", // Health
      "E", // buy
      "Q", // sell
      ";", // menu
  };

  final static String[] VALID_YN_KEYS = {
    "N", // no -- default
    "Y", // yes
  };

  final static Scanner SCAN = new Scanner(System.in);
  
  /**
   * It takes in an array of valid keys and a string to print to the console, and returns a valid
   * keystroke
   * 
   * @param validKeys An array of valid keys that the user can enter.
   * @param consoleText The text that will be displayed to the user.
   * @return A String
   */
  public static String getValidKeystroke(String[] validKeys, String consoleText) {
    System.out.print(consoleText);
    String key = SCAN.nextLine();

    if (key.equals("")) {
      return "";
    }

    while (!checkKey(key, validKeys)) {
      System.out.println("Sorry, Invalid option.");
      System.out.print(consoleText);
      key = SCAN.nextLine();
    }
    return key.toUpperCase();
  }

  /**
   * It takes in an ArrayList of valid keys and a String of console text, and returns a valid keystroke
   * 
   * @param validKeys An ArrayList of Strings that contains all the valid keys that the user can enter.
   * @param consoleText The text that will be displayed to the user.
   * @return A String
   */
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

  // please generate javadocs for these methods

  /**
   * It takes in an array of valid keys and a string to print to the console, and returns a valid
   * keystroke
   * 
   * @param validKeys An array of valid keys that the user can enter.
   * @param consoleText The text that will be displayed to the user.
   * @return A String
   */
  private static boolean checkKey(String key, String[] validKeys) {
    // case ignorant
    for (int x = 0; x < validKeys.length; x++) {
      if (key.equalsIgnoreCase(validKeys[x])) {
        return true;
      }
    }
    return false;
  }

  /**
   * It takes in an ArrayList of valid keys and a String of console text, and returns a valid keystroke
   * 
   * @param validKeys An ArrayList of Strings that contains all the valid keys that the user can enter.
   * @param consoleText The text that will be displayed to the user.
   * @return A String
   */
  private static boolean checkKey(String key, ArrayList<String> validKeys) {
    // case ignorant
    for (int x = 0; x < validKeys.size(); x++) {
      if (key.equalsIgnoreCase(validKeys.get(x))) {
        return true;
      }
    }
    return false;
  }

  /**
   * It takes in a string and returns a boolean value based on whether the user wants to continue or
   * not.
   * 
   * @param consoleText The text that will be displayed to the user.
   * @return A boolean
   */
  public static void waitForKeyPress() {
    System.out.print("Press enter key to continue...");
    SCAN.nextLine();
  }

  /**
   * It takes in a string and returns a boolean value based on whether the user wants to continue or
   * not.
   * 
   * @param consoleText The text that will be displayed to the user.
   * @return A boolean
   */
  public static String getMove(String[] movableDirections) {
    // I know this is inefficient. - oh well.

    // efficiency - convert representation of directions and movement into an int[]
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
    possibleMovementKeys.add("R"); // patch in inventory;
    toolTip.append(" R: Inventory"); // patch in inventory;
    possibleMovementKeys.add(";"); // patch in menu;
    toolTip.append(" ;: Exit"); // patch in menu;

    System.out.println(toolTip);
    // return the direction, rather than the key
    String keyStroke = getValidKeystroke(possibleMovementKeys, "Move: ");

    if (keyStroke.equals("R")) {
      return "R";
    }
    if (keyStroke.equals(";")) {
      return ";";
    }

    return VALID_DIRECTIONS[Util.index(VALID_MOVEMENT_KEYS, keyStroke)];
  }

  /**
   * It takes in a string and returns a boolean value based on whether the user wants to continue or
   * not.
   * 
   * @param consoleText The text that will be displayed to the user.
   * @return A boolean
   */
  public static String getKeyOrDefault(String[] validKeys, String consoleText) {
    String key = getValidKeystroke(validKeys, consoleText);
    if (key.equals("")) {
      return validKeys[0];
    }
    return key;
  }

  /**
   * It takes in a string and returns a boolean value based on whether the user wants to continue or
   * not.
   * 
   * @param consoleText The text that will be displayed to the user.
   * @return A boolean
   */
  public static String getMenuKeys() {
    return getKeyOrDefault(VALID_MENU_KEYS, "Input: ");
  }

  /**
   * It takes in a string and returns a boolean value based on whether the user wants to continue or
   * not.
   * 
   * @param consoleText The text that will be displayed to the user.
   * @return A boolean
   */
  public static String getFightKeys() {
    return getKeyOrDefault(VALID_FIGHT_KEYS, "Input: ");
  }

  /**
   * It takes in a string and returns a boolean value based on whether the user wants to continue or
   * not.
   * 
   * @param consoleText The text that will be displayed to the user.
   * @return A boolean
   */
  public static String getInventoryKeys() {
    return getKeyOrDefault(VALID_INVENTORY_KEYS, "Input: ");
  }

  /**
   * It takes in a string and returns a boolean value based on whether the user wants to continue or
   * not.
   * 
   * @param consoleText The text that will be displayed to the user.
   * @return A boolean
   */
  public static String getPreDungeonKeys() {
    return getKeyOrDefault(VALID_PRE_DUNGEON_KEYS, "Input: ");
  }

  /**
   * It takes in a string and returns a boolean value based on whether the user wants to continue or
   * not.
   * 
   * @param consoleText The text that will be displayed to the user.
   * @return A boolean
   */
  public static String getDeathKeys() {
    return getKeyOrDefault(VALID_DEATH_MENU_KEYS, "Input: ");
  }

  /**
   * It takes in a string and returns a boolean value based on whether the user wants to continue or
   * not.
   * 
   * @param consoleText The text that will be displayed to the user.
   * @return A boolean
   */
  public static String getShopKeys() {
    return getKeyOrDefault(VALID_SHOP_KEYS, "Input: ");
  }

  /**
   * It takes in a string and returns a boolean value based on whether the user wants to continue or
   * not.
   * 
   * @param consoleText The text that will be displayed to the user.
   * @return A boolean
   */
  public static String getText(String consoleText) {
    System.out.print(consoleText);
    return SCAN.nextLine();
  }

  /**
   * It takes in a string and returns a boolean value based on whether the user wants to continue or
   * not.
   * 
   * @param consoleText The text that will be displayed to the user.
   * @return A boolean
   */
  public static String getYN() {
    return getKeyOrDefault(VALID_YN_KEYS, "Input: ");
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