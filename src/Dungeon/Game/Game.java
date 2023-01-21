package Dungeon.Game;

import Dungeon.Game.DungeonMap.Dungeon;
import Dungeon.Game.Items.HealthItem;
import Dungeon.Game.Items.PlayerInventory;
import Dungeon.Game.Items.ShopInventory;
import Dungeon.Game.Items.WeaponItem;
import Dungeon.Game.Rooms.Room;

import java.io.IOException;
import java.util.Arrays;

public class Game {
  private static final String GAME_NAME = "Vaquera: The Emboldened Adventure";
  private static final Player PLAYER = new Player();
  private static final PlayerInventory PLAYER_INVENTORY = PLAYER.getInventory();
  private static final ShopInventory SHOP_INVENTORY = new ShopInventory();
  private static final Dungeon CURRENT_MAP = new Dungeon();
  private static int[] playerCoordinates = CURRENT_MAP.getCenter();
  private static final HighScore SCORES_HANDLER = new HighScore();

  public static ShopInventory getShopInventory() {
    return SHOP_INVENTORY;
  }

  public Game() {
    // do nothing
    Views.printMainMenu();

    // getMenuInputs
    String optionSelected = "";
    while (!optionSelected.equals("B")) {
      System.out.println(Views.getToolTip("MAINMENU"));
      optionSelected = Input.getMenuKeys();
      if (optionSelected.equals("H")) {
        System.out.println("High scores: \n" + SCORES_HANDLER.returnHighScoreText());
      }
      if (optionSelected.equals(";")) {
        exit();
      }
    }

    // getName
    System.out.println("What do you want to your name to be?");
    PLAYER.setName(Input.getText("Input: "));


    PLAYER_INVENTORY.initializeWeapons();
    PLAYER_INVENTORY.initializeHealth();

    // if PLAYER isn't dead, keep playing the dungeon

    while (!PLAYER.isDead()) {
      showDungeon();
    }
  }

  public static Player getPlayer() {
    return PLAYER;
  }

  public static String getName() {
    return GAME_NAME;
  }

  public void showDungeon() {
    if (CURRENT_MAP.isReset()) {
      Game.showStart();
    }

    // update visibility
    CURRENT_MAP.updateVisibility(playerCoordinates);
    Views.printDungeon(CURRENT_MAP, playerCoordinates);
    // getMenuInputs
    String optionSelected = Input.getMove(CURRENT_MAP.getMovableDirections(playerCoordinates));

    if (optionSelected.equals("R")) {
      showInventory();
      return;
    }
    if (optionSelected.equals(";")) {
      exit();
    }

    // update coordinates
    this.playerCoordinates = Dungeon.calculateCoordinates(playerCoordinates, optionSelected);

    // activate Room input
    Room currentRoom = CURRENT_MAP.getMapRoom(playerCoordinates);
    handleRoom(currentRoom);
  }

  public static void showStart() {
    String optionSelected = "";
    while (!optionSelected.equals("R")) {
      Views.printPreDungeon(CURRENT_MAP.getDifficultyMultiplier()); // diffuciltyMultipler == depth

      System.out.println(Views.getToolTip("PREDUNGEON"));
      optionSelected = Input.getPreDungeonKeys();
      if (optionSelected.equals("S")) {
        showShop();
      }
      if (optionSelected.equals(";")) {
        exit();
      }
    }
  }

