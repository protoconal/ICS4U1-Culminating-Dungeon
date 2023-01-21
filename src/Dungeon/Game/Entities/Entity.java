package Dungeon.Game.Entities;

import Dungeon.Game.Items.HealthItem;
import Dungeon.Game.Items.WeaponItem;

public abstract class Entity implements Attackable {
  private final int MAX_HP;
  private int currentHP;
  public Entity(int maximumHP) {
    this.MAX_HP = maximumHP;
    this.currentHP = maximumHP;
  }

  public int getCurrentHP() {
    return currentHP;
  }
  public int getMaxHP() {
    return MAX_HP;
  }
  public void resetHP() {currentHP = getMaxHP();}

  @Override
  public void heal(HealthItem health) {
    int newHealth = this.currentHP + health.getRestoreHP();
    if (newHealth > MAX_HP) {
      this.currentHP = MAX_HP;
      return;
    }
    this.currentHP = newHealth;
  }

  @Override
  public boolean isDead() {
    return this.currentHP <= 0;
  }

  @Override
  public boolean damage(WeaponItem weapon) {
    int newHealth = this.currentHP - weapon.randomDamage();
    if (newHealth < 0) {
      this.currentHP = 0;
      return true;
    }
    this.currentHP = newHealth;
    return false;
  }

  @Override
  public boolean damage(int damage) {
    int newHealth = this.currentHP - damage;
    if (newHealth < 0) {
      this.currentHP = 0;
      return true;
    }
    this.currentHP = newHealth;
    return false;
  }
}
