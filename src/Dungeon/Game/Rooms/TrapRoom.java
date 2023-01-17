package Dungeon.Game.Rooms;

public class TrapRoom extends Room {
    private static final int TILE_ID = 4;

    public TrapRoom() {
        super(TILE_ID);
    }

    @Override
    public String toString() {
        return "TRAP!";
    }

}
