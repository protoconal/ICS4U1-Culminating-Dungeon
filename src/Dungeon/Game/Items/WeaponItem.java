package Dungeon.Game.Items;

import java.util.ArrayList;

public class WeaponItem extends Item {

  private final int MIN_DAMAGE;
  private final int MAX_DAMAGE;

  public WeaponItem(String name, String description, double price, int maximumStackSize, int minDamage, int maxDamage) {
    super(name, description, price, maximumStackSize);
    this.MIN_DAMAGE = minDamage;
    this.MAX_DAMAGE = maxDamage;
  }

  public WeaponItem(String name, String description, double price, int maximumStackSize, ArrayList<String> properties, int minDamage, int maxDamage) {
    super(name, description, price, maximumStackSize, properties);
    this.MIN_DAMAGE = minDamage;
    this.MAX_DAMAGE = maxDamage;
  }

  public int randomDamage() {
    int damageRange = MAX_DAMAGE - MIN_DAMAGE;
    return (int) (MIN_DAMAGE + Math.random() * damageRange);
  }

  public int getAvgDamage() {
    return ((MAX_DAMAGE - MIN_DAMAGE) / 2);
  }
}
