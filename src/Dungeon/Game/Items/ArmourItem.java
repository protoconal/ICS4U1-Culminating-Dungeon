package Dungeon.Game.Items;

/**
 * This ArmourItem class represents an item of Armour.
 *
 * @author Ilelemwanta Nomaren, Tony Guo, Chris Yang, Emily Ta
 * @version 1.0
 * @since 1.0
 */
public abstract class ArmourItem extends Item {
  private final int HP_INCREASE;

  /**
   * Constructor for the ArmourItem class.
   *
   * @param name        a string that stores the name of the armour.
   * @param description a string that stores the description of the armour.
   * @param price       stores the price of the armour.
   * @param hpIncrease  stores the amount of HP the armour increases.
   */
  public ArmourItem(String name, String description, int price, int hpIncrease) {
    super(name, description, price);
    this.HP_INCREASE = hpIncrease;
  }

  /**
   * @return the amount of HP the armour increases.
   */
  public int getHpIncrease() {
    return HP_INCREASE;
  }
}
