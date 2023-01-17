package Dungeon.Game;

import Dungeon.Game.Items.PlayerInventory;

public class Player {
    PlayerInventory inventory = new PlayerInventory();

    private int score = 0;

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }


}