  private static void showShop() {
    String optionSelected;
    String mode = "Weapon";

    int index = 0;
    boolean flag = true;
    do {
      WeaponItem weaponItem;
      HealthItem healthItem;

      String itemId;
      String itemName;
      int price;

      String[] currentIdSet;

      if (mode.equals("Weapon")) {
        currentIdSet = SHOP_INVENTORY.getSortedWeaponIds();
      }
      else {
        currentIdSet = SHOP_INVENTORY.getSortedHealthIds();
        currentIdSet = Util.copyArrayFromIndexes(currentIdSet, 1, currentIdSet.length);
      }

      String[] outString;

      if (mode.equals("Weapon")) {
        weaponItem = SHOP_INVENTORY.getWeaponDefinitions().returnItemFromName(currentIdSet[index]);
        price = weaponItem.getPrice();
        itemId = weaponItem.getId();
        itemName = weaponItem.getName();
        outString = new String[] {
            "Current Mode: " + mode,
            "     Selected item: " + itemName,
            "    Average Damage: " + weaponItem.getAvgDamage(),
            "       Description: " + weaponItem.getDescription(),
            "             Price: " + price,
            "   Inventory Count: " + PLAYER_INVENTORY.getItemCount(itemId),
        };
      }
      else {
        healthItem = SHOP_INVENTORY.getHealthDefinitions().returnItemFromName(currentIdSet[index]);
        price = healthItem.getPrice();
        itemId = healthItem.getId();
        itemName = healthItem.getName();
        outString = new String[] {
            "Current Mode: " + mode,
            "     Selected item: " + itemName,
            "        HP Restore: " + healthItem.getRestoreHP(),
            "       Description: " + healthItem.getDescription(),
            "             Price: " + price,
            "   Inventory Count: " + PLAYER_INVENTORY.getItemCount(itemId),
        };
      }

      Views.printLn(Arrays.toString(currentIdSet), true);
      System.out.println(String.join("\n", outString));
      System.out.println(Views.getToolTip("SHOP"));
      optionSelected = Input.getShopKeys();

      // could replace with a switch statement
      if (optionSelected.equals("W")) {
        index = 0;
        mode = "Weapon";
      } else if (optionSelected.equals("S")) {
        index = 0;
        mode = "Health";
      } else if (optionSelected.equals("A")) {
        index -= 1;
        if (index < 0) {
          index = currentIdSet.length - 1;
        }
      } else if (optionSelected.equals("D")) {
        index += 1;
        if (index > currentIdSet.length - 1) {
          index = 0;
        }
      } else if (optionSelected.equals("E")) {
        // buy item
        // check if player has cash
        if (PLAYER.getScore() >= price) {
          PLAYER.removeScore(price);
          // allowed to buy item
          if (mode.equals("Weapon")) {
            if (PLAYER_INVENTORY.getItemCount(itemId) == 0) {
              PLAYER_INVENTORY.addWeapon(itemId);
            }
            else {
              System.out.println("Sorry, you already have this item.");
              Input.waitForKeyPress();
            }
          }

          // add health to counters
          if (mode.equals("Health")) {
            PLAYER_INVENTORY.addHealthItem(itemId);
          }
        }
        else {
          System.out.println("Sorry, insufficient funds.");
          Input.waitForKeyPress();
        }

      } else if (optionSelected.equals("Q")) {
        // buy item
        // check if player has cash
        int sellPrice = 0;
        if (PLAYER_INVENTORY.getItemCount(itemId) != 0 && !itemId.equals("DullSword")) {
          // allowed to sell item
          if (mode.equals("Weapon") ) {
            PLAYER_INVENTORY.removeWeapon(itemId);
            sellPrice = (int) Math.round(price * SHOP_INVENTORY.getWeaponSellMultiplier());
          }
          // add health to counters
          if (mode.equals("Health")) {
            PLAYER_INVENTORY.removeHealthItem(itemId);
            sellPrice = (int) Math.round(price * SHOP_INVENTORY.getHealthSellMultiplier());
          }
          PLAYER.addScore(sellPrice);

          System.out.println("Sold " + itemName + " for " + sellPrice + ".");
        }
        else {
          System.out.println("Sorry, unable to sell last item.");
          Input.waitForKeyPress();
        }
      }
      // exit loop as input is any selection
      else {
        flag = false;
      }
    }
    while (flag);
  }

  public void handleRoom(Room currentRoom) {
    // if room is not interactable
    if (!currentRoom.isInteractable()) {
      return;
    }

    boolean hasDied = currentRoom.interactRoom(PLAYER);
    if (hasDied) {
      // send to death code
      showDeathMenu();
    }
  }

