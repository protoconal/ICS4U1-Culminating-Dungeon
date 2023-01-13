package Dungeon.Game.Items;

import java.util.HashMap;

public class Inventory {
    // possible items
    private final HashMap<String, Item> ITEM_INVENTORY = new HashMap<>();

    // use a map
    private final HashMap<String, Integer> playerInventory = new HashMap<>();

    private String[] itemPriceIds;
    private double[] itemPrices;

  

    public HashMap<String, Integer> getPlayerInventory() {
        // probably redundant
        return playerInventory;
    }

    public void initializeItemInventory() {
        // add items to the inventory, so later on we can use
        // getItemCount("name")
        // this.ITEM_INVENTORY.put("ItemID", new Item());
    }

    public Item returnItemFromName(String itemName) {
        return ITEM_INVENTORY.getOrDefault(itemName, null);
    }

    public void addItemCount(String itemName) {
        this.playerInventory.put(itemName, getItemCount(itemName) + 1);
    }

    public int getItemCount(String itemName) {
        // get the count or return 0 if it doesnt exist.
        return playerInventory.getOrDefault(itemName, 0);
    }

    public String[] getItemIds() {
      return (String[]) this.ITEM_INVENTORY.keySet().toArray();
    }

    // For sorting items based on price
    // selecton sort implemented under Util class
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
      // two arrays, one containing the itemStrings and the other the prices, while sorting, update both arrays according to indexi

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

  
    
  

  

}

// inventoryArray = new Item[20];