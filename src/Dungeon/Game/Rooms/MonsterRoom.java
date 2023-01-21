package Dungeon.Game.Rooms;

import Dungeon.Game.Game;
import Dungeon.Game.Input;
import Dungeon.Game.Player;
import Dungeon.Game.Entities.Monster;
import Dungeon.Game.Entities.Spawner;
import Dungeon.Game.Items.HealthItem;
import Dungeon.Game.Items.PlayerInventory;
import Dungeon.Game.Views;

public class MonsterRoom extends Room {
  private static final int TILE_ID = 3;
  private Monster monster = null;

  public MonsterRoom(Spawner spawner, int depth) {
    super(TILE_ID);
    this.monster = spawner.randomSpawn(depth);
  }

  @Override
  public String toString() {
    return " <M> ";
  }

  @Override
  public boolean interactRoom(Player player) {
    this.setInteractableStatus(false);
    return handleFight();
  }

  public boolean handleFight() {
    Player player = Game.getPlayer();

    Views.printLn(monster.getAppearText(), true);
    Input.waitForKeyPress();

    // send over to inventory
    Game.showInventory();

    int damageTaken = monster.generateDamage();
    player.damage(damageTaken);
    while (!player.isDead() && !monster.isDead()) {

      PlayerInventory currentInventory = player.getInventory();
      String[] healthItems = currentInventory.getHealthItems();
      String currentAvailableHealthItem;

      // if no item exists, allow them to wait
      if (currentInventory.getHealthItems().length == 0) {
        currentAvailableHealthItem = "Wait";
      }
      else {
        currentAvailableHealthItem = healthItems[0];
      }

      HealthItem currentHealthItem = currentInventory.getHealthDefinitions().returnItemFromName(currentAvailableHealthItem);
      String useHealth = currentAvailableHealthItem + ": Restores " + currentHealthItem.getRestoreHP();

      String optionSelected = "";
      // while not attacking
      boolean flag = true;
      while (flag) {
        String[] outString = new String[]{
                monster.getName() + " " + monster.getAttackText(),
                "  HP: " + monster.getCurrentHP(),
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
          }
          else {
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
          monster.damage(playerDamage);
          Views.printLn("You took " + playerDamage + " HP away!", true);
          System.out.println("    " + monster.getName() + " HP: " + monster.getCurrentHP());
          Input.waitForKeyPress();

          flag = false;
        }
        if (optionSelected.equals("R")) {
          // showInventory
          Game.showInventory();
        }
      }

      damageTaken = monster.generateDamage();
      player.damage(damageTaken);
    }


    if (player.isDead()) {
      player.setDeathReason(monster.getName());
    }

    if (monster.isDead()) {
      player.addScore((int) Math.round(monster.getMaxHP() * 0.1));
      // add ten percent to score
    }

    return player.isDead();
  }
}