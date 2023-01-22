package Dungeon.Game.Entities;

import Dungeon.Game.Items.HealthItem;
import Dungeon.Game.Items.WeaponItem;

/**
 * This Attackable interface contains all the methods that an attackable that can be attacked must have.
 *
 * @author Tony Guo, Emily Ta, Chris Yang, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public interface Attackable {

  /**
   * Heals the attackable with a provided item.
   *
   * @param health stores the health item to heal the attackable with.
   */
  void heal(HealthItem health);

  /**
   * @return whether the attackable is dead.
   */
  boolean isDead();

  /**
   * Damages the attackable with a provided item.
   *
   * @param weapon stores the weapon to damage the attackable with.
   * @return whether the attackable is dead.
   */
  boolean damage(WeaponItem weapon);

  /**
   * Damages the attackable with a provided damage amount.
   *
   * @param damage stores the amount of damage to deal to the attackable.
   * @return whether the attackable is dead.
   */
  boolean damage(int damage);
}