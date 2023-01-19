package Dungeon.Game;

import Dungeon.Game.Entities.Hero;
import Dungeon.Game.Items.PlayerInventory;

public class Player extends Hero {
  public PlayerInventory inventory = new PlayerInventory();
  private int score = 0;

  public Player() {
    super();
  }

  @Override
  public String toString() {
    String out = "Player - HP: " + this.getCurrentHP() +
        " - AVG DMG: " +
        inventory.getEquippedWeapon().getAvgDamage();
    return out;
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
