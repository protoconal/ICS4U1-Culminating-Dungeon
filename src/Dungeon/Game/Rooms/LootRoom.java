package Dungeon.Game.Rooms;

import Dungeon.Game.Input;
import Dungeon.Game.Items.LootItem;
import Dungeon.Game.Player;
import Dungeon.Game.Views;
// generate java docs for this class please

/**
 * The LootRoom class is a subclass of the Room class, and it is the room that the player can find loot
 * in.
 */
public class LootRoom extends Room {
  private static final int ROOM_ID = 2;

  private final LootItem LOOT;

  /**
   * The constructor for the LootRoom class.
   * 
   * @param item The loot item that the room contains.
   */
  public LootRoom(LootItem item) {
    super(ROOM_ID, true);
    LOOT = item;
  }


  /**
   * The toString() method returns a string representation of the object.
   * 
   * @return The string representation of the object.
   */
  @Override
  public String toString() {
    return "!!!!!";
  }

  /**
   * The interactRoom() method is called when the player interacts with the room.
   * 
   * @param player The player object.
   * @return The boolean value of the interactRoom() method.
   */
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
