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
            50 // restoreHP
    );
  }
}

class Potion extends HealthItem {
  public Potion() {
    super("Bandage", // name
            "TEMPORARY DESCRIPTION", // description
            10.00, // price
            1, // maximumStackSize
            100 // restoreHP
    );
  }
}

class Pill extends HealthItem {
  public Pill() {
    super("Bandage", // name
            "TEMPORARY DESCRIPTION", // description
            10.00, // price
            1, // maximumStackSize
            250 // restoreHP
    );
  }
}

class ChickenSoup extends HealthItem {
  public ChickenSoup() {
    super("Bandage", // name
            "TEMPORARY DESCRIPTION", // description
            10.00, // price
            1, // maximumStackSize
            500 // restoreHP
    );
  }
}