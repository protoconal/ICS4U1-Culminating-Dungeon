package Dungeon.Game.Rooms;

import Dungeon.Game.Game;
import Dungeon.Game.Input;
import Dungeon.Game.Player;
import Dungeon.Game.Views;

// generate java docs for this class please

/**
 * The EndRoom class is a subclass of the Room class, and it is the room that the player must reach to
 * win the game.
 */
public class EndRoom extends Room {
  private static final int ROOM_ID = 5;

  /**
   * The constructor for the EndRoom class.
   */
  public EndRoom() {
    super(ROOM_ID, true);
  }

  /**
   * The toString() method returns a string representation of the object.
   * 
   * @return The string representation of the object.
   */
  @Override
  public String toString() {
    return "((O))";
  }

  /**
   * The interactRoom() method is called when the player interacts with the room.
   * 
   * @param player The player object.
   * @return The boolean value of the interactRoom() method.
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
