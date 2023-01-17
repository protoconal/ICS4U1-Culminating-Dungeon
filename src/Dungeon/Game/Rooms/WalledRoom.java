package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

public class WalledRoom extends Room {
    private static final int TILE_ID = 1;

    public WalledRoom() {
        super(TILE_ID);
    }

    @Override
    public String toString() {
        return "#####";
    }

    public boolean interactRoom(Player player) {
        return false;
    }

}
