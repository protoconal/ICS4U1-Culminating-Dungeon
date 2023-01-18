package Dungeon.Game.Items;

import java.util.HashMap;

public class PlayerInventory {

    // use a map
    private final HashMap<String, Integer> PLAYER_INVENTORY = new HashMap<>();
    private final HashMap<String, Integer> HEALTH_PLAYER_INVENTORY = new HashMap<>();
    private final HashMap<String, Integer> WEAPON_PLAYER_INVENTORY = new HashMap<>();

    public WeaponItem getEquipedItem() {
        return equipedItem;
    }

    public void setEquipedItem(WeaponItem equipedItem) {
        this.equipedItem = equipedItem;
    }

    private WeaponItem equipedItem;

    public void initializePlayerInventory() {
        // add items to the inventory, so later on we can use
        // getItemCount("name")
        // this.ITEM_INVENTORY.put("ItemID", new Item());
    }

    public String[] getItems() {
        return this.PLAYER_INVENTORY.keySet().toArray(new String[0]);
    }

    public String[] getWeapons() {
        return this.WEAPON_PLAYER_INVENTORY.keySet().toArray(new String[0]);
    }
    public String[] getHealthItems() {
        return this.HEALTH_PLAYER_INVENTORY.keySet().toArray(new String[0]);
    }

    public void addItemCount(String itemName) {
        // get current count
        this.PLAYER_INVENTORY.put(itemName, getItemCount(itemName) + 1);
    }

    public int getItemCount(String itemName) {
        // get the count or return 0 if it doesn't exist.
        return PLAYER_INVENTORY.getOrDefault(itemName, 0);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("Currently held weapons... \n");

        String[] weapons = this.getWeapons();
        for (int x = 0; x < weapons.length; x++) {
            out.append(weapons[x]).append(", ");
            if (x % 5 == 0) {
                out.append("\n");
            }
        }

        out.append("Currently held weapons... ");
        String[] health = this.getHealthItems();
        for (int x = 0; x < health.length; x++) {
            out.append(health[x]).append(", ");
            if (x % 5 == 0) {
                out.append("\n");
            }
        }

        return out.toString();
    }

}

// inventoryArray = new Item[20];