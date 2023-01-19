package Dungeon.Game;

import Dungeon.Game.Entities.Hero;
import Dungeon.Game.Items.PlayerInventory;

public class Player extends Hero {
  public final PlayerInventory inventory = new PlayerInventory();
  private int score = 0;

  public Player() {
    super();
  }

  @Override
  public String toString() {
    return "Player - HP: " + this.getCurrentHP() +
        " - AVG DMG: " +
        inventory.getEquippedWeapon().getAvgDamage();
  }

  public int getScore() {
    return score;
  }

  public void addScore(int score) {
    this.score += score;
  }

  public PlayerInventory getInventory() {
    return inventory;
  }

}
