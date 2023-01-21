package Dungeon.Game.Entities;

import Dungeon.Game.DungeonMap.MapGenerationSettings;
import Dungeon.Game.GameWeightedRandoms;
import Dungeon.Game.Util;

public class Spawner {

  private final GameWeightedRandoms RAND;
  private final WeakMonsterDefinitions WEAK_MONSTER_DEFINITIONS = new WeakMonsterDefinitions();
  private final NormalMonsterDefinitions NORMAL_MONSTER_DEFINITIONS = new NormalMonsterDefinitions();
  private final StrongMonsterDefinitions STRONG_MONSTER_DEFINITIONS = new StrongMonsterDefinitions();
  private final BossMonsterDefinitions BOSS_MONSTER_DEFINITIONS = new BossMonsterDefinitions();

  public Spawner() {
    double[] spawnChances = new double[]{
        0.40, // WeakMonsters
        0.30, // NormalMonsters
        0.20, // StrongMonsters
        0.10, // Bosses
    };
    RAND = new GameWeightedRandoms(spawnChances);
  }

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
