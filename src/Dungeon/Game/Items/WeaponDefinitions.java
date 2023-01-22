package Dungeon.Game.Items;

import java.util.HashMap;

/**
 * The WeaponDefinitions class is a class that contains all the weapon items that the player can use in the game.
 */
public class WeaponDefinitions {
  private final HashMap<String, WeaponItem> WEAPON_DEFINITIONS = new HashMap<>();
  private final String[] WEAPON_IDS;

  /**
   * The constructor for the WeaponDefinitions class.
   */
  public WeaponDefinitions() {
    this.WEAPON_DEFINITIONS.put("DullSword", new DullSword());
    this.WEAPON_DEFINITIONS.put("IronSword", new IronSword());
    this.WEAPON_DEFINITIONS.put("Katana", new Katana());
    this.WEAPON_DEFINITIONS.put("RoyalSword", new RoyalSword());
    this.WEAPON_DEFINITIONS.put("CrystalGreatSword", new CrystalGreatSword());
    this.WEAPON_DEFINITIONS.put("HolyBlade", new HolyBlade());
    this.WEAPON_DEFINITIONS.put("Muramasa", new Muramasa());
    this.WEAPON_DEFINITIONS.put("CorruptedGreatSword", new CorruptedGreatSword());
    this.WEAPON_DEFINITIONS.put("AbyssalBlade", new AbyssalBlade());
    this.WEAPON_DEFINITIONS.put("GodSlayer", new GodSlayer());
    this.WEAPON_IDS = this.WEAPON_DEFINITIONS.keySet().toArray(new String[0]);
  }

  /**
   * The returnItemFromId() method returns a WeaponItem object from the name of the item.
   *
   * @param itemName The name of the item.
   * @return The WeaponItem object.
   */
  public WeaponItem returnItemFromId(String itemName) {
    return WEAPON_DEFINITIONS.getOrDefault(itemName, null);
  }

  /**
   * The getWeaponIds() method returns an array of Strings that contains the names of all the weapon
   * items.
   *
   * @return The array of Strings.
   */
  public String[] getWeaponIds() {
    return WEAPON_IDS;
  }
}

/**
 * The WeaponItem class is a subclass of the Item class, and it is the item that the player can use to
 * attack the enemies.
 */
class DullSword extends WeaponItem {
  /**
   * The constructor for the DullSword class.
   */
  public DullSword() {
    super(
        "Dull Sword", // name
        "A stupid sword for a stupid person", // description
        50, // price
        5, // minDamage
        15); // maxDamage
  }
}

/**
 * The WeaponItem class is a subclass of the Item class, and it is the item that the player can use to
 * attack the enemies.
 */
class IronSword extends WeaponItem {
  /**
   * The constructor for the IronSword class.
   */
  public IronSword() {
    super(
        "Iron Sword", // name
        "TEMPORARY DESCRIPTION", // description
        150, // price
        20, // minDamage
        30); // maxDamage
  }
}

/**
 * The WeaponItem class is a subclass of the Item class, and it is the item that the player can use to
 * attack the enemies.
 */
class Katana extends WeaponItem {
  /**
   * The constructor for the Katana class.
   */
  public Katana() {
    super(
        "Katana", // name
        "これが何を意味するのか、あなたには決してわからないでしょう！", // description
        300, // price
        25, // minDamage
        40); // maxDamage
  }
}

/**
 * The WeaponItem class is a subclass of the Item class, and it is the item that the player can use to
 * attack the enemies.
 */
class RoyalSword extends WeaponItem {
  /**
   * The constructor for the RoyalSword class.
   */
  public RoyalSword() {
    super(
        "Royal Sword", // name
        " This is a sword fit for a sheikh, emir, chief, oba, lord, caesar, prince, king, or queen,", // description
        550, // price
        30, // minDamage
        45); // maxDamage
  }
}

/**
 * The WeaponItem class is a subclass of the Item class, and it is the item that the player can use to
 * attack the enemies.
 */
class CrystalGreatSword extends WeaponItem {
  /**
   * The constructor for the CrystalGreatSword class.
   */
  public CrystalGreatSword() {
    super(
        "Crystal Great Sword", // name
        "Crystal's definitely great, but I'm not so sure about the sword", // description
        700, // price
        40, // minDamage
        60); // maxDamage
  }
}

/**
 * The WeaponItem class is a subclass of the Item class, and it is the item that the player can use to
 * attack the enemies.
 */
class HolyBlade extends WeaponItem {
  /**
   * The constructor for the HolyBlade class.
   */
  public HolyBlade() {
    super(
        "Holy Blade", // name
        "For such a powerful sword, this price is sacrilegious!", // description
        800, // price
        55, // minDamage
        70); // maxDamage
  }
}

/**
 * The WeaponItem class is a subclass of the Item class, and it is the item that the player can use to
 * attack the enemies.
 */
class Muramasa extends WeaponItem {
  /**
   * The constructor for the Muramasa class.
   */
  public Muramasa() {
    super(
        "Muramasa", // name
        "待って、この剣は呪われている？", // description
        1000, // price
        60, // minDamage
        75); // maxDamage
  }
}

/**
 * The WeaponItem class is a subclass of the Item class, and it is the item that the player can use to
 * attack the enemies.
 */
class CorruptedGreatSword extends WeaponItem {
  /**
   * The constructor for the CorruptedGreatSword class.
   */
  public CorruptedGreatSword() {
    super(
        "Corrupted Great Sword", // name
        "This sword will be taken off the market soon because it's too danger- Actually, our generous sponsors have ensured that this sword is the safest one of all.", // description
        1250, // price
        55, // minDamage
        80); // maxDamage
  }
}

/**
 * The WeaponItem class is a subclass of the Item class, and it is the item that the player can use to
 * attack the enemies.
 */
class AbyssalBlade extends WeaponItem {
  /**
   * The constructor for the AbyssalBlade class.
   */
  public AbyssalBlade() {
    super(
        "Abyssal Blade", // name
        "Yeah, we're kind of lazy with our names.", // description
        1500, // price
        70, // minDamage
        85); // maxDamage
  }
}

/**
 * The WeaponItem class is a subclass of the Item class, and it is the item that the player can use to
 * attack the enemies.
 */
class GodSlayer extends WeaponItem {
  /**
   * The constructor for the GodSlayer class.
   */
  public GodSlayer() {
    super(
        "God Slayer", // name
        "Isn't God immortal, though?", // description
        2000, // price
        90, // minDamage
        100); // maxDamage
  }
}