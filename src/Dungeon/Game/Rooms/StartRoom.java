package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

public class StartRoom extends Room {
  private static final int ROOM_ID = -1;

  public StartRoom() {
    super(ROOM_ID, false);
  }

  @Override
  public String toString() {
    return "START";
  }

  @Override
  public boolean interactRoom(Player player) {
    return false;
  }
}
