package Dungeon.Game.Tiles;

public class WallTile extends GameTile {
    private static final int TITLE_ID = 1;

    public WallTile() {
        super(TITLE_ID);
    }

    @Override
    public String toString() {
        return "####";
    }

    // --Commented out by Inspection (1/12/2023 11:22 PM):private final boolean UNTRAVERSABLE = true;
}
