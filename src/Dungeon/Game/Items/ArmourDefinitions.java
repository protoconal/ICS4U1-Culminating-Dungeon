package Dungeon.Game.Items;

import java.util.HashMap;

public class ArmourDefinitions {
  private final HashMap<String, ArmourItem> ARMOUR_DEFINITIONS = new HashMap<>();

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
  }

  public ArmourItem returnItemFromName(String itemName) {
    return ARMOUR_DEFINITIONS.getOrDefault(itemName, null);
  }

}

class RustyArmour extends ArmourItem {
  public RustyArmour() {
    super(
        "Rusty Armour", // name
        "You're really broke, aren't you?", // description
        50, // price
        100); // hpIncrease
  }
}

class ChainArmour extends ArmourItem {
  public ChainArmour() {
    super(
        "Chain Armour", // name
        "What is this, the Middle Ages?", // description
        150, // price
        150); // hpIncrease
  }
}

class IronArmour extends ArmourItem {
  public IronArmour() {
    super(
        "Iron Armour", // name
        "I'd say your Iron Man, but you aren't a real man and this isn't real--", // description
        300, // price
        200); // hpIncrease
  }
}

class SteelArmour extends ArmourItem {
  public SteelArmour() {
    super(
        "Steel Armour", // name
        "I hope no monster stee- no, I won't stoop that low", // description
        550, // price
        250); // hpIncrease
  }
}

class RoyalArmour extends ArmourItem {
  public RoyalArmour() {
    super(
        "Royal Armour", // name
        "This is armour fit for an emperor, empress, duke, duchess, baron, baroness, prince, princess, tsar, or tsarina", // description
        700, // price
        300); // hpIncrease
  }
}

class DarkKnightArmour extends ArmourItem {
  public DarkKnightArmour() {
    super(
        "dark Knight Armour", // name
        "We put the dark in lowercase. Now we can't get sued!", // description
        800, // price
        350); // hpIncrease
  }
}

class CrystallineSteelArmour extends ArmourItem {
  public CrystallineSteelArmour() {
    super(
        "Crystalline Steel Armour", // name
        "When regular steel just isn't crystal enough.", // description
        1000, // price
        400); // hpIncrease
  }
}

class ArmourOfTheCorrupted extends ArmourItem {
  public ArmourOfTheCorrupted() {
    super(
        "Armour Of The Corrupted", // name
        "Sold at your local politician's house", // description
        1500, // price
        450); // hpIncrease
  }
}

class AbyssalSteelArmour extends ArmourItem {
  public AbyssalSteelArmour() {
    super(
        "Abyssal Steel Armour", // name
        "People need to stop calling it abysmal. The only abysmal thing about it is the state of your wallet once you purchase it.", // description
        2000, // price
        500); // hpIncrease
  }
}

class HolyTrinityArmour extends ArmourItem {
  public HolyTrinityArmour() {
    super(
        "HolyTrinityArmour", // name
        "Just one look at this armour and monsters will convert to Christianity.", // description
        2000, // price
        600); // hpIncrease
  }
}