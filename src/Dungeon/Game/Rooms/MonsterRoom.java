package Dungeon.Game.Rooms;

import Dungeon.Game.Entities.Monster;
import Dungeon.Game.Entities.Spawner;
import Dungeon.Game.Game;
import Dungeon.Game.Input;
import Dungeon.Game.Items.HealthItem;
import Dungeon.Game.Items.PlayerInventory;
import Dungeon.Game.Player;
import Dungeon.Game.Views;

/**
 * The MonsterRoom class represents the room where a player can fight monsters.
 *
 * @author Tony Guo, Emily Ta, Ilelemwanta Nomaren, Chris Yang
 * @version 1.0
 * @since 1.0
 */
public class MonsterRoom extends Room {
  private static final int TILE_ID = 3;
  private final Monster MONSTER;

  /**
   * Constructor for the MonsterRoom class.
   *
   * @param spawner stores a spawner to generate monsters.
   * @param depth   stores the depth of the dungeon.
   */
  public MonsterRoom(Spawner spawner, int depth) {
    super(TILE_ID);
    this.MONSTER = spawner.randomSpawn(depth);
  }

  /**
   * @return the representation of the room on a Dungeon map.
   */
  @Override
  public String toString() {
    return " <M> ";
  }

  /**
   * Handles when the player interacts with the monsters.
   *
   * @param player stores the player to interact with.
   * @return whether the player died in the room.
   */
  @Override
  public boolean interactRoom(Player player) {
    this.setInteractableStatus(false);
    return handleFight(player);
  }

  /**
   * Handles the fight between the player and the monster.
   *
   * @param player stores the player to interact with.
   * @return whether the player died in the fight.
   */
  public boolean handleFight(Player player) {

    Views.printLn(MONSTER.getAppearText(), true);
    Input.waitForKeyPress();

    // send over to inventory
    Game.showInventory();

    int damageTaken = MONSTER.generateDamage();
    player.damage(damageTaken);
    while (!player.isDead() && !MONSTER.isDead()) {

      PlayerInventory currentInventory = player.getInventory();
      String[] healthItems = currentInventory.getHealthIds();
      String currentAvailableHealthItem;

      // if no item exists, allow them to wait
      if (currentInventory.getHealthIds().length == 0) {
        currentAvailableHealthItem = "Wait";
      } else {
        currentAvailableHealthItem = healthItems[0];
      }

      HealthItem currentHealthItem = currentInventory.getHealthDefinitions().returnItemFromId(currentAvailableHealthItem);
      String useHealth = currentAvailableHealthItem + ": Restores " + currentHealthItem.getRestoreHP();

      String optionSelected;
      // while not attacking
      boolean flag = true;
      while (flag) {
        String[] outString = new String[]{
            MONSTER.getName() + " " + MONSTER.getAttackText(),
            "  HP: " + MONSTER.getCurrentHP(),
            "They dealt " + damageTaken + " damage!",
            "",
            "A: Attack using " + currentInventory.getEquippedWeapon(),
            "H: Heal using " + useHealth,
            "R: Inventory"
        };

        Views.printLines(outString);
        optionSelected = Input.getFightKeys();

        if (optionSelected.equals("H")) {
          HealthItem healingItem;
          if (currentAvailableHealthItem.equals("Wait")) {
            // just sub in the empty heal
            healingItem = currentHealthItem;
          } else {
            // use the proper inventory remove health item
            healingItem = currentInventory.removeHealthItem(currentAvailableHealthItem);
          }
          player.heal(healingItem);

          Views.printLn("You healed " + healingItem.getRestoreHP() + " HP!", true);
          System.out.println("    " + player.getName() + " HP: " + player.getCurrentHP());
          Input.waitForKeyPress();

          flag = false;
        }
        if (optionSelected.equals("A")) {
          int playerDamage = player.getInventory().getEquippedWeapon().randomDamage();
          MONSTER.damage(playerDamage);
          Views.printLn("You took " + playerDamage + " HP away!", true);
          System.out.println("    " + MONSTER.getName() + " HP: " + MONSTER.getCurrentHP());
          Input.waitForKeyPress();

          flag = false;
        }
        if (optionSelected.equals("R")) {
          // showInventory
          Game.showInventory();
        }
      }

      damageTaken = MONSTER.generateDamage();
      player.damage(damageTaken);
    }


    if (player.isDead()) {
      player.setDeathReason(MONSTER.getName());
    }

    if (MONSTER.isDead()) {
      player.addScore((int) Math.round(MONSTER.getMaxHP() * 0.1));
      // add ten percent to score
    }

    return player.isDead();
  }
}