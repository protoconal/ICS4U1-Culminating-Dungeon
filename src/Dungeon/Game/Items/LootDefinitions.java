package Dungeon.Game.Items;
// 7
public class LootDefinitions {
  // store all possible weapons
  // can move some code out of inventory
}

class Silver extends LootItem {
  public Silver() {
    super("Silver", // name
        "TEMPORARY DESCRIPTION", // description
        10 // value
    );
  }
}

class Gold extends LootItem {
  public Gold() {
    super("Gold", // name
        "TEMPORARY DESCRIPTION", // description
        50 // value
    );
  }
}

class Platinum extends LootItem {
  public Platinum() {
    super("Platinum", // name
        "TEMPORARY DESCRIPTION", // description
        75 // value
    );
  }
}

class Sapphire extends LootItem {
  public Sapphire() {
    super("Sapphire", // name
        "TEMPORARY DESCRIPTION", // description
        120 // value
    );
  }
}

class Diamond extends LootItem {
  public Diamond() {
    super("Diamond", // name
        "TEMPORARY DESCRIPTION", // description
        200 // value
    );
  }
}

class Ruby extends LootItem {
  public Ruby() {
    super("Ruby", // name
        "TEMPORARY DESCRIPTION", // description
        300 // value
    );
  }
}