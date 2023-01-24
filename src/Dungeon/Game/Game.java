package Dungeon.Game;

import Dungeon.Game.DungeonMap.Dungeon;
import Dungeon.Game.Items.*;
import Dungeon.Game.Rooms.Room;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Vaquera: The Emboldened Adventure.
 * This project was a project.
 * Thank you for playing and marking this.
 *
 * @author Tony Guo, Emily Ta, Chris Yang, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public class Game {
  private static final String GAME_NAME = "Vaquera: The Emboldened Adventure";
  private static final Player PLAYER = new Player();
  private static final PlayerInventory PLAYER_INVENTORY = PLAYER.getInventory();
  private static final ShopInventory SHOP_INVENTORY = new ShopInventory();
  private static final Dungeon CURRENT_MAP = new Dungeon(9);
  private static final HighScore SCORES_HANDLER = new HighScore();
  private static int[] playerCoordinates = CURRENT_MAP.getCenter();

  /**
   * Constructor for the Game class.
   */
  public Game() {
    // do nothing
    Views.printMainMenu();

    // getMenuInputs
    String optionSelected = "";
    while (!optionSelected.equals("B")) {
      System.out.println(Views.getToolTip("MAINMENU"));
      optionSelected = Input.getMenuKeys();

      if (optionSelected.equals("H")) {
        System.out.println("\nHigh scores: \n" + SCORES_HANDLER.returnHighScoreText());
      }
      if (optionSelected.equals(";")) {
        exit();
      }
    }

    System.out.println();
    // getName
    System.out.println("What do you want to your name to be?");
    PLAYER.setName(Input.getText("Input: "));

    // if PLAYER isn't dead, keep playing the dungeon
    while (!PLAYER.isDead()) {
      showDungeon();
    }
  }

  /**
   * @return the shop inventory.
   */
  public static ShopInventory getShopInventory() {
    return SHOP_INVENTORY;
  }

  /**
   * @return the player object.
   */
  public static Player getPlayer() {
    return PLAYER;
  }

  /**
   * @return the name of the game.
   */
  public static String getName() {
    return GAME_NAME;
  }

  /**
   * Show the start menu.
   * <p></p>
   * Give the user the information about dungeon depth.
   * Ask if they want to access the shop.
   * Allow them to exit or continue.
   */
  public static void showPreDungeon() {
    // provide a little free health
    PLAYER.heal((HealthItem) ItemInventory.returnItemFromId("Bandage"));

    String optionSelected = "";
    while (!optionSelected.equals("R")) {
      Views.printPreDungeon(CURRENT_MAP.getDepth()); // difficultyMultiplier == depth

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

  /**
   * Show the shop menu.
   * <p></p>
   * Allow the player to buy and sell items.
   */
  private static void showShop() {
    String optionSelected;
    String mode = "Weapon";

    int index = 0;
    boolean flag = true;
    do {
      String itemId;

      String[] currentIdSet = SHOP_INVENTORY.getSortedWeaponIds();
      if (mode.equals("Armour")) {
        currentIdSet = SHOP_INVENTORY.getSortedArmourIds();
      }
      if (mode.equals("Health")) {
        currentIdSet = SHOP_INVENTORY.getSortedHealthIds();
        currentIdSet = Util.copyArrayFromIndexes(currentIdSet, 1, currentIdSet.length);
      }

      // set itemId
      itemId = currentIdSet[index];
      Item currentItem = ItemInventory.returnItemFromId(itemId);
      int price = currentItem.getPrice();

      ArrayList<String> outString = new ArrayList<>();
      outString.add("Items for sale: ");
      for (int x = 0; x < currentIdSet.length; x++) {
        outString.add("    " + ItemInventory.returnItemFromId(currentIdSet[x]).getName());
      }
      outString.add("Current Mode: " + mode);
      outString.add("     Selected item: " + currentItem.getName());
      outString.add("       Description: " + currentItem.getDescription());
      outString.add("             Price: " + currentItem.getPrice());
      if (currentItem instanceof WeaponItem) {
        outString.add("    Average Damage: " + ((WeaponItem) currentItem).getAvgDamage());
      }
      if (currentItem instanceof HealthItem) {
        outString.add("        HP Restore: " + ((HealthItem) currentItem).getRestoreHP());
      }
      if (currentItem instanceof ArmourItem) {
        outString.add("       HP Increase: " + ((ArmourItem) currentItem).getHpIncrease());
      }
      outString.add("   Inventory Count: " + PLAYER_INVENTORY.getItemCount(itemId));


      Views.printLines(outString);
      System.out.println(Views.getToolTip("SHOP"));
      optionSelected = Input.getShopKeys();

      // could replace with a switch statement
      if (optionSelected.equals("W")) {
        index = 0;
        mode = "Weapon";
      } else if (optionSelected.equals("S")) {
        index = 0;
        mode = "Health";
      } else if (optionSelected.equals("T")) {
        index = 0;
        mode = "Armour";
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
            } else {
              System.out.println("Sorry, you already have this item.");
              Input.waitForKeyPress();
            }
          }

          // add health to counters
          if (mode.equals("Health")) {
            PLAYER_INVENTORY.addHealthItem(itemId);
          }

          // set equipped armour
          if (mode.equals("Armour")) {
            ArmourItem equippedArmour = PLAYER_INVENTORY.getEquippedArmour();
            PLAYER_INVENTORY.setArmour((ArmourItem) currentItem);
            PLAYER.setArmour((ArmourItem) currentItem);
            System.out.println("Bought and equipped: " + currentItem.getName());
            System.out.println("Sold: " + equippedArmour.getName() + " for " + equippedArmour.getPrice());
            Input.waitForKeyPress();
          }
        } else {
          System.out.println("Sorry, insufficient funds.");
          Input.waitForKeyPress();
        }

      } else if (optionSelected.equals("Q")) {
        // buy item
        // check if player has cash
        int sellPrice = 0;
        // if it exists, isn't a dull sword and isn't an armour item
        if (PLAYER_INVENTORY.getItemCount(itemId) != 0 && !itemId.equals("DullSword") && !(currentItem instanceof ArmourItem)) {
          // allowed to sell item
          if (mode.equals("Weapon")) {
            PLAYER_INVENTORY.removeWeapon(itemId);
            sellPrice = (int) Math.round(price * SHOP_INVENTORY.getWeaponSellMultiplier());
            SHOP_INVENTORY.updateWeaponSellMultiplier();
          }
          // add health to counters
          if (mode.equals("Health")) {
            PLAYER_INVENTORY.removeHealthItem(itemId);
            sellPrice = (int) Math.round(price * SHOP_INVENTORY.getHealthSellMultiplier());
            SHOP_INVENTORY.updateHealthSellMultiplier();
          }
          PLAYER.addScore(sellPrice);

          System.out.println("Sold " + currentItem.getName() + " for " + sellPrice + ".");
        } else {
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

  /**
   * Prepares the game to enter its next dungeon level
   * <p></p>
   * Specifically, it resets the player's coordinates to the center of the map, and then resets the map.
   */
  public static void nextLevel() {
    playerCoordinates = CURRENT_MAP.getCenter();
    CURRENT_MAP.nextLevel();
  }

  /**
   * Shows the player's inventory
   * <p></p>
   * They can use, equip or drop items.
   */
  public static void showInventory() {
    String optionSelected;
    String mode = "Weapon";

    int index = 0;
    boolean flag = true;
    do {

      String itemId;
      String[] currentIdSet = PLAYER_INVENTORY.getWeaponsIds();

      if (mode.equals("Weapon")) {
        currentIdSet = PLAYER_INVENTORY.getWeaponsIds();
      }
      if (mode.equals("Health")) {
        currentIdSet = PLAYER_INVENTORY.getHealthIds();
      }

      // use regular print;
      Views.printLn(PLAYER_INVENTORY.toString(), true);

      // if empty, give up
      if (PLAYER_INVENTORY.size() == 0) {
        Input.waitForKeyPress();
        return;
      }
      // if empty, try switching to health
      if (mode.equals("Weapon") && currentIdSet.length == 0) {
        mode = "Health";
        currentIdSet = PLAYER_INVENTORY.getHealthIds();
      }
      // if empty, try switching to weapons
      if (mode.equals("Health") && currentIdSet.length == 0) {
        mode = "Weapon";
        currentIdSet = PLAYER_INVENTORY.getWeaponsIds();
      }

      // set itemId
      itemId = currentIdSet[index];
      Item currentItem = ItemInventory.returnItemFromId(itemId);

      System.out.println("Current Mode: " + mode);
      System.out.println("       Selected item: " + currentItem.getName());
      System.out.println("         Description: " + currentItem.getDescription());
      System.out.println("     Inventory Count: " + PLAYER_INVENTORY.getItemCount(itemId));
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
          index = currentIdSet.length - 1;
        }
      } else if (optionSelected.equals("D")) {
        index += 1;
        if (index > currentIdSet.length - 1) {
          index = 0;
        }
      } else if (optionSelected.equals("E")) {
        index = 0;
        // Use/Equip
        if (mode.equals("Weapon")) {
          PLAYER_INVENTORY.setEquippedWeapon(itemId);
        }
        if (mode.equals("Health")) {
          // ensure that PLAYER needs more than 50% of heal
          HealthItem item = ItemInventory.getHealthDefinitions().returnItemFromId(itemId);
          if (PLAYER.getCurrentHP() + item.getRestoreHP() * 0.25 < PLAYER.getMaxHP()) {
            item = PLAYER_INVENTORY.removeHealthItem(itemId);
            PLAYER.heal(item);
            System.out.println("Healed!");
            Input.waitForKeyPress();
          }
          else {
            System.out.println("You already have enough health.");
            Input.waitForKeyPress();
          }
        }
      } else if (optionSelected.equals("Q")) {
        index = 0;
        // Drop/Delete
        if (mode.equals("Weapon")) {
          PLAYER_INVENTORY.removeWeapon(itemId);
        }
        if (mode.equals("Health")) {
          PLAYER_INVENTORY.removeHealthItem(itemId);
          System.out.println("Removed item.");
        }
      }
      // exit loop as input is not selection
      else {
        flag = false;
      }
    }
    while (flag);
  }

  /**
   * Shows the current dungeon.
   * <p></p>
   * The player can interact with it.
   */
  public void showDungeon() {
    if (CURRENT_MAP.isReset()) {
      Game.showPreDungeon();
    }

    // update visibility
    CURRENT_MAP.updateVisibility(playerCoordinates);
    Views.printDungeon(CURRENT_MAP, playerCoordinates);
    // getMenuInputs
    String optionSelected = Input.getMove(CURRENT_MAP.calculateMovableDirections(playerCoordinates));

    if (optionSelected.equals("R")) {
      showInventory();
      return;
    }
    if (optionSelected.equals(";")) {
      exit();
    }

    // update coordinates
    playerCoordinates = Dungeon.calculateCoordinates(playerCoordinates, optionSelected);

    // activate Room input
    Room currentRoom = CURRENT_MAP.getMapRoom(playerCoordinates);
    handleRoom(currentRoom);
  }

  /**
   * Handles the room.
   * <p></p>
   * If there is nothing to handle, quit early.
   * Otherwise, check for death when the real interaction code hooks in.
   *
   * @param currentRoom stores the room that the player is currently in.
   */
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

  /**
   * Show the death menu.
   * <p>
   * Save the score, then ask if they want to play again.
   */
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
    } else {
      exit();
    }
  }

  /**
   * Saves score.
   */
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

  /**
   * Saves score and Quits.
   */
  public static void exit() {
    saveScore();
    System.exit(0);
  }
}