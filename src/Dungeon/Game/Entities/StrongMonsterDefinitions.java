package Dungeon.Game.Entities;

import Dungeon.Game.WeightedRandoms;

public class StrongMonsterDefinitions {
  private final WeightedRandoms rand;
  private final Monster[] monsters = new Monster[]{
      new Troll(),
      new Centaur(),
      new Minotaur(),
  };

  public StrongMonsterDefinitions() {
    double[] spawnChances = new double[]{
        1, // Troll
        2, // Centaur
        3, // Minotaur
    };
    this.rand = new WeightedRandoms(spawnChances);
  }

  public Monster generateMonster() {
    return monsters[rand.generateChoice()];
  }

  public abstract static class StrongMonster extends Monster {
    public StrongMonster(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
      super(maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
  }
}

class Troll extends StrongMonsterDefinitions.StrongMonster {
  public Troll() {
    super(200, //maxHP
        40, // minDamage
        60, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }
}

class Centaur extends StrongMonsterDefinitions.StrongMonster {
  public Centaur() {
    super(180, //maxHP
        40, // minDamage
        55, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }
}

class Minotaur extends StrongMonsterDefinitions.StrongMonster {
  public Minotaur() {
    super(240, //maxHP
        50, // minDamage
        65, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }
}
