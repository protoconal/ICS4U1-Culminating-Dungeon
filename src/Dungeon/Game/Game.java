package Dungeon.Game;

import Dungeon.Game.Views;

public class Game {
  static String gameName = "PLACEHOLDER_NAME";
  static String phase;
  
  Input in = new Input();

  public Game() {
    // do nothing
    Views.showMainMenu();
    phase = "MAINMENU";

    // getMenuInputs
    String optionSelected = in.getMenuKeys();
    if (optionSelected.equals(";")) {
      exit();
    }
   // continue onto main method
  };

  public static String getName() { return gameName; }

  
  public void exit() {
    System.exit(0);
  }
}