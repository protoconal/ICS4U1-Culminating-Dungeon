package Dungeon.Game.Items;

import java.util.HashMap;

/**
 * This ArmourDefinitions class contains all the armour items that the player can use in the game.
 *
 * @author Chris Yang, Ilelemwanta Nomaren, Tony Guo, Emily Ta,
 * @version 1.0
 * @since 1.0
 */
public class ArmourDefinitions {
  private final HashMap<String, ArmourItem> ARMOUR_DEFINITIONS = new HashMap<>();
  private final String[] ARMOUR_IDS;

  /**
   * Constructor for the ArmourDefinitions class.
   */
  public ArmourDefinitions() {
    this.ARMOUR_DEFINITIONS.put("RustyArmour", new RustyArmour());
    this.ARMOUR_DEFINITIONS.put("ChainArmour", new ChainArmour());
    this.ARMOUR_DEFINITIONS.put("IronArmour", new IronArmour());
    this.ARMOUR_DEFINITIONS.put("SteelArmour", new SteelArmour());
    this.ARMOUR_DEFINITIONS.put("RoyalArmour", new RoyalArmour());
    this.ARMOUR_DEFINITIONS.put("DarkKnightArmour", new DarkKnightArmour());
    this.ARMOUR_DEFINITIONS.put("CrystallineSteelArmour", new CrystallineSteelArmour());
    this.ARMOUR_DEFINITIONS.put("ArmourOfTheCorrupted", new ArmourOfTheCorrupted());
    this.ARMOUR_DEFINITIONS.put("AbyssalSteelArmour", new AbyssalSteelArmour());
    this.ARMOUR_DEFINITIONS.put("HolyTrinityArmour", new HolyTrinityArmour());
    this.ARMOUR_IDS = this.ARMOUR_DEFINITIONS.keySet().toArray(new String[0]);
  }

  /**
   * Returns an ArmourItem object from the name of the item.
   *
   * @param itemName a string storing the name of the item.
   * @return the ArmourItem object.
   */
  public ArmourItem returnItemFromId(String itemName) {
    return ARMOUR_DEFINITIONS.getOrDefault(itemName, null);
  }

  /**
   * @return the array of Strings that contains the names of all the armour items.
   */
  public String[] getArmourIds() {
    return ARMOUR_IDS;
  }

}

/**
 * This class defines RustyArmour, it adds 100 maximumHP.
 */
class RustyArmour extends ArmourItem {
  /**
   * Constructor for the RustyArmour class.
   */
  public RustyArmour() {
    super(
        "Rusty Armour", // name
        "You're really broke, aren't you?", // description
        50, // price
        100); // hpIncrease
  }
}

/**
 * This class defines ChainArmour, it adds 150 maximumHP.
 */
class ChainArmour extends ArmourItem {
  /**
   * Constructor for the ChainArmour class.
   */
  public ChainArmour() {
    super(
        "Chain Armour", // name
        "What is this, the Middle Ages?", // description
        150, // price
        150); // hpIncrease
  }
}

/**
 * This class defines IronArmour, it adds 200 maximumHP.
 */
class IronArmour extends ArmourItem {
  /**
   * Constructor for the IronArmour class.
   */
  public IronArmour() {
    super(
        "Iron Armour", // name
        "I'd say your Iron Man, but you aren't a real man and this isn't real--", // description
        300, // price
        200); // hpIncrease
  }
}

/**
 * This class defines SteelArmour, it adds 250 maximumHP.
 */
class SteelArmour extends ArmourItem {
  /**
   * Constructor for the SteelArmour class.
   */
  public SteelArmour() {
    super(
        "Steel Armour", // name
        "I hope no monster stee- no, I won't stoop that low", // description
        550, // price
        250); // hpIncrease
  }
}

/**
 * This class defines RoyalArmour, it adds 300 maximumHP.
 */
class RoyalArmour extends ArmourItem {
  /**
   * Constructor for the RoyalArmour class.
   */
  public RoyalArmour() {
    super(
        "Royal Armour", // name
        "This is armour fit for an emperor, empress, duke, duchess, baron, baroness, prince, princess, tsar, or tsarina", // description
        700, // price
        300); // hpIncrease
  }
}

/**
 * This class defines DarkKnightArmour, it adds 350 maximumHP.
 */
class DarkKnightArmour extends ArmourItem {
  /**
   * Constructor for the DarkKnightArmour class.
   */
  public DarkKnightArmour() {
    super(
        "dark Knight Armour", // name
        "We put the dark in lowercase. Now we can't get sued!", // description
        800, // price
        350); // hpIncrease
  }
}

/**
 * This class defines CrystallineSteelArmour, it adds 400 maximumHP.
 */
class CrystallineSteelArmour extends ArmourItem {
  /**
   * Constructor for the CrystallineSteelArmour class.
   */
  public CrystallineSteelArmour() {
    super(
        "Crystalline Steel Armour", // name
        "When regular steel just isn't crystal enough.", // description
        1000, // price
        400); // hpIncrease
  }
}

/**
 * This class defines ArmourOfTheCorrupted, it adds 450 maximumHP.
 */
class ArmourOfTheCorrupted extends ArmourItem {
  /**
   * Constructor for the ArmourOfTheCorrupted class.
   */
  public ArmourOfTheCorrupted() {
    super(
        "Armour Of The Corrupted", // name
        "Sold at your local politician's house", // description
        1500, // price
        450); // hpIncrease
  }
}

/**
 * This class defines AbyssalSteelArmour, it adds 500 maximumHP.
 */
class AbyssalSteelArmour extends ArmourItem {
  /**
   * Constructor for the AbyssalSteelArmour class.
   */
  public AbyssalSteelArmour() {
    super(
        "Abyssal Steel Armour", // name
        "People need to stop calling it abysmal. The only abysmal thing about it is the state of your wallet once you purchase it.", // description
        2000, // price
        500); // hpIncrease
  }
}

/**
 * This class defines HolyTrinityArmour, it adds 600 maximumHP.
 */
class HolyTrinityArmour extends ArmourItem {
  /**
   * Constructor for the HolyTrinityArmour class.
   */
  public HolyTrinityArmour() {
    super(
        "Holy Trinity Armour", // name
        "Just one look at this armour and monsters will convert to Christianity.", // description
        2000, // price
        600); // hpIncrease
  }
}