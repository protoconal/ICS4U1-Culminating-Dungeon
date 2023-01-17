package Dungeon.Game.Rooms;

import Dungeon.Game.Entities.*;
import Dungeon.Game.WeightedRandoms;

public class MonsterRoom extends Room {
    private static final int TILE_ID = 3;
    private Monster monster = null;

    private Spawner spawner = null;

    public MonsterRoom() {
        super(TILE_ID);
    }

    public MonsterRoom(Monster monster) {
        super(TILE_ID);
        this.monster = monster;
    }

    public MonsterRoom(Spawner spawner) {
        super(TILE_ID);
        this.spawner = spawner;
        this.monster = spawner.randomSpawn();
    }

    public MonsterRoom(Spawner spawner, Monster monster) {
        super(TILE_ID);
        this.spawner = spawner;
        this.monster = monster;
    }

    @Override
    public String toString() {
        return "MONST";
    }
}