package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

/**
 * The StartRoom class represents an walled off room.
 *
 * @author Tony Guo, Emily Ta, Ilelemwanta Nomaren, Chris Yang
 * @version 1.0
 * @since 1.0
 */
public class WalledRoom extends Room {
  private static final int ROOM_ID = 1;

  /**
   * Constructor for the WalledRoom class.
   */
  public WalledRoom() {
    super(ROOM_ID);
  }

  /**
   * @return the representation of the room on a Dungeon map.
   */
  @Override
  public String toString() {
    return "#####";
  }

  /**
   * Does nothing.
   *
   * @param player does nothing.
   * @return false.
   */
  public boolean interactRoom(Player player) {
    return false;
  }

}
