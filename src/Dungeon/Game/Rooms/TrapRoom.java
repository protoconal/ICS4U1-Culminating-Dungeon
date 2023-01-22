package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

/**
 * The TrapRoom class represents a challenge that the player must complete to continue.
 *
 * @author Tony Guo, Emily Ta, Ilelemwanta Nomaren, Chris Yang
 * @version 1.0
 * @since 1.0
 */
public class TrapRoom extends Room {
  private static final int ROOM_ID = 4;

  /**
   * Constructor for the TrapRoom class.
   */
  public TrapRoom() {
    super(ROOM_ID, false);
  }

  /**
   * Handles when the player interacts with the trap.
   *
   * @param player stores the player to interact with.
   * @return whether the player died in the room.
   */
  @Override
  public boolean interactRoom(Player player) {
    // TODO: IMPLEMENT THIS
    return false;
  }


}
