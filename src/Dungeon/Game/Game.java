package Dungeon.Game;

import Dungeon.Game.DungeonMap.Dungeon;
import Dungeon.Game.Entities.Monster;
import Dungeon.Game.Items.HealthItem;
import Dungeon.Game.Items.PlayerInventory;
import Dungeon.Game.Rooms.Room;

import java.io.IOException;

public class Game {
  private static final String GAME_NAME = "Vaquera: The Emboldened Adventure";
  private static final Player PLAYER = new Player();
  static String phase;
  private final Dungeon currentMap = new Dungeon();
  private int[] playerCoordinates = currentMap.getCenter();
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

    // update visibility
    this.currentMap.updateVisibility(playerCoordinates);
    Views.printDungeon(this.currentMap, playerCoordinates);
    // getMenuInputs
    String optionSelected = Input.getMove(currentMap.getMovableDirections(playerCoordinates));

    PLAYER.getInventory().initializeWeapons();
    PLAYER.getInventory().initializeHealth();

    if (optionSelected.equals("R")) {
      PLAYER.damage(80);
      showInventory();
      return;
    }
    if (optionSelected.equals(";")) {
      exit();
    }

    // update coordinates
    this.playerCoordinates = Dungeon.calculateCoordinates(playerCoordinates, optionSelected);

    // TODO: handle input

    // activate Room input
    Room currentRoom = this.currentMap.getMapRoom(playerCoordinates);
    handleRoom(currentRoom);

  }

  public void handleRoom(Room currentRoom) {
    // if room is not interactable
    if (!currentRoom.isInteractable()) {
      return;
    }

    boolean hasDied = currentRoom.interactRoom(PLAYER);
    Input.waitForKeyPress();
    if (hasDied) {
      // send to death code
    }
    // otherwise continue
  }



  public static void showInventory() {
    String optionSelected;
    PlayerInventory currentInventory = PLAYER.getInventory();

    String mode = "Weapon";
    String[] weaponsInInventory = currentInventory.getWeaponNames();
    String[] healingInInventory = currentInventory.getHealthItems();

    int index = 0;
    boolean flag = true;
    do {
      // use regular print;
      Views.printLn(currentInventory.toString());

      // if empty, try switching to health
      if (mode.equals("Weapon") && weaponsInInventory.length == 0) {
        mode = "Health";
      }
      // if empty, try switching to weapons
      if (mode.equals("Health") && healingInInventory.length == 0) {
        mode = "Weapon";
      }
      // if empty, give up
      if (currentInventory.size() == 0) {
        Input.waitForKeyPress();
        return;
      }

      System.out.println("Current Mode: " + mode);

      String[] currentWorkingInventory = weaponsInInventory;
      if (mode.equals("Health")) {
        currentWorkingInventory = healingInInventory;
      }

      System.out.println("Selected item: " + currentWorkingInventory[index]);
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
      // Return
      return;
    }
    if (optionSelected.equals("E")) {
      // Use/Equip
      if (mode.equals("Weapon")) {
        currentInventory.setEquippedWeapon(itemId);

      }
      if (mode.equals("Health")) {
        // ensure that PLAYER needs more than 50% of heal
        HealthItem item = currentInventory.getHealthDefinitions().returnItemFromName(itemId);
        if (PLAYER.getCurrentHP() + item.getRestoreHP() * 0.5 < PLAYER.getMaxHP()) {
          item = currentInventory.removeHealthItem(itemId);
          PLAYER.heal(item);
        }
      }
    }
    if (optionSelected.equals("Q")) {
      // Drop/Delete
      if (mode.equals("Weapon")) {
        currentInventory.removeWeapon(itemId);
      }
      if (mode.equals("Health")) {
        currentInventory.removeHealthItem(itemId);
      }
    }
    showInventory();
  }

  public void deathMenu() {
    Views.printDeathMenu(PLAYER);
    System.out.println(Views.getToolTip("DEATH"));
    String optionSelected = Input.getDeathKeys();
    if (optionSelected.equals("R")) {
      // reset
      currentMap.reset();
      PLAYER.reset();
    }
    else {
      exit();
    }
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

  public static boolean handleFight(Monster monster) {
    System.out.println(monster.getAppearText());
    // send over to inventory
    Game.showInventory();

    do {
      int damageTaken = monster.generateDamage();
      PLAYER.damage(damageTaken);

      PlayerInventory currentInventory = PLAYER.getInventory();
      String currentAvailableHealthItem = currentInventory.getHealthItems()[0];

      // if no item exists, allow them to wait
      if (currentAvailableHealthItem != null) {
        currentAvailableHealthItem = "Wait";
      }

      HealthItem currentHealthItem = currentInventory.getHealthDefinitions().returnItemFromName(currentAvailableHealthItem);
      String useHealth = currentAvailableHealthItem + ": Restores " + currentHealthItem.getRestoreHP();

      System.out.println(monster.getAttackText());
      System.out.println("They took: " + damageTaken + " HP!");
      System.out.println("A: Attack using " + PLAYER.getInventory().getEquippedWeapon());
      System.out.println("H: Heal using " + useHealth);
      System.out.println("I: Inventory");
      String optionSelected = Input.getFightKeys();

      // while not attacking
      while (!optionSelected.equals("A")) {
        if (optionSelected.equals("H")) {
          HealthItem healingItem;
          if (currentAvailableHealthItem.equals("Wait")) {
            // just sub in the empty heal
            healingItem = currentHealthItem;
          }
          else {
            // use the proper inventory remove health item
            healingItem = PLAYER.getInventory().removeHealthItem(currentAvailableHealthItem);
          }
          PLAYER.heal(healingItem);
        }
        if (optionSelected.equals("I")) {
          // showInventory
          Game.showInventory();
        }
      }
    }
    while (!PLAYER.isDead() && !monster.isDead());

    return PLAYER.isDead();
  }
}