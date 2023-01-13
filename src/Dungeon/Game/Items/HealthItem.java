package Dungeon.Game.Items;

import java.util.ArrayList;

public class HealthItem extends Item {

  private int hpRestored;
  
  public HealthItem(String name, String description, double price, int maximumStackSize, int hpRestored) {
    super(name, description, price, maximumStackSize);
    this.hpRestored = hpRestored;
  }

  public HealthItem(String name, String description, double price, int maximumStackSize, ArrayList<String> properties, int hpRestored) {
    super(name, description, price, maximumStackSize, properties);
    this.hpRestored = hpRestored;
  }

  public int getHpRestored() {
    return hpRestored;
  }  
}
