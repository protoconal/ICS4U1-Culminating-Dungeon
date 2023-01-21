package Dungeon.Game.Entities;

/**
 * The Entity class is the superclass of all entities in the game.
 */
public class Hero extends Entity {
  private String name;

  /**
   * The constructor for the Hero class.
   */
  public Hero() {
    // set maximumHP
    super(100);
  }

  /**
   * The getName() method returns the name of the hero.
   * 
   * @return The name of the hero.
   */
  public String getName() {
    return name;
  }

  /**
   * The setName() method sets the name of the hero.
   * 
   * @param name The name of the hero.
   */
  public void setName(String name) {
    this.name = name;
  }

}
