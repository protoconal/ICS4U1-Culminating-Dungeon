package Dungeon.Game.Entities;

import Dungeon.Game.DungeonMap.MapGenerationSettings;
import Dungeon.Game.GameWeightedRandoms;
import Dungeon.Game.Util;

/**
 * The Spawner class is a class that spawns monsters in the dungeon.
 */
public class Spawner {

  private final GameWeightedRandoms RAND;
  private final WeakMonsterDefinitions WEAK_MONSTER_DEFINITIONS = new WeakMonsterDefinitions();
  private final NormalMonsterDefinitions NORMAL_MONSTER_DEFINITIONS = new NormalMonsterDefinitions();
  private final StrongMonsterDefinitions STRONG_MONSTER_DEFINITIONS = new StrongMonsterDefinitions();
  private final BossMonsterDefinitions BOSS_MONSTER_DEFINITIONS = new BossMonsterDefinitions();

  /**
   * The constructor for the Spawner class.
   */
  public Spawner() {
    double[] spawnChances = new double[]{
        0.40, // WeakMonsters
        0.30, // NormalMonsters
        0.20, // StrongMonsters
        0.10, // Bosses
    };
    RAND = new GameWeightedRandoms(spawnChances);
  }

  /**
   * The lookupScaleFactors() method looks up the scale factors for the given depth.
   * 
   * @param depth The depth to look up the scale factors for.
   * @return The scale factors for the given depth.
   */
  private double[] lookupScaleFactors(int depth) {
    double[][] factors = MapGenerationSettings.getMonsterChanceTable();

    double[] scalingFactor = factors[0];
    int x = 0;
    while ((double) depth > scalingFactor[0] && x < (factors.length - 1)) {
      x += 1;
      scalingFactor = factors[x];
    }

    scalingFactor = Util.copyArrayFromIndexes(scalingFactor, 1, scalingFactor.length);
    return scalingFactor;
  }

  /**
   * The randomSpawn() method spawns a random monster.
   * 
   * @param radius The radius of the monster.
   * @return A random monster.
   */
  public Monster randomSpawn(int radius) {
    if (RAND.getRadius() != radius) {
      RAND.setScaleFactors(radius, lookupScaleFactors(radius));
    }

    int choice = RAND.generateChoice();
    if (choice == 0) {
      return WEAK_MONSTER_DEFINITIONS.generateMonster();
    }
    if (choice == 1) {
      return NORMAL_MONSTER_DEFINITIONS.generateMonster();
    }
    if (choice == 2) {
      return STRONG_MONSTER_DEFINITIONS.generateMonster();
    }
    if (choice == 3) {
      return BOSS_MONSTER_DEFINITIONS.generateMonster();
    }
    return null;
  }
}
