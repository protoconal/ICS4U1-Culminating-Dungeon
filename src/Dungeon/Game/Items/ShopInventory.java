package Dungeon.Game.Items;

/**
 * This ShopInventory class represents the game's shop inventory.
 * It contains all the items that the player can buy from the shop.
 *
 * @author Tony Guo, Emily Ta, Chris Yang, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public class ShopInventory {
  private double weaponSellPriceMultiplier = 0.95;
  private double healthSellPriceMultiplier = 0.95;
  private String[] sortedWeaponIds;
  private String[] sortedHealthIds;
  private String[] sortedArmourIds;

  /**
   * Constructor for the ShopInventory class.
   */
  public ShopInventory() {
    sortWeaponsByPrices();
    sortHealthByPrices();
    sortArmourByPrices();
  }

  /**
   * @return the sorted weapon ids.
   */
  public String[] getSortedWeaponIds() {
    return sortedWeaponIds;
  }

  /**
   * @return the sorted health ids.
   */
  public String[] getSortedHealthIds() {
    return sortedHealthIds;
  }

  /**
   * @return the sorted armour ids.
   */
  public String[] getSortedArmourIds() {
    return sortedArmourIds;
  }

  /**
   * @return the weapon sell multiplier.
   */
  public double getWeaponSellMultiplier() {
    return weaponSellPriceMultiplier;
  }

  /**
   * @return the health sell multiplier.
   */
  public double getHealthSellMultiplier() {

    return healthSellPriceMultiplier;
  }

  /**
   * Depreciates the amount a weapon can sell for.
   */
  public void updateWeaponSellMultiplier() {
    // selling more depreciates value
    if (weaponSellPriceMultiplier > 0.4) {
      weaponSellPriceMultiplier *= 0.95;
    }
  }

  /**
   * Depreciates the amount a health item can sell for.
   */
  public void updateHealthSellMultiplier() {
    // selling more depreciates value
    if (healthSellPriceMultiplier > 0.6) {
      healthSellPriceMultiplier *= 0.99;
    }
  }

  /**
   * Sorts the weaponIds by prices.
   */
  public void sortWeaponsByPrices() {
    // For sorting items based on price
    // selection sort implemented under Util class
    // access using Util.selectionSort(Array[]);


    WeaponDefinitions weaponDefinitions = ItemInventory.getWeaponDefinitions();
    String[] itemIds = weaponDefinitions.getWeaponIds();
    // get all the items
    // access their prices
    double[] itemPrices = new double[itemIds.length];
    for (int x = 0; x < itemIds.length; x++) {
      Item item = weaponDefinitions.returnItemFromId(itemIds[x]);
      itemPrices[x] = item.getPrice();
    }

    sortItems(itemIds, itemPrices);
    this.sortedWeaponIds = itemIds;
  }

  /**
   * Sorts the healthIds by prices.
   */
  public void sortHealthByPrices() {
    HealthDefinitions healthDefinitions = ItemInventory.getHealthDefinitions();
    String[] itemIds = healthDefinitions.getHealthIds();
    // get all the items
    // access their prices
    double[] itemPrices = new double[itemIds.length];
    for (int x = 0; x < itemIds.length; x++) {
      Item item = healthDefinitions.returnItemFromId(itemIds[x]);
      itemPrices[x] = item.getPrice();
    }

    sortItems(itemIds, itemPrices);
    this.sortedHealthIds = itemIds;
  }

  public void sortArmourByPrices() {
    // For sorting items based on price
    // selection sort implemented under Util class
    // access using Util.selectionSort(Array[]);


    ArmourDefinitions armourDefinitions = ItemInventory.getArmourDefinitions();
    String[] itemIds = armourDefinitions.getArmourIds();
    // get all the items
    // access their prices
    double[] itemPrices = new double[itemIds.length];
    for (int x = 0; x < itemIds.length; x++) {
      Item item = armourDefinitions.returnItemFromId(itemIds[x]);
      itemPrices[x] = item.getPrice();
    }

    sortItems(itemIds, itemPrices);
    this.sortedArmourIds = itemIds;
  }

  /**
   * Generally selection sorts the items by prices given its inputs.
   *
   * @param itemIds    stores the item ids.
   * @param itemPrices stores the item prices.
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

