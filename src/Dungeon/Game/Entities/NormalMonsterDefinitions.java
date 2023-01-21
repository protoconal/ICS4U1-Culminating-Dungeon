package Dungeon.Game.Entities;

import Dungeon.Game.NormalWeightedRandoms;

/**
 * The NormalMonsterDefinitions class is a class that contains all the definitions for the normal
 * monsters.
 */
public class NormalMonsterDefinitions {

  private final NormalWeightedRandoms RANDOM;
  private final Monster[] MONSTERS = new Monster[]{
      new HauntedArmour(),
      new Ghoul(),
      new Cultist(),
      new LichKing(),
      new AldwynTheFallen(),
  };

  /**
   * The constructor for the NormalMonsterDefinitions class.
   */
  public NormalMonsterDefinitions() {
    double[] spawnChances = new double[]{
        0.40, // HauntedArmour()
        0.30, // Ghoul()
        0.20, // Cultist()
    };
    this.RANDOM = new NormalWeightedRandoms(spawnChances);
  }

  /**
   * The generateMonster() method generates a random normal monster.
   * 
   * @return A random normal monster.
   */
  public Monster generateMonster() {
    return MONSTERS[RANDOM.generateChoice()].returnCopy();
  }

  /**
   * The NormalMonster class is a subclass of the Monster class, and it is a normal monster.
   */
  public abstract static class NormalMonster extends Monster {
    public NormalMonster(String name, int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
      super(name, maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
  }
}

/**
 * The HauntedArmour class is a subclass of the NormalMonster class, and it is a normal monster.
 */
class HauntedArmour extends NormalMonsterDefinitions.NormalMonster {
  /**
   * The constructor for the HauntedArmour class.
   */
  public HauntedArmour() {
    super("Henry the Haunted Armour",
        170, //maxHP
        20, // minDamage
        30, // maxDamage
        "Armour clanks.", // onAttackText
        "A ghostly set of armor appears!" // onAppearText
    );
  }

  /**
   * The returnCopy() method returns a copy of the HauntedArmour class.
   * 
   * @return A copy of the HauntedArmour class.
   */
  @Override
  public Monster returnCopy() {
    return new HauntedArmour();
  }
}

/**
 * The Ghoul class is a subclass of the NormalMonster class, and it is a normal monster.
 */
class Ghoul extends NormalMonsterDefinitions.NormalMonster {
  /**
   * The constructor for the Ghoul class.
   */
  public Ghoul() {
    super("Jerry the Ghoul",
        125, //maxHP
        15, // minDamage
        25, // maxDamage
        " verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  /**
   * The returnCopy() method returns a copy of the Ghoul class.
   * 
   * @return A copy of the Ghoul class.
   */
  @Override
  public Monster returnCopy() {
    return new Ghoul();
  }
}

/**
 * The Cultist class is a subclass of the NormalMonster class, and it is a normal monster.
 */
class Cultist extends NormalMonsterDefinitions.NormalMonster {
  /**
   * The constructor for the Cultist class.
   */
  public Cultist() {
    super("Jasmine, our Holy Leader",
        150, //maxHP
        25, // minDamage
        30, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  /**
   * The returnCopy() method returns a copy of the Cultist class.
   * 
   * @return A copy of the Cultist class.
   */
  @Override
  public Monster returnCopy() {
    return new Cultist();
  }
}
