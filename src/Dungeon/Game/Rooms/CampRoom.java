package Dungeon.Game.Rooms;

public class CampRoom extends Room {
    public CampRoom() {
        super();
    }

    @Override
    public boolean interactRoom(Player player) {
        return false;
    }
}
