package Dungeon.Game.Rooms;

import Dungeon.Game.Items.LootDefinitions;
import Dungeon.Game.Items.LootItem;
import Dungeon.Game.Player;
import Dungeon.Game.Views;

public class TreasureRoom extends Room {
  private static final int TILE_ID = 2;

  private final LootItem LOOT;

  public TreasureRoom(LootItem item) {
    super(TILE_ID, true);
    LOOT = item;
  }

  public TreasureRoom() {
    super();
    LOOT = new LootDefinitions().generateLoot();
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
    return false;
  }

  public LootItem getLoot() {
    return LOOT;
  }


}
