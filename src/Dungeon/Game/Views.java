package Dungeon.Game;

import Dungeon.Game.DungeonMap.Dungeon;
import Dungeon.Game.Game;
import Dungeon.Game.Items.PlayerInventory;

public class Views {
  private static final String PLAYER_MODEL = " <i> ";

  public static String gameHeader() {
    return "----------  " + Game.getName() + "  ----------\n";
  }

  public static String getToolTip(String type) {
    if (type.equals("INVENTORY")) {
      return "E: Use, ";
    }
    if (type.equals("MAINMENU")) {
      return "B: Begin, ;, Exit";
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
    printLines(consoleText);
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

  public static void printInventory(PlayerInventory inventory) {
    String[] consoleText = new String[]{
            inventory.toString(),
            "",
    };
    printLines(consoleText);
  }

  public static void printDeathMenu() {
    
  }

  public static void printShop() {
    
  }

  public static void printLines(String[] consoleText) {
    // cls terminal
    Util.clearTerminal();
    StringBuilder outString = new StringBuilder(gameHeader());
    for (int x = 0; x < consoleText.length; x++) {
      outString.append(consoleText[x]).append("\n");
    }
    System.out.println(outString);
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
}