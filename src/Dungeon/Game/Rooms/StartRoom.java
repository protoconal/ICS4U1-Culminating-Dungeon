package Dungeon.Game.Rooms;

import Dungeon.Game.Player;
// generate java docs for this class please

/**
 * The StartRoom class is a subclass of the Room class, and it is the room that the player starts in.
 */
public class StartRoom extends Room {
  private static final int ROOM_ID = -1;

  /**
   * The constructor for the StartRoom class.
   */
  public StartRoom() {
    super(ROOM_ID, false);
  }

  /**
   * The toString() method returns a string representation of the object.
   * 
   * @return The string representation of the object.
   */
  @Override
  public String toString() {
    return "START";
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
