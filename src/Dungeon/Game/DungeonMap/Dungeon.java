package Dungeon.Game.DungeonMap;

import Dungeon.Game.Tiles.GameTile;
import Dungeon.Game.Tiles.StartTile;
import Dungeon.Game.Util;
import Dungeon.Game.Tiles.WallTile;

import java.util.ArrayList;
import java.util.Arrays;

public class Dungeon {

    // TODO: implement randomized scaling generation
    // i.e, map must have x Tiles of each Type, therefore randomly spit them around.
    final String[] validDirections = {
            "LEFT",
            "RIGHT",
            "UP",
            "DOWN"
    };

    final WeightedRandom weightedRandom = new WeightedRandom(MapGenerationSettings.getProbabilities());

    GameTile[][] map;
    int[] center;

    public Dungeon() {
        final int defaultSize = 9;
        // rememeber, convention = row, column
        map = new GameTile[defaultSize][defaultSize];
        center = new int[]{defaultSize / 2, defaultSize / 2};
        setMapTile(new StartTile(), center);

        generateMap();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        for (int row = 0; row < this.map.length; row++) {
            out.append(Arrays.toString(this.map[row]) + "\n");
        }

        return out.toString();
    }

    public void generateMap() {
        traverse(this.center, 0);

        System.out.println(this);
    }

    public void traverse(int[] initialCoordinates, int radius) {
        //Util.clearTerminal();
        //System.out.println(this + "\n");

        // randomly get tile
        ArrayList<String> traversableDirections = new ArrayList<>();
        GameTile randomTile;

        // check each direction, generate new tile if no tile exists
        for (int x = 0; x < validDirections.length; x++) {
            String direction = validDirections[x];
            final int[] newCoordinates = calculateCoordinates(initialCoordinates, direction);
            if (checkBounds(newCoordinates) && getMapTile(newCoordinates) == null) {
                randomTile = generateRandomTile(radius);
                // if the tile is not a WallTile
                if (!(randomTile instanceof WallTile)) {
                    traversableDirections.add(direction);
                }
                setMapTile(randomTile, newCoordinates);
            }
        }

        while (!traversableDirections.isEmpty()) {
            String direction = traversableDirections.remove(0);
            traverse(calculateCoordinates(initialCoordinates, direction), radius + 1);
        }
    }

    private GameTile generateRandomTile(int radius) {
        // TODO: implement radius based randomization

        // TODO: implement this better, make one tile class that can handle this automatically
        weightedRandom.setScaleFactors(lookupScaleFactors(radius));
        return MapGenerationSettings.getTile(weightedRandom.generateChoice());
    }

    private double[] lookupScaleFactors(int radius) {
        double[][] factors = MapGenerationSettings.getScalingFactors();

        double[] scalingFactor = factors[0];
        int x = 0;
        while (radius > scalingFactor[0]) {
            x++;
            scalingFactor = factors[x];
        }

        double[] truncScalingFactor = Util.copyArrayFromIndexes(scalingFactor, 1, scalingFactor.length);;

        return truncScalingFactor;
    }

    private void setMapTile(GameTile gameTile, int[] coordinates) {
        this.map[coordinates[0]][coordinates[1]] = gameTile;

        //Util.clearTerminal();
        //System.out.println(this);
    }

    public GameTile getMapTile(int[] coordinates) {
        return this.map[coordinates[0]][coordinates[1]];
    }

    private int[] calculateCoordinates(int[] initialCoordinates, String direction) {
        // calculate new coordinates based on input
        final int[][] directionFactors = {
                // row, column
                { 0,-1},
                { 0, 1},
                {-1, 0},
                { 1, 0}
        };

        int directionIndex = Util.index(this.validDirections, direction);
        if (directionIndex == -1) {
            System.out.println("ERROR: Invalid Direction. Raised by calculateCoordinates().");
            return null;
        }

        int[] directionFactor = directionFactors[directionIndex].clone();
        for (int x = 0; x < 2; x++) {
            directionFactor[x] += initialCoordinates[x];
        }

        return directionFactor;
    }

    private boolean checkBounds(int[] coordinates) {
        final int minBound = 0;
        final int maxBound = this.map.length - 1;

        boolean rowBounds = (coordinates[0] >= minBound) && (coordinates[0] <= maxBound);
        boolean columnBounds = (coordinates[1] >= minBound) && (coordinates[1] <= maxBound);

        return rowBounds && columnBounds;
    }
}
