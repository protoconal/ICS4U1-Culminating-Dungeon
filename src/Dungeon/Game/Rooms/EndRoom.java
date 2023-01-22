package Dungeon.Game.Rooms;

import Dungeon.Game.Game;
import Dungeon.Game.Input;
import Dungeon.Game.Player;
import Dungeon.Game.Views;

/**
 * The EndRoom class represents the portal to exit the Dungeon to deeper depth.
 *
 * @author Tony Guo, Emily Ta, Ilelemwanta Nomaren, Chris Yang
 * @version 1.0
 * @since 1.0
 */
public class EndRoom extends Room {
  private static final int ROOM_ID = 5;

  /**
   * Constructor for the EndRoom class.
   */
  public EndRoom() {
    super(ROOM_ID, true);
  }

  /**
   * @return the representation of the room on a Dungeon map.
   */
  @Override
  public String toString() {
    return "((O))";
  }

  /**
   * Handles when the player interacts with the portal.
   *
   * @param player stores the player to interact with.
   * @return whether the player died in the room.
   */
  public boolean interactRoom(Player player) {
    String[] consoleText = new String[]{
        "This is the portal to the next dungeon.",
        "Are you ready to leave?",
        "(y/N)",
    };

    String optionSelected;
    Views.printLines(consoleText);
    optionSelected = Input.getYN();

    if (optionSelected.equals("Y")) {
      Game.nextLevel();
    }
    return false;
  }

}
