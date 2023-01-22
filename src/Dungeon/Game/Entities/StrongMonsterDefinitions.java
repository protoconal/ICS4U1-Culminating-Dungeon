package Dungeon.Game.Entities;

/**
 * This StrongMonsterDefinitions class contains all the possible strong monsters in the game.
 *
 * @author Chris Yang, Ilelemwanta Nomaren, Tony Guo, Emily Ta,
 * @version 1.0
 * @since 1.0
 */
public class StrongMonsterDefinitions extends MonsterDefinitions {

  /**
   * Constructor for the StrongMonsterDefinitions class.
   */
  public StrongMonsterDefinitions() {
    super(
        // types of monsters
        new Monster[]{
            new Troll(),
            new Centaur(),
            new Minotaur(),
        },
        // chances of monsters
        new double[]{
            1, // Troll
            2, // Centaur
            3, // Minotaur
        });
  }

  /**
   * This class represents a strong monster.
   */
  public abstract static class StrongMonster extends Monster {
    /**
     * Constructor for the StrongMonster class.
     */
    public StrongMonster(String name, int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
      super(name, maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
  }
}

/**
 * This class defines a Troll, which is a strong monster.
 */
class Troll extends StrongMonsterDefinitions.StrongMonster {
  /**
   * Constructor for the Troll class.
   */
  public Troll() {
    super("Miles the Troll",
        200, //maxHP
        40, // minDamage
        60, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  /**
   * @return a copy of the Troll class.
   */
  @Override
  public Monster returnCopy() {
    return new Troll();
  }
}

/**
 * This class defines a Centaur, which is a strong monster.
 */
class Centaur extends StrongMonsterDefinitions.StrongMonster {
  /**
   * Constructor for the Centaur class.
   */
  public Centaur() {
    super("Fiona the Centaur",
        180, //maxHP
        40, // minDamage
        55, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  /**
   * @return a copy of the Centaur class.
   */
  @Override
  public Monster returnCopy() {
    return new Centaur();
  }
}

/**
 * This class defines a Minotaur, which is a strong monster.
 */
class Minotaur extends StrongMonsterDefinitions.StrongMonster {
  /**
   * Constructor for the Minotaur class.
   */
  public Minotaur() {
    super("Klara the Minotaur",
        240, //maxHP
        50, // minDamage
        65, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  /**
   * @return a copy of the Centaur class.
   */
  @Override
  public Monster returnCopy() {
    return new Minotaur();
  }
}
