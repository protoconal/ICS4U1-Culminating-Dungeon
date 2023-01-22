package Dungeon.Game.Items;

import Dungeon.Game.Game;

import java.util.TreeMap;

// please document this whole java file with javadocs

/**
 * The PlayerInventory class is a class that stores the player's inventory.
 */
public class PlayerInventory {
  private final WeaponDefinitions WEAPON_DEFINITIONS = new WeaponDefinitions();
  private final HealthDefinitions HEALTH_DEFINITIONS = new HealthDefinitions();
  // use a map
  private final TreeMap<String, Integer> HEALTH_PLAYER_INVENTORY = new TreeMap<>();
  private final TreeMap<String, WeaponItem> WEAPON_PLAYER_INVENTORY = new TreeMap<>();
  private WeaponItem equippedWeapon = WEAPON_DEFINITIONS.returnItemFromName("DullSword");

  /**
   * The constructor for the PlayerInventory class.
   */

  /**
   * The reset method resets the player's inventory.
   */
  public void reset() {
    HEALTH_PLAYER_INVENTORY.clear();
    WEAPON_PLAYER_INVENTORY.clear();
    equippedWeapon = WEAPON_DEFINITIONS.returnItemFromName("DullSword");
  }

  /**
   * The getWeaponDefinitions method returns the WeaponDefinitions object.
   * 
   * @return The WeaponDefinitions object.
   */
  public WeaponDefinitions getWeaponDefinitions() {
    return WEAPON_DEFINITIONS;
  }

  /**
   * The getHealthDefinitions method returns the HealthDefinitions object.
   * 
   * @return The HealthDefinitions object.
   */
  public HealthDefinitions getHealthDefinitions() {
    return HEALTH_DEFINITIONS;
  }

  /**
   * The getEquippedWeapon method returns the equipped weapon.
   * 
   * @return WeaponItem The equipped weapon.
   */
  public WeaponItem getEquippedWeapon() {
    return equippedWeapon;
  }

  /**
   * The setEquippedWeapon method sets the equipped weapon.
   * 
   * @return WeaponItem The equipped weapon.
   */
  public void setEquippedWeapon(String itemString) {
    // assumes validated data

    // return weapon, set new weapon
    addWeapon(this.equippedWeapon);
    this.equippedWeapon = removeWeapon(itemString);
  }

  /**
   * The addWeapon method adds a weapon to the player's inventory.
   * 
   * @param weapon
   */
  private void addWeapon(WeaponItem weapon) {
    if (getItemCount(weapon.getId()) == 0) {
      // not found, therefore put into inventory
      this.WEAPON_PLAYER_INVENTORY.put(weapon.getId(), weapon);
    } else {
      // sell weapon automatically
      Game.getPlayer()
          .addScore((int) Math.round(Game.getShopInventory().getWeaponSellMultiplier() * weapon.getPrice()));
    }
  }

  /**
   * The addWeapon method adds a weapon to the player's inventory.
   * 
   * @param weapon
   */
  public void addWeapon(String itemName) {
    this.WEAPON_PLAYER_INVENTORY.put(itemName, WEAPON_DEFINITIONS.returnItemFromName(itemName));
  }

  /**
   * The getWeapons method returns the weapons in the player's inventory.
   * 
   * @return String[] The weapons in the player's inventory.
   */
  public String[] getWeapons() {
    return this.WEAPON_PLAYER_INVENTORY.keySet().toArray(new String[0]);
  }

  /**
   * The getHealthItems method returns the health items in the player's inventory.
   * 
   * @return String[] The health items in the player's inventory.
   */
  public String[] getHealthItems() {
    return this.HEALTH_PLAYER_INVENTORY.keySet().toArray(new String[0]);
  }

  /**
   * The initializeWeapons method initializes the player's weapons.
   */
  public void initializeWeapons() {
    addWeapon("DullSword");
    addWeapon("IronSword");
    addWeapon("Katana");
  }

  /**
   * The initializeHealth method initializes the player's weapons.
   */
  public void initializeHealth() {
    addHealthItem("Bandage");
    addHealthItem("Bandage");
    addHealthItem("Bandage");
  }

  /**
   * The getWeaponNames method returns the names of the weapons in the player's
   * inventory.
   * 
   * @return String[] The names of the weapons in the player's inventory.
   */
  public String[] getWeaponNames() {
    String[] weaponNames = getWeapons();
    for (int x = 0; x < weaponNames.length; x++) {
      weaponNames[x] = WEAPON_DEFINITIONS.returnItemFromName(weaponNames[x]).getName();
    }
    return weaponNames;
  }

  /**
   * The getHealthNames method returns the names of the health items in the
   * player's inventory.
   * 
   * @return String[] The names of the health items in the player's inventory.
   */
  public String[] getHealthNames() {
    String[] healthNames = getHealthItems();
    for (int x = 0; x < healthNames.length; x++) {
      healthNames[x] = HEALTH_DEFINITIONS.returnItemFromName(healthNames[x]).getName();
    }
    return healthNames;
  }

  /**
   * The size method returns the total number of items in the player inventory.
   * 
   * @return int the total number of items.
   */
  public int size() {
    return HEALTH_PLAYER_INVENTORY.size() + WEAPON_PLAYER_INVENTORY.size();
  }

  /**
   * The removeWeapon method removes a weapon from the player's inventory.
   * 
   * @param itemName
   * @return
   */
  public WeaponItem removeWeapon(String itemName) {
    if (WEAPON_PLAYER_INVENTORY.size() > 1) {
      return this.WEAPON_PLAYER_INVENTORY.remove(itemName);
    }
    return null;
  }

  /**
   * The addHealthItem method adds a health item to the player's inventory.
   *
   * @param itemName The name of the item to add.
   */
  public void addHealthItem(String itemName) {
    this.HEALTH_PLAYER_INVENTORY.put(itemName, getItemCount(itemName) + 1);
  }

  /**
   * The removeHealthItem method removes a health item from the player's
   * inventory.
   *
   * @param itemName The name of the item to remove.
   * @return The item that was removed.
   */
  public HealthItem removeHealthItem(String itemName) {
    int count = getItemCount(itemName) - 1;

    // if count smaller or equal to zero
    if (count <= 0) {
      // delete from inventory
      this.HEALTH_PLAYER_INVENTORY.remove(itemName);
    } else {
      // otherwise, update count
      this.HEALTH_PLAYER_INVENTORY.put(itemName, count);
    }
    return HEALTH_DEFINITIONS.returnItemFromName(itemName);
  }

  /**
   * The getItemCount method returns the number of items in the player's
   * inventory.
   *
   * @param itemName The name of the item to check.
   * @return The number of items in the player's inventory.
   */
  public int getItemCount(String itemName) {
    // check weapons
    if (WEAPON_PLAYER_INVENTORY.getOrDefault(itemName, null) != null) {
      return 1;
    }
    // must be health item with stackable properties
    return HEALTH_PLAYER_INVENTORY.getOrDefault(itemName, 0);
  }

  /**
   * The toString method for the PlayerInventory class.
   *
   * @return The string representation of the PlayerInventory class.
   */
  @Override
  public String toString() {

    StringBuilder out = new StringBuilder();
    out.append("Currently equipped Weapon: ").append(equippedWeapon.getName()).append("\n");

    // build weapon string
    String[] weapons = this.getWeapons();
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
    String[] health = this.getHealthItems();
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

// inventoryArray = new Item[20];