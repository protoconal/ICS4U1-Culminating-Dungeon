package Dungeon.Game;

import Dungeon.Game.DungeonMap.Dungeon;

import java.util.ArrayList;

/**
 * This Views class stores methods to prints out the game's text.
 *
 * @author Ilelemwanta Nomaren, Emily Ta, Chris Yang, Tony Guo
 * @version 1.0
 * @since 1.0
 */
public class Views {
  static final String DASH_PADDING = "------------";
  static final String SPACE_PADDING = "            ";
  private static final String PLAYER_MODEL = " <i> ";
  private static final double TIME_DELAY = 1.5;

  /**
   * @return returns a padded string that contains the name of the game.
   */
  public static String gameHeader() {
    return DASH_PADDING + "  " + Game.getName() + "  " + DASH_PADDING + "\n";
  }

  /**
   * Returns a tooltip given the type needed;
   *
   * @param type a string that stores the type of menu you want to get the tooltip for.
   * @return the tooltip
   */
  public static String getToolTip(String type) {
    if (type.equals("INVENTORY")) {
      return "A: Left, D: Right, E: Use/Equip, W: Weapons, S: Healing, R: Return, ;: Menu";
    }
    if (type.equals("SHOP")) {
      return "A: Left, D: Right, E: Buy, Q: Sell, W: Weapons, S: Healing, T: Armour, R: Return, ;: Menu";
    }
    if (type.equals("PREDUNGEON")) {
      return "S: Go to the Shop, R: Enter the dungeon, ;: Menu";
    }
    if (type.equals("MAINMENU")) {
      return "B: Begin, H: High Scores, ;: Exit";
    }
    if (type.equals("DEATHMENU")) {
      return "R: Reset  ;: Exit";
    }
    return null;
  }

  /**
   * Prints the main menu
   */
  public static void printMainMenu() {
    String[] consoleText = new String[]{
        "Hello, wandering traveller!",
        "You’ve been selected to explore the newly-discovered dungeon of Vaquera.",
        "Your bravery will help you fight monsters, find treasure, and help Vaquera learn more about the treasures that lie beneath the surface.",
        "",
        "If you ever need to find out what you can input, a tooltip will always appear!",
        "ex: W: Up, A: Left, S: Down, D: Right",
        "",
        "Finally, if you're a coward, press ; to exit to the main menu.",
        "Are you ready? Enter B to begin! Enter H to see the high scores.",
    };
    printLinesWithoutPlayer(consoleText);
  }

  /**
   * Prints the Dungeon
   *
   * @param map               stores the current dungeon
   * @param playerCoordinates stores the current coordinates of the player.
   */
  public static void printDungeon(Dungeon map, int[] playerCoordinates) {
    String[] consoleText = new String[]{
        map.visibleSpacesToString(playerCoordinates, PLAYER_MODEL),
        "",
        "",
    };
    printLines(consoleText);
  }


  /**
   * Prints the Death Menu
   *
   * @param player stores the player object to grab scores
   * @param score  stores the HighScore object to grab high scores
   */
  public static void printDeathMenu(Player player, HighScore score) {
    String[] consoleText = new String[]{
        "Unfortunately, the great \"" + player.getName() + "\" has met their great demise from " + player.getDeathReason(),
        "",
        "Thanks for playing!",
        "Your final score: " + player.getScore(),
        "",
        "High scores!",
        score.returnHighScoreText(),
        "",
    };
    printLines(consoleText);
  }

  /**
   * Print a String Array with a GameHeader and the Player's current stats.
   *
   * @param consoleText stores a String[] containing the text to be printed to the console
   */
  public static void printLines(String[] consoleText) {
    // cls terminal
    Util.clearTerminal();
    StringBuilder outString = new StringBuilder(gameHeader() + SPACE_PADDING + "    " + Game.getPlayer().toString() + "    " + SPACE_PADDING + "\n");
    for (int x = 0; x < consoleText.length; x++) {
      outString.append(consoleText[x]).append("\n");
    }
    System.out.println(outString);
  }

  /**
   * Print a String Array with a GameHeader and the Player's current stats.
   *
   * @param consoleText stores a ArrayList<String> containing the text to be printed to the console
   */
  public static void printLines(ArrayList<String> consoleText) {
    // cls terminal
    Util.clearTerminal();
    StringBuilder outString = new StringBuilder(gameHeader() + SPACE_PADDING + "    " + Game.getPlayer().toString() + "    " + SPACE_PADDING + "\n");
    for (int x = 0; x < consoleText.size(); x++) {
      outString.append(consoleText.get(x)).append("\n");
    }
    System.out.println(outString);
  }

  /**
   * Print an String Array with a GameHeader
   *
   * @param consoleText stores a String[] containing the text to be printed to the console
   */
  public static void printLinesWithoutPlayer(String[] consoleText) {
    // cls terminal
    Util.clearTerminal();
    StringBuilder outString = new StringBuilder(gameHeader());
    for (int x = 0; x < consoleText.length; x++) {
      outString.append(consoleText[x]).append("\n");
    }
    System.out.println(outString);
  }


  /**
   * Print a String Array with a GameHeader and the Player's current stats, optionally clearing the terminal.
   *
   * @param outString   stores the string to be printed to the terminal
   * @param clsTerminal stores whether to clear the terminal
   */
  public static void printLn(String outString, boolean clsTerminal) {
    // cls terminal
    if (clsTerminal) {
      Util.clearTerminal();
    }
    System.out.println(gameHeader() + SPACE_PADDING + "    " + Game.getPlayer().toString() + "    " + SPACE_PADDING + "\n" + outString);
  }

  /**
   * Wait a delay after printing some lines.
   *
   * @param consoleText stores a String[] containing the text to be printed to the console
   */
  public static void delayedPrintLines(String[] consoleText) {
    printLines(consoleText);
    delay();
  }

  /**
   * Wait a delay after printing some lines without the stat header.
   *
   * @param consoleText stores a String[] containing the text to be printed to the console
   */
  public static void delayedPrintLinesWithoutPlayer(String[] consoleText) {
    printLinesWithoutPlayer(consoleText);
    delay();
  }

  /**
   * Wait a delay after printing a line, always clears terminal.
   *
   * @param consoleText stores a String containing the text to be printed to the console
   */
  public static void delayedPrintLn(String consoleText) {
    printLn(consoleText, true);
    delay();
  }

  /**
   * Sleep
   */
  public static void delay() {
    try {
      Thread.sleep((long) (TIME_DELAY * 1000));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }


  /**
   * Prints out the welcome message to the dungeon.
   *
   * @param depth stores how deep we are through the dungeon.
   */
  public static void printPreDungeon(int depth) {
    String[] consoleText = new String[]{
        "Welcome traveller, you've reached the entrance to dungeon: " + depth,
        "",
        "Beware of creepy monsters!"
    };
    printLines(consoleText);
  }
}