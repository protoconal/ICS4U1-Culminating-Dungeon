package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

/**
 * The Room abstract class provides a template for all other Rooms in the game.
 *
 * @author Tony Guo, Emily Ta, Ilelemwanta Nomaren, Chris Yang
 * @version 1.0
 * @since 1.0
 */
public abstract class Room {
  private final int ROOM_ID;
  private boolean isInteractable = true;

  /**
   * Constructor for the Room class, assumes it acts as a normal room.
   */
  public Room() {
    this.ROOM_ID = 0;
  }

  /**
   * Constructor for the Room class, sets the roomId to the provided id.
   *
   * @param roomId a string that stores the room ID.
   */
  public Room(int roomId) {
    this.ROOM_ID = roomId;
  }

  /**
   * Constructor for the Room class, sets the roomId to the provided id and its interaction status.
   *
   * @param roomId         a string that stores the room ID.
   * @param isInteractable stores whether the room is interactable
   */
  public Room(int roomId, boolean isInteractable) {
    this.ROOM_ID = roomId;
    this.isInteractable = isInteractable;
  }

  /**
   * @return the representation of the room on a Dungeon map.
   */
  @Override
  public String toString() {
    return "     ";
  }

  /**
   * @return this room's id.
   */
  public int getRoomId() {
    return this.ROOM_ID;
  }

  /**
   * This abstract method handles when the player interacts with the room.
   *
   * @param player stores the player to interact with.
   * @return whether the player died in the room.
   */
  public abstract boolean interactRoom(Player player);

  /**
   * @return whether the room is interactable.
   */
  public boolean isInteractable() {
    return isInteractable;
  }

  /**
   * Sets the whether the room is interactable.
   *
   * @param interactable stores whether the room is interactable.
   */
  public void setInteractableStatus(boolean interactable) {
    this.isInteractable = interactable;
  }
}
