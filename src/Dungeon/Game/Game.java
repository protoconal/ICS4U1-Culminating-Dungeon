package Dungeon.Game;

import Dungeon.Game.DungeonMap.Dungeon;
import Dungeon.Game.Rooms.Room;

public class Game {
  static final String GAME_NAME = "Vaquera: The Emboldened Adventure";
  static String phase;
  private Dungeon currentMap = new Dungeon();
  private int[] playerCoordinates = currentMap.getCenter();

  private Player player = new Player();

  public Game() {
    // do nothing
    Views.printMainMenu();
    phase = "MAINMENU";

    // getMenuInputs
    System.out.println(Views.getToolTip("MAINMENU"));
    String optionSelected = Input.getMenuKeys();
    if (optionSelected.equals(";")) {
      exit();
    }
   // continue onto main method
    showDungeon();
  }

  public void showDungeon() {
    // update visibility
    this.currentMap.updateVisibility(playerCoordinates);
    Views.printDungeon(this.currentMap, playerCoordinates);
    // getMenuInputs
    String optionSelected = Input.getMove(currentMap.getMovableDirections(playerCoordinates));

    // update coordinates
    this.playerCoordinates = Dungeon.calculateCoordinates(playerCoordinates, optionSelected);

    // TODO: handle input

    // activate Room input
    Room currentRoom = this.currentMap.getMapTile(playerCoordinates);
    handleRoom(currentRoom);

    // begin draw routine
    showDungeon();
  }

  public void handleRoom(Room currentRoom) {
    // if room is not interactable
    if (!currentRoom.isInteractable()) {
      return;
    }

    boolean hasDied = currentRoom.interactRoom(this.player);
    Input.waitForKeyPress();
    if (hasDied) {
      // send to death code
    }
    // otherwise continue
  }
  

  public static String getName() { return GAME_NAME; }

  
  public void exit() {
    System.exit(0);
  }
}