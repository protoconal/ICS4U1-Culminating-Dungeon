package Dungeon.Game.DungeonMap;


import Dungeon.Game.Entities.Spawner;
import Dungeon.Game.GameWeightedRandoms;
import Dungeon.Game.Items.LootDefinitions;
import Dungeon.Game.Rooms.*;
import Dungeon.Game.Util;

import java.util.ArrayList;
import java.util.Arrays;

public class Dungeon {

  // TODO: implement randomized scaling generation
  // i.e, map must have x Room of each Type, therefore randomly spit them around.
  private static final String[] VALID_DIRECTIONS = {
      "UP",
      "LEFT",
      "DOWN",
      "RIGHT"
  };
  private static final int[][] DIRECTION_FACTORS = {
      // row, column
      {-1, 0}, // UP
      {0, -1}, // LEFT
      {1, 0}, // DOWN
      {0, 1}, // RIGHT
  };
  final LootDefinitions LOOT_GENERATOR = new LootDefinitions();
  final Spawner SPAWNER = new Spawner();
  private final GameWeightedRandoms WEIGHTED_RANDOM = new GameWeightedRandoms(MapGenerationSettings.getProbabilities());
  private final int[] CENTER;
  private final int DEFAULT_SIZE;
  private Room[][] map;
  private boolean[][] visibleSpaces;
  private int difficultyMultiplier = 0;
  private boolean isReset;
  private int[] randomExit;


  public Dungeon() {
    this.DEFAULT_SIZE = 9;
    // remember, convention = row, column
    CENTER = new int[]{DEFAULT_SIZE / 2, DEFAULT_SIZE / 2};
    nextLevel();
  }

  public static int[] calculateCoordinates(int[] initialCoordinates, String direction) {
    // calculate new coordinates based on input


    int directionIndex = Util.index(VALID_DIRECTIONS, direction);
    if (directionIndex == -1) {
      System.out.println("ERROR: Invalid Direction. Raised by calculateCoordinates().");
      return null;
    }

    int[] directionFactor = DIRECTION_FACTORS[directionIndex].clone();
    for (int x = 0; x < 2; x++) {
      directionFactor[x] += initialCoordinates[x];
    }

    return directionFactor;
  }

  public void nextLevel() {
    map = new Room[DEFAULT_SIZE][DEFAULT_SIZE];
    setMapRoom(new StartRoom(), CENTER);

    visibleSpaces = new boolean[DEFAULT_SIZE][DEFAULT_SIZE];
    visibleSpaces[CENTER[0]][CENTER[1]] = true;
    this.isReset = true;

    this.difficultyMultiplier += 1;
    randomExit = CENTER;

    generateMap();
  }

  public void fullReset() {
    this.difficultyMultiplier = 0;
    nextLevel();
  }

  public int[] getCenter() {
    return CENTER;
  }

  public void setVisibleSpaces(int[] coordinates) {
    // update visited space with the correct tiling
    this.visibleSpaces[coordinates[0]][coordinates[1]] = true;
  }

  public String[] getMovableDirections(int[] playerCoordinates) {
    ArrayList<String> movableDirections = new ArrayList<>();
    for (int x = 0; x < VALID_DIRECTIONS.length; x++) {
      int[] proposedCoordinates = Dungeon.calculateCoordinates(playerCoordinates, VALID_DIRECTIONS[x]);
      if (checkBounds(proposedCoordinates) &&
          !(map[proposedCoordinates[0]][proposedCoordinates[1]] instanceof WalledRoom)) {
        movableDirections.add(VALID_DIRECTIONS[x]);
      }
    }
    return movableDirections.toArray(new String[0]);
  }

  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();

    for (int row = 0; row < this.map.length; row++) {
      out.append(Arrays.toString(this.map[row])).append("\n");
    }

