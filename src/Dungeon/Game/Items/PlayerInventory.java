package Dungeon.Game.Items;

import Dungeon.Game.Game;

import java.util.TreeMap;

/**
 * This PlayerInventory class represents a player's inventory.
 *
 * @author Tony Guo, Emily Ta, Chris Yang, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public class PlayerInventory {
  private final WeaponDefinitions WEAPON_DEFINITIONS = new WeaponDefinitions();
  private final HealthDefinitions HEALTH_DEFINITIONS = new HealthDefinitions();
  // use a map
  private final TreeMap<String, Integer> HEALTH_PLAYER_INVENTORY = new TreeMap<>();
  private final TreeMap<String, WeaponItem> WEAPON_PLAYER_INVENTORY = new TreeMap<>();
  private WeaponItem equippedWeapon = WEAPON_DEFINITIONS.returnItemFromId("DullSword");

  /**
   * Constructor for PlayerInventory class
   */
  public PlayerInventory() {
    // do nothing
  }

  /**
   * @return this class's child WeaponDefinitions object.
   */
  public WeaponDefinitions getWeaponDefinitions() {
    return WEAPON_DEFINITIONS;
  }

  /**
   * @return this class's child HealthDefinitions object.
   */
  public HealthDefinitions getHealthDefinitions() {
    return HEALTH_DEFINITIONS;
  }

  /**
   * @return the weapon ids currently in the player's inventory.
   */
  public String[] getWeaponsIds() {
    return this.WEAPON_PLAYER_INVENTORY.keySet().toArray(new String[0]);
  }

  /**
   * @return the health ids currently in the player's inventory.
   */
  public String[] getHealthIds() {
    return this.HEALTH_PLAYER_INVENTORY.keySet().toArray(new String[0]);
  }


  /**
   * @return the names of the weapons in the player's inventory.
   */
  public String[] getWeaponNames() {
    String[] weaponNames = getWeaponsIds();
    for (int x = 0; x < weaponNames.length; x++) {
      weaponNames[x] = WEAPON_DEFINITIONS.returnItemFromId(weaponNames[x]).getName();
    }
    return weaponNames;
  }

  /**
   * @return the names of the health items in the player's inventory.
   */
  public String[] getHealthNames() {
    String[] healthNames = getHealthIds();
    for (int x = 0; x < healthNames.length; x++) {
      healthNames[x] = HEALTH_DEFINITIONS.returnItemFromId(healthNames[x]).getName();
    }
    return healthNames;
  }

  /**
   * Returns the current count of an itemId in the player's inventory.
   *
   * @param itemId a string that stores the itemId to check.
   * @return the current count of an item in the player's inventory.
   */
  public int getItemCount(String itemId) {
    // check weapons
    if (WEAPON_PLAYER_INVENTORY.getOrDefault(itemId, null) != null) {
      return 1;
    }
    // must be health item with stackable properties
    return HEALTH_PLAYER_INVENTORY.getOrDefault(itemId, 0);
  }

  /**
   * Adds a weapon to the player's inventory given its Object.
   * <p></p>
   * If the item already exists within the player's inventory, it is automatically sold.
   *
   * @param weapon a WeaponItem to be added to the inventory.
   */
  private void addWeapon(WeaponItem weapon) {
    if (getItemCount(weapon.getId()) == 0) {
      // not found, therefore put into inventory
      this.WEAPON_PLAYER_INVENTORY.put(weapon.getId(), weapon);
    } else {
      // sell weapon automatically
      Game.getPlayer().addScore((int) Math.round(Game.getShopInventory().getWeaponSellMultiplier() * weapon.getPrice()));
    }
  }

  /**
   * Adds a weapon to the player's inventory given its itemId.
   * <p></p>
   * If the item already exists within the player's inventory, it is automatically sold.
   *
   * @param itemId a string representing a WeaponItem to be added to the inventory.
   */
  public void addWeapon(String itemId) {
    addWeapon(WEAPON_DEFINITIONS.returnItemFromId(itemId));
  }

  /**
   * Removes a weapon from the player's inventory given a itemId.
   *
   * @param itemId a string storing the item's id to remove.
   * @return the weapon that was removed
   */
  public WeaponItem removeWeapon(String itemId) {
    if (WEAPON_PLAYER_INVENTORY.size() > 1) {
      return this.WEAPON_PLAYER_INVENTORY.remove(itemId);
    }
    return null;
  }

  /**
   * Adds a health item to the player's inventory given a itemId.
   *
   * @param itemId a string storing the item's id to add.
   */
  public void addHealthItem(String itemId) {
    this.HEALTH_PLAYER_INVENTORY.put(itemId, getItemCount(itemId) + 1);
  }

  /**
   * Removes a health item from the player's inventory.
   *
   * @param itemId a string storing the name of the item to remove.
   * @return the health item that was removed.
   */
  public HealthItem removeHealthItem(String itemId) {
    int count = getItemCount(itemId) - 1;

    // if count smaller or equal to zero
    if (count <= 0) {
      // delete from inventory
      this.HEALTH_PLAYER_INVENTORY.remove(itemId);
    } else {
      // otherwise, update count
      this.HEALTH_PLAYER_INVENTORY.put(itemId, count);
    }
    return HEALTH_DEFINITIONS.returnItemFromId(itemId);
  }

  /**
   * @return the player's equipped weapon.
   */
  public WeaponItem getEquippedWeapon() {
    return equippedWeapon;
  }

  /**
   * Sets the equipped weapon given a itemId.
   *
   * @param itemId a string storing the id of the item wanted to be equipped.
   */
  public void setEquippedWeapon(String itemId) {
    // assumes validated data

    // return weapon, set new weapon
    addWeapon(this.equippedWeapon);
    this.equippedWeapon = removeWeapon(itemId);
  }

  /**
   * @return the total number of items in the player inventory.
   */
  public int size() {
    return HEALTH_PLAYER_INVENTORY.size() + WEAPON_PLAYER_INVENTORY.size();
  }

  /**
   * Debug: Initializes the player's weapons.
   */
  public void DEBUG_initializeWeapons() {
    addWeapon("DullSword");
    addWeapon("IronSword");
    addWeapon("Katana");
  }

  /**
   * Debug: Initializes the player's weapons.
   */
  public void DEBUG_initializeHealth() {
    addHealthItem("Bandage");
    addHealthItem("Bandage");
    addHealthItem("Bandage");
  }

  /**
   * Resets the player's inventory by destroying their Weapons and HealthItems. They are equipped with one DullSword.
   */
  public void reset() {
    HEALTH_PLAYER_INVENTORY.clear();
    WEAPON_PLAYER_INVENTORY.clear();
    equippedWeapon = WEAPON_DEFINITIONS.returnItemFromId("DullSword");
  }


  /**
   * @return the string representation of the player's inventory.
   */
  @Override
  public String toString() {


    StringBuilder out = new StringBuilder();
    out.append("Currently equipped Weapon: ").append(equippedWeapon.getName()).append("\n");

    // build weapon string
    String[] weapons = this.getWeaponsIds();
    out.append("Your weapons... \n");
    // check empty
    if (weapons.length == 0) {
      out.append("  No weapons. \n");
    }
    // join together weapons
    for (int x = 0; x < weapons.length; x++) {
      WeaponItem weapon = WEAPON_PLAYER_INVENTORY.get(weapons[x]);
      out.append("  ")
          .append(weapon.getName())
          .append(" : Avg Damage - ")
          .append(weapon.getAvgDamage());
      if (x != weapons.length - 1) {
        out.append(", ");
      }
      out.append("\n");
    }
    out.append("\n");

    // build weapon string
    String[] health = this.getHealthIds();
    out.append("Your healing items... \n");
    if (health.length == 0) {
      out.append("  No healing items. \n");
    }

    for (int x = 0; x < health.length; x++) {
      // HEALTH ITEM: COUNT, HEALTH ITEM: COUNT, ...
      out.append("  ")
          .append(health[x])
          .append(": ")
          .append(getItemCount(health[x]));
      if (x != health.length - 1) {
        out.append(", ");
      }
      out.append("\n");
    }

    return out.toString();
  }
}