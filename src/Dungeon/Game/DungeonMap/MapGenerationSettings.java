package Dungeon.Game.DungeonMap;

/**
 * This MapGenerationSettings class contains the specifications for map generation.
 * <p></>
 * Each table contains the relative weights against each other to be used.
 *
 * @author Tony Guo, Emily Ta, Chris Yang, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public class MapGenerationSettings {
  /**
   * Stores the chances for generating each Room for any given coordinate
   */
  private static final double[] ROOM_PROBABILITY_TABLE = {
      0.20, // EmptyRoom
      0.20, // WallRoom
      0.20, // TreasureRoom
      0.40, // MonsterRoom
  };

  /**
   * Stores the scaling factors for the base Room probabilities to be multiplied by according to the distance from the center.
   * <p></p>
   * When the player gets farther away from the center, we can allow for higher occurrences of MonsterRooms.
   */
  private static final double[][] ROOM_PROBABILITY_SCALING_TABLES = {
      // the depth is the maximum validity
      // i.e. before two will have x values

      // depth will always be half of width of table
      {1, 1.00, 0.00, 0.00, 0.00}, // distance 1,   EmptyChance, WallChance, TreasureChance, MonsterChance
      {2, 1.00, 1.50, 1.50, 1.00}, // distance 2,   EmptyChance, WallChance, TreasureChance, MonsterChance
      {4, 1.00, 0.50, 0.00, 1.50}, // distance 3-4, EmptyChance, WallChance, TreasureChance, MonsterChance
      {5, 1.00, 5.00, 2.00, 0.00}, // distance 5,   EmptyChance, WallChance, TreasureChance, MonsterChance
      {8, 1.00, 2.00, 0.00, 0.25}, // distance 6-8,   EmptyChance, WallChance, TreasureChance, MonsterChance
  };

  /**
   * Stores the scaling factors for the base Monster probabilities to be multiplied by according to the dungeon depth.
   * <p></p>
   * When the player gets deeper into the dungeon, we can allow for higher strength of monsters.
   */
  private static final double[][] MONSTER_CHANCE_TABLE = {
      // the depth is the maximum validity
      // i.e. before two will have x values

      // depending on levels deep into the dungeon
      {3, 1.00, 0.00, 0.00, 0.00}, // 1-3, Weak, Normal, Strong, Boss
      {6, 1.00, 1.50, 1.50, 0.00}, // 4-6
      {9, 0.00, 0.50, 1.00, 0.00}, // 7-9
      {10, 0.00, 5.00, 2.00, 2.00}, // 10
      {12, 0.00, 0.00, 1.00, 2.00}, // 11-12
  };


  /**
   * @return the Room probability table (double[]).
   */
  public static double[] getRoomProbabilities() {
    return ROOM_PROBABILITY_TABLE;
  }

  /**
   * @return the Room probability scaling table (double[][]).
   */
  public static double[][] getRoomScalingFactors() {
    return ROOM_PROBABILITY_SCALING_TABLES;
  }

  /**
   * @return the monster chance table (double[][]).
   */
  public static double[][] getMonsterChanceTable() {
    return MONSTER_CHANCE_TABLE;
  }
}
