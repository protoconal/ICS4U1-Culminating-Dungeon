package Dungeon.Game.DungeonMap;

public class MapGenerationSettings {
  // TODO: implement scaling generation
  private static final double[] CHANCE_TABLES = {
      0.20, // EmptyRoom
      0.15, // WallRoom
      0.20, // TreasureRoom
      0.30, // MonsterRoom
      0.00, // TrapRoom
  };

  private static final double[][] SCALING_TABLES = {
      // depth will always be half of width of table
      {1, 1.00, 0.00, 0.00, 0.00, 0}, // depth 1, EmptyChance, WallChance, TreasureChance, MonsterChance, TrapChance
      {2, 1.00, 1.50, 1.50, 0.50, 0}, // depth 2, EmptyChance, WallChance, TreasureChance, MonsterChance, TrapChance
      {4, 1.00, 0.50, 0.00, 2.00, 0}, // depth 5, EmptyChance, WallChance, TreasureChance, MonsterChance, TrapChance
      {5, 1.00, 5.00, 2.00, 0.00, 0}, // depth 5, EmptyChance, WallChance, TreasureChance, MonsterChance, TrapChance
      {8, 1.00, 2.00, 0.00, 0.25, 0}, // depth 6, EmptyChance, WallChance, TreasureChance, MonsterChance, TrapChance
  };

  private static final double[][] MONSTER_CHANCE_TABLE = {
      // depending on levels deep into the dungeon
      {1, 1.00, 0.00, 0.00, 0.00}, // depth 1, Weak, Normal, Strong, Boss
      {3, 1.00, 1.50, 1.50, 0.00}, // depth 2
      {6, 0.00, 0.50, 1.00, 0.00}, // depth 5
      {9, 0.00, 5.00, 2.00, 2.00}, // depth 5
      {10, 0.00, 1.00, 1.00, 2.00}, // depth 6
  };


  public static double[] getProbabilities() {
    return CHANCE_TABLES;
  }

  public static double[][] getScalingFactors() {
    return SCALING_TABLES;
  }

  public static double[][] getMonsterChanceTable() {
    return MONSTER_CHANCE_TABLE;
  }
}
