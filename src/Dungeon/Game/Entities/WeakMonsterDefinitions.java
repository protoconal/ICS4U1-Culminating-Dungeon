package Dungeon.Game.Entities;

/**
 * This WeakMonsterDefinitions class contains all the possible weak monsters in the game.
 *
 * @author Chris Yang, Ilelemwanta Nomaren, Tony Guo, Emily Ta,
 * @version 1.0
 * @since 1.0
 */
public class WeakMonsterDefinitions extends MonsterDefinitions {

  /**
   * Constructor for the WeakMonsterDefinitions class.
   */
  public WeakMonsterDefinitions() {
    super(
        // types of monsters
        new Monster[]{
            new Skeleton(),
            new Slime(),
            new Spider(),
        },
        // chances of monsters
        new double[]{
            1, // Skeleton
            2, // Slime
            3, // Spider
        });
  }

  /**
   * This class represents a weak monster.
   */
  public abstract static class WeakMonster extends Monster {
    /**
     * Constructor for the WeakMonster class.
     */
    public WeakMonster(String name, int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
      super(name, maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
  }
}

/**
 * This class defines a Skeleton, which is a weak monster.
 */
class Skeleton extends WeakMonsterDefinitions.WeakMonster {
  /**
   * Constructor for the Skeleton class.
   */
  public Skeleton() {
    super("Fallen Warrior",
        75, //maxHP
        10, // minDamage
        20, // maxDamage
        "Breathes.", // onAttackText
        "A fury of red approaches you! You can't do anything but become enthralled by his scent, his hair, his beard, his face. You are enamoured with his bones. He's only bones. You're smelling bones. You're hallucinating." // onAppearText
    );
  }

  /**
   * @return a copy of the Skeleton class.
   */
  @Override
  public Monster returnCopy() {
    return new Skeleton();
  }
}

/**
 * This class defines a Slime, which is a weak monster.
 */
class Slime extends WeakMonsterDefinitions.WeakMonster {
  /**
   * Constructor for the Slime class.
   */
  public Slime() {
    super("Blobby",
        25, //maxHP
        1, // minDamage
        10, // maxDamage
        "Blobs around.", // onAttackText
        "Bobby the blobby appears! You wouldn't kill it... Would you?" // onAppearText
    );
  }

  /**
   * @return a copy of the Slime class.
   */
  @Override
  public Monster returnCopy() {
    return new Slime();
  }
}

/**
 * This class defines a Spider, which is a weak monster.
 */
class Spider extends WeakMonsterDefinitions.WeakMonster {
  /**
   * Constructor for the Spider class.
   */
  public Spider() {
    super("Tiffany the Spider",
        45, //maxHP
        5, // minDamage
        15, // maxDamage
        "grabs your throat and squeezes.", // onAttackText
        "A creepy crawler appears!" // onAppearText
    );
  }

  /**
   * @return a copy of the Spider class.
   */
  @Override
  public Monster returnCopy() {
    return new Spider();
  }
}
