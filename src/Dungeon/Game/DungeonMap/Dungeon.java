package Dungeon.Game.DungeonMap;

import Dungeon.Game.Tiles.GameTile;
import Dungeon.Game.Tiles.WallTile;
import Dungeon.Game.Tiles.StartTile;
import Dungeon.Game.Util;

import java.util.ArrayList;
import java.util.Arrays;

public class Dungeon {

    // TODO: implement randomized scaling generation
    // i.e, MAP must have x Tiles of each Type, therefore randomly spit them around.
    private final String[] VALID_DIRECTIONS = {
            "LEFT",
            "RIGHT",
            "UP",
            "DOWN"
    };
    private final WeightedRandom WEIGHTED_RANDOM = new WeightedRandom(MapGenerationSettings.getProbabilities());
    private final GameTile[][] MAP;
    private final int[] CENTER;

    public Dungeon() {
        final int defaultSize = 9;
        // remember, convention = row, column
        MAP = new GameTile[defaultSize][defaultSize];
        CENTER = new int[]{defaultSize / 2, defaultSize / 2};
        setMapTile(new StartTile(), CENTER);

        generateMap();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        for (int row = 0; row < this.MAP.length; row++) {
            out.append(Arrays.toString(this.MAP[row])).append("\n");
        }

        return out.toString();
    }

    public void generateMap() {
        traverse(this.CENTER, 0);

        System.out.println(this);
    }

    public void traverse(int[] initialCoordinates, int radius) {

        // randomly get tile
        ArrayList<String> traversableDirections = new ArrayList<>();
        GameTile randomTile;

        // check each direction, generate new tile if no tile exists
        for (int x = 0; x < VALID_DIRECTIONS.length; x++) {
            String direction = VALID_DIRECTIONS[x];
            final int[] newCoordinates = calculateCoordinates(initialCoordinates, direction);
            if (newCoordinates != null && // check coordinates are there
                    checkBounds(newCoordinates) && // check they are in bounds
                    getMapTile(newCoordinates) == null) { // check if it is empty
                randomTile = generateRandomTile(radius);
                // if the tile is not a wall tile

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
        if (WEIGHTED_RANDOM.getRadius() != radius) {
            WEIGHTED_RANDOM.setScaleFactors(radius, lookupScaleFactors(radius));
        }
        int choice = WEIGHTED_RANDOM.generateChoice();
        return GameTile.getTile(choice);
    }

    private double[] lookupScaleFactors(int radius) {
        double[][] factors = MapGenerationSettings.getScalingFactors();

        double[] scalingFactor = factors[0];
        int x = 0;
        while ((double) radius > scalingFactor[0] && x < (factors.length - 1)) {
            x += 1;
            scalingFactor = factors[x];
        }

        return Util.copyArrayFromIndexes(scalingFactor, 1, scalingFactor.length);
    }

    private void setMapTile(GameTile gameTile, int[] coordinates) {
        this.MAP[coordinates[0]][coordinates[1]] = gameTile;

        boolean DEBUG = false;
        if (DEBUG) {
            Util.clearTerminal();
            System.out.println(this);
        }
    }

    public GameTile getMapTile(int[] coordinates) {
        return this.MAP[coordinates[0]][coordinates[1]];
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

        int directionIndex = Util.index(this.VALID_DIRECTIONS, direction);
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
        final int maxBound = this.MAP.length - 1;

        boolean rowBounds = (coordinates[0] >= minBound) && (coordinates[0] <= maxBound);
        boolean columnBounds = (coordinates[1] >= minBound) && (coordinates[1] <= maxBound);

        return rowBounds && columnBounds;
    }
}
