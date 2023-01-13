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
        10); // maxDamage
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
        10); // maxDamage
  }
}