package Dungeon.Game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This Input class contains methods and definitions to get valid input.
 *
 * @author Tony Guo, Ilelemwanta Nomaren, Emily Ta, Chris Yang,
 * @version 1.0
 * @since 1.0
 */
public class Input {
  // these definitions could be stored in its own class
  private final static String[] VALID_MOVEMENT_KEYS = {
      // keeping same from dungeon
      "W", // up
      "A", // left
      "S", // down
      "D", // right
  };

  private final static String[] VALID_INVENTORY_KEYS = {
      "R", // Return -- default behaviour
      "A", // Left
      "D", // Right
      "W", // Weapons
      "S", // Health
      "E", // Use/Equip
      "Q", // Drop/Delete
      ";" // menu
  };

  private final static String[] VALID_DIRECTIONS = {
      // keeping same from dungeon
      "UP", // up
      "LEFT", // left
      "DOWN", // down
      "RIGHT", // right
  };

  private final static String[] TOOLTIP_DIRECTIONS = {
      // keeping same from dungeon
      "W: Up", // up
      "A: Left", // left
      "S: Down", // down
      "D: Right", // right
  };

  private final static String[] VALID_MENU_KEYS = {
      "B", // begin -- default
      "H", // high scores
      ";", // menu
  };

  private final static String[] VALID_DEATH_MENU_KEYS = {
      "R", // Reset -- default
      ";", // Exit
  };

  private final static String[] VALID_FIGHT_KEYS = {
      "A", // fight -- default
      "H", // heal
      "R", // inventory
      ";", // menu
  };

  private final static String[] VALID_PRE_DUNGEON_KEYS = {
      "R", // continue -- default
      "S", // go shop
      ";", // menu
  };

  private final static String[] VALID_SHOP_KEYS = {
      "R", // return -- default
      "A", // Left
      "D", // Right
      "W", // Weapons
      "S", // Health
      "T", // Armour
      "E", // buy
      "Q", // sell
      ";", // menu
  };

  private final static String[] VALID_YN_KEYS = {
      "N", // no -- default
      "Y", // yes
  };

  final private static Scanner SCAN = new Scanner(System.in);

  /**
   * Returns a valid keystroke given a definition of what keys are valid.
   *
   * @param validKeys   stores array of valid keys that the user can enter.
   * @param consoleText stores the text that will be prompted to the user.
   * @return the valid keystroke.
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
   * Returns a valid keystroke given a definition of what keys are valid.
   *
   * @param validKeys   stores ArrayList of valid keys that the user can enter.
   * @param consoleText stores the text that will be prompted to the user.
   * @return the valid keystroke.
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

  /**
   * Checks whether a keystroke is in the valid keys array.
   *
   * @param key   stores the key to be checked
   * @param validKeys stores array of valid keys that the user can enter.
   * @return whether the key is a valid key.
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
   * Checks whether a keystroke is in the valid keys array.
   *
   * @param key   stores the key to be checked
   * @param validKeys stores ArrayList of valid keys that the user can enter.
   * @return whether the key is a valid key.
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
   * Wait's for any key press.
   */
  public static void waitForKeyPress() {
    System.out.print("Press enter key to continue...");
    SCAN.nextLine();
  }

  /**
   * Retrieves input that matches the directions that it is given.
   *
   * @param movableDirections stores a list of directions that the player can move
   * @return the valid direction keystroke.
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
   * Retrieves input that matches a valid key list. If no input is found, it defaults to the first option.
   *
   * @param validKeys   stores ArrayList of valid keys that the user can enter.
   * @param consoleText stores the text that will be prompted to the user.
   * @return the valid keystroke.
   */
  public static String getKeyOrDefault(String[] validKeys, String consoleText) {
    String key = getValidKeystroke(validKeys, consoleText);
    if (key.equals("")) {
      return validKeys[0];
    }
    return key;
  }

  /**
   * Retrieves valid Menu input.
   *
   * @return the valid keystroke.
   */
  public static String getMenuKeys() {
    return getKeyOrDefault(VALID_MENU_KEYS, "Input: ");
  }

  /**
   * Retrieves valid Fight input.
   *
   * @return the valid keystroke.
   */
  public static String getFightKeys() {
    return getKeyOrDefault(VALID_FIGHT_KEYS, "Input: ");
  }

  /**
   * Retrieves valid Inventory input.
   *
   * @return the valid keystroke.
   */
  public static String getInventoryKeys() {
    return getKeyOrDefault(VALID_INVENTORY_KEYS, "Input: ");
  }

  /**
   * Retrieves valid Pre-Dungeon input.
   *
   * @return the valid keystroke.
   */
  public static String getPreDungeonKeys() {
    return getKeyOrDefault(VALID_PRE_DUNGEON_KEYS, "Input: ");
  }

  /**
   * Retrieves valid Death Menu input.
   *
   * @return the valid keystroke.
   */
  public static String getDeathKeys() {
    return getKeyOrDefault(VALID_DEATH_MENU_KEYS, "Input: ");
  }

  /**
   * Retrieves valid Shopping input.
   *
   * @return the valid keystroke.
   */
  public static String getShopKeys() {
    return getKeyOrDefault(VALID_SHOP_KEYS, "Input: ");
  }

  /**
   * Retrieves a yes or no from the user.
   *
   * @return the valid keystroke.
   */
  public static String getYN() {
    return getKeyOrDefault(VALID_YN_KEYS, "Input: ");
  }

  /**
   * Retrieves any String input from the user.
   *
   * @param consoleText stores the text that will be prompted to the user.
   * @return a string containing user input.
   */
  public static String getText(String consoleText) {
    System.out.print(consoleText);
    return SCAN.nextLine();
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