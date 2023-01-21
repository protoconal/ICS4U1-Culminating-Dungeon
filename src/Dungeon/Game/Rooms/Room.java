package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

/**
 * The Room class is an abstract class that is the parent class of all the room classes.
 * 
 * @author Dylan
 *
 */
public abstract class Room {
  private final int ROOM_ID;
  private boolean isInteractable = true;

  /**
   * The constructor for the Room class.
   */
  public Room() {
    this.ROOM_ID = 0;
  }

  /**
   * The constructor for the Room class.
   * 
   * @param roomId The room ID.
   */
  public Room(int roomId) {
    this.ROOM_ID = roomId;
  }

  /**
   * The constructor for the Room class.
   * 
   * @param tileID The tile ID.
   * @param isInteractable The boolean value of the isInteractable variable.
   */
  public Room(int tileID, boolean isInteractable) {
    this.ROOM_ID = tileID;
    this.isInteractable = isInteractable;
  }

  /**
   * The toString() method returns a string representation of the object.
   * 
   * @return The string representation of the object.
   */
  @Override
  public String toString() {
    return "     ";
  }

  /**
   * The interactRoom() method is called when the player interacts with the room.
   * 
   * @param player The player object.
   * @return The boolean value of the interactRoom() method.
   */
  public int getRoomId() {
    return this.ROOM_ID;
  }

  /**
   * The interactRoom() method is called when the player interacts with the room.
   * 
   * @param player The player object.
   * @return The boolean value of the interactRoom() method.
   */
  public abstract boolean interactRoom(Player player);

  /**
   * The isInteractable() method returns the boolean value of the isInteractable variable.
   * 
   * @return The boolean value of the isInteractable variable.
   */
  public boolean isInteractable() {
    return isInteractable;
  }

  /**
   * The setInteractableStatus() method sets the boolean value of the isInteractable variable.
   * 
   * @param interactable The boolean value of the isInteractable variable.
   */
  public void setInteractableStatus(boolean interactable) {
    this.isInteractable = interactable;
  }
}
