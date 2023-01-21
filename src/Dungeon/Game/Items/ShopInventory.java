package Dungeon.Game.Items;

public class ShopInventory {
  // possible items
  public WeaponDefinitions getWeaponDefinitions() {
    return WEAPON_DEFINITIONS;
  }
  public HealthDefinitions getHealthDefinitions() {
    return HEALTH_DEFINITIONS;
  }
  private final WeaponDefinitions WEAPON_DEFINITIONS = new WeaponDefinitions();
  private final HealthDefinitions HEALTH_DEFINITIONS = new HealthDefinitions();

  public String[] getSortedHealthIds() {
    return sortedHealthIds;
  }
  public String[] getSortedWeaponIds() {
    return sortedWeaponIds;
  }

  double weaponSellPriceMultiplier = 0.85;
  double healthSellPriceMultiplier = 0.95;
  public double getWeaponSellMultiplier() {
    // selling more depreciates value
    if (weaponSellPriceMultiplier > 0.4) {
      weaponSellPriceMultiplier *= 0.95;
    }
    return weaponSellPriceMultiplier;
  }
  public double getHealthSellMultiplier() {
    if (healthSellPriceMultiplier > 0.6) {
      healthSellPriceMultiplier *= 0.99;
    }
    return healthSellPriceMultiplier;
  }

  private String[] sortedWeaponIds;

  private String[] sortedHealthIds;

  public ShopInventory() {
    // add items to the inventory, so later on we can use
    // getItemCount("name")
    // this.SHOP_INVENTORY.put("ItemID", new Item());
    sortWeaponsByPrices();
    sortHealthByPrices();
  }



  // For sorting items based on price
  // selection sort implemented under Util class
  // access using Util.selectionSort(Array[]);
  public void sortWeaponsByPrices() {
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

