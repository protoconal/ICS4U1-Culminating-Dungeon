package Dungeon.Game.Items;

/**
 * This LootItem class provides a template for HealthItems in the game. These items increase the health of the player.
 *
 * @author Tony Guo, Chris Yang, Emily Ta, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public abstract class HealthItem extends Item {
  private final int RESTORE_HP;

  /**
   * Constructor for the HealthItem class.
   *
   * @param name        a string that stores the name of the health item.
   * @param description a string that stores the description of the health item.
   * @param price       stores the price of the health item.
   * @param restoreHP   stores the amount of HP the health item restores.
   */
  public HealthItem(String name, String description, int price, int restoreHP) {
    super(name, description, price);
    this.RESTORE_HP = restoreHP;
  }

  /**
   * @return the amount of HP the health item restores.
   */
  public int getRestoreHP() {
    return RESTORE_HP;
  }
}
