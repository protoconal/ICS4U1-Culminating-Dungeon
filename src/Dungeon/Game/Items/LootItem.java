package Dungeon.Game.Items;

public class LootItem extends Item {
  private final int value;

  public LootItem(String name, String description, int value) {
    super(name, description);
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
