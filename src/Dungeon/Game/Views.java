package Dungeon.Game;

import Dungeon.Game.DungeonMap.Dungeon;
import Dungeon.Game.Game;

public class Views {
  public static String gameHeader() {
    return "----------  " + Game.getName() + "  ----------\n";
  }
  
  public static void showMainMenu() {
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

  public static String showToolTip(String type) {
    if (type.equals("MOVEMENT")) {
      return "W: Up, A: Left, S: Down, D: Right";
    }
    if (type.equals("INVENTORY")) {
      return "E: Use, ";
    }
    return null;
  }

  public static void showTutorial() {
    String[] consoleText = new String[]{
      "Hello, wandering traveller!",
      "You’ve been selected to explore the newly-discovered dungeon of Vaquera.", 
      "Your bravery will help you fight monsters, find treasure, and help Vaquera learn more about the treasures that lie beneath the surface.",
      "Oh, I didn't tell you how to move!",
      "",
      "",
      "",
    };
    printLines(consoleText);
  }

  public static void showDungeon(Dungeon map) {
    
  }

  public static void showDeathMenu(Dungeon map) {
    
  }

  public static void showShop() {
    
  }

  public static void printLines(String[] consoleText) {
    StringBuilder outString = new StringBuilder(gameHeader());
    for (int x = 0; x < consoleText.length; x++) {
      outString.append(consoleText[x] + "\n");
    }
    System.out.println(outString.toString());
  }
}