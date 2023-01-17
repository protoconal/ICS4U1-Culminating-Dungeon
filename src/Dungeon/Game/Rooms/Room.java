package Dungeon.Game.Rooms;

public abstract class Room {
    private final int TILE_ID;

    public Room() {
        this.TILE_ID = 0;
    }

    public Room(int tileID) {
        this.TILE_ID = tileID;
    }

    public static Room getTile(int tileID) {
        // these definitions correspond to chance table
        if (tileID == 0) { return new NormalRoom(); }
        if (tileID == 1) { return new WalledRoom(); }
        if (tileID == 2) { return new TreasureRoom(); }
        if (tileID == 3) { return new MonsterRoom(); }
        if (tileID == 4) { return new TrapRoom(); }
        if (tileID == -1) { return new StartRoom(); }
        return null;
    }

    @Override
    public String toString() {
        return "     ";
    }

    public int getTileID() {
        return this.TILE_ID;
    }
}
