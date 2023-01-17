package Dungeon.Game.Rooms;

public class WalledRoom extends Room {
    private static final int TILE_ID = 1;

    public WalledRoom() {
        super(TILE_ID);
    }

    @Override
    public String toString() {
        return "#####";
    }

}
