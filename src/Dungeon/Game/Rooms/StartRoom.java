package Dungeon.Game.Rooms;

public class StartRoom extends Room {
    private static final int TILE_ID = -1;

    public StartRoom() {
        super(TILE_ID);
    }

    @Override
    public String toString() {
        return "START";
    }
}
