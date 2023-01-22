package Dungeon.Game.Items;

/**
 * This Item class provides a template for all items in the game.
 *
 * @author Tony Guo, Chris Yang, Emily Ta, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public abstract class Item {
  private final String NAME;
  private final String ITEM_ID;
  private final String DESCRIPTION;
  private final int PRICE;

  /**
   * Constructor for the Item class.
   *
   * @param name        a string that stores the name of the health item.
   * @param description a string that stores the description of the health item.
   * @param price       stores the price of the health item.
   */
  public Item(String name, String description, int price) {
    this.NAME = name;
    this.DESCRIPTION = description;
    this.PRICE = price;
    this.ITEM_ID = name.replaceAll("\\s", "");
  }

  /**
   * Constructor for the Item class, ignoring the price.
   *
   * @param name        The name of the item.
   * @param description The description of the item.
   */
  public Item(String name, String description) {
    this.NAME = name;
    this.DESCRIPTION = description;
    this.PRICE = -1;
    this.ITEM_ID = name.replaceAll("\\s", "");
  }

  /**
   * @return the name of the item.
   */
  public String getName() {
    return this.NAME;
  }

  /**
   * @return the description of the item.
   */
  public String getDescription() {
    return this.DESCRIPTION;
  }

  /**
   * @return the price of the item.
   */
  public int getPrice() {
    return this.PRICE;
  }

  /**
   * @return the ID of the item.
   */
  public String getId() {
    return ITEM_ID;
  }
}
