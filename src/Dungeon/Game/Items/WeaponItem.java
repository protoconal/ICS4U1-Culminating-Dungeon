package Dungeon.Game.Items;

/**
 * This WeaponItem class provides a template for WeaponItems in the game. These items allow the player to attack.
 *
 * @author Tony Guo, Chris Yang, Emily Ta, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public abstract class WeaponItem extends Item {

  private final int MIN_DAMAGE;
  private final int MAX_DAMAGE;

  /**
   * Constructor for the WeaponItem class.
   *
   * @param name        a string that stores the name of the weapon.
   * @param description a string that stores the description of the weapon.
   * @param price       stores the of the weapon.
   * @param minDamage   stores the minimum damage the weapon can do.
   * @param maxDamage   stores the maximum damage the weapon can do.
   */
  public WeaponItem(String name, String description, int price, int minDamage, int maxDamage) {
    super(name, description, price);
    this.MIN_DAMAGE = minDamage;
    this.MAX_DAMAGE = maxDamage;
  }

  /**
   * @return the minimum damage the weapon can do.
   */
  public int randomDamage() {
    int damageRange = MAX_DAMAGE - MIN_DAMAGE;
    return (int) (MIN_DAMAGE + Math.random() * damageRange);
  }

  /**
   * @return the average damage the weapon can do.
   */
  public int getAvgDamage() {
    return ((MAX_DAMAGE - MIN_DAMAGE) / 2) + MIN_DAMAGE;
  }
}
