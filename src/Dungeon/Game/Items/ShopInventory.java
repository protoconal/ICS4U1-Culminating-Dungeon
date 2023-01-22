package Dungeon.Game.Items;

/**
 * The ShopInventory class is a class that contains all the items that the player can buy from the shop.
 */
public class ShopInventory {
  private final WeaponDefinitions WEAPON_DEFINITIONS = new WeaponDefinitions();
  private final HealthDefinitions HEALTH_DEFINITIONS = new HealthDefinitions();
  double weaponSellPriceMultiplier = 0.95;
  double healthSellPriceMultiplier = 0.95;
  private String[] sortedWeaponIds;
  private String[] sortedHealthIds;

  /**
   * The constructor for the ShopInventory class.
   */
  public ShopInventory() {
    // add items to the inventory, so later on we can use
    // getItemCount("name")
    // this.SHOP_INVENTORY.put("ItemID", new Item());
    sortWeaponsByPrices();
    sortHealthByPrices();
  }

  // possible items
  
  /**
   * The getWeaponDefinitions() method returns the WeaponDefinitions object.
   * @return The WeaponDefinitions object.
   */
  public WeaponDefinitions getWeaponDefinitions() {
    return WEAPON_DEFINITIONS;
  }

  /**
   * The getHealthDefinitions() method returns the HealthDefinitions object.
   * @return The HealthDefinitions object.
   */
  public HealthDefinitions getHealthDefinitions() {
    return HEALTH_DEFINITIONS;
  }

  /**
   * The getSortedWeaponIds() method returns the sorted weapon ids.
   * @return The sorted weapon ids.
   */
  public String[] getSortedWeaponIds() {
    return sortedWeaponIds;
  }

  /**
   * The getSortedHealthIds() method returns the sorted health ids.
   * @return The sorted health ids.
   */
  public String[] getSortedHealthIds() {
    return sortedHealthIds;
  }

  /**
   * The getWeaponSellMultiplier() method returns the weapon sell multiplier.
   * @return The weapon sell multiplier.
   */
  public double getWeaponSellMultiplier() {
    // selling more depreciates value
    if (weaponSellPriceMultiplier > 0.4) {
      weaponSellPriceMultiplier *= 0.95;
    }
    return weaponSellPriceMultiplier;
  }

  /**
   * The getHealthSellMultiplier() method returns the health sell multiplier.
   * @return The health sell multiplier.
   */
  public double getHealthSellMultiplier() {
    if (healthSellPriceMultiplier > 0.6) {
      healthSellPriceMultiplier *= 0.99;
    }
    return healthSellPriceMultiplier;
  }
  
  /**
   * The sortWeaponsByPrices() method sorts the weapons by prices.
   * @return The sorted weapons by prices.
   */
  public void sortWeaponsByPrices() {
    // For sorting items based on price
    // selection sort implemented under Util class
    // access using Util.selectionSort(Array[]);


    String[] itemIds = WEAPON_DEFINITIONS.getWeaponIds();
    // get all the items
    // access their prices
    double[] itemPrices = new double[itemIds.length];
    for (int x = 0; x < itemIds.length; x++) {
      Item item = WEAPON_DEFINITIONS.returnItemFromName(itemIds[x]);
      itemPrices[x] = item.getPrice();
    }

    sortItems(itemIds, itemPrices);
    this.sortedWeaponIds = itemIds;
  }

  /**
   * The sortHealthByPrices() method sorts the health by prices.
   * @return The sorted health by prices.
   */
  public void sortHealthByPrices() {
    String[] itemIds = HEALTH_DEFINITIONS.getHealthIds();
    // get all the items
    // access their prices
    double[] itemPrices = new double[itemIds.length];
    for (int x = 0; x < itemIds.length; x++) {
      Item item = HEALTH_DEFINITIONS.returnItemFromName(itemIds[x]);
      itemPrices[x] = item.getPrice();
    }

    sortItems(itemIds, itemPrices);
    this.sortedHealthIds = itemIds;
  }

  /**
   * The sortItems() method sorts the items.
   * @param itemIds The item ids.
   * @param itemPrices The item prices.
   * @return The sorted items.
   */
  private void sortItems(String[] itemIds, double[] itemPrices) {
    // implement some sort that keeps the ordering of the items
    // two arrays, one containing the itemStrings and the other the prices, while sorting, update both arrays according to indexes

    //Selection Sort
    int smallestIndex;
    for (int i = 0; i < itemPrices.length; i++) { //this is reducing the unsorted portion of the array
      smallestIndex = i; //setting smallestIndex to the first element of the UNSORTED portion of the array
      for (int j = i + 1; j < itemPrices.length; j++) {//these are the elements we compared TO
        // smallestIndex to the current element of the array
        if (itemPrices[j] < itemPrices[smallestIndex]) {
          smallestIndex = j;
        }
      }
      // Swap the smallestIndex to the beginning of the unsorted portion of the array
      double tempVarOne = itemPrices[smallestIndex];
      itemPrices[smallestIndex] = itemPrices[i];
      itemPrices[i] = tempVarOne;

      String tempVarTwo = itemIds[smallestIndex];
      itemIds[smallestIndex] = itemIds[i];
      itemIds[i] = tempVarTwo;
    }
  }
}

