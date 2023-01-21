package Dungeon.Game.Items;

import java.util.HashMap;

public class WeaponDefinitions {
  private final HashMap<String, WeaponItem> WEAPON_DEFINITIONS = new HashMap<>();
  private final String[] WEAPON_IDS;

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

  public WeaponItem returnItemFromName(String itemName) {
    return WEAPON_DEFINITIONS.getOrDefault(itemName, null);
  }

  public String[] getWeaponIds() {
    return WEAPON_IDS;
  }
}

class DullSword extends WeaponItem {
  public DullSword() {
    super(
        "Dull Sword", // name
        "A stupid sword for a stupid person", // description
        50, // price
        5, // minDamage
        15); // maxDamage
  }
}

class IronSword extends WeaponItem {
  public IronSword() {
    super(
        "Iron Sword", // name
        "TEMPORARY DESCRIPTION", // description
        150, // price
        20, // minDamage
        30); // maxDamage
  }
}

class Katana extends WeaponItem {
  public Katana() {
    super(
        "Katana", // name
        "これが何を意味するのか、あなたには決してわからないでしょう！", // description
        300, // price
        25, // minDamage
        40); // maxDamage
  }
}

class RoyalSword extends WeaponItem {
  public RoyalSword() {
    super(
        "Royal Sword", // name
        " This is a sword fit for a sheikh, emir, chief, oba, lord, caesar, prince, king, or queen,", // description
        550, // price
        30, // minDamage
        45); // maxDamage
  }
}

class CrystalGreatSword extends WeaponItem {
  public CrystalGreatSword() {
    super(
        "Crystal Great Sword", // name
        "Crystal's definitely great, but I'm not so sure about the sword", // description
        700, // price
        40, // minDamage
        60); // maxDamage
  }
}

class HolyBlade extends WeaponItem {
  public HolyBlade() {
    super(
        "Holy Blade", // name
        "For such a powerful sword, this price is sacrilegious!", // description
        800, // price
        55, // minDamage
        70); // maxDamage
  }
}

class Muramasa extends WeaponItem {
  public Muramasa() {
    super(
        "Muramasa", // name
        "待って、この剣は呪われている？", // description
        1000, // price
        60, // minDamage
        75); // maxDamage
  }
}

class CorruptedGreatSword extends WeaponItem {
  public CorruptedGreatSword() {
    super(
        "Corrupted Great Sword", // name
        "This sword will be taken off the market soon because it's too danger- Actually, our generous sponsors have ensured that this sword is the safest one of all.", // description
        1250, // price
        55, // minDamage
        80); // maxDamage
  }
}

class AbyssalBlade extends WeaponItem {
  public AbyssalBlade() {
    super(
        "Abyssal Blade", // name
        "Yeah, we're kind of lazy with our names.", // description
        1500, // price
        70, // minDamage
        85); // maxDamage
  }
}

class GodSlayer extends WeaponItem {
  public GodSlayer() {
    super(
        "God Slayer", // name
        "Isn't God immortal, though?", // description
        2000, // price
        90, // minDamage
        100); // maxDamage
  }
}