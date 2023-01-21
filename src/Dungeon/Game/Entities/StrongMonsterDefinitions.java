package Dungeon.Game.Entities;

import Dungeon.Game.NormalWeightedRandoms;

/**
 * The StrongMonsterDefinitions class is a class that contains all the definitions of the strong
 * monsters in the game.
 */
public class StrongMonsterDefinitions {
  private final NormalWeightedRandoms RANDOM;
  private final Monster[] MONSTERS = new Monster[]{
      new Troll(),
      new Centaur(),
      new Minotaur(),
  };

  /**
   * The constructor for the StrongMonsterDefinitions class.
   */
  public StrongMonsterDefinitions() {
    double[] spawnChances = new double[]{
        1, // Troll
        2, // Centaur
        3, // Minotaur
    };
    this.RANDOM = new NormalWeightedRandoms(spawnChances);
  }

  /**
   * The generateMonster() method generates a random strong monster.
   * 
   * @return A random strong monster.
   */
  public Monster generateMonster() {
    return MONSTERS[RANDOM.generateChoice()].returnCopy();
  }

  /**
   * The StrongMonster class is a subclass of the Monster class, and it is a strong monster.
   */
  public abstract static class StrongMonster extends Monster {
    public StrongMonster(String name, int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
      super(name, maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
  }
}

/**
 * The Troll class is a subclass of the StrongMonster class, and it is a strong monster.
 */
class Troll extends StrongMonsterDefinitions.StrongMonster {
  /**
   * The constructor for the Troll class.
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
   * The returnCopy() method returns a copy of the Troll class.
   * 
   * @return A copy of the Troll class.
   */
  @Override
  public Monster returnCopy() {
    return new Troll();
  }
}

/**
 * The Centaur class is a subclass of the StrongMonster class, and it is a strong monster.
 */
class Centaur extends StrongMonsterDefinitions.StrongMonster {
  /**
   * The constructor for the Centaur class.
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
   * The returnCopy() method returns a copy of the Centaur class.
   * 
   * @return A copy of the Centaur class.
   */
  @Override
  public Monster returnCopy() {
    return new Centaur();
  }
}

/**
 * The Minotaur class is a subclass of the StrongMonster class, and it is a strong monster.
 */
class Minotaur extends StrongMonsterDefinitions.StrongMonster {
  /**
   * The constructor for the Minotaur class.
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
   * The returnCopy() method returns a copy of the Minotaur class.
   */
  @Override
  public Monster returnCopy() {
    return new Minotaur();
  }
}
