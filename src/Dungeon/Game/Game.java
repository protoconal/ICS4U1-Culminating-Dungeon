package Dungeon.Game;

import Dungeon.Game.DungeonMap.Dungeon;
import Dungeon.Game.Views;

public class Game {
  static String gameName = "PLACEHOLDER_NAME";
  static String phase;
  
  Input in = new Input();
  Dungeon currentMap = new Dungeon();

  public Game() {
    // do nothing
    Views.printMainMenu();
    phase = "MAINMENU";

    // getMenuInputs
    System.out.println(Views.getToolTip("MAINMENU"));
    String optionSelected = in.getMenuKeys();
    if (optionSelected.equals(";")) {
      exit();
    }
   // continue onto main method
    showDungeon();
  };

  public void showDungeon() {
    Views.printDungeon(this.currentMap);
    // getMenuInputs
    System.out.println(Views.getToolTip("MAINMENU"));
    String optionSelected = in.getMenuKeys();
    // TODO: handle input
  }

  

  public static String getName() { return gameName; }

  
  public void exit() {
    System.exit(0);
  }
}