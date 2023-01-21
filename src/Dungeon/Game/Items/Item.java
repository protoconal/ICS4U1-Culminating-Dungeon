package Dungeon.Game.Items;

public class Item {
  private final String NAME;
  private final String ITEM_ID;
  private final String DESCRIPTION;
  private final int PRICE;

  public Item(String name, String description, int price) {
    this.NAME = name;
    this.DESCRIPTION = description;
    this.PRICE = price;
    this.ITEM_ID = name.replaceAll("\\s", "");
  }

  public Item(String name, String description) {
    this.NAME = name;
    this.DESCRIPTION = description;
    this.PRICE = -1;
    this.ITEM_ID = name.replaceAll("\\s", "");
  }

  public String getName() {
    return this.NAME;
  }

  public String getDescription() {
    return this.DESCRIPTION;
  }

  public int getPrice() {
    return this.PRICE;
  }

  public String getId() {
    return ITEM_ID;
  }
}
