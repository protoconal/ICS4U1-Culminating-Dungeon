package Dungeon.Game.Map;

import Dungeon.Game.GameTile;

import java.util.ArrayList;

public class Map {
    GameTile[][] map;
    int[] center;

    public Map() {
        final int defaultSize = 10;
        // rememeber, convention = row, column
        map = new GameTile[defaultSize][defaultSize];
        center = new int[]{defaultSize / 2, defaultSize / 2};
    }

    public generateRandomMap() {

    }

    public void traverse(int[] initialCoordinates, String fromDirection) {

        // randomly get tile
        int row = initialCoordinates[0];
        int column = initialCoordinates[1];
        ArrayList<String> traversableDirections = new ArrayList<>();
        GameTile randomTile;

        if (!fromDirection.equals("LEFT")) {
            // left means column minus 1
            randomTile = new GameTile();
            if (randomTile instanceof GameTile) {
                traversableDirections.add("LEFT");
            }
            setMap(randomTile, row, column - 1);
        }
        if (!fromDirection.equals("RIGHT")) {
            // right means column plus 1
            randomTile = new GameTile();
            if (randomTile instanceof GameTile) {
                traversableDirections.add("RIGHT");
            }
            setMap(new GameTile(), row, column + 1);
        }
        if (!fromDirection.equals("UP")) {
            // up means row minus 1
            randomTile = new GameTile();
            if (randomTile instanceof GameTile) {
                traversableDirections.add("UP");
            }
            setMap(new GameTile(), row - 1, column);
        }
        if (!fromDirection.equals("DOWN")) {
            // down means row plus 1
            randomTile = new GameTile();
            if (randomTile instanceof GameTile) {
                traversableDirections.add("DOWN");
            }
            setMap(new GameTile(), row + 1, column);
        }



        // move one block, randomly assign traversable blocks

        // dfs.
    }

    public checkTraversable() {

    }



}
