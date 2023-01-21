package Dungeon.Game;

import Dungeon.Game.DungeonMap.Dungeon;
import Dungeon.Game.Items.HealthItem;
import Dungeon.Game.Items.PlayerInventory;
import Dungeon.Game.Rooms.Room;

import java.io.IOException;

public class Game {
  private static final String GAME_NAME = "Vaquera: The Emboldened Adventure";
  private static final Player PLAYER = new Player();
  private static final PlayerInventory INVENTORY = PLAYER.getInventory();
  static String phase;
  private final Dungeon CURRENT_MAP = new Dungeon();
  private int[] playerCoordinates = CURRENT_MAP.getCenter();
  private final HighScore SCORES_HANDLER = new HighScore();


  public Game() {
    // do nothing
    Views.printMainMenu();
    phase = "MAINMENU";

    // getMenuInputs
    System.out.println(Views.getToolTip("MAINMENU"));
    String optionSelected = Input.getMenuKeys();
    if (optionSelected.equals(";")) {
      exit();
    }

    // getName
    System.out.println("What do you want to your name to be?");
    PLAYER.setName(Input.getText("Input: "));


    INVENTORY.initializeWeapons();
    INVENTORY.initializeHealth();

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
    // show the preDungeon screen
    showPreDungeon();

    // update visibility
    this.CURRENT_MAP.updateVisibility(playerCoordinates);
    Views.printDungeon(this.CURRENT_MAP, playerCoordinates);
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
    Room currentRoom = this.CURRENT_MAP.getMapRoom(playerCoordinates);
    handleRoom(currentRoom);
  }

  public void showPreDungeon() {
    // show the preDungeon screen
    Views.printDungeon(this.CURRENT_MAP, playerCoordinates);
    // getMenuInputs
    String optionSelected = "";

    while (!optionSelected.equals("R")) {
      optionSelected = Input.getPreDungeonKeys();
      if (optionSelected.equals("S")) {
        showShop();
      }
      if (optionSelected.equals(";")) {
        exit();
      }
    }
  }

  private void showShop() {
    // getMenuInputs
    String optionSelected = "";
    while (!optionSelected.equals("R")) {
      Views.printDungeon(this.CURRENT_MAP, playerCoordinates);

      optionSelected = Input.getShopKeys();
      if (optionSelected.equals("R")) {
        // buy item
        showShop();
      }
      if (optionSelected.equals("Q")) {
        // sell item
        exit();
      }

    }
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
    System.out.println(Views.getToolTip("DEATH"));
    String optionSelected = Input.getDeathKeys();
    if (optionSelected.equals("R")) {
      // reset
      CURRENT_MAP.reset();
      PLAYER.reset();
    }
    else {
      exit();
    }
  }

  public static void showInventory() {
    String optionSelected;

    String mode = "Weapon";
    String[] weaponsInInventory = INVENTORY.getWeaponNames();
    String[] healingInInventory = INVENTORY.getHealthItems();

    int index = 0;
    boolean flag = true;
    do {
      // use regular print;
      Views.printLn(INVENTORY.toString());

      // if empty, try switching to health
      if (mode.equals("Weapon") && weaponsInInventory.length == 0) {
        mode = "Health";
      }
      // if empty, try switching to weapons
      if (mode.equals("Health") && healingInInventory.length == 0) {
        mode = "Weapon";
      }
      // if empty, give up
      if (INVENTORY.size() == 0) {
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
        mode = "Weapons";
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
        INVENTORY.setEquippedWeapon(itemId);
      }
      if (mode.equals("Health")) {
        // ensure that PLAYER needs more than 50% of heal
        HealthItem item = INVENTORY.getHealthDefinitions().returnItemFromName(itemId);
        if (PLAYER.getCurrentHP() + item.getRestoreHP() * 0.5 < PLAYER.getMaxHP()) {
          item = INVENTORY.removeHealthItem(itemId);
          PLAYER.heal(item);
        }
      }
    }
    if (optionSelected.equals("Q")) {
      // Drop/Delete
      if (mode.equals("Weapon")) {
        INVENTORY.removeWeapon(itemId);
      }
      if (mode.equals("Health")) {
        INVENTORY.removeHealthItem(itemId);
      }
    }
    showInventory();
  }

  public void exit() {
    saveScore();
    System.exit(0);
  }

  public void saveScore() {
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