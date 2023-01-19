package Dungeon.Game.Items;

import java.util.ArrayList;

public class HealthItem extends Item {
  private final int RESTORE_HP;

  public HealthItem(String name, String description, double price, int maximumStackSize, int restoreHP) {
    super(name, description, price, maximumStackSize);
    this.RESTORE_HP = restoreHP;
  }

  public HealthItem(String name, String description, double price, int maximumStackSize, ArrayList<String> properties, int restoreHP) {
    super(name, description, price, maximumStackSize, properties);
    this.RESTORE_HP = restoreHP;
  }

  public int getRestoreHP() {
    return RESTORE_HP;
  }
}
