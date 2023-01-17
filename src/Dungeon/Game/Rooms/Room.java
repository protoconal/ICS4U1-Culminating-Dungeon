package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

public abstract class Room {
    private boolean isInteractable = true;

    private final int TILE_ID;

    public Room() {
        this.TILE_ID = 0;
    }

    public Room(int tileID) {
        this.TILE_ID = tileID;
    }

    public Room(int tileID, boolean isInteractable) {
        this.TILE_ID = tileID;
        this.isInteractable = isInteractable;
    }


    @Override
    public String toString() {
        return "     ";
    }

    public int getTileID() {
        return this.TILE_ID;
    }

    public abstract boolean interactRoom(Player player);

    public boolean isInteractable() {
        return isInteractable;
    }

    public void setInteractableStatus(boolean interactable) {
        this.isInteractable = interactable;
    }
}
