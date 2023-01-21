package Dungeon.Game.Rooms;

import Dungeon.Game.Game;
import Dungeon.Game.Input;
import Dungeon.Game.Player;
import Dungeon.Game.Views;

public class EndRoom extends Room {
  private static final int ROOM_ID = 5;

  public EndRoom() {
    super(ROOM_ID, true);
  }

  @Override
  public String toString() {
    return "((O))";
  }

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
