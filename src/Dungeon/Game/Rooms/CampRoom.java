package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

public class CampRoom extends Room {
  // allow shopping

  // allow for healing

  private static final int TILE_ID = 5;

  public CampRoom() {
    super(TILE_ID, false);
  }

  @Override
  public String toString() {
    return "CAMP!";
  }

  @Override
  public boolean interactRoom(Player player) {
    // check to heal player
    return false;
  }
}
