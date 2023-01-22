package Dungeon.Game.Items;

/**
 * The LootItem class is a subclass of the Item class, and it is the item that the player can use to
 * increase their gold.
 */
public class LootItem extends Item {
  private final int VALUE;

  /**
   * The constructor for the LootItem class.
   * 
   * @param name The name of the loot item.
   * @param description The description of the loot item.
   * @param value The value of the loot item.
   */
  public LootItem(String name, String description, int value) {
    super(name, description);
    this.VALUE = value;
  }

  /**
   * The getValue() method returns the value of the loot item.
   * 
   * @return The value of the loot item.
   */
  public int getValue() {
    return VALUE;
  }
}
