package Dungeon.Game;

import Dungeon.Game.Entities.Monster;

public class FightHandler {

  private Monster monster;

  public void onFight(Player player, Monster monster) {
    this.monster = monster;
    printOnAttack();
  }

  public void printOnAttack() {
    System.out.println(this.monster.getAppearText());
    // send over to inventory


    System.out.println(this.monster.getAppearText());
  }

  public void processPlayerTurn(String monsterActionText) {
    String[] consoleText = new String[]{
        monsterActionText,

    };
    Views.printLines(consoleText);
    String optionSelected = Input.getFightKeys();

    // while not attacking
    while (!optionSelected.equals("A")) {
      if (optionSelected.equals("H")) {
        // get health item

        // reduce health item

        // heal player

      }
      if (optionSelected.equals("i")) {
        // showInventory

      }
    }
    // go to monster

    // print attack options
    // A: (ATTACK) using WEAPON, 
    // H: (HEAL) using ITEM_THAT_MAXIMIZES_HEALTH
    // R: (INVENTORY)

  }

  // on fight
  // print attack details
  // choose weapon from inventory
  // attack enemy
  // turn based - thinking
  // 
}
