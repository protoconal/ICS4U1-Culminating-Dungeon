package Dungeon.Game.Items;

/**
 * This ItemInventory class collates all items into one utility class.
 *
 * @author Tony Guo, Emily Ta, Chris Yang, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public class ItemInventory {
  private final static WeaponDefinitions WEAPON_DEFINITIONS = new WeaponDefinitions();
  private final static HealthDefinitions HEALTH_DEFINITIONS = new HealthDefinitions();
  private final static ArmourDefinitions ARMOUR_DEFINITIONS = new ArmourDefinitions();

  /**
   * @return this class's child WeaponDefinitions object.
   */
  public static WeaponDefinitions getWeaponDefinitions() {
    return WEAPON_DEFINITIONS;
  }

  /**
   * @return this class's child HealthDefinitions object.
   */
  public static HealthDefinitions getHealthDefinitions() {
    return HEALTH_DEFINITIONS;
  }

  /**
   * @return this class's child HealthDefinitions object.
   */
  public static ArmourDefinitions getArmourDefinitions() {
    return ARMOUR_DEFINITIONS;
  }

  /**
   * @param itemId accepts any itemId from any definition
   * @return any matched item.
   */
  public static Item returnItemFromId(String itemId) {
    Item getItem = WEAPON_DEFINITIONS.returnItemFromId(itemId);
    if (getItem == null) {
      getItem = HEALTH_DEFINITIONS.returnItemFromId(itemId);
    }
    if (getItem == null) {
      getItem = ARMOUR_DEFINITIONS.returnItemFromId(itemId);
    }
    return getItem;
  }

}
