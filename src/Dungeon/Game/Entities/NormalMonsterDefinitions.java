package Dungeon.Game.Entities;

import Dungeon.Game.NormalWeightedRandoms;

public class NormalMonsterDefinitions {

  private final NormalWeightedRandoms RANDOM;
  private final Monster[] MONSTERS = new Monster[]{
      new HauntedArmour(),
      new Ghoul(),
      new Cultist(),
      new LichKing(),
      new AldwynTheFallen(),
  };

  public NormalMonsterDefinitions() {
    double[] spawnChances = new double[]{
        0.40, // HauntedArmour()
        0.30, // Ghoul()
        0.20, // Cultist()
    };
    this.RANDOM = new NormalWeightedRandoms(spawnChances);
  }

  public Monster generateMonster() {
    return MONSTERS[RANDOM.generateChoice()];
  }

  public abstract static class NormalMonster extends Monster {
    public NormalMonster(String name, int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
      super(name, maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
  }
}

class HauntedArmour extends NormalMonsterDefinitions.NormalMonster {
  public HauntedArmour() {
    super("Henry the Haunted Armour",
            170, //maxHP
        20, // minDamage
        30, // maxDamage
        "Armour clanks.", // onAttackText
        "A ghostly set of armor appears!" // onAppearText
    );
  }
}

class Ghoul extends NormalMonsterDefinitions.NormalMonster {
  public Ghoul() {
    super("Jerry the Ghoul",
            125, //maxHP
        15, // minDamage
        25, // maxDamage
        " verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }
}

class Cultist extends NormalMonsterDefinitions.NormalMonster {
  public Cultist() {
    super("Jasmine, our Holy Leader",
            150, //maxHP
        25, // minDamage
        30, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }
}
