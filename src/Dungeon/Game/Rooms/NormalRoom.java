package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

/**
 * The NormalRoom class is a subclass of the Room class, and it is the room that the player can find
 * monsters in.
 */
public class NormalRoom extends Room {
  
  /**
   * The constructor for the NormalRoom class.
   */
  public NormalRoom() {
    super(0, false);
  }

  /**
   * Interact room
   */
  public boolean interactRoom(Player player) {
    return false;
  }
}
