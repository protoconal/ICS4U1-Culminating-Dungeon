package Dungeon.Game.Items;

import java.util.ArrayList;

public class ArmourItem extends Item {
  private final int HP_INCREASE;

  public ArmourItem(String name, String description, double price, int maxNumber, int hpIncrease) {
    super(name, description, price, maxNumber);
    this.HP_INCREASE = hpIncrease;
  }

  public int getHpIncrease() {
    return HP_INCREASE;
  }
}
