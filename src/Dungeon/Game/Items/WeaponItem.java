package Dungeon.Game.Items;

import java.util.ArrayList;

public class WeaponItem extends Item {

  private int minDamage;
  private int maxDamage;
  
  public WeaponItem(String name, String description, double price, int maximumStackSize, int minDamage, int maxDamage) {
    super(name, description, price, maximumStackSize);
    this.minDamage = minDamage;
    this.maxDamage = maxDamage;
  }

  public WeaponItem(String name, String description, double price, int maximumStackSize, ArrayList<String> properties, int minDamage, int maxDamage) {
    super(name, description, price, maximumStackSize, properties);
    this.minDamage = minDamage;
    this.maxDamage = maxDamage;
  }

  public int randomDamage() {
    int damageRange = maxDamage - minDamage;
    return (int) (minDamage + Math.random() * damageRange);
  }  
}
