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
        1, // minDamage
        1); // maxDamage
  }
}

class IronSword extends WeaponItem {
  public IronSword() {
    super(
        "Iron Sword", // name
        "TEMPORARY DESCRIPTION", // description
        10.00, // price
        1, // maxNumber
        1, // minDamage
        2); // maxDamage
  }
}

class Katana extends WeaponItem {
  public Katana() {
    super(
        "Katana", // name
        "TEMPORARY DESCRIPTION", // description
        10.00, // price
        1, // maxNumber
        1, // minDamage
        6); // maxDamage
  }
}

class RoyalSword extends WeaponItem {
  public RoyalSword() {
    super(
        "Royal Sword", // name
        "TEMPORARY DESCRIPTION", // description
        10.00, // price
        1, // maxNumber
        1, // minDamage
        24); // maxDamage
  }
}

class CrystalGreatSword extends WeaponItem {
  public CrystalGreatSword() {
    super(
        "Crystal Great Sword", // name
        "TEMPORARY DESCRIPTION", // description
        10.00, // price
        1, // maxNumber
        1, // minDamage
        120); // maxDamage
  }
}

class HolyBlade extends WeaponItem {
  public HolyBlade() {
    super(
        "Holy Blade", // name
        "TEMPORARY DESCRIPTION", // description
        10.00, // price
        1, // maxNumber
        1, // minDamage
        720); // maxDamage
  }
}

class Muramasa extends WeaponItem {
  public Muramasa() {
    super(
        "Muramasa", // name
        "TEMPORARY DESCRIPTION", // description
        10.00, // price
        1, // maxNumber
        1, // minDamage
        5040); // maxDamage
  }
}

class CorruptedGreatSword extends WeaponItem {
  public CorruptedGreatSword() {
    super(
        "Corrupted Great Sword", // name
        "TEMPORARY DESCRIPTION", // description
        10.00, // price
        1, // maxNumber
        1, // minDamage
        40320); // maxDamage
  }
}

class AbyssalBlade extends WeaponItem {
  public AbyssalBlade() {
    super(
        "Abyssal Blade", // name
        "TEMPORARY DESCRIPTION", // description
        10.00, // price
        1, // maxNumber
        1, // minDamage
        3628800); // maxDamage
  }
}