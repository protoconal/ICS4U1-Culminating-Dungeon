import Dungeon.Game.DungeonMap.Dungeon;
import Dungeon.Game.Game;

import static java.lang.Thread.sleep;

public class Main {
  public static void main(String[] args) {
    boolean DEBUG = false;
    if (DEBUG) {
      for (int x = 0; x < 10; x++) {
        new Dungeon();
        try {
          sleep(1500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }

    new Game();
  }
}