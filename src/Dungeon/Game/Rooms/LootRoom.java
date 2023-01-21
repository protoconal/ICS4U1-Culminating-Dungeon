package Dungeon.Game.Rooms;

import Dungeon.Game.Input;
import Dungeon.Game.Items.LootItem;
import Dungeon.Game.Player;
import Dungeon.Game.Views;

public class LootRoom extends Room {
  private static final int ROOM_ID = 2;

  private final LootItem LOOT;

  public LootRoom(LootItem item) {
    super(ROOM_ID, true);
    LOOT = item;
  }


  @Override
  public String toString() {
    return "!!!!!";
  }

  public boolean interactRoom(Player player) {
    player.addScore(LOOT.getValue());
    this.setInteractableStatus(false);

    String[] consoleText = new String[]{
        "You've found a " + LOOT.getName(),
        LOOT.getValue() + " has been added to your score!",
        "Total Gold: " + player.getScore(),
    };

    Views.printLines(consoleText);
    Input.waitForKeyPress();
    return false;
  }

}
