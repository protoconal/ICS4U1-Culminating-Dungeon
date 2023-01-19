package Dungeon.Game.DungeonMap;

public class MapGenerationSettings {
  // TODO: implement scaling generation
  private static final double[] CHANCE_TABLES = {
      0.50, // EmptyRoom
      0.40, // WallRoom
      0.10, // TreasureRoom
      0.00, // MonsterRoom
      0.00, // TrapRoom
  };

  private static final double[][] SCALING_TABLES = {
      // depth will always be half of width of table
      {1, 1.00, 0.00, 0.00, 0, 0}, // depth 1, EmptyChance, WallChance, TreasureChance, MonsterChane, TrapChance
      {2, 1.00, 1.50, 1.50, 0, 0}, // depth 2
      {4, 1.00, 0.50, 0.00, 0, 0}, // depth 5
      {5, 1.00, 5.00, 2.00, 0, 0}, // depth 5
      {8, 1.00, 2.00, 0.00, 0, 0}, // depth 6
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
