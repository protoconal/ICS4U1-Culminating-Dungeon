package Dungeon.Game.Items;

import java.util.HashMap;

public abstract class ItemInventory {
  // possible items
  private final HashMap<String, Item> ITEM_INVENTORY = new HashMap<>();
  private String[] itemPriceIds;
  private double[] itemPrices;

  public abstract void initializeItemInventory();
  // add items to the inventory, so later on we can use
  // getItemCount("name")
  // this.ITEM_INVENTORY.put("ItemID", new Item());

  public Item returnItemFromName(String itemName) {
    return ITEM_INVENTORY.getOrDefault(itemName, null);
  }

  public String[] getItemIds() {
    return this.ITEM_INVENTORY.keySet().toArray(new String[0]);
  }

  // For sorting items based on price
  // selection sort implemented under Util class
  // access using Util.selectionSort(Array[]);
  public void calculateSortedPrices() {
    // get all the items
    String[] itemIds = this.getItemIds();
    // access their prices
    double[] itemPrices = new double[itemIds.length];
    for (int x = 0; x < itemIds.length; x++) {
      Item item = returnItemFromName(itemIds[x]);
      itemPrices[x] = item.getPrice();
    }
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
    this.itemPriceIds = itemIds;
    this.itemPrices = itemPrices;
  }

  public String[] getItemPriceIds() {
    return itemPriceIds;
  }

  public double[] getItemPrices() {
    return itemPrices;
  }
}

