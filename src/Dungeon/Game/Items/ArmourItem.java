package Dungeon.Game.Items;

/**
 * The ArmourItem class is a subclass of the Item class, and it is the item that the player can use to
 * increase their HP.
 */
public class ArmourItem extends Item {
  private final int HP_INCREASE;

  /**
   * The constructor for the ArmourItem class.
   * 
   * @param name The name of the armour.
   * @param description The description of the armour.
   * @param price The price of the armour.
   * @param hpIncrease The amount of HP the armour increases.
   */
  public ArmourItem(String name, String description, int price, int hpIncrease) {
    super(name, description, price);
    this.HP_INCREASE = hpIncrease;
  }

  /**
   * The getHpIncrease() method returns the amount of HP the armour increases.
   * 
   * @return The amount of HP the armour increases.
   */
  public int getHpIncrease() {
    return HP_INCREASE;
  }
}
