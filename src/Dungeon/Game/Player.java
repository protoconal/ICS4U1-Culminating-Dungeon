package Dungeon.Game;

import Dungeon.Game.Entities.Hero;
import Dungeon.Game.Items.PlayerInventory;

public class Player extends Hero {
  public final PlayerInventory INVENTORY = new PlayerInventory();
  private int score = 0;
  private String deathReason;

  public Player() {
    super();
  }

  @Override
  public String toString() {
    return "Player - HP: " + this.getCurrentHP() +
        " - AVG DMG: " +
        INVENTORY.getEquippedWeapon().getAvgDamage();
  }

  public int getScore() {
    return score;
  }

  public void addScore(int score) {
    this.score += score;
  }

  public void reset() {
    this.score = 0;
    this.resetHP();
    INVENTORY.reset();
  }

  public PlayerInventory getInventory() {
    return INVENTORY;
  }

  public String getDeathReason() {
    return deathReason;
  }

  public void setDeathReason(String deathReason) {
    this.deathReason = deathReason;
  }
}
