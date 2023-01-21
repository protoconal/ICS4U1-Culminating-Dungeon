package Dungeon.Game.Items;

/**
 * The WeaponItem class is a subclass of the Item class, and it is the item that the player can use to
 * increase their damage.
 */
public class WeaponItem extends Item {

  private final int MIN_DAMAGE;
  private final int MAX_DAMAGE;

  /**
   * The constructor for the WeaponItem class.
   * 
   * @param name The name of the weapon.
   * @param description The description of the weapon.
   * @param price The price of the weapon.
   * @param minDamage The minimum damage the weapon can do.
   * @param maxDamage The maximum damage the weapon can do.
   */
  public WeaponItem(String name, String description, int price, int minDamage, int maxDamage) {
    super(name, description, price);
    this.MIN_DAMAGE = minDamage;
    this.MAX_DAMAGE = maxDamage;
  }

  /**
   * The getMinDamage() method returns the minimum damage the weapon can do.
   * 
   * @return The minimum damage the weapon can do.
   */
  public int randomDamage() {
    int damageRange = MAX_DAMAGE - MIN_DAMAGE;
    return (int) (MIN_DAMAGE + Math.random() * damageRange);
  }

  /**
   * The getAvgDamage() method returns the average damage the weapon can do.
   * 
   * @return The average damage the weapon can do.
   */
  public int getAvgDamage() {
    return ((MAX_DAMAGE - MIN_DAMAGE) / 2) + MIN_DAMAGE;
  }
}
