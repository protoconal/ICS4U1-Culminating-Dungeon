package Dungeon.Game.Entities;

/**
 * This Monster class is a template for all other monsters to follow.
 *
 * @author Tony Guo, Emily Ta, Chris Yang, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public abstract class Monster extends Entity {
  private final String NAME;
  private final int MIN_DAMAGE;
  private final int MAX_DAMAGE;
  private final String onAttackText; // ex. x verbs you.
  private final String onAppearText; // ex. a blobby creature appears.

  /**
   * Constructor for the Monster class.
   *
   * @param name         a string storing the name of the monster.
   * @param maxHP        stores the maximum HP of the monster.
   * @param minDamage    stores the minimum damage from the monster.
   * @param maxDamage    stores the maximum damage from the monster.
   * @param onAttackText a string storing the text that is displayed when the monster attacks.
   * @param onAppearText a string storing the text that is displayed when the monster appears.
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
   * @return the minimum damage the monster can do.
   */
  public String getAttackText() {
    return onAttackText;
  }

  /**
   * @return the text that is displayed when the monster appears.
   */
  public String getAppearText() {
    return onAppearText;
  }

  /**
   * @return the name of the monster.
   */
  public String getName() {
    return NAME;
  }

  /**
   * @return a copy of the monster.
   */
  public abstract Monster returnCopy();

  /**
   * @return a generated a random damage value.
   */
  public int generateDamage() {
    int damageRange = MAX_DAMAGE - MIN_DAMAGE;
    return (int) (MIN_DAMAGE + Math.random() * damageRange);
  }
}
