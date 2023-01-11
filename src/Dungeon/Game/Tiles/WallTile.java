package Dungeon.Game.Tiles;

public class WallTile extends GameTile {
    private final int tileID = 0;
    @Override
    public int getTileID() {
        return tileID;
    }

    @Override
    public String toString() {
        return "####";
    }

    private boolean UNTRAVERSABLE = true;
}
