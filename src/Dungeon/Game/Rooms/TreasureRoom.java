package Dungeon.Game.Rooms;
// Are you supposed to know where the treasure room is?
public class TreasureRoom extends Room {
    private static final int TILE_ID = 2;

    public TreasureRoom() {
        super(TILE_ID);
    }

    @Override
    public String toString() {
        return "!!!!!";
    }

}
