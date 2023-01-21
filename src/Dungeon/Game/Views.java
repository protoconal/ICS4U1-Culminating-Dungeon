package Dungeon.Game;

import Dungeon.Game.DungeonMap.Dungeon;

public class Views {
  static final String DASH_PADDING = "------------";
  static final String SPACE_PADDING = "            ";
  private static final String PLAYER_MODEL = " <i> ";

  private static final double TIME_DELAY = 1.5;

  public static String gameHeader() {
    return DASH_PADDING + "  " + Game.getName() + "  " + DASH_PADDING + "\n";
  }

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

  public static void printDungeon(Dungeon map, int[] playerCoordinates) {
    String[] consoleText = new String[]{
        map.visibleSpacesToString(playerCoordinates, PLAYER_MODEL),
        "",
        "",
    };
    printLines(consoleText);
  }

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

  public static void printLines(String[] consoleText) {
    // cls terminal
    Util.clearTerminal();
    StringBuilder outString = new StringBuilder(gameHeader() + SPACE_PADDING + "    " + Game.getPlayer().toString() + "    " + SPACE_PADDING + "\n");
    for (int x = 0; x < consoleText.length; x++) {
      outString.append(consoleText[x]).append("\n");
    }
    System.out.println(outString);
  }

  public static void printLinesWithoutPlayer(String[] consoleText) {
    // cls terminal
    Util.clearTerminal();
    StringBuilder outString = new StringBuilder(gameHeader());
    for (int x = 0; x < consoleText.length; x++) {
      outString.append(consoleText[x]).append("\n");
    }
    System.out.println(outString);
  }

  public static void printLn(String outString, boolean clsTerminal) {
    // cls terminal
    if (clsTerminal) {
      Util.clearTerminal();
    }
    System.out.println(gameHeader() + SPACE_PADDING + "    " + Game.getPlayer().toString() + "    " + SPACE_PADDING + "\n" + outString);
  }

  public static void delayedPrintLines(String[] consoleText) {
    printLines(consoleText);
    delay();
  }

  public static void delayedPrintLinesWithoutPlayer(String[] consoleText) {
    printLinesWithoutPlayer(consoleText);
    delay();
  }

  public static void delayedPrintLn(String consoleText) {
    printLn(consoleText, true);
    delay();
  }

  public static void delay() {
    try {
      Thread.sleep((long) (TIME_DELAY * 1000));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }


  public static void printPreDungeon(int difficultyMultiplier) {
    String[] consoleText = new String[]{
        "Welcome traveller, you've reached the entrance to dungeon: " + difficultyMultiplier,
        "",
        "Beware of creepy monsters!"
    };
    printLines(consoleText);
  }
}