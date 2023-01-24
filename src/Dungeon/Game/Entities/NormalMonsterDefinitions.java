package Dungeon.Game.Entities;

/**
 * This NormalMonsterDefinitions class contains all the possible normal monsters in the game.
 *
 * @author Chris Yang, Ilelemwanta Nomaren, Tony Guo, Emily Ta,
 * @version 1.0
 * @since 1.0
 */
public class NormalMonsterDefinitions extends MonsterDefinitions {

  /**
   * Constructor for the StrongMonsterDefinitions class.
   */
  public NormalMonsterDefinitions() {
    super(
        // types of monsters
        new Monster[]{
            new HauntedArmour(),
            new Ghoul(),
            new Cultist()
        },
        // chances of monsters
        new double[]{
            0.40, // HauntedArmour()
            0.30, // Ghoul()
            0.20, // Cultist()
        });
  }


  /**
   * This class represents a normal monster.
   */
  public abstract static class NormalMonster extends Monster {
    /**
     * Constructor for the NormalMonster class.
     */
    public NormalMonster(String name, int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
      super(name, maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
  }
}

/**
 * This class defines a HauntedArmour, which is a normal monster.
 */
class HauntedArmour extends NormalMonsterDefinitions.NormalMonster {
  /**
   * Constructor for the HauntedArmour class.
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
   * @return a copy of the HauntedArmour class.
   */
  @Override
  public Monster returnCopy() {
    return new HauntedArmour();
  }
}

/**
 * This class defines a Ghoul, which is a normal monster.
 */
class Ghoul extends NormalMonsterDefinitions.NormalMonster {
  /**
   * Constructor for the Ghoul class.
   */
  public Ghoul() {
    super("Jerry the Ghoul",
        125, //maxHP
        15, // minDamage
        25, // maxDamage
        "Irradiates the surroundings.", // onAttackText
        "Poor soul appears!" // onAppearText
    );
  }

  /**
   * @return a copy of the Ghoul class.
   */
  @Override
  public Monster returnCopy() {
    return new Ghoul();
  }
}

/**
 * This class defines a Cultist, which is a normal monster.
 */
class Cultist extends NormalMonsterDefinitions.NormalMonster {
  /**
   * Constructor for the Cultist class.
   */
  public Cultist() {
    super("Jasmine, our Holy Leader",
        150, //maxHP
        25, // minDamage
        30, // maxDamage
        "Commands her followers to chant.", // onAttackText
        "Emily is running back from the store when she gets recruited by Jasmine, our holy leader. And I'm like I can't believe that Jasmine became that but honestly, she's girlbossing her way to becoming a millionaire. Anyways, there she is.!" // onAppearText
    );
  }

  /**
   * @return a copy of the Cultist class.
   */
  @Override
  public Monster returnCopy() {
    return new Cultist();
  }
}
