package Dungeon.Game.Items;

/**
 * The Item class is the superclass of all items in the game.
 */
public class Item {
  private final String NAME;
  private final String ITEM_ID;
  private final String DESCRIPTION;
  private final int PRICE;

  /**
   * The constructor for the Item class.
   * 
   * @param name The name of the item.
   * @param description The description of the item.
   * @param price The price of the item.
   */
  public Item(String name, String description, int price) {
    this.NAME = name;
    this.DESCRIPTION = description;
    this.PRICE = price;
    this.ITEM_ID = name.replaceAll("\\s", "");
  }

  /**
   * The constructor for the Item class.
   * 
   * @param name The name of the item.
   * @param description The description of the item.
   */
  public Item(String name, String description) {
    this.NAME = name;
    this.DESCRIPTION = description;
    this.PRICE = -1;
    this.ITEM_ID = name.replaceAll("\\s", "");
  }

  /**
   * The getName() method returns the name of the item.
   * 
   * @return The name of the item.
   */
  public String getName() {
    return this.NAME;
  }

  /**
   * The getDescription() method returns the description of the item.
   * 
   * @return The description of the item.
   */
  public String getDescription() {
    return this.DESCRIPTION;
  }

  /**
   * The getPrice() method returns the price of the item.
   * 
   * @return The price of the item.
   */
  public int getPrice() {
    return this.PRICE;
  }

  /**
   * The getId() method returns the ID of the item.
   * 
   * @return The ID of the item.
   */
  public String getId() {
    return ITEM_ID;
  }
}
