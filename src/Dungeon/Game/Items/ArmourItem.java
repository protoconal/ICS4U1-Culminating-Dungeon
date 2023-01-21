package Dungeon.Game.Items;

public class ArmourItem extends Item {
  private final int HP_INCREASE;

  public ArmourItem(String name, String description, int price, int hpIncrease) {
    super(name, description, price);
    this.HP_INCREASE = hpIncrease;
  }

  public int getHpIncrease() {
    return HP_INCREASE;
  }
}
