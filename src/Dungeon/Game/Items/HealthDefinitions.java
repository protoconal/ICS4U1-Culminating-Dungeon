package Dungeon.Game.Items;

import java.util.HashMap;

// 7
public class HealthDefinitions {
  private final HashMap<String, HealthItem> HEALTH_DEFINITIONS = new HashMap<>();
  private final String[] HEALTH_IDS;

  public HealthDefinitions() {
    this.HEALTH_DEFINITIONS.put("Bandage", new Bandage());
    this.HEALTH_DEFINITIONS.put("Potion", new Potion());
    this.HEALTH_DEFINITIONS.put("Pill", new Pill());
    this.HEALTH_DEFINITIONS.put("ChickenSoup", new ChickenSoup());
    this.HEALTH_DEFINITIONS.put("Wait", new Wait());
    this.HEALTH_IDS = this.HEALTH_DEFINITIONS.keySet().toArray(new String[0]);
  }

  public HealthItem returnItemFromName(String itemName) {
    return HEALTH_DEFINITIONS.getOrDefault(itemName, null);
  }

  public String[] getHealthIds() {
    return HEALTH_IDS;
  }
}

class Wait extends HealthItem {
  public Wait() {
    super("Wait", // name
        "Catch your breath!", // description
        0, // price
        10 // restoreHP
    );
  }
}

class Bandage extends HealthItem {
  public Bandage() {
    super("Bandage", // name
        "TEMPORARY DESCRIPTION", // description
        50, // price
        50 // restoreHP
    );
  }
}

class Potion extends HealthItem {
  public Potion() {
    super("Potion", // name
        "Hocus pocus, I'm starting to lose focus.", // description
        150, // price
        120 // restoreHP
    );
  }
}

class Pill extends HealthItem {
  public Pill() {
    super("Pill", // name
        "Warning: Not approved by the FDA", // description
        200, // price
        140 // restoreHP
    );
  }
}

class ChickenSoup extends HealthItem {
  public ChickenSoup() {
    super("Chicken Soup", // name
        "All proceeds go to the charity 'Save the Chickens'.", // description
        250, // price
        180 // restoreHP
    );
  }
}