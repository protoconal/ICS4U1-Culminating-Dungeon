package Dungeon.Game.Items;

import java.util.ArrayList;

public class Item {
  private final String NAME;
  private final String DESCRIPTION;
  private final double PRICE;
  private ArrayList<String> properties = new ArrayList<>();
  private final int STACK_SIZE;

  // required details
  // DESCRIPTION, NAME
  
  public Item(String name, String description, double price, int maximumStackSize) {
    this.NAME = name;
    this.DESCRIPTION = description;
    this.PRICE = price;
    this.STACK_SIZE = maximumStackSize;
  }

  public Item(String name, String description) {
    this.NAME = name;
    this.DESCRIPTION = description;
    this.PRICE = -1;
    this.STACK_SIZE = -1;
  }

  public Item(String name, String description, double price, int maximumStackSize, ArrayList<String> properties) {
    this.NAME = name;
    this.DESCRIPTION = description;
    this.PRICE = price;
    this.STACK_SIZE = maximumStackSize;
    this.properties = properties;
  }

  public String getName() { return this.NAME; }

  public String getDescription() { return this.DESCRIPTION; }

  public double getPrice() { return this.PRICE; }

  public int getStackSize() { return this.STACK_SIZE; }
}
