package Dungeon.Game.Items;

import Dungeon.Game.NormalWeightedRandoms;

/**
 * The LootDefinitions class is a class that contains all the loot definitions.
 */
public class LootDefinitions {
  private final NormalWeightedRandoms RAND;
  private final LootItem[] LOOT = new LootItem[]{
      new Silver(),
      new Gold(),
      new Platinum(),
      new Diamond(),
      new Ruby(),
  };

  /**
   * The constructor for the LootDefinitions class.
   */
  public LootDefinitions() {
    double[] loot = new double[]{
        0.35, // Silver();
        0.30, // Gold
        0.20, // Platinum
        0.10, // Diamond
        0.05, // Ruby
    };
    this.RAND = new NormalWeightedRandoms(loot);
  }

  /**
   * The generateLoot() method generates a random loot item.
   * 
   * @return A random loot item.
   */
  public LootItem generateLoot() {
    return LOOT[RAND.generateChoice()];
  }
}

/**
 * The LootItem class is a subclass of the Item class, and it is the item that the player can use to
 * increase their score.
 */
class Silver extends LootItem {
  /**
   * The constructor for the Silver class.
   */
  public Silver() {
    super("Silver", // name
        "Cheaper than platinum", // description
        10 // value
    );
  }
}

/**
 * The LootItem class is a subclass of the Item class, and it is the item that the player can use to
 * increase their score.
 */
class Gold extends LootItem {
  /**
   * The constructor for the Gold class.
   */
  public Gold() {
    super("Gold", // name
        "Ruby, but yellow", // description
        50 // value
    );
  }
}

/**
 * The LootItem class is a subclass of the Item class, and it is the item that the player can use to
 * increase their score.
 */
class Platinum extends LootItem {
  /**
   * The constructor for the Platinum class.
   */
  public Platinum() {
    super("Platinum", // name
        "More expensive than silver", // description
        70 // value
    );
  }
}

/**
 * The LootItem class is a subclass of the Item class, and it is the item that the player can use to
 * increase their score.
 */
class Diamond extends LootItem {
  /**
   * The constructor for the Diamond class.
   */
  public Diamond() {
    super("Diamond", // name
        "A solid form of the element carbon with its atoms arranged in a crystal structure called diamond cubic.", // description
        150 // value
    );
  }
}

/**
 * The LootItem class is a subclass of the Item class, and it is the item that the player can use to
 * increase their score.
 */
class Ruby extends LootItem {
  /**
   * The constructor for the Ruby class.
   */
  public Ruby() {
    super("Ruby", // name
        "Gold, but red", // description
        200 // value
    );
  }
}