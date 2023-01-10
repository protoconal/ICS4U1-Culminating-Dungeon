package Dungeon.Game.DungeonMap;

import Dungeon.Game.GameTile;
import Dungeon.Game.WallTile;

public class MapGenerationSettings {
    // TODO: implement scaling generation
    private static double[] chanceTables = {
            0.50, // Wall
            0.50, // RegularTile
    };

    private static double[] wallChance = {
            0.10, // DeadEnd
            0.70, // Wall Twice
            0.20, // Wall Thrice
    };

    public static GameTile getTile(int tileID) {
        // these definitions correspond to chance table
        if (tileID == 0) { return new WallTile(); };
        if (tileID == 1) { return new GameTile(); };
        return null;
    }

    public static double[] getProbabilities() {
        return chanceTables;
    }

    public static double[] getWallChance() {
        return wallChance;
    }
}
