package Dungeon.Game.Entities;

import Dungeon.Game.Items.ArmourItem;
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
  private int maxHP;
  private int damageEndured;
  private ArmourItem armour;

  /**
   * Constructor for the Entity class.
   *
   * @param maximumHP stores the maximum HP of the entity.
   */
  public Entity(int maximumHP) {
    this.maxHP = maximumHP;
    this.damageEndured = 0;
  }

  public void setArmour(ArmourItem armour) {
    this.armour = armour;
  }

  /**
   * @return the current HP of the entity.
   */
  public int getCurrentHP() {
    int currentHp = getMaxHP() - damageEndured;
    if (currentHp <= 0) {
      return 0;
    }
    return currentHp;
  }

  /**
   * @return the maximum HP of the entity.
   */
  public int getMaxHP() {
    if (armour != null) {
      return this.maxHP + armour.getHpIncrease();
    }
    return this.maxHP;
  }

  /**
   * Resets the HP of the entity to the maximum HP.
   */
  public void resetHP() {
    damageEndured = 0;
  }

  /**
   * Heals the entity with a provided item.
   *
   * @param health stores the health item to heal the entity with.
   */
  @Override
  public void heal(HealthItem health) {
    int newDamageEndured = this.damageEndured - health.getRestoreHP();
    if (newDamageEndured < 0) {
      this.damageEndured = 0;
      return;
    }
    this.damageEndured = newDamageEndured;
  }

  /**
   * @return whether the entity is dead.
   */
  @Override
  public boolean isDead() {
    return this.getCurrentHP() <= 0;
  }

  /**
   * Damages the entity with a provided item.
   *
   * @param weapon stores the weapon to damage the entity with.
   * @return whether the entity is dead.
   */
  @Override
  public boolean damage(WeaponItem weapon) {
    int newDamageEndured = this.damageEndured + weapon.randomDamage();
    if (this.damageEndured > getMaxHP()) {
      return true;
    }
    this.damageEndured = newDamageEndured;
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
    int newDamageEndured = this.damageEndured + damage;
    if (this.damageEndured > getMaxHP()) {
      return true;
    }
    this.damageEndured = newDamageEndured;
    return false;
  }


}
