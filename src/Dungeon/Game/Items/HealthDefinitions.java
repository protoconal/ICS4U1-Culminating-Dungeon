package Dungeon.Game.Items;

import java.util.HashMap;

/**
 * This HealthDefinitions class contains all the health items that the player can use in the game.
 *
 * @author Chris Yang, Ilelemwanta Nomaren, Tony Guo, Emily Ta,
 * @version 1.0
 * @since 1.0
 */
public class HealthDefinitions {
  private final HashMap<String, HealthItem> HEALTH_DEFINITIONS = new HashMap<>();
  private final String[] HEALTH_IDS;

  /**
   * Constructor for the HealthDefinitions class.
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
   * Returns an HealthItem object from the name of the item.
   *
   * @param itemName a string storing the name of the item.
   * @return the HealthItem object.
   */
  public HealthItem returnItemFromId(String itemName) {
    return HEALTH_DEFINITIONS.getOrDefault(itemName, null);
  }

  /**
   * @return the array of Strings that contains the names of all the health items.
   */
  public String[] getHealthIds() {
    return HEALTH_IDS;
  }
}

/**
 * This class defines Wait, it is a free option when the player has no more health items to use. It restores 10 HP.
 */
class Wait extends HealthItem {
  /**
   * Constructor for the Wait class.
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
 * This class defines Bandage, it restores 50 HP.
 */
class Bandage extends HealthItem {
  /**
   * Constructor for the Bandage class.
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
 * This class defines Potion, it restores 120 HP.
 */
class Potion extends HealthItem {
  /**
   * Constructor for the Potion class.
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
 * This class defines Pill, it restores 140 HP.
 */
class Pill extends HealthItem {
  /**
   * Constructor for the Pill class.
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
 * This class defines ChickenSoup, it restores 180 HP.
 */
class ChickenSoup extends HealthItem {
  /**
   * Constructor for the ChickenSoup class.
   */
  public ChickenSoup() {
    super("Chicken Soup", // name
        "All proceeds go to the charity 'Save the Chickens'.", // description
        250, // price
        180 // restoreHP
    );
  }
}