package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

import Dungeon.Game.Views;

public class EndRoom extends Room {
  private static final int ROOM_ID = 5;

  public EndRoom() {
    super(ROOM_ID);
  }

  @Override
  public String toString() {
    return "FINAL";
  }

  public boolean interactRoom(Player player) {

    String[] consoleText = new String[]{
       "You've won!", "Hooray!",
    };

    Views.printLines(consoleText);
    return false;
  }

}
