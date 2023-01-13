package Dungeon.Game.Items;

import java.util.ArrayList;

public class Item {
  private String name;
  private String description;
  private double price;
  private ArrayList<String> properties = new ArrayList<>();
  private int maximumStackSize;

  // required details
  // description, name
  
  public Item(String name, String description, double price, int maximumStackSize) {
    this.name = name;
    this.description = description;
    this.price = price;
    // should the item store the size allowed in inventory or should that be seperately tracked???
    this.maximumStackSize = maximumStackSize;
  }

  public Item(String name, String description, double price, int maximumStackSize, ArrayList<String> properties) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.maximumStackSize = maximumStackSize;
    this.properties = properties;
  }

  public String getName() { return this.name; }

  public String getDescription() { return this.description; }

  public double getPrice() { return this.price; }

  public int getStackSize() { return this.maximumStackSize; }
}