    return out.toString();
  }

  public String visibleSpacesToString(int[] playerCoordinates, String playerModel) {
    StringBuilder out = new StringBuilder();

    for (int row = 0; row < this.map.length; row++) {
      Room[] columns = this.map[row];
      for (int col = 0; col < columns.length; col++) {
        // place player
        if (row == playerCoordinates[0] && col == playerCoordinates[1]) {
          out.append(playerModel);
        } else if (this.visibleSpaces[row][col]) {
          out.append(this.map[row][col]);
        } else {
          out.append("?_?_?");
        }
        if (col != columns.length - 1) {
          out.append(", ");
        }
      }
      out.append("\n");
    }

    return out.toString();
  }

  public void updateVisibility(int[] playerCoordinates) {
    this.isReset = false;

    setVisibleSpaces(playerCoordinates);

    // double check bounds, then paint
    for (int x = 0; x < VALID_DIRECTIONS.length; x++) {
      int[] proposedCoordinates = Dungeon.calculateCoordinates(playerCoordinates, VALID_DIRECTIONS[x]);
      if (checkBounds(proposedCoordinates)) {
        setVisibleSpaces(proposedCoordinates);
      }
    }
  }

  public void generateMap() {
    this.traverse(this.CENTER, 0);
    this.setMapRoom(new EndRoom(), randomExit);

    System.out.println(this);
  }


  private void traverse(int[] initialCoordinates, int radius) {

    // randomly get room
    ArrayList<String> traversableDirections = new ArrayList<>();
    Room randomRoom;

    // check each direction, generate new room if no room exists
    for (int x = 0; x < VALID_DIRECTIONS.length; x++) {
      String direction = VALID_DIRECTIONS[x];
      int[] newCoordinates = calculateCoordinates(initialCoordinates, direction);
      if (newCoordinates != null && // check coordinates are there
          checkBounds(newCoordinates) && // check they are in bounds
          getMapRoom(newCoordinates) == null) { // check if it is empty
        randomRoom = generateRandomRoom(radius);
        // if the room is not a wall

        if (!(randomRoom instanceof WalledRoom)) {
          traversableDirections.add(direction);

          // random chance to be exiting
          if (Math.random() > 0.75) {
            randomExit = newCoordinates;
          }
        }
        setMapRoom(randomRoom, newCoordinates);
      }
    }

    while (!traversableDirections.isEmpty()) {
      String direction = traversableDirections.remove(0);
      traverse(calculateCoordinates(initialCoordinates, direction), radius + 1);
    }
  }

  private Room generateRandomRoom(int radius) {
    // TODO: implement radius based randomization
    if (WEIGHTED_RANDOM.getRadius() != radius) {
      WEIGHTED_RANDOM.setScaleFactors(radius, lookupScaleFactors(radius));
    }
    int choice = WEIGHTED_RANDOM.generateChoice();
    return getRoom(choice);
  }

  public Room getRoom(int roomID) {
    // these definitions correspond to chance table
    if (roomID == 0) {
      return new NormalRoom();
    }
    if (roomID == 1) {
      return new WalledRoom();
    }
    if (roomID == 2) {
      return new LootRoom(LOOT_GENERATOR.generateLoot());
    }
    if (roomID == 3) {
      return new MonsterRoom(SPAWNER, difficultyMultiplier);
    }
    if (roomID == 4) {
      return new TrapRoom();

    }
    if (roomID == 5) {
      return new EndRoom();

    }
    if (roomID == -1) {
      return new StartRoom();
    }
    return null;
  }

  private double[] lookupScaleFactors(int radius) {
    double[][] factors = MapGenerationSettings.getScalingFactors();

    double[] scalingFactor = factors[0];
    int x = 0;
    while ((double) radius > scalingFactor[0] && x < (factors.length - 1)) {
      x += 1;
      scalingFactor = factors[x];
    }

    scalingFactor = Util.copyArrayFromIndexes(scalingFactor, 1, scalingFactor.length);
    return scalingFactor;
  }

  private void setMapRoom(Room room, int[] coordinates) {
    this.map[coordinates[0]][coordinates[1]] = room;
  }

  public Room getMapRoom(int[] coordinates) {
    return this.map[coordinates[0]][coordinates[1]];
  }

  private boolean checkBounds(int[] coordinates) {
    int minBound = 0;
    int maxBound = this.map.length - 1;

    boolean rowBounds = (coordinates[0] >= minBound) && (coordinates[0] <= maxBound);
    boolean columnBounds = (coordinates[1] >= minBound) && (coordinates[1] <= maxBound);

    return rowBounds && columnBounds;
  }

  public int getDifficultyMultiplier() {
    return difficultyMultiplier;
  }

  public boolean isReset() {
    return this.isReset;
  }
}
