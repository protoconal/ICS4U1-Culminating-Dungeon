package Dungeon.Game.DungeonMap;

public class MapGenerationSettings {
    // TODO: implement scaling generation
    private static final double[] CHANCE_TABLES = {
            0.50, // EmptyTile
            0.50, // WallTile
    };

    private static final double[][] SCALING_TABLES = {
            // depth will always be half of width of table
            {1, 1.00, 0.00}, // depth 1, EmptyTile Chance, WallTile Chance,
            {2, 1.00, 1.50}, // depth 2
            {4, 1.00, 0.50}, // depth 5
            {5, 1.00, 5.00}, // depth 5
            {8, 1.00, 2.00}, // depth 6
    };

    private static final double[] WALL_CHANCE = {
            0.10, // DeadEnd
            0.70, // Wall Twice
            0.20, // Wall Thrice
    };

    public static double[] getProbabilities() {
        return CHANCE_TABLES;
    }

    public static double[][] getScalingFactors() {
        return SCALING_TABLES;
    }

    public static double[] getWallChance() {
        return WALL_CHANCE;
    }
}
