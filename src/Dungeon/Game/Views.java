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
      return "A: Left D: Right E: Use/Equip W: Weapons S: Healing R: Return ;: Menu";
    }
    if (type.equals("MAINMENU")) {
      return "B: Begin ;: Exit";
    }
    if (type.equals("DEATH")) {
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
        "Oh, I didn't tell you how to move!",
        "Press W to move up",
        "Press A to move left",
        "Press S to move down",
        "Press D to move right",
        "I also need to help you use your equipment.",
        "Press E to interact",
        "Press F to open your inventory at anytime",
        "Finally, if you're a coward, press ; to exit to the main menu.",
        "Are you ready? Press B to begin!",
    };
    printLinesWithoutPlayer(consoleText);
  }


  public static void showTutorial() {
    String[] consoleText = new String[]{
        "",
        "",
        "",
    };
    printLines(consoleText);
  }

  public static void printDungeon(Dungeon map, int[] playerCoordinates) {
    String[] consoleText = new String[]{
        map.visibleSpacesToString(playerCoordinates, PLAYER_MODEL),
        "",
        "",
    };
    printLines(consoleText);
  }

  public static void printAttackModel(Dungeon map, int[] playerCoordinates) {
    String[] consoleText = new String[]{
        "",
        "",
    };
    printLines(consoleText);
  }

  public static void printDeathMenu(Player player) {
    String[] consoleText = new String[]{
            "Uh oh, you died!",
            "Final Score: " + player.getScore(),
    };
    printLines(consoleText);
  }

  public static void printShop() {

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

  public static void printLn(String outString) {
    // cls terminal
    Util.clearTerminal();
    System.out.println(gameHeader() + SPACE_PADDING + "    " + Game.getPlayer().toString() + "    " + SPACE_PADDING + "\n" + outString);
  }

  public static void delayedPrintLines(String[] consoleText) {
    // cls terminal
    Util.clearTerminal();
    StringBuilder outString = new StringBuilder(gameHeader());
    for (int x = 0; x < consoleText.length; x++) {
      outString.append(consoleText[x]).append("\n");
    }
    System.out.println(outString);
  }

  public static void delayedPrintLn(String outString) {
    try {
      Thread.sleep((long) (TIME_DELAY * 1000));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    printLn(outString);
  }
}