  public void showDeathMenu() {
    saveScore();

    Views.printDeathMenu(PLAYER, SCORES_HANDLER);
    System.out.println(Views.getToolTip("DEATHMENU"));
    String optionSelected = Input.getDeathKeys();
    if (optionSelected.equals("R")) {
      // reset
      playerCoordinates = CURRENT_MAP.getCenter();
      CURRENT_MAP.fullReset();
      PLAYER.reset();
    }
    else {
      exit();
    }
  }

  public static void nextLevel() {
    playerCoordinates = CURRENT_MAP.getCenter();
    CURRENT_MAP.fullReset();
  }

  public static void showInventory() {
    String optionSelected;

    String mode = "Weapon";
    String[] weaponsInInventory = PLAYER_INVENTORY.getWeaponNames();
    String[] healingInInventory = PLAYER_INVENTORY.getHealthNames();

    int index = 0;
    boolean flag = true;
    do {
      // use regular print;
      Views.printLn(PLAYER_INVENTORY.toString(), true);

      // if empty, try switching to health
      if (mode.equals("Weapon") && weaponsInInventory.length == 0) {
        mode = "Health";
      }
      // if empty, try switching to weapons
      if (mode.equals("Health") && healingInInventory.length == 0) {
        mode = "Weapon";
      }
      // if empty, give up
      if (PLAYER_INVENTORY.size() == 0) {
        Input.waitForKeyPress();
        return;
      }

      System.out.println("Current Mode: " + mode);

      String[] currentWorkingInventory = weaponsInInventory;
      if (mode.equals("Health")) {
        currentWorkingInventory = healingInInventory;
      }

      System.out.println("Selected item: " + currentWorkingInventory[index]);
      System.out.println();
      System.out.println(Views.getToolTip("INVENTORY"));
      optionSelected = Input.getInventoryKeys();

      // could replace with a switch statement
      if (optionSelected.equals("W")) {
        index = 0;
        mode = "Weapon";
      } else if (optionSelected.equals("S")) {
        index = 0;
        mode = "Health";
      } else if (optionSelected.equals("A")) {
        index -= 1;
        if (index < 0) {
          index = currentWorkingInventory.length - 1;
        }
      } else if (optionSelected.equals("D")) {
        index += 1;
        if (index > currentWorkingInventory.length - 1) {
          index = 0;
        }
      }
      // exit loop as input is not selection
      else {
        flag = false;
      }
    }
    while (flag);

    String itemId = "";
    if (mode.equals("Weapon")) {
      itemId = weaponsInInventory[index].replaceAll("\\s", "");
    }
    if (mode.equals("Health")) {
      itemId = healingInInventory[index].replaceAll("\\s", "");
    }

    if (optionSelected.equals("R")) {
      return;
    }
    if (optionSelected.equals("E")) {
      // Use/Equip
      if (mode.equals("Weapon")) {
        PLAYER_INVENTORY.setEquippedWeapon(itemId);
      }
      if (mode.equals("Health")) {
        // ensure that PLAYER needs more than 50% of heal
        HealthItem item = PLAYER_INVENTORY.getHealthDefinitions().returnItemFromName(itemId);
        if (PLAYER.getCurrentHP() + item.getRestoreHP() * 0.5 < PLAYER.getMaxHP()) {
          item = PLAYER_INVENTORY.removeHealthItem(itemId);
          PLAYER.heal(item);
        }
      }
    }
    if (optionSelected.equals("Q")) {
      // Drop/Delete
      if (mode.equals("Weapon")) {
        PLAYER_INVENTORY.removeWeapon(itemId);
      }
      if (mode.equals("Health")) {
        PLAYER_INVENTORY.removeHealthItem(itemId);
      }
    }
    showInventory();
  }

  public static void exit() {
    saveScore();
    System.exit(0);
  }

  public static void saveScore() {
    if (PLAYER.getScore() != 0) {
      SCORES_HANDLER.updateHighScore(PLAYER.getName(), PLAYER.getScore());
      try {
        SCORES_HANDLER.writeHighScore();
      } catch (IOException e) {
        System.out.println("Unable to save score, check disk space.");
      }
    }
  }

}