package Dungeon.Game.Items;
// 7
public class HealthDefinitions {
  // store all possible weapons
  // can move some code out of inventory
}

class Bandage extends HealthItem {
  public Bandage() {
    super("Bandage", // name
        "TEMPORARY DESCRIPTION", // description
        10.00, // price
        1, // maximumStackSize
            1 // restoreHP
    );
  }
}

class Potion extends HealthItem {
  public Potion() {
    super("Bandage", // name
        "TEMPORARY DESCRIPTION", // description
        10.00, // price
        1, // maximumStackSize
            1 // restoreHP
    );
  }
}

class Pill extends HealthItem {
  public Bandage() {
    super("Bandage", // name
        "TEMPORARY DESCRIPTION", // description
        10.00, // price
        1, // maximumStackSize
            1 // restoreHP
    );
  }
}

class ChickenSoup extends HealthItem {
  public Bandage() {
    super("Bandage", // name
        "TEMPORARY DESCRIPTION", // description
        10.00, // price
        1, // maximumStackSize
            1 // restoreHP
    );
  }
}