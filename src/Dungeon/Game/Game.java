package Dungeon.Game;

import Dungeon.Game.DungeonMap.Dungeon;

public class Game {
  static final String GAME_NAME = "PLACEHOLDER_NAME";
  static String phase;
  
  private final Input IN = new Input();
  private Dungeon currentMap = new Dungeon();
  private int[] playerCoordinates = currentMap.getCenter();

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
    String optionSelected = IN.getMove(currentMap.getMovableDirections(playerCoordinates));
    // TODO: handle input

    // activate Room input

  }

  public void handleRoom() {
    
  }
  

  public static String getName() { return GAME_NAME; }

  
  public void exit() {
    System.exit(0);
  }
}