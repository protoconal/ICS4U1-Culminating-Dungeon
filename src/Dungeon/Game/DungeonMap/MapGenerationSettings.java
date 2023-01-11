package Dungeon.Game.DungeonMap;

import Dungeon.Game.Tiles.GameTile;
import Dungeon.Game.Tiles.WallTile;

public class MapGenerationSettings {
    // TODO: implement scaling generation
    private static double[] chanceTables = {
            0.50, // Wall
            0.50, // RegularTile
    };

    private static final double[][] scalingTables = {
            // depth will always be half of width of table
            {1, 0.00, 1.00}, // depth 1
            {2, 0.50, 1.00}, // depth 2
            //{3, 1.00, 1.00}, // depth 3
            {4, 3.00, 1.00}, // depth 4
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

    public static double[][] getScalingFactors() {
        return scalingTables;
    }

    public static double[] getWallChance() {
        return wallChance;
    }
}
