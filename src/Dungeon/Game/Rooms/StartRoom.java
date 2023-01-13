package Dungeon.Game.Rooms;

public class StartRoom extends Room {
    private static final int TITLE_ID = -1;

    public StartRoom() {
        super(TITLE_ID);
    }

    @Override
    public String toString() {
        return "START";
    }
}
