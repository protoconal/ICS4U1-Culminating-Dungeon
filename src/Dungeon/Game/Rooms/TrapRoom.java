package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

/**
 * The TrapRoom class is a subclass of the Room class, and it is the room that the player can find
 * monsters in.
 */
public class TrapRoom extends Room {
  private static final int ROOM_ID = 4;

  /**
   * The constructor for the TrapRoom class.
   */
  public TrapRoom() {
    super(ROOM_ID, false);
  }

  /**
   * The toString() method returns a string representation of the object.
   * 
   * @return The string representation of the object.
   */
  @Override
  public String toString() {
    return "TRAP!";
  }

  /**
   * The interactRoom() method is called when the player interacts with the room.
   * 
   * @param player The player object.
   * @return The boolean value of the interactRoom() method.
   */
  @Override
  public boolean interactRoom(Player player) {
    return false;
  }


}
