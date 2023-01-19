package Dungeon.Game.Entities;

import Dungeon.Game.WeightedRandoms;

public class WeakMonsterDefinitions {
  private final WeightedRandoms rand;
  private final Monster[] monsters = new Monster[]{
      new Skeleton(),
      new Slime(),
      new Spider(),
  };

  public WeakMonsterDefinitions() {
    double[] spawnChances = new double[]{
        1, // Skeleton
        2, // Slime
        3, // Spider
    };
    this.rand = new WeightedRandoms(spawnChances);
  }

  public Monster generateMonster() {
    return monsters[rand.generateChoice()];
  }

  public abstract static class WeakMonster extends Monster {
    public WeakMonster(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
      super(maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
  }
}

class Skeleton extends WeakMonsterDefinitions.WeakMonster {
  public Skeleton() {
    super(75, //maxHP
        10, // minDamage
        20, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }
}

class Slime extends WeakMonsterDefinitions.WeakMonster {
  public Slime() {
    super(25, //maxHP
        1, // minDamage
        10, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }
}

class Spider extends WeakMonsterDefinitions.WeakMonster {
  public Spider() {
    super(45, //maxHP
        5, // minDamage
        15, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }
}
