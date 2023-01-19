package Dungeon.Game.Items;

public class WeaponDefinitions {
  // store all possible weapons
  // can move some code out of inventory
}

class DullSword extends WeaponItem {
  public DullSword() {
    super(
        "Dull Sword", // name
        "A stupid sword for a stupid person", // description
        50.00, // price
        1, // maxNumber
        5, // minDamage
        15); // maxDamage
  }
}

class IronSword extends WeaponItem {
  public IronSword() {
    super(
        "Iron Sword", // name
        "TEMPORARY DESCRIPTION", // description
        150.00, // price
        1, // maxNumber
        20, // minDamage
        30); // maxDamage
  }
}

class Katana extends WeaponItem {
  public Katana() {
    super(
        "Katana", // name
        "これが何を意味するのか、あなたには決してわからないでしょう！", // description
        300.00, // price
        1, // maxNumber
        25, // minDamage
        40); // maxDamage
  }
}

class RoyalSword extends WeaponItem {
  public RoyalSword() {
    super(
        "Royal Sword", // name
        " This is a sword fit for a sheikh, emir, chief, oba, lord, caesar, prince, king, or queen,", // description
        550.00, // price
        1, // maxNumber
        30, // minDamage
        45); // maxDamage
  }
}

class CrystalGreatSword extends WeaponItem {
  public CrystalGreatSword() {
    super(
        "Crystal Great Sword", // name
        "Crystal's definetly great, but I'm not so sure about the sword", // description
        700.00, // price
        1, // maxNumber
        40, // minDamage
        60); // maxDamage
  }
}

class HolyBlade extends WeaponItem {
  public HolyBlade() {
    super(
        "Holy Blade", // name
        "For such a powerful sword, this price is sacrilegious!", // description
        800.00, // price
        1, // maxNumber
        55, // minDamage
        70); // maxDamage
  }
}

class Muramasa extends WeaponItem {
  public Muramasa() {
    super(
        "Muramasa", // name
        "待って、この剣は呪われている？", // description
        1000.00, // price
        1, // maxNumber
        60, // minDamage
        75); // maxDamage
  }
}

class CorruptedGreatSword extends WeaponItem {
  public CorruptedGreatSword() {
    super(
        "Corrupted Great Sword", // name
        "This sword will be taken off the market soon because it's too danger- Actually, our generous sponsors have ensured that this sword is the safest one of all.", // description
        1250.00, // price
        1, // maxNumber
        55, // minDamage
        80); // maxDamage
  }
}

class AbyssalBlade extends WeaponItem {
  public AbyssalBlade() {
    super(
        "Abyssal Blade", // name
        "Yeah, we're kind of lazy with our names.", // description
        1500.00, // price
        1, // maxNumber
        70, // minDamage
        85); // maxDamage
  }
}

class GodSlayer extends WeaponItem {
  public GodSlayer() {
    super(
        "God Slayer", // name
        "Isn't God immortal, though?", // description
        2000.00, // price
        1, // maxNumber
        90, // minDamage
        100); // maxDamage
  }
}