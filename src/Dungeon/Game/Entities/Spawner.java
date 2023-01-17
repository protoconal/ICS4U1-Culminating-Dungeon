package Dungeon.Game.Entities;

import Dungeon.Game.WeightedRandoms;

public class Spawner {

    private final WeightedRandoms RAND;
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
        RAND = new WeightedRandoms(spawnChances);
    }

    public Monster randomSpawn() {
        int choice = RAND.generateChoice();
        if (choice == 0) { return WEAK_MONSTER_DEFINITIONS.generateMonster(); };
        if (choice == 1) { return NORMAL_MONSTER_DEFINITIONS.generateMonster(); };
        if (choice == 2) { return STRONG_MONSTER_DEFINITIONS.generateMonster(); };
        if (choice == 3) { return BOSS_MONSTER_DEFINITIONS.generateMonster(); };
        return null;
    }
}
