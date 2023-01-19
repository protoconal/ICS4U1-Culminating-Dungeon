package Dungeon.Game.Entities;

public class Hero extends Entity {
  public Hero() {
    // set maximumHP
    super(100);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private String name;

}
