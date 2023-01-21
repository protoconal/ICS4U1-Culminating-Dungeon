package Dungeon.Game.Items;

/**
 * The HealthItem class is a subclass of the Item class, and it is the item that the player can use to
 * increase their HP.
 */
public class HealthItem extends Item {
  private final int RESTORE_HP;

  /**
   * The constructor for the HealthItem class.
   * 
   * @param name The name of the health item.
   * @param description The description of the health item.
   * @param price The price of the health item.
   * @param restoreHP The amount of HP the health item restores.
   */
  public HealthItem(String name, String description, int price, int restoreHP) {
    super(name, description, price);
    this.RESTORE_HP = restoreHP;
  }

  /**
   * The getRestoreHP() method returns the amount of HP the health item restores.
   * 
   * @return The amount of HP the health item restores.
   */
  public int getRestoreHP() {
    return RESTORE_HP;
  }
}
