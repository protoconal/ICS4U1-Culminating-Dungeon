package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

/**
 * The WalledRoom class is a subclass of the Room class, and it is the room that the player can find
 * monsters in.
 */
public class WalledRoom extends Room {
  private static final int ROOM_ID = 1;

  /**
   * The constructor for the WalledRoom class.
   */
  public WalledRoom() {
    super(ROOM_ID);
  }

  /**
   * The toString() method returns a string representation of the object.
   * 
   * @return The string representation of the object.
   */
  @Override
  public String toString() {
    return "#####";
  }

  /**
   * The interactRoom() method is called when the player interacts with the room.
   * 
   * @param player The player object.
   * @return The boolean value of the interactRoom() method.
   */
  public boolean interactRoom(Player player) {
    return false;
  }

}
