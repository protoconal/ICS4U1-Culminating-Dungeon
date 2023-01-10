package Dungeon.Game.DungeonMap;

import Dungeon.Game.GameTile;
import Dungeon.Game.StartTile;
import Dungeon.Game.Util;
import Dungeon.Game.WallTile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DungeonV2 {

    // TODO: implement randomized scaling generation
    // i.e, map must have x Tiles of each Type, therefore randomly spit them around.
    final String[] validDirections = {
            "LEFT",
            "RIGHT",
            "UP",
            "DOWN"
    };

    WeightedRandom weightedRandom = new WeightedRandom(MapGenerationSettings.getProbabilities());
    WeightedRandom branchRandom = new WeightedRandom(MapGenerationSettings.getWallChance());

    GameTile[][] map;
    int[] center;
    int[] numberOfTiles = {0, 0, 0};

    public DungeonV2() {
        final int defaultSize = 9;
        // rememeber, convention = row, column
        map = new GameTile[defaultSize][defaultSize];
        center = new int[]{defaultSize / 2, defaultSize / 2};
        numberOfTiles[0] = defaultSize * defaultSize;
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

    public void traverse(int[] initialCoordinates, int depth) {
        // randomly get tile
        ArrayList<String> traversableDirections = new ArrayList<>();
        Random rand = new Random();

        int numberOfWalls = generateNumberOfWalls(depth);
        ArrayList<String> wallable = new ArrayList<String>(Arrays.asList(validDirections));
        for (int x = 0; x < numberOfWalls; x++) {
            String direction = wallable.remove(rand.nextInt(wallable.size()));
            final int[] newCoordinates = calculateCoordinates(initialCoordinates, direction);
            if (checkBounds(newCoordinates) && getMapTile(newCoordinates) == null) {
                setMapTile(new WallTile(), newCoordinates);
            }
        }

        while (!wallable.isEmpty()) {
            String direction = wallable.remove(0);
            final int[] newCoordinates = calculateCoordinates(initialCoordinates, direction);
            if (checkBounds(newCoordinates) && getMapTile(newCoordinates) == null) {
                traversableDirections.add(direction);
                setMapTile(new GameTile(), newCoordinates);
            }
        }

        while (!traversableDirections.isEmpty()) {
            String direction = traversableDirections.remove(0);
            traverse(calculateCoordinates(initialCoordinates, direction), depth++);
        }
    }

    private int generateNumberOfWalls(int depth) {
        if (depth == 0) {
            return 1;
        }
        return branchRandom.generateChoice();
    }

    private GameTile generateRandomTile(int radius) {
        // TODO: implement radius based randomization

        // TODO: implement this better, make one tile class that can handle this automatically
        return MapGenerationSettings.getTile(weightedRandom.generateChoice());
    }

    private void setMapTile(GameTile gameTile, int[] coordinates) {
        this.numberOfTiles[0] += 1;
        this.numberOfTiles[gameTile.getTileID()] += 1;
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
