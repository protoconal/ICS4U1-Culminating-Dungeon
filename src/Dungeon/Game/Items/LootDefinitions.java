package Dungeon.Game.Items;

import Dungeon.Game.GameWeightedRandoms;

/**
 * This LootDefinitions class contains all the LOOT_DEFINITIONS that the player can find in the game.
 *
 * @author Chris Yang, Ilelemwanta Nomaren, Tony Guo, Emily Ta,
 * @version 1.0
 * @since 1.0
 */
public class LootDefinitions {
  private final GameWeightedRandoms RANDOM;
  private final LootItem[] LOOT_DEFINITIONS = new LootItem[]{
      new Silver(),
      new Gold(),
      new Platinum(),
      new Diamond(),
      new Ruby(),
  };

  /**
   * Constructor for the LootDefinitions class.
   */
  public LootDefinitions() {
    double[] lootChances = new double[]{
        0.35, // Silver();
        0.30, // Gold
        0.20, // Platinum
        0.10, // Diamond
        0.05, // Ruby
    };
    this.RANDOM = new GameWeightedRandoms(lootChances);
  }

  /**
   * Generates a random LootItem.
   *
   * @return a random LootItem.
   */
  public LootItem generateLoot() {
    return LOOT_DEFINITIONS[RANDOM.generateChoice()];
  }
}

/**
 * This Silver is an item worth 10 score.
 */
class Silver extends LootItem {
  /**
   * Constructor for the Silver class.
   */
  public Silver() {
    super("Silver", // name
        "Cheaper than platinum", // description
        20 // value
    );
  }
}

/**
 * This Silver is an item worth 50 score.
 */
class Gold extends LootItem {
  /**
   * Constructor for the Gold class.
   */
  public Gold() {
    super("Gold", // name
        "Ruby, but yellow", // description
        50 // value
    );
  }
}

/**
 * This Silver is an item worth 70 score.
 */
class Platinum extends LootItem {
  /**
   * Constructor for the Platinum class.
   */
  public Platinum() {
    super("Platinum", // name
        "More expensive than silver", // description
        70 // value
    );
  }
}

/**
 * This Silver is an item worth 150 score.
 */
class Diamond extends LootItem {
  /**
   * Constructor for the Diamond class.
   */
  public Diamond() {
    super("Diamond", // name
        "A solid form of the element carbon with its atoms arranged in a crystal structure called diamond cubic.", // description
        150 // value
    );
  }
}

/**
 * This Silver is an item worth 200 score.
 */
class Ruby extends LootItem {
  /**
   * Constructor for the Ruby class.
   */
  public Ruby() {
    super("Ruby", // name
        "Gold, but red", // description
        250 // value
    );
  }
}