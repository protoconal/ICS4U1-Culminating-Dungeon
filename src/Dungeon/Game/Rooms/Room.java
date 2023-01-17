package Dungeon.Game.Rooms;

public abstract class Room {
    private final int TILE_ID;

    public Room() {
        this.TILE_ID = 0;
    }

    public Room(int tileID) {
        this.TILE_ID = tileID;
    }


    @Override
    public String toString() {
        return "     ";
    }

    public int getTileID() {
        return this.TILE_ID;
    }
}
