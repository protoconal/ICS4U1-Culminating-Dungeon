package Dungeon.Game.Items;

import java.util.ArrayList;

public class HealthItem extends Item {
  private final int RESTORE_HP;

  public HealthItem(String name, String description, int price, int restoreHP) {
    super(name, description, price);
    this.RESTORE_HP = restoreHP;
  }

  public int getRestoreHP() {
    return RESTORE_HP;
  }
}
