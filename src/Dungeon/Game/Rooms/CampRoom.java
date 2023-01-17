package Dungeon.Game.Rooms;

public class CampRoom extends Room {
    private static final int TILE_ID = 5;

    public CampRoom() {
        super();
    }
  
    @Override
    public String toString() {
        return "CAMP!";
    }

    @Override
    public boolean interactRoom(Player player) {
        return false;
    }
}
