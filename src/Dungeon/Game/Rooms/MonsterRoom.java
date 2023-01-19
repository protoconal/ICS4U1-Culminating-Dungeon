package Dungeon.Game.Rooms;

import Dungeon.Game.Entities.Monster;
import Dungeon.Game.Entities.Spawner;
import Dungeon.Game.Player;
import Dungeon.Game.Game;

public class MonsterRoom extends Room {
  private static final int TILE_ID = 3;
  private Monster monster = null;

  private Spawner spawner = null;

  public MonsterRoom() {
    super(TILE_ID, false);
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
    return " <M> ";
  }

  public boolean interactRoom(Player player) {
    this.setInteractableStatus(false);
    Game.handleFight(this.monster);
    return false;
  }
}