package Dungeon.Game.Entities;

import Dungeon.Game.Items.HealthItem;
import Dungeon.Game.Items.WeaponItem;

/**
 * The Entity class is a superclass of the Player and Enemy classes, and it is the class that contains
 * all the methods that both the player and the enemy have in common.
 */
public abstract class Entity implements Attackable {
  private final int MAX_HP;
  private int currentHP;

  /**
   * The constructor for the Entity class.
   * 
   * @param maximumHP The maximum HP of the entity.
   */
  public Entity(int maximumHP) {
    this.MAX_HP = maximumHP;
    this.currentHP = maximumHP;
  }

  /**
   * The getCurrentHP() method returns the current HP of the entity.
   * 
   * @return The current HP of the entity.
   */
  public int getCurrentHP() {
    return currentHP;
  }

  /**
   * The getMaxHP() method returns the maximum HP of the entity.
   * 
   * @return The maximum HP of the entity.
   */
  public int getMaxHP() {
    return MAX_HP;
  }

  /**
   * The resetHP() method resets the HP of the entity to the maximum HP.
   */
  public void resetHP() {
    currentHP = getMaxHP();
  }

  /**
   * The heal() method heals the entity.
   * 
   * @param health The health item to heal the entity with.
   */
  @Override
  public void heal(HealthItem health) {
    int newHealth = this.currentHP + health.getRestoreHP();
    if (newHealth > MAX_HP) {
      this.currentHP = MAX_HP;
      return;
    }
    this.currentHP = newHealth;
  }

  /**
   * The isDead() method returns whether the entity is dead or not.
   * 
   * @return Whether the entity is dead or not.
   */
  @Override
  public boolean isDead() {
    return this.currentHP <= 0;
  }

  /**
   * The damage() method damages the entity.
   * 
   * @param weapon The weapon to damage the entity with.
   * @return Whether the entity is dead or not.
   */
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

  /**
   * The damage() method damages the entity.
   * 
   * @param damage The amount of damage to deal to the entity.
   * @return Whether the entity is dead or not.
   */
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
