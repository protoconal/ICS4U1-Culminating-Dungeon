package Dungeon.Game.Tiles;

public abstract class GameTile {
    private final int TILE_ID;

    public GameTile() {
        this.TILE_ID = 0;
    }

    public GameTile(int tileID) {
        this.TILE_ID = tileID;
    }

    public static GameTile getTile(int tileID) {
        // these definitions correspond to chance table
        if (tileID == 0) { return new EmptyTile(); }
        if (tileID == 1) { return new WallTile(); }
        if (tileID == -1) { return new StartTile(); }
        return null;
    }

    @Override
    public String toString() {
        return "    ";
    }

    public int getTileID() {
        return this.TILE_ID;
    }
}
