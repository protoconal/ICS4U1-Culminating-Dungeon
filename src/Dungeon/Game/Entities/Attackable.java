package Dungeon.Game.Entities;

import Dungeon.Game.Items.HealthItem;
import Dungeon.Game.Items.WeaponItem;

/**
 * The Attackable interface is an interface that contains all the methods that an entity that can be
 * attacked must have.
 */
public interface Attackable {
  /**
   * The heal() method heals the entity.
   * 
   * @param health The health item to heal the entity with.
   */
  void heal(HealthItem health);

  /**
   * The isDead() method returns whether the entity is dead or not.
   * 
   * @return Whether the entity is dead or not.
   */
  boolean isDead();

  /**
   * The damage() method damages the entity.
   * 
   * @param weapon The weapon to damage the entity with.
   * @return Whether the entity is dead or not.
   */
  boolean damage(WeaponItem weapon);

  /**
   * The damage() method damages the entity.
   * 
   * @param damage The amount of damage to deal to the entity.
   * @return Whether the entity is dead or not.
   */
  boolean damage(int damage);
}