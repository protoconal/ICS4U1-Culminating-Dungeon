package Dungeon.Game.DungeonMap;

import Dungeon.Game.Rooms.Room;
import Dungeon.Game.Rooms.WalledRoom;
import Dungeon.Game.Rooms.StartRoom;
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
    private final Room[][] MAP;
    private final boolean[][] VISIBLE_SPACES;
    private final int[] CENTER;

    public Dungeon() {
        int defaultSize = 9;
        // remember, convention = row, column
        MAP = new Room[defaultSize][defaultSize];
        VISIBLE_SPACES = new boolean[defaultSize][defaultSize];
        CENTER = new int[]{defaultSize / 2, defaultSize / 2};
        setMapTile(new StartRoom(), CENTER);
        VISIBLE_SPACES[CENTER[0]][CENTER[1]] = true;
      
        generateMap();
    }

    public boolean[][] getVisibleSpaces() {
      return this.VISIBLE_SPACES;
    }

    public void setVisibleSpaces(int row, int column) {
      // update visited space with the correct tiling
      this.VISIBLE_SPACES[row][column] = true;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        for (int row = 0; row < this.MAP.length; row++) {
            out.append(Arrays.toString(this.MAP[row])).append("\n");
        }

        return out.toString();
    }

    public String visibleSpacesToString() {
        StringBuilder out = new StringBuilder();

        for (int row = 0; row < this.MAP.length; row++) {
            Room[] columns = this.MAP[row];
            for (int col = 0; col < columns.length; col++) {
                if (this.VISIBLE_SPACES[row][col]) {
                  out.append(this.MAP[row][col]);
                }
                else {
                  out.append("#####");
                }
                out.append(", ");
            }
          out.append("\n");
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
        Room randomTile;

        // check each direction, generate new tile if no tile exists
        for (int x = 0; x < VALID_DIRECTIONS.length; x++) {
            String direction = VALID_DIRECTIONS[x];
            int[] newCoordinates = calculateCoordinates(initialCoordinates, direction);
            if (newCoordinates != null && // check coordinates are there
                    checkBounds(newCoordinates) && // check they are in bounds
                    getMapTile(newCoordinates) == null) { // check if it is empty
                randomTile = generateRandomTile(radius);
                // if the tile is not a wall tile

                if (!(randomTile instanceof WalledRoom)) {
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

    private Room generateRandomTile(int radius) {
        // TODO: implement radius based randomization
        if (WEIGHTED_RANDOM.getRadius() != radius) {
            WEIGHTED_RANDOM.setScaleFactors(radius, lookupScaleFactors(radius));
        }
        int choice = WEIGHTED_RANDOM.generateChoice();
        return Room.getTile(choice);
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

    private void setMapTile(Room room, int[] coordinates) {
        this.MAP[coordinates[0]][coordinates[1]] = room;

        boolean DEBUG = false;
        if (DEBUG) {
            Util.clearTerminal();
            System.out.println(this);
        }
    }

    public Room getMapTile(int[] coordinates) {
        return this.MAP[coordinates[0]][coordinates[1]];
    }

    private int[] calculateCoordinates(int[] initialCoordinates, String direction) {
        // calculate new coordinates based on input
        int[][] directionFactors = {
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
        int minBound = 0;
        int maxBound = this.MAP.length - 1;

        boolean rowBounds = (coordinates[0] >= minBound) && (coordinates[0] <= maxBound);
        boolean columnBounds = (coordinates[1] >= minBound) && (coordinates[1] <= maxBound);

        return rowBounds && columnBounds;
    }
}
