package Dungeon.Game;

import Dungeon.Game.DungeonMap.Dungeon;

public class Game {
  static final String GAME_NAME = "PLACEHOLDER_NAME";
  static String phase;
  
  final Input IN = new Input();
  private Dungeon currentMap = new Dungeon();

  public Game() {
    // do nothing
    Views.printMainMenu();
    phase = "MAINMENU";

    // getMenuInputs
    System.out.println(Views.getToolTip("MAINMENU"));
    String optionSelected = IN.getMenuKeys();
    if (optionSelected.equals(";")) {
      exit();
    }
   // continue onto main method
    showDungeon();
  }

    public void showDungeon() {
    Views.printDungeon(this.currentMap);
    // getMenuInputs
    System.out.println(Views.getToolTip("MAINMENU"));
    String optionSelected = IN.getMenuKeys();
    // TODO: handle input
  }

  

  public static String getName() { return GAME_NAME; }

  
  public void exit() {
    System.exit(0);
  }
}