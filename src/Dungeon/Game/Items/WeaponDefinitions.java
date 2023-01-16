package Dungeon.Game.Items;

public class WeaponDefinitions {
  // store all possible weapons
  // can move some code out of inventory
}

class DullSword extends WeaponItem {
  public DullSword() {
    super(
        "Dull Sword", // name
        "TEMPORARY DESCRIPTION", // description
        10.00, // price
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
        "TEMPORARY DESCRIPTION", // description
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
        "TEMPORARY DESCRIPTION", // description
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
        "TEMPORARY DESCRIPTION", // description
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
        "TEMPORARY DESCRIPTION", // description
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
        "TEMPORARY DESCRIPTION", // description
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
        "TEMPORARY DESCRIPTION", // description
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
        "TEMPORARY DESCRIPTION", // description
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
        "TEMPORARY DESCRIPTION", // description
        2000.00, // price
        1, // maxNumber
        90, // minDamage
        100); // maxDamage
  }
}