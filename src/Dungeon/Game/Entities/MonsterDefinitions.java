package Dungeon.Game.Entities;

import Dungeon.Game.GameWeightedRandoms;

/**
 * This abstract class provides a helper template for all the other definitions to store their information within.
 *
 * @author Tony Guo, Emily Ta, Chris Yang, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public abstract class MonsterDefinitions {
  private final GameWeightedRandoms RANDOM;
  private final Monster[] MONSTER_TABLE;

  /**
   * Constructor for the MonsterDefinition class.
   */
  public MonsterDefinitions(Monster[] monsterTable, double[] spawnChances) {
    MONSTER_TABLE = monsterTable;
    RANDOM = new GameWeightedRandoms(spawnChances);
  }

  /**
   * @return generates a random monster from the monster table.
   */
  public Monster generateMonster() {
    return MONSTER_TABLE[RANDOM.generateChoice()].returnCopy();
  }
}
