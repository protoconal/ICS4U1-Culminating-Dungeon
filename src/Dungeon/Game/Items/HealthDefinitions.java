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
        50.00, // price
        15, // maximumStackSize
        50 // restoreHP
    );
  }
}

class Potion extends HealthItem {
  public Potion() {
    super("Potion", // name
        "TEMPORARY DESCRIPTION", // description
        250.00, // price
        3, // maximumStackSize
        200 // restoreHP
    );
  }
}

class Pill extends HealthItem {
  public Pill() {
    super("Pill", // name
        "TEMPORARY DESCRIPTION", // description
        200.00, // price
        5, // maximumStackSize
        150 // restoreHP
    );
  }
}

class ChickenSoup extends HealthItem {
  public ChickenSoup() {
    super("Chicken Soup", // name
        "TEMPORARY DESCRIPTION", // description
        150.00, // price
        5, // maximumStackSize
        120 // restoreHP
    );
  }
}