package Dungeon.Game.Tiles;

public class StartTile extends GameTile {
    private static final int TITLE_ID = -1;

    public StartTile() {
        super(TITLE_ID);
    }

    @Override
    public String toString() {
        return "START";
    }
}
