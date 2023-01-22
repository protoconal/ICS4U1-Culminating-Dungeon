package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

/**
 * The NormalRoom class represents an empty room.
 *
 * @author Tony Guo, Emily Ta, Ilelemwanta Nomaren, Chris Yang
 * @version 1.0
 * @since 1.0
 */
public class NormalRoom extends Room {

  /**
   * Constructor for the NormalRoom class.
   */
  public NormalRoom() {
    super(0, false);
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
