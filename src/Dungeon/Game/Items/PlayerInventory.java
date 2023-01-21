package Dungeon.Game.Items;

import Dungeon.Game.Game;

import java.util.TreeMap;


public class PlayerInventory {
  public WeaponDefinitions getWeaponDefinitions() {
    return WEAPON_DEFINITIONS;
  }
  public HealthDefinitions getHealthDefinitions() {
    return HEALTH_DEFINITIONS;
  }

  private final WeaponDefinitions WEAPON_DEFINITIONS = new WeaponDefinitions();
  private final HealthDefinitions HEALTH_DEFINITIONS = new HealthDefinitions();

  // use a map
  private final TreeMap<String, Integer> HEALTH_PLAYER_INVENTORY = new TreeMap<>();
  private final TreeMap<String, WeaponItem> WEAPON_PLAYER_INVENTORY = new TreeMap<>();

  private WeaponItem equippedWeapon = WEAPON_DEFINITIONS.returnItemFromName("DullSword");

  public void reset() {
    HEALTH_PLAYER_INVENTORY.clear();
    WEAPON_PLAYER_INVENTORY.clear();
    equippedWeapon = WEAPON_DEFINITIONS.returnItemFromName("DullSword");
  }

  public WeaponItem getEquippedWeapon() {
    return equippedWeapon;
  }

  public void setEquippedWeapon(String itemString) {
    // assumes validated data

    // return weapon, set new weapon
    addWeapon(this.equippedWeapon);
    this.equippedWeapon = removeWeapon(itemString);
  }

  private void addWeapon(WeaponItem weapon) {
    if (getItemCount(weapon.getId()) == 0) {
      // not found, therefore put into inventory
      this.WEAPON_PLAYER_INVENTORY.put(weapon.getId(), weapon);
    }
    else {
      // sell weapon automatically
      Game.getPlayer().addScore((int) Math.round(Game.getShopInventory().getWeaponSellMultiplier() * weapon.getPrice()));
    }
  }

  public void addWeapon(String itemName) {
    this.WEAPON_PLAYER_INVENTORY.put(itemName, WEAPON_DEFINITIONS.returnItemFromName(itemName));
  }

  public String[] getWeapons() {
    return this.WEAPON_PLAYER_INVENTORY.keySet().toArray(new String[0]);
  }
  public String[] getHealthItems() {
    return this.HEALTH_PLAYER_INVENTORY.keySet().toArray(new String[0]);
  }

  public void initializeWeapons() {
    addWeapon("DullSword");
    addWeapon("IronSword");
    addWeapon("Katana");
  }

  public void initializeHealth() {
    addHealthItem("Bandage");
    addHealthItem("Bandage");
    addHealthItem("Bandage");
  }


  public String[] getWeaponNames() {
    String[] weaponNames = getWeapons();
    for (int x = 0; x < weaponNames.length; x++) {
      weaponNames[x] = WEAPON_DEFINITIONS.returnItemFromName(weaponNames[x]).getName();
    }
    return weaponNames;
  }

  public String[] getHealthNames() {
    String[] healthNames = getHealthItems();
    for (int x = 0; x < healthNames.length; x++) {
      healthNames[x] = HEALTH_DEFINITIONS.returnItemFromName(healthNames[x]).getName();
    }
    return healthNames;
  }

  public int size() {
    return HEALTH_PLAYER_INVENTORY.size() + WEAPON_PLAYER_INVENTORY.size();
  }


  public WeaponItem removeWeapon(String itemName) {
    if (WEAPON_PLAYER_INVENTORY.size() > 1) {
      return this.WEAPON_PLAYER_INVENTORY.remove(itemName);
    }
    return null;
  }

  public void addHealthItem(String itemName) {
    this.HEALTH_PLAYER_INVENTORY.put(itemName, getItemCount(itemName) + 1);
  }

  public HealthItem removeHealthItem(String itemName) {
    int count = getItemCount(itemName) - 1;

    // if count smaller or equal to zero
    if (count <= 0) {
      // delete from inventory
      this.HEALTH_PLAYER_INVENTORY.remove(itemName);
    }
    else {
      // otherwise, update count
      this.HEALTH_PLAYER_INVENTORY.put(itemName, count);
    }
    return HEALTH_DEFINITIONS.returnItemFromName(itemName);
  }

  public int getItemCount(String itemName) {
    // check weapons
    if (WEAPON_PLAYER_INVENTORY.getOrDefault(itemName, null) != null) {
      return 1;
    }
    // must be health item with stackable properties
    return HEALTH_PLAYER_INVENTORY.getOrDefault(itemName, 0);
  }

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