package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

/**
 * The StartRoom class represents an empty starting room.
 *
 * @author Tony Guo, Emily Ta, Ilelemwanta Nomaren, Chris Yang
 * @version 1.0
 * @since 1.0
 */
public class StartRoom extends Room {
  private static final int ROOM_ID = -1;

  /**
   * Constructor for the StartRoom class.
   */
  public StartRoom() {
    super(ROOM_ID, false);
  }

  /**
   * @return the representation of the room on a Dungeon map.
   */
  @Override
  public String toString() {
    return "START";
  }

  /**
   * Does nothing.
   *
   * @param player does nothing.
   * @return false.
   */
  @Override
  public boolean interactRoom(Player player) {
    return false;
  }
}
