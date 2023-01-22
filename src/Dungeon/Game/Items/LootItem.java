package Dungeon.Game.Items;

/**
 * This LootItem class provides a template for LootItems in the game. These items increase the score of the player.
 *
 * @author Tony Guo, Chris Yang, Emily Ta, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public abstract class LootItem extends Item {
  private final int value;

  /**
   * Constructor for the LootItem class.
   *
   * @param name        a string that stores the name of the loot item.
   * @param description a string that stores the description of the loot item.
   * @param value       stores the value of the loot item.
   */
  public LootItem(String name, String description, int value) {
    super(name, description);
    this.value = value;
  }

  /**
   * @return the value of the loot item.
   */
  public int getValue() {
    return value;
  }
}
