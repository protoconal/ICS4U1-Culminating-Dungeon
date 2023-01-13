package Dungeon.Game.Entities;

import Dungeon.Game.WeightedRandoms;

public class Spawner {
    private final Monster[] spawnSubtypes;
    private final WeightedRandoms rand;

    public Spawner(Monster[] spawnSubtypes, double[] spawnChances) {
        this.spawnSubtypes = spawnSubtypes;
        this.rand = new WeightedRandoms(spawnChances);
    }

    public Monster randomSpawn() {
        return spawnSubtypes[rand.generateChoice()];
    }
}
