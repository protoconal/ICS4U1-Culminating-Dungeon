package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

public class TrapRoom extends Room {
  private static final int TILE_ID = 4;

  public TrapRoom() {
    super(TILE_ID, false);
  }

  @Override
  public String toString() {
    return "TRAP!";
  }

  @Override
  public boolean interactRoom(Player player) {
    return false;
  }


}
