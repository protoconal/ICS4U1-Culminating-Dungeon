package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

public class NormalRoom extends Room {
  public NormalRoom() {
    super(0, false);
  }

  public boolean interactRoom(Player player) {
    return false;
  }
}
