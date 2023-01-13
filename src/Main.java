import Dungeon.Game.Game;
import Dungeon.Game.DungeonMap.Dungeon;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        for (int x = 0; x < 10; x++) {
            new Dungeon();
            try {
                sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        new Game();
    }
}