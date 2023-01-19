package Dungeon.Game.Entities;

import Dungeon.Game.WeightedRandoms;

public class NormalMonsterDefinitions {

  private final WeightedRandoms rand;
  private final Monster[] monsters = new Monster[]{
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
    this.rand = new WeightedRandoms(spawnChances);
  }

  public Monster generateMonster() {
    return monsters[rand.generateChoice()];
  }

  public abstract static class NormalMonster extends Monster {
    public NormalMonster(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
      super(maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
  }
}

class HauntedArmour extends NormalMonsterDefinitions.NormalMonster {
  public HauntedArmour() {
    super(170, //maxHP
        20, // minDamage
        30, // maxDamage
        "Armour clanks.", // onAttackText
        "A ghostly set of armor appears!" // onAppearText
    );
  }
}

class Ghoul extends NormalMonsterDefinitions.NormalMonster {
  public Ghoul() {
    super(125, //maxHP
        15, // minDamage
        25, // maxDamage
        " verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }
}

class Cultist extends NormalMonsterDefinitions.NormalMonster {
  public Cultist() {
    super(150, //maxHP
        25, // minDamage
        30, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }
}
