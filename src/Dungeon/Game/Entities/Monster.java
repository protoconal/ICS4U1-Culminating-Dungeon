package Dungeon.Game.Entities;

/**
 * The Monster class is the superclass of all monsters in the game.
 */
public abstract class Monster extends Entity {
  private final String NAME;
  private final int MIN_DAMAGE;
  private final int MAX_DAMAGE;
  private final String onAttackText; // x verbs you.
  private final String onAppearText; // a blobby creature appears.

  /**
   * The constructor for the Monster class.
   * 
   * @param name The name of the monster.
   * @param maxHP The maximum HP of the monster.
   * @param minDamage The minimum damage of the monster.
   * @param maxDamage The maximum damage of the monster.
   * @param onAttackText The text that is displayed when the monster attacks.
   * @param onAppearText The text that is displayed when the monster appears.
   */
  public Monster(String name, int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
    super(maxHP);
    this.NAME = name;
    this.MIN_DAMAGE = minDamage;
    this.MAX_DAMAGE = maxDamage;
    this.onAttackText = onAttackText;
    this.onAppearText = onAppearText;
  }

  /**
   * The returnCopy() method returns a copy of the monster.
   * 
   * @return A copy of the monster.
   */
  public abstract Monster returnCopy();

  /**
   * The generateDamage() method generates a random damage value.
   * 
   * @return A random damage value.
   */
  public int generateDamage() {
    int damageRange = MAX_DAMAGE - MIN_DAMAGE;
    return (int) (MIN_DAMAGE + Math.random() * damageRange);
  }

  /**
   * The getMinDamage() method returns the minimum damage the monster can do.
   * 
   * @return The minimum damage the monster can do.
   */
  public String getAttackText() {
    return onAttackText;
  }

  /**
   * The getAppearText() method returns the text that is displayed when the monster appears.
   * 
   * @return The text that is displayed when the monster appears.
   */
  public String getAppearText() {
    return onAppearText;
  }

  /**
   * The getName() method returns the name of the monster.
   * 
   * @return The name of the monster.
   */
  public String getName() {
    return NAME;
  }
}
