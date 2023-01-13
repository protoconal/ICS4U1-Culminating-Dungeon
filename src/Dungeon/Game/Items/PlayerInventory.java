package Dungeon.Game.Items;

import java.util.HashMap;

public class PlayerInventory {

    // use a map
    private final HashMap<String, Integer> PLAYER_INVENTORY = new HashMap<>();
    private final HashMap<String, Integer> HEALTH_PLAYER_INVENTORY = new HashMap<>();
    private final HashMap<String, Integer> WEAPON_PLAYER_INVENTORY = new HashMap<>();

    public void initializePlayerInventory() {
        // add items to the inventory, so later on we can use
        // getItemCount("name")
        // this.ITEM_INVENTORY.put("ItemID", new Item());
    }

    public String[] getItems() {
        return this.PLAYER_INVENTORY.keySet().toArray(new String[0]);
    }

    public void addItemCount(String itemName) {
        // get current count
        this.PLAYER_INVENTORY.put(itemName, getItemCount(itemName) + 1);
    }

    public int getItemCount(String itemName) {
        // get the count or return 0 if it doesn't exist.
        return PLAYER_INVENTORY.getOrDefault(itemName, 0);
    }

}

// inventoryArray = new Item[20];