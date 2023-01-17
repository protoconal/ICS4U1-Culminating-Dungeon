package Dungeon.Game.Rooms;

import Dungeon.Game.Player;

public class StartRoom extends Room {
    private static final int TILE_ID = -1;

    public StartRoom() {
        super(TILE_ID, false);
    }

    @Override
    public String toString() {
        return "START";
    }

    @Override
    public boolean interactRoom(Player player) {
        return false;
    }
}
