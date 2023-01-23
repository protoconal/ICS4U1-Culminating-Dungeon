package Dungeon.Game.Entities;

import Dungeon.Game.GameWeightedRandoms;

/**
 * This BossMonsterDefinitions class contains all the possible boss monsters in the game.
 *
 * @author Chris Yang, Ilelemwanta Nomaren, Tony Guo, Emily Ta,
 * @version 1.0
 * @since 1.0
 */
public class BossMonsterDefinitions {

  private final GameWeightedRandoms RANDOM;
  private final Monster[] MONSTER_TABLE = new Monster[]{
      new SpiderBroodMother(),
      new DarkKnightofTheForgotten(),
      new CorruptedExecutioner(),
      new LichKing(),
      new AldwynTheFallen(),
  };

  /**
   * The constructor for the BossMonsterDefinitions class.
   */
  public BossMonsterDefinitions() {
    double[] spawnChances = new double[]{
        0.40, // SpiderBroodMother
        0.30, // DarkKnightofTheForgotten
        0.20, // CorruptedExecutioner
        0.10, // LichKing
        0.05, // AldwynTheFallen
    };
    this.RANDOM = new GameWeightedRandoms(spawnChances);
  }

  /**
   * The generateMonster() method generates a random boss monster.
   *
   * @return A random boss monster.
   */
  public Monster generateMonster() {
    return MONSTER_TABLE[RANDOM.generateChoice()].returnCopy();
  }

  public abstract static class BossMonster extends Monster {
    public BossMonster(String name, int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
      super(name, maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
  }
}

/**
 * The SpiderBroodMother class is a subclass of the BossMonster class, and it is a boss monster.
 */
class SpiderBroodMother extends BossMonsterDefinitions.BossMonster {
  /**
   * The constructor for the SpiderBroodMother class.
   */
  public SpiderBroodMother() {
    super("The Mother Spider",
        500, //maxHP
        30, // minDamage
        70, // maxDamage
        "splooshes goo everywhere. It gets into your eyes.", // onAttackText
        "Mother Spider appears!" // onAppearText
    );
  }

  /**
   * The returnCopy() method returns a copy of the SpiderBroodMother class.
   *
   * @return A copy of the SpiderBroodMother class.
   */
  @Override
  public Monster returnCopy() {
    return new SpiderBroodMother();
  }
}

/**
 * The DarkKnightofTheForgotten class is a subclass of the BossMonster class, and it is a boss monster.
 */
class DarkKnightofTheForgotten extends BossMonsterDefinitions.BossMonster {
  /**
   * The constructor for the DarkKnightofTheForgotten class.
   */
  public DarkKnightofTheForgotten() {
    super("The Dark Knight of The Forgotten",
        650, //maxHP
        60, // minDamage
        80, // maxDamage
        "slices you with his carbon fibre tendrils.", // onAttackText
        "A shadow of the night appears!" // onAppearText
    );
  }

  /**
   * The returnCopy() method returns a copy of the DarkKnightofTheForgotten class.
   *
   * @return A copy of the DarkKnightofTheForgotten class.
   */
  @Override
  public Monster returnCopy() {
    return new DarkKnightofTheForgotten();
  }
}

/**
 * The CorruptedExecutioner class is a subclass of the BossMonster class, and it is a boss monster.
 */
class CorruptedExecutioner extends BossMonsterDefinitions.BossMonster {
  /**
   * The constructor for the CorruptedExecutioner class.
   */
  public CorruptedExecutioner() {
    super("The Corrupted Executioner",
        750, //maxHP
        70, // minDamage
        90, // maxDamage
        "They drop the axe.", // onAttackText
        "A politician appears!" // onAppearText
    );
  }

  /**
   * The returnCopy() method returns a copy of the CorruptedExecutioner class.
   *
   * @return A copy of the CorruptedExecutioner class.
   */
  @Override
  public Monster returnCopy() {
    return new CorruptedExecutioner();
  }
}

/**
 * The LichKing class is a subclass of the BossMonster class, and it is a boss monster.
 */
class LichKing extends BossMonsterDefinitions.BossMonster {
  /**
   * The constructor for the LichKing class.
   */
  public LichKing() {
    super("The Lich King",
        900, //maxHP
        75, // minDamage
        90, // maxDamage
        "Kisses you.", // onAttackText
        "A king appears!" // onAppearText
    );
  }

  /**
   * The returnCopy() method returns a copy of the LichKing class.
   *
   * @return A copy of the LichKing class.
   */
  @Override
  public Monster returnCopy() {
    return new LichKing();
  }
}

/**
 * The AldwynTheFallen class is a subclass of the BossMonster class, and it is a boss monster.
 */
class AldwynTheFallen extends BossMonsterDefinitions.BossMonster {
  /**
   * The constructor for the AldwynTheFallen class.
   */
  public AldwynTheFallen() {
    super("Aldwyn the Fallen",
        1000, //maxHP
        80, // minDamage
        100, // maxDamage
        "Takes you out on a bad date but you can't say no because he's too nice.", // onAttackText
        "A good boy appears!" // onAppearText
    );
  }

  /**
   * The returnCopy() method returns a copy of the AldwynTheFallen class.
   *
   * @return A copy of the AldwynTheFallen class.
   */
  @Override
  public Monster returnCopy() {
    return new AldwynTheFallen();
  }
}
