package Dungeon.Game;

import Dungeon.Game.DungeonMap.Dungeon;

/**
 * It's a class that prints out the game's text
 */
public class Views {
  static final String DASH_PADDING = "------------";
  static final String SPACE_PADDING = "            ";
  private static final String PLAYER_MODEL = " <i> ";

  private static final double TIME_DELAY = 1.5;

  /**
   * It returns a string that contains the name of the game, padded with dashes
   * 
   * @return The gameHeader() method returns a string that contains the name of the game.
   */
  public static String gameHeader() {
    return DASH_PADDING + "  " + Game.getName() + "  " + DASH_PADDING + "\n";
  }

  /**
   * It returns a string based on the string passed to it
   * 
   * @param type The type of menu you want to get the tooltip for.
   * @return The return value is a String.
   */
  public static String getToolTip(String type) {
    if (type.equals("INVENTORY")) {
      return "A: Left, D: Right, E: Use/Equip, W: Weapons, S: Healing, R: Return, ;: Menu";
    }
    if (type.equals("SHOP")) {
      return "A: Left, D: Right, E: Buy, Q: Sell, W: Weapons, S: Healing, R: Return, ;: Menu";
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
   * This function takes a dungeon map and the player's coordinates, and prints the map to the console
   * 
   * @param map The dungeon object
   * @param playerCoordinates The coordinates of the player.
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
   * It prints a bunch of text to the console
   * 
   * @param player The player object
   * @param score HighScore object
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
   * It takes an array of strings, prints them to the console, and then prints the player's stats
   * 
   * @param consoleText String[]
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
   * It takes an array of strings, prints them to the console, and adds a header to the top of the
   * console
   * 
   * @param consoleText The text to be printed to the console.
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
   * This function prints a string to the terminal, and optionally clears the terminal before printing
   * 
   * @param outString The string to be printed to the terminal
   * @param clsTerminal clears the terminal
   */
  public static void printLn(String outString, boolean clsTerminal) {
    // cls terminal
    if (clsTerminal) {
      Util.clearTerminal();
    }
    System.out.println(gameHeader() + SPACE_PADDING + "    " + Game.getPlayer().toString() + "    " + SPACE_PADDING + "\n" + outString);
  }

  /**
   * This function prints the text in the consoleText array, one line at a time, with a delay between
   * each line
   * 
   * @param consoleText The text to be printed to the console.
   */
  public static void delayedPrintLines(String[] consoleText) {
    printLines(consoleText);
    delay();
  }

  /**
   * It prints the text to the console and then delays the program for a second.
   * 
   * @param consoleText The text to be printed to the console.
   */
  public static void delayedPrintLinesWithoutPlayer(String[] consoleText) {
    printLinesWithoutPlayer(consoleText);
    delay();
  }

  /**
   * This function prints a string to the console, and then delays the program for a second
   * 
   * @param consoleText The text to be printed to the console.
   */
  public static void delayedPrintLn(String consoleText) {
    printLn(consoleText, true);
    delay();
  }

  /**
   * It's a function that takes no arguments and returns nothing. It's called delay and it sleeps for a
   * certain amount of time
   */
  public static void delay() {
    try {
      Thread.sleep((long) (TIME_DELAY * 1000));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }


  /**
   * It prints out a welcome message to the console
   * 
   * @param difficultyMultiplier This is the difficulty of the dungeon.
   */
  public static void printPreDungeon(int difficultyMultiplier) {
    String[] consoleText = new String[]{
        "Welcome traveller, you've reached the entrance to dungeon: " + difficultyMultiplier,
        "",
        "Beware of creepy monsters!"
    };
    printLines(consoleText);
  }
}