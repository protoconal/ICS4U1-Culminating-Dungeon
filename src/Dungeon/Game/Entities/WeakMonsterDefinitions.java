package Dungeon.Game.Entities;

import Dungeon.Game.NormalWeightedRandoms;

/**
 * The WeakMonsterDefinitions class is a class that contains all the definitions for the weak monsters
 * in the game.
 */
public class WeakMonsterDefinitions {
  private final NormalWeightedRandoms RANDOM;
  private final Monster[] MONSTERS = new Monster[]{
      new Skeleton(),
      new Slime(),
      new Spider(),
  };

  /**
   * The constructor for the WeakMonsterDefinitions class.
   */
  public WeakMonsterDefinitions() {
    double[] spawnChances = new double[]{
        1, // Skeleton
        2, // Slime
        3, // Spider
    };
    this.RANDOM = new NormalWeightedRandoms(spawnChances);
  }

  /**
   * The generateMonster() method generates a random weak monster.
   * 
   * @return A random weak monster.
   */
  public Monster generateMonster() {
    return MONSTERS[RANDOM.generateChoice()].returnCopy();
  }

  /**
   * The WeakMonster class is a subclass of the Monster class, and it is a weak monster.
   */
  public abstract static class WeakMonster extends Monster {
    public WeakMonster(String name, int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
      super(name, maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
  }
}

/**
 * The Skeleton class is a subclass of the WeakMonster class, and it is a weak monster.
 */
class Skeleton extends WeakMonsterDefinitions.WeakMonster {
  /**
   * The constructor for the Skeleton class.
   */
  public Skeleton() {
    super("Fallen Warrior",
        75, //maxHP
        10, // minDamage
        20, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  /**
   * The returnCopy() method returns a copy of the Skeleton class.
   * 
   * @return A copy of the Skeleton class.
   */
  @Override
  public Monster returnCopy() {
    return new Skeleton();
  }
}

/**
 * The Slime class is a subclass of the WeakMonster class, and it is a weak monster.
 */
class Slime extends WeakMonsterDefinitions.WeakMonster {
  /**
   * The constructor for the Slime class.
   */
  public Slime() {
    super("Blobby",
        25, //maxHP
        1, // minDamage
        10, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  /**
   * The returnCopy() method returns a copy of the Slime class.
   * 
   * @return A copy of the Slime class.
   */
  @Override
  public Monster returnCopy() {
    return new Slime();
  }
}

/**
 * The Spider class is a subclass of the WeakMonster class, and it is a weak monster.
 */
class Spider extends WeakMonsterDefinitions.WeakMonster {
  /**
   * The constructor for the Spider class.
   */
  public Spider() {
    super("Tiffany the Spider",
        45, //maxHP
        5, // minDamage
        15, // maxDamage
        "verbs.", // onAttackText
        "A creepy crawler appears!" // onAppearText
    );
  }

  /**
   * The returnCopy() method returns a copy of the Spider class.
   * 
   * @return A copy of the Spider class.
   */
  @Override
  public Monster returnCopy() {
    return new Spider();
  }
}
