package Dungeon.Game.Entities;

import Dungeon.Game.Items.HealthItem;
import Dungeon.Game.Items.WeaponItem;

/**
 * This Entity class is a template for all other entities to follow.
 *
 * @author Tony Guo, Emily Ta, Chris Yang, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public abstract class Entity implements Attackable {
  private final int MAX_HP;
  private int currentHP;

  /**
   * Constructor for the Entity class.
   *
   * @param maximumHP stores the maximum HP of the entity.
   */
  public Entity(int maximumHP) {
    this.MAX_HP = maximumHP;
    this.currentHP = maximumHP;
  }

  /**
   * @return the current HP of the entity.
   */
  public int getCurrentHP() {
    return currentHP;
  }

  /**
   * @return the maximum HP of the entity.
   */
  public int getMaxHP() {
    return MAX_HP;
  }

  /**
   * Resets the HP of the entity to the maximum HP.
   */
  public void resetHP() {
    currentHP = getMaxHP();
  }

  /**
   * Heals the entity with a provided item.
   *
   * @param health stores the health item to heal the entity with.
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
   * @return whether the entity is dead.
   */
  @Override
  public boolean isDead() {
    return this.currentHP <= 0;
  }

  /**
   * Damages the entity with a provided item.
   *
   * @param weapon stores the weapon to damage the entity with.
   * @return whether the entity is dead.
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
   * Damages the entity with a provided damage amount.
   *
   * @param damage stores the amount of damage to deal to the entity.
   * @return whether the attackable is dead.
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
