package Dungeon.Game.Entities;

import Dungeon.Game.NormalWeightedRandoms;

public class BossMonsterDefinitions {

  private final NormalWeightedRandoms RANDOM;
  private final Monster[] MONSTERS = new Monster[]{
      new SpiderBroodMother(),
      new DarkKnightofTheForgotten(),
      new CorruptedExecutioner(),
      new LichKing(),
      new AldwynTheFallen(),
  };

  public BossMonsterDefinitions() {
    double[] spawnChances = new double[]{
        0.40, // SpiderBroodMother
        0.30, // DarkKnightofTheForgotten
        0.20, // CorruptedExecutioner
        0.10, // LichKing
        0.05, // AldwynTheFallen
    };
    this.RANDOM = new NormalWeightedRandoms(spawnChances);
  }

  public Monster generateMonster() {
    return MONSTERS[RANDOM.generateChoice()].returnCopy();
  }

  public abstract static class BossMonster extends Monster {
    public BossMonster(String name, int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
      super(name, maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
  }
}

class SpiderBroodMother extends BossMonsterDefinitions.BossMonster {
  public SpiderBroodMother() {
    super("The Mother Spider",
        500, //maxHP
        30, // minDamage
        70, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  @Override
  public Monster returnCopy() {
    return new SpiderBroodMother();
  }
}

class DarkKnightofTheForgotten extends BossMonsterDefinitions.BossMonster {
  public DarkKnightofTheForgotten() {
    super("The Dark Knight of The Forgotten",
        650, //maxHP
        60, // minDamage
        80, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  @Override
  public Monster returnCopy() {
    return new DarkKnightofTheForgotten();
  }
}

class CorruptedExecutioner extends BossMonsterDefinitions.BossMonster {
  public CorruptedExecutioner() {
    super("The Corrupted Executioner",
        750, //maxHP
        70, // minDamage
        90, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  @Override
  public Monster returnCopy() {
    return new CorruptedExecutioner();
  }
}

class LichKing extends BossMonsterDefinitions.BossMonster {
  public LichKing() {
    super("The Lich King",
        900, //maxHP
        75, // minDamage
        90, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  @Override
  public Monster returnCopy() {
    return new LichKing();
  }
}

class AldwynTheFallen extends BossMonsterDefinitions.BossMonster {
  public AldwynTheFallen() {
    super("Aldwyn the Fallen",
        1000, //maxHP
        80, // minDamage
        100, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  @Override
  public Monster returnCopy() {
    return new AldwynTheFallen();
  }
}
