package Dungeon.Game.Rooms;

public class CampRoom extends Room {
    private static final int TILE_ID = 5;

    public CampRoom() {
        super(TILE_ID);
    }

    @Override
    public String toString() {
        return "CAMP!";
    }

}
