package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

public abstract class Room {
  private final int ROOM_ID;
  private boolean isInteractable = true;

  public Room() {
    this.ROOM_ID = 0;
  }

  public Room(int roomId) {
    this.ROOM_ID = roomId;
  }

  public Room(int tileID, boolean isInteractable) {
    this.ROOM_ID = tileID;
    this.isInteractable = isInteractable;
  }


  @Override
  public String toString() {
    return "     ";
  }

  public int getRoomId() {
    return this.ROOM_ID;
  }

  public abstract boolean interactRoom(Player player);

  public boolean isInteractable() {
    return isInteractable;
  }

  public void setInteractableStatus(boolean interactable) {
    this.isInteractable = interactable;
  }
}
