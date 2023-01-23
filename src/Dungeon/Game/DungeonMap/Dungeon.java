package Dungeon.Game.DungeonMap;

import Dungeon.Game.Entities.Spawner;
import Dungeon.Game.GameWeightedRandoms;
import Dungeon.Game.Items.LootDefinitions;
import Dungeon.Game.Rooms.*;
import Dungeon.Game.Util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This Dungeon class represents a dungeon.
 * <p>
 * It can randomly generate a dungeon according to the specifications in MapGenerationSettings.
 *
 * @author Tony Guo, Emily Ta, Chris Yang, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public class Dungeon {

  /**
   * Stores the supported directions one can move.
   * <p>
   * DIRECTION_FACTORS inherits this ordering.
   *
   * @see #DIRECTION_FACTORS
   */
  private static final String[] VALID_DIRECTIONS = {
      "UP",
      "LEFT",
      "DOWN",
      "RIGHT"
  };
  /**
   * Stores the required transformations to apply to set of coordinates to produce a movement into a given direction.
   * <p>
   * The ordering is defined by VALID_DIRECTIONS.
   *
   * @see #VALID_DIRECTIONS
   */
  private static final int[][] DIRECTION_FACTORS = {
      // row, column
      {-1, 0}, // UP
      {0, -1}, // LEFT
      {1, 0}, // DOWN
      {0, 1}, // RIGHT
  };
  private final LootDefinitions LOOT_GENERATOR = new LootDefinitions();
  private final Spawner MONSTER_SPAWNER = new Spawner();
  private final GameWeightedRandoms WEIGHTED_RANDOM = new GameWeightedRandoms(MapGenerationSettings.getRoomProbabilities());
  private final int[] CENTER_OF_MAP;
  private final int DEFAULT_SIZE;
  private Room[][] map;
  private boolean[][] visibleSpaces;
  private int depth = 0;
  /**
   * Stores whether the dungeon is in a "fresh" state.
   */
  private boolean isReset;
  /**
   * Stores the coordinate to be overwritten with the ExitRoom.
   */
  private int[] randomExit;

  /**
   * Constructor for the Dungeon class.
   */
  public Dungeon(int defaultSize) {
    this.DEFAULT_SIZE = defaultSize;
    // remember, convention = row, column
    CENTER_OF_MAP = new int[]{DEFAULT_SIZE / 2, DEFAULT_SIZE / 2};
    nextLevel();
  }

  /**
   * Calculates the new set of coordinates given a direction and its initial coordinates.
   *
   * @param direction          a string representing the direction to follow.
   * @param initialCoordinates an array to store the initialCoordinates.
   * @return an int[] containing the new set of coordinates
   */
  public static int[] calculateCoordinates(int[] initialCoordinates, String direction) {
    // calculate new coordinates based on input
    int directionIndex = Util.index(VALID_DIRECTIONS, direction);
    if (directionIndex == -1) {
      // something terribly went wrong
      System.out.println("ERROR: Invalid Direction. Raised by calculateCoordinates().");
      return null;
    }

    int[] directionFactor = DIRECTION_FACTORS[directionIndex].clone();
    for (int x = 0; x < 2; x++) {
      directionFactor[x] += initialCoordinates[x];
    }

    return directionFactor;
  }

  /**
   * @return the int[] containing for the center of the map.
   */
  public int[] getCenter() {
    return CENTER_OF_MAP;
  }

  /**
   * Sets the provided coordinate to a visible state.
   *
   * @param coordinates an int array storing the coordinates to be set visible
   */
  public void setVisibleSpaces(int[] coordinates) {
    // update visited space with the correct tiling
    this.visibleSpaces[coordinates[0]][coordinates[1]] = true;
  }

  /**
   * @return the current dungeon depth.
   */
  public int getDepth() {
    return depth;
  }

  /**
   * @return whether the dungeon has reset.
   */
  public boolean isReset() {
    return this.isReset;
  }

  /**
   * Resets the required instance variables for generating a new layout. Generates that layout afterwards.
   */
  public void nextLevel() {
    map = new Room[DEFAULT_SIZE][DEFAULT_SIZE];
    setMapRoom(new StartRoom(), CENTER_OF_MAP);

    visibleSpaces = new boolean[DEFAULT_SIZE][DEFAULT_SIZE];
    // make sure start is visible
    visibleSpaces[CENTER_OF_MAP[0]][CENTER_OF_MAP[1]] = true;

    this.isReset = true;

    this.depth += 1;
    randomExit = CENTER_OF_MAP;

    generateMap();
  }

  /**
   * Resets all instance variables to generate a new dungeon. Generates the map afterwards.
   */
  public void fullReset() {
    this.depth = 0;
    nextLevel();
  }

  /**
   * Calculates the directions that are clear to move forward.
   *
   * @param playerCoordinates an int array that stores the current player position
   * @return a String[] containing directions a player can move
   */
  public String[] calculateMovableDirections(int[] playerCoordinates) {
    ArrayList<String> movableDirections = new ArrayList<>();
    for (int x = 0; x < VALID_DIRECTIONS.length; x++) {
      int[] proposedCoordinates = Dungeon.calculateCoordinates(playerCoordinates, VALID_DIRECTIONS[x]);
      // if within bounds and it isn't a wall
      if (checkBounds(proposedCoordinates) &&
          !(map[proposedCoordinates[0]][proposedCoordinates[1]] instanceof WalledRoom)) {
        movableDirections.add(VALID_DIRECTIONS[x]);
      }
    }
    return movableDirections.toArray(new String[0]);
  }

  /**
   * @return the string representation of the current map.
   */
  @Override
  public String toString() {
    StringBuilder out = new StringBuilder();

    for (int row = 0; row < this.map.length; row++) {
      out.append(Arrays.toString(this.map[row])).append("\n");
    }

    return out.toString();
  }

  /**
   * Returns a string representation of what the player should see.
   * <p>
   * The provided params tell the method which block to replace with the player.
   *
   * @param playerCoordinates an int array that stores the current player position
   * @param playerModel       a string that stores the representation of the player
   * @return the string representation of the visible spaces on the current map.
   */
  public String visibleSpacesToString(int[] playerCoordinates, String playerModel) {
    StringBuilder out = new StringBuilder();

    for (int row = 0; row < this.map.length; row++) {
      Room[] columns = this.map[row];
      for (int col = 0; col < columns.length; col++) {
        if (row == playerCoordinates[0] && col == playerCoordinates[1]) { // place player
          out.append(playerModel);
        } else if (this.visibleSpaces[row][col]) { // check visibility
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

  /**
   * Updates the visibility of the player.
   * <p></p>
   * The directions around the player should become visible.
   *
   * @param playerCoordinates an int array that stores the current player position
   */
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

  /**
   * Generates the map.
   */
  public void generateMap() {
    this.traverse(this.CENTER_OF_MAP, 0);
    this.setMapRoom(new EndRoom(), randomExit);

    System.out.println(this);
  }

  /**
   * A traversal method to update an empty map with random rooms.
   * <p></p>
   * This method uses a DFS-style traversal pattern. This method continues down a direction until the direction becomes blocked by a randomly generated wall. Only when it reaches a dead-end does it return back.
   *
   * @param initialCoordinates stores the position of the node being considered
   * @param radius             stores the distance from the center
   */
  private void traverse(int[] initialCoordinates, int radius) {
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

  /**
   * Generates a random room.
   * <p></p>
   * It consults the generation settings, updating the generator with the correct weights, to generate a variable map.
   *
   * @param radius stores the distance from the center of the room.
   * @return the chosen Room.
   */
  private Room generateRandomRoom(int radius) {
    if (WEIGHTED_RANDOM.getRadius() != radius) {
      WEIGHTED_RANDOM.setScaleFactors(radius, lookupScaleFactors(radius));
    }
    int choice = WEIGHTED_RANDOM.generateChoice();
    return getRoom(choice);
  }

  /**
   * @param roomID stores the numeric representation of the room.
   * @return the Room object based on the provided id.
   */
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
      return new MonsterRoom(MONSTER_SPAWNER, depth);
    }
    if (roomID == 5) {
      return new EndRoom();
    }
    if (roomID == -1) {
      return new StartRoom();
    }
    return null;
  }

  /**
   * Searches through the generation settings for the correct probability scaling factor for the current depth.
   *
   * @param radius stores the radius from the center.
   * @return the correct probability scaling double[] factor for the current depth.
   */
  private double[] lookupScaleFactors(int radius) {
    double[][] factors = MapGenerationSettings.getRoomScalingFactors();

    double[] scalingFactor = factors[0];
    int x = 0;
    while ((double) radius > scalingFactor[0] && x < (factors.length - 1)) {
      x += 1;
      scalingFactor = factors[x];
    }

    scalingFactor = Util.copyArrayFromIndexes(scalingFactor, 1, scalingFactor.length);
    return scalingFactor;
  }

  /**
   * Sets the provided coordinates to the provided room.
   *
   * @param room        the room to update with.
   * @param coordinates the coordinates to update.
   */
  private void setMapRoom(Room room, int[] coordinates) {
    this.map[coordinates[0]][coordinates[1]] = room;
  }

  /**
   * @param coordinates the coordinates to check.
   * @return the room at the provided coordinates (int[]).
   */
  public Room getMapRoom(int[] coordinates) {
    return this.map[coordinates[0]][coordinates[1]];
  }

  /**
   * Checks whether the coordinate is in bounds of the map.
   *
   * @return whether the coordinate is in bounds
   */
  private boolean checkBounds(int[] coordinates) {
    int minBound = 0;
    int maxBound = this.map.length - 1;

    boolean rowBounds = (coordinates[0] >= minBound) && (coordinates[0] <= maxBound);
    boolean columnBounds = (coordinates[1] >= minBound) && (coordinates[1] <= maxBound);

    return rowBounds && columnBounds;
  }
}
