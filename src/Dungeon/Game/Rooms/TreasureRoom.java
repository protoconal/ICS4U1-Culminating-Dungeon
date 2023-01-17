package Dungeon.Game.Rooms;

import Dungeon.Game.Items.LootDefinitions;
import Dungeon.Game.Items.LootItem;
import Dungeon.Game.Views;

public class TreasureRoom extends Room {
    private static final int TILE_ID = 2;

    private final LootItem LOOT;

    public TreasureRoom(LootItem item) {
        super();
        LOOT = item;
    }

    public TreasureRoom() {
        super();
        LOOT = new LootDefinitions().generateLoot();
    }

    public boolean interactRoom(Player player) {
        String[] consoleText = new String[]{
                "You've found one: " + LOOT.getName(),
                LOOT.getValue() + "has been added to your score!",
                "Total Gold: " + player.getScore(),
        };

        Views.printLines(consoleText);
        player.addScore(LOOT.getValue());
        return false;
    }

    public LootItem getLoot() {
        return LOOT;
    }

    @Override
    public String toString() {
        return "!!!!!";
    }

}
