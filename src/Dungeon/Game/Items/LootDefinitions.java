package Dungeon.Game.Items;

import Dungeon.Game.WeightedRandoms;

// 7
public class LootDefinitions {
  private final WeightedRandoms rand;
  private final LootItem[] loot = new LootItem[]{
      new Silver(),
      new Gold(),
      new Platinum(),
      //new Sapphire(),
      new Diamond(),
      new Ruby(),
  };

  public LootDefinitions() {
    double[] loot = new double[]{
        0.35, // Silver();
        0.30, // Gold
        0.20, // Platinum
        0.10, // Diamond
        0.05, // Ruby
    };
    this.rand = new WeightedRandoms(loot);
  }

  public LootItem generateLoot() {
    return loot[rand.generateChoice()];
  }
}

class Silver extends LootItem {
  public Silver() {
    super("Silver", // name
        "Cheaper than platinum", // description
        10 // value
    );
  }
}

class Gold extends LootItem {
  public Gold() {
    super("Gold", // name
        "Ruby, but yellow", // description
        50 // value
    );
  }
}

class Platinum extends LootItem {
  public Platinum() {
    super("Platinum", // name
        "More expensive than silver", // description
        70 // value
    );
  }
}

/*class Sapphire extends LootItem {
  public Sapphire() {
    super("Sapphire", // name
        "TEMPORARY DESCRIPTION", // description
        120 // value
    );
  }
}*/

class Diamond extends LootItem {
  public Diamond() {
    super("Diamond", // name
        "A solid form of the element carbon with its atoms arranged in a crystal structure called diamond cubic.", // description
        150 // value
    );
  }
}

class Ruby extends LootItem {
  public Ruby() {
    super("Ruby", // name
        "Gold, but red", // description
        200 // value
    );
  }
}