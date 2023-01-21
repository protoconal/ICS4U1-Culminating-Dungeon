package Dungeon.Game.Items;

import java.util.HashMap;

/**
 * The HealthDefinitions class contains all the health items that the player can use.
 */
public class HealthDefinitions {
  private final HashMap<String, HealthItem> HEALTH_DEFINITIONS = new HashMap<>();
  private final String[] HEALTH_IDS;

  /**
   * The constructor for the HealthDefinitions class.
   */
  public HealthDefinitions() {
    this.HEALTH_DEFINITIONS.put("Bandage", new Bandage());
    this.HEALTH_DEFINITIONS.put("Potion", new Potion());
    this.HEALTH_DEFINITIONS.put("Pill", new Pill());
    this.HEALTH_DEFINITIONS.put("ChickenSoup", new ChickenSoup());
    this.HEALTH_DEFINITIONS.put("Wait", new Wait());
    this.HEALTH_IDS = this.HEALTH_DEFINITIONS.keySet().toArray(new String[0]);
  }

  /**
   * The returnItemFromName() method returns an HealthItem object from the name of the item.
   * 
   * @param itemName The name of the item.
   * @return The HealthItem object.
   */
  public HealthItem returnItemFromName(String itemName) {
    return HEALTH_DEFINITIONS.getOrDefault(itemName, null);
  }

  /**
   * The getHealthIds() method returns an array of Strings that contains the names of all the health
   * items.
   * 
   * @return The array of Strings.
   */
  public String[] getHealthIds() {
    return HEALTH_IDS;
  }
}

/**
 * The HealthItem class is a subclass of the Item class, and it is the item that the player can use to
 * increase their health.
 */
class Wait extends HealthItem {
  /**
   * The constructor for the Wait class.
   */
  public Wait() {
    super("Wait", // name
        "Catch your breath!", // description
        0, // price
        10 // restoreHP
    );
  }
}

/**
 * The HealthItem class is a subclass of the Item class, and it is the item that the player can use to
 * increase their health.
 */
class Bandage extends HealthItem {
  /**
   * The constructor for the Bandage class.
   */
  public Bandage() {
    super("Bandage", // name
        "TEMPORARY DESCRIPTION", // description
        50, // price
        50 // restoreHP
    );
  }
}

/**
 * The HealthItem class is a subclass of the Item class, and it is the item that the player can use to
 * increase their health.
 */
class Potion extends HealthItem {
  /**
   * The constructor for the Potion class.
   */
  public Potion() {
    super("Potion", // name
        "Hocus pocus, I'm starting to lose focus.", // description
        150, // price
        120 // restoreHP
    );
  }
}

/**
 * The HealthItem class is a subclass of the Item class, and it is the item that the player can use to
 * increase their health.
 */
class Pill extends HealthItem {
  /**
   * The constructor for the Pill class.
   */
  public Pill() {
    super("Pill", // name
        "Warning: Not approved by the FDA", // description
        200, // price
        140 // restoreHP
    );
  }
}

/**
 * The HealthItem class is a subclass of the Item class, and it is the item that the player can use to
 * increase their health.
 */
class ChickenSoup extends HealthItem {
  /**
   * The constructor for the ChickenSoup class.
   */
  public ChickenSoup() {
    super("Chicken Soup", // name
        "All proceeds go to the charity 'Save the Chickens'.", // description
        250, // price
        180 // restoreHP
    );
  }
